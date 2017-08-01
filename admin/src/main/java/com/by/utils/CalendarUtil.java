package com.by.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Carl
 *
 */
public class CalendarUtil {
	public static String getToday() {
		Calendar c = Calendar.getInstance();
		return c.get(Calendar.YEAR) + "-" + c.get(Calendar.DAY_OF_YEAR);
	}
	
	/** 
     * 获取当月的 天数 
     * */  
    public static int getCurrentMonthDay() {  
          
        Calendar a = Calendar.getInstance();  
        a.set(Calendar.DATE, 1);  
        a.roll(Calendar.DATE, -1);  
        int maxDate = a.get(Calendar.DATE);  
        return maxDate;  
    }  
  
    /** 
     * 根据年 月 获取对应的月份 天数 
     * */  
    public static int getDaysByYearMonth(int year, int month) {  
          
        Calendar a = Calendar.getInstance();  
        a.set(Calendar.YEAR, year);  
        a.set(Calendar.MONTH, month - 1);  
        a.set(Calendar.DATE, 1);  
        a.roll(Calendar.DATE, -1);  
        int maxDate = a.get(Calendar.DATE);  
        return maxDate;  
    }  
      
    /** 
     * 根据日期 找到对应日期的 星期 
     */  
    public static String getDayOfWeekByDate(String date) {  
        String dayOfweek = "-1";  
        try {  
            SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");  
            Date myDate = myFormatter.parse(date);  
            SimpleDateFormat formatter = new SimpleDateFormat("E");  
            String str = formatter.format(myDate);  
            dayOfweek = str;  
              
        } catch (Exception e) {  
            System.out.println("错误!");  
        }  
        return dayOfweek;  
    }  
    /**
     * 日期格式化
     * @param str
     * @return
     * @throws ParseException
     */
	public static Calendar stringToCalendar(String str) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(str);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar;
	}
	public static void main(String[] args) {
		int dateOfMonth = getDaysByYearMonth(2016,2);
		System.out.println(dateOfMonth);
	}
	
}
