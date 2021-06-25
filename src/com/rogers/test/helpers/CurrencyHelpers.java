package com.rogers.test.helpers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CurrencyHelpers {

    /**
     *
     * @param strValue
     * @return
     * @author Mirza.Kamran
     */
    public  static  boolean validateCurrency(String strValue){
    boolean symbolMatched = false;
    if(strValue.startsWith("$") || strValue.endsWith("$")){
        symbolMatched =true;
    }else{
        symbolMatched =false;
    }
    strValue=strValue.replaceAll(",",".").replaceAll("[^\\d.]+", "");
    //\d+\.\d{2}
    Pattern p=Pattern.compile("^\\d+\\.\\d{2}$");
    Matcher m=p.matcher(strValue);
    if (m.matches() && symbolMatched)
        return true;
    else return false;
}

    /**
     *
     * @param strValue
     * @return
     * @author Mirza.Kamran
     */
public static String removeMonth(String strValue)
{
    if(strValue.contains("/mo"))
    {
        strValue = strValue.split("/mo")[0];
    }else if(strValue.contains("/mois")){
        strValue = strValue.split("/mois")[0];
    }

    return strValue;
}

    /**
     *
     * @param strValue
     * @return
     * @author Mirza.Kamran
     */
public static String removeLineBreaksFromString(String strValue)
{
    return strValue.replaceAll("\n","");
}

    /**
     *
     * @param strValue
     * @return
     * @author Mirza.Kamran
     */
    public static String extractNumberFromString(String strValue) {
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(strValue);
        String strNumber="";
        while(m.find()) {
            strNumber = strNumber + m.group();
        }

        return strNumber;
    }


}
