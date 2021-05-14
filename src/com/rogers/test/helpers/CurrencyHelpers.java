package com.rogers.test.helpers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CurrencyHelpers {

public  static  boolean validateCurrency(String strValue){
    boolean symbolMatched = false;
    if(strValue.startsWith("$") || strValue.endsWith("$")){
        symbolMatched =true;
    }else{
        symbolMatched =false;
    }

    Pattern p=Pattern.compile("^(?:0|[1-9]\\d{0,2}(?:\\.\\d{3})*),\\d{2}$");
    Matcher m=p.matcher(strValue);
    if (m.matches() && symbolMatched)return true;
    else return false;
}

public static String removeLineBreaksFromString(String strValue)
{
    return strValue.replaceAll("\n","");
}

}
