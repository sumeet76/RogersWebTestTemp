# RogersWebTestAutomation
Belongs to Rogers Digital QA Test Automation
[Under Construction]
How to Launch Tests

To run tests on SauceLabs
gradle sauceTest   -Ptest_Browser=saucechrome -Ptest_Language=en   --tests 'RogersCH_Regression*' -Ptest_threadCount=1 -Ptest_QaUrl=https://qa6.Rogers.com -i --stacktrace

To run tests on Local
gradle localTest   -Ptest_Browser=chrome -Ptest_Language=en   --tests 'RogersCH_Regression*' -Ptest_threadCount=1 -Ptest_QaUrl=https://qa6.Rogers.com -i --stacktrace
