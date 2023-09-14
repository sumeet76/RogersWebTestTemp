#!/bin/bash
# set -x
teams="${1}"

rawurlencode() {
  local string="${1}"
  local strlen=${#string}
  local encoded=""
  local pos c o
  for (( pos=0 ; pos<strlen ; pos++ )); do
    c=${string:$pos:1}
    case "$c" in
    [-_.~a-zA-Z0-9] ) o="${c}" ;;
    * ) printf -v o '%%%02x' "'$c"
    esac
    encoded+="${o}"
  done
  echo "${encoded}"
}
      
filename="generic-build-result"

cat > ${filename}.json <<'endmsg'
{
  "type": "message",
  "summary": "Message Summary",
  "attachments": [
    {
      "contentType": "application/vnd.microsoft.card.adaptive",
      "contentUrl": null,
      "content": {
        "$schema": "http://adaptivecards.io/schemas/adaptive-card.json",
        "type": "AdaptiveCard",
        "version": "1.2",
        "body": [
          {
            "type": "TextBlock",
            "size": "Medium",
            "weight": "Bolder",
            "text": "notification_header",
            "wrap": true,
            "style": "heading"
          },
          {
            "type": "FactSet",
            "facts": [
              {
                "title": "Status",
                "value": "status"
              },
              {
                "title": "Commit Author",
                "value": "commit_author"
              },
              {
                "title": "Commit Message",
                "value": "commit_message"
              }
            ]
          }
        ],
        "actions": [
          {
            "type": "Action.OpenUrl",
            "title": "View Build",
            "url": "view_build"
          },
          {
            "type": "Action.OpenUrl",
            "title": "View Commit",
            "url": "view_commit"
          }
        ],
        "msteams": {
          "width": "Full"
        }
      }
    }
  ]
}
endmsg

url_encoded_project_name=$(rawurlencode "${SYSTEM_TEAMPROJECT}")
# echo "url_encoded_project_name: $url_encoded_project_name"
build_url=$(curl -s -S -X GET -H "ContentType: application/json" -H "Authorization: Bearer ${ACCESS_TOKEN}" "${SYSTEM_COLLECTIONURI}${url_encoded_project_name}/_apis/build/builds/${BUILD_BUILDID}?api-version=6.0" | jq -r '._links.web.href')
# echo "build_url: $build_url"
timeline_url=$(curl -s -S -X GET -H "ContentType: application/json" -H "Authorization: Bearer ${ACCESS_TOKEN}" "${SYSTEM_COLLECTIONURI}${url_encoded_project_name}/_apis/build/builds/${BUILD_BUILDID}?api-version=6.0" | jq -r '._links.timeline.href')

echo "timeline_url: $timeline_url"

# readarray -t stage_results < <(curl -X GET -H "ContentType: application/json" -H "Authorization: Bearer ${ACCESS_TOKEN}" "${timeline_url}" | jq -r '.records[] | select(.state=="completed" and .type=="Stage" and .identifier!="environment" and .identifier!="post") | .result')

curl -s -S -X GET -H "ContentType: application/json" -H "Authorization: Bearer ${ACCESS_TOKEN}" "${timeline_url}" > result.json

# cat result.json

results=$(cat result.json | jq -r ".records[] | select(.state==completed and .type==Stage and .identifier!=environment and .identifier!=post) | .result")

echo "results: $results"

build_result="Unknown"

if printf '%s\0' "${stage_results[@]}" | grep -Fxqz 'failed'; then
  build_result="Failed"
elif printf '%s\0' "${stage_results[@]}" | grep -Fxqz 'canceled'; then
  build_result="Aborted"
else
  build_result="Succeeded"
fi

repo_name=$(echo "${GITHUB_REPO}" | awk -F/ '{print $NF}')
notification_header="Notification from ${SYSTEM_TEAMPROJECT} » ${BUILD_DEFINITIONNAME} » ${repo_name} » ${BUILD_SOURCEBRANCHNAME} » ${BUILD_BUILDNUMBER} (${BUILD_REASON})"
commit_url="https://github.com/${GITHUB_REPO}/commit/${BUILD_SOURCEVERSION}" 

jq -r --arg value "${CHANGE_AUTHOR}"              '(.attachments | .[].content.body | .[] | select(.type=="FactSet") | .facts | .[] | select(.title=="Commit Author")  .value) = $value' "${filename}.json" > "${filename}.tmp" && mv "${filename}.tmp" "${filename}.json"
jq -r --arg value "${BUILD_SOURCEVERSIONMESSAGE}" '(.attachments | .[].content.body | .[] | select(.type=="FactSet") | .facts | .[] | select(.title=="Commit Message") .value) = $value' "${filename}.json" > "${filename}.tmp" && mv "${filename}.tmp" "${filename}.json"
jq -r --arg value "${build_result}"               '(.attachments | .[].content.body | .[] | select(.type=="FactSet") | .facts | .[] | select(.title=="Status")         .value) = $value' "${filename}.json" > "${filename}.tmp" && mv "${filename}.tmp" "${filename}.json"

jq -r --arg value "${notification_header}"        '(.attachments | .[].content.body | .[] | select(.text=="notification_header") .text)                                        = $value' "${filename}.json" > "${filename}.tmp" && mv "${filename}.tmp" "${filename}.json"

jq -r --arg value "${commit_url}"                 '(.attachments | .[].content.actions | .[] | select(.title=="View Commit") .url)                                             = $value' "${filename}.json" > "${filename}.tmp" && mv "${filename}.tmp" "${filename}.json"
jq -r --arg value "${build_url}"                  '(.attachments | .[].content.actions | .[] | select(.title=="View Build")  .url)                                             = $value' "${filename}.json" > "${filename}.tmp" && mv "${filename}.tmp" "${filename}.json"

urls="${teams}"

if [ ! -z "${urls}" ]; then
  if [[ ! "${urls}" =~ ['|'] ]]; then
    urls=$(
      echo "${urls}" \
        | tr '\n' '|'             `# make it one line, pipe separated        ` \
        | sed 's/^/|/g'           `# add the extra pipe up front             `
    )
  fi

  IFS='|' read -r -a urls_array <<< "${urls}"

  for url in "${urls_array[@]}"; do
    if [ ! -z "${url}" ]; then
      curl -X POST -H "Content-Type: application/json" -d @"${filename}.json" "${url}"
    fi
  done
fi

