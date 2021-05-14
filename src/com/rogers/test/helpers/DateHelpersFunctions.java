package com.rogers.test.helpers;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

public class DateHelpersFunctions {

    public  static boolean isValidDAte(String strDate){
        Locale locale=Locale.CANADA;;
        String datePattern = "MMM. d, u";
        ZoneId defaultZoneId = ZoneId.systemDefault();
        if(System.getProperty("test_language")=="en")
        {
            locale =Locale.CANADA;
            datePattern = "MMM. d, u";
        }else if(System.getProperty("test_language")=="fr"){
            locale =Locale.FRENCH;
            datePattern = "dd MMM yyyy";
        }

        try
        {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(datePattern,locale);
            LocalDate date = LocalDate.parse(strDate, dateFormatter);
        }
        /* Date format is invalid */
        catch (DateTimeParseException e)
        {
            return false;
        }
        /* Return true if date format is valid */
        return true;
    }
}
