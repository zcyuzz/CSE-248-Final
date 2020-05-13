
package com.cz.spring.common.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class DateUtil {

    public static String getCurrentDate() {
        return formatDate(new Date());
    }

  
    public static String getCurrentDate(String formate) {
        return formatDate(new Date(), formate);
    }


    public static String getCurrentYear() {
        return formatDate(new Date(), "yyyy");
    }

 
    public static String getCurrentMonth() {
        return formatDate(new Date(), "MM");
    }

    public static String getCurrentDay() {
        return formatDate(new Date(), "dd");
    }


    public static String getCurrentWeek() {
        return getCurrentWeek(new Date());
    }

    public static String getCurrentWeek(Date date) {
        return formatDate(date, "E");
    }


    public static String formatDate(Date date, String formate) {
        SimpleDateFormat sdf = new SimpleDateFormat(formate);
        return sdf.format(date);
    }


    public static String formatDate(Date date) {
        return formatDate(date, "yyyy-MM-dd HH:mm:ss");
    }


    public static Date parseDate(String date, String formate) {
        SimpleDateFormat sdf = new SimpleDateFormat(formate);
        try {
            return sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static Date parseDate(String date) {
        return parseDate(date, "yyyy-MM-dd HH:mm:ss");
    }

  
    public static int compareToDate(String first, String second, String pattern) {
        DateFormat df = new SimpleDateFormat(pattern);
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        try {
            cal1.setTime(df.parse(first));
            cal2.setTime(df.parse(second));
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("error: comapare data");
        }
        int result = cal1.compareTo(cal2);
        if (result < 0) {
            return -1;
        } else if (result > 0) {
            return 1;
        }
        return 0;
    }

    public static int compareToDate(Date first, Date second) {
        int result = first.compareTo(second);
        if (result < 0) {
            return -1;
        } else if (result > 0) {
            return 1;
        }
        return 0;
    }

   
    public static Date getAppointDate(Date date, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, day);
        return calendar.getTime();
    }

   
    public static double getDistanceOfTwoDate(Date before, Date after) {
        long beforeTime = before.getTime();
        long afterTime = after.getTime();
        return (afterTime - beforeTime) / (1000 * 60 * 60 * 24);
    }

   
    public static long pastDays(Date date) {
        long t = new Date().getTime() - date.getTime();
        return t / (24 * 60 * 60 * 1000);
    }

   
    public static long pastHour(Date date) {
        long t = new Date().getTime() - date.getTime();
        return t / (60 * 60 * 1000);
    }

    public static long pastMinutes(Date date) {
        long t = new Date().getTime() - date.getTime();
        return t / (60 * 1000);
    }

    
    public static Date getFirstDayOfWeek() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return cal.getTime();
    }

    
    public static Date getFirstDayOfMonth() {
        Calendar cal = Calendar.getInstance();
        int firstDay = cal.getMinimum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH, firstDay);
        return cal.getTime();
    }


    public static Date getFirstDayOfNextMonth() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, +1);
        int firstDay = cal.getMinimum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH, firstDay);
        return cal.getTime();
    }


    public static int getAgeByBirthDate(Date birtnDay) {
        Calendar cal = Calendar.getInstance();
        if (cal.before(birtnDay)) {
            return 0;
        }
        int yearNow = cal.get(Calendar.YEAR);
        int monthNow = cal.get(Calendar.MONTH);
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
        cal.setTime(birtnDay);
        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH);
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);
        int age = yearNow - yearBirth;
        if (monthNow <= monthBirth) {
            if (monthNow == monthBirth) {
                if (dayOfMonthNow < dayOfMonthBirth) {
                    age--;
                }
            } else {
                age--;
            }
        }
        return age;
    }


    public static List<String> getWeekDays(Date date) {
        List<String> weekDays = new ArrayList<>();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        if (1 == cal.get(Calendar.DAY_OF_WEEK)) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
        }
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        weekDays.add(formatDate(cal.getTime(), "yyyy-MM-dd"));
        for (int i = 1; i < 5; i++) {
            cal.add(Calendar.DATE, 1);
            weekDays.add(formatDate(cal.getTime(), "yyyy-MM-dd"));
        }
        return weekDays;
    }

  
    public static List<String> getMonthDays(Date date) {
        List<String> monthDays = new ArrayList<>();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int firstDay = cal.getMinimum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH, firstDay);
        int cMonth = cal.get(Calendar.MONTH);
        monthDays.add(formatDate(cal.getTime(), "yyyy-MM-dd"));
        for (int i = 1; i < 31; i++) {
            cal.add(Calendar.DATE, 1);
            if (cMonth == cal.get(Calendar.MONTH)) {
                monthDays.add(formatDate(cal.getTime(), "yyyy-MM-dd"));
            }
        }
        return monthDays;
    }
}
