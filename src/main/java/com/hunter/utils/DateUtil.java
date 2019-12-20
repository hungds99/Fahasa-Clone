package com.hunter.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtil {
	
	public static final String SHORT_JANUARY                    = "Jan";
	public static final String SHORT_FEBRUARY                   = "Feb";
	public static final String SHORT_MARCH                      = "Mar";
	public static final String SHORT_APRIL                      = "Apr";
	public static final String SHORT_MAY                        = "May";
	public static final String SHORT_JUNE                       = "Jun";
	public static final String SHORT_JULY                       = "Jul";
	public static final String SHORT_AUGUST                     = "Aug";
	public static final String SHORT_SEPTEMBER                  = "Sep";
	public static final String SHORT_OCTOBER                    = "Oct";
	public static final String SHORT_NOVEMBER                   = "Nov";
	public static final String SHORT_DECEMBER                   = "Dec";
	
	public static final String PT_MM_DD_YYYY			        = "MM/dd/yyyy";
	public static final String PT_MMM_YY			            = "MMM-yy";
	public static final String PT_MMMYY			            = "MMyy";
	public static final String PT_YYYY_MM_DD_HH_MM_SS			= "yyyy-MM-dd HH:mm:ss";
	public static final String PT_MM_DD_YYYY_HH_MM_SS			= "MM-dd-yyyy HH:mm:ss";
	public static final String PT_MM_DD_YYYY_HH_MM_A			= "MM/dd/yyyy hh:mm a";
	public static final String PT_MM_DD_YYYY_HH_MM_AA			= "MM/dd/yyyy hh:mm aa";
	public static final String PT_DD_MMM_YYYY					= "dd MMM yyyy";
	public static final String PT_DD_MM_YYYY			        = "dd/MM/yyyy";
	public static final String PT_DD_MM_YYYY_HH_MM_A		    = "dd/MM/yyyy hh:mm a";
	public static final String PT_DD_MM_YYYY_HH_MM_AS		    = "dd/MM/yyyy HH:mm a";
	public static final String PT_YYYY_MM_DD					= "yyyy-MM-dd";
	public static final String PT_DD_MM_YYYY_HH_MM_SS		    = "dd/MM/yyyy HH:mm:ss";
	public static final String PT_YYYY_MM_DD_HH_MM_A			= "yyyy-MM-dd hh:mm a";
	public static final String PT_YYYY_MM_DD_T_HH_MM_SS_SSS			= "yyyy-MM-dd'T'HH:mm:ss.SSS";
	public static final String PT_YYYY_MM_DD_T_HH_MM_SS_SSS_Z			= "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
	public static final String PT_HH_MM			        = "HH:mm";
	public static final String PT_HH_MM_SS			        = "hh:mm:ss";
	public static final String FORMAT_SLASH_DD_MM_YYYY = "dd/MM/yyy";
	public static final String FORMAT_SLASH_DD_MM_YYYY_HH_MM_SS = "dd/MM/yyy hh:mm:ss";
	
	public static Date getFormatDate(String date, String pattern)  {
    	SimpleDateFormat sdf = new SimpleDateFormat(pattern, Locale.ENGLISH);
        if(date!=null){
           try {
			return sdf.parse(date);
           } catch (ParseException e) {
			System.out.println("ParseException: "+date);
           }
        }
        return null;
	}
    
    public static String getFormatDate(Date date, String pattern){
        SimpleDateFormat sdf = new SimpleDateFormat(pattern, Locale.ENGLISH);
        if(date!=null){
           return sdf.format(date);
        }else{
            return "";
        }
    }
    
    public static Date getCurrentDateTime() {
    	return Calendar.getInstance().getTime();
    }
}
