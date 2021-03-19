package com.agit.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 *
 * @author erwin
 */
public class DateUtil {

    /**
     *
     * @param date
     * @return
     */
    public static Date truncate(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		cal.set(Calendar.AM_PM, Calendar.AM);
		return cal.getTime();
	}

    /**
     *
     * @param date
     * @return
     */
    public static Date endOfDay(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		cal.set(Calendar.MILLISECOND, 999);
		return cal.getTime();
	}

    /**
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int compare(Date date1, Date date2) {
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(date1);
		cal1.set(Calendar.HOUR, 0);
		cal1.set(Calendar.MINUTE, 0);
		cal1.set(Calendar.SECOND, 0);
		cal1.set(Calendar.MILLISECOND, 0);
		cal1.set(Calendar.AM_PM, Calendar.AM);

		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(date2);
		cal2.set(Calendar.HOUR, 0);
		cal2.set(Calendar.MINUTE, 0);
		cal2.set(Calendar.SECOND, 0);
		cal2.set(Calendar.MILLISECOND, 0);
		cal2.set(Calendar.AM_PM, Calendar.AM);

		return cal1.compareTo(cal2);
	}

    /**
     *
     * @param dt
     * @return
     */
    public static Date stringToDate(String dt) {
		// 01-Jun-2016
		DateFormat df = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
		Date startDate = null;
		// String dt1 = dt.substring(0,4)+"/"+dt.substring(4,
		// 6)+"/"+dt.substring(6, 8);
		try {
			startDate = df.parse(dt);
			String newDateString = df.format(startDate);
			System.out.println(newDateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return startDate;
	}
	
    /**
     *
     * @param dt
     * @return
     */
    public static Date stringToDateMMYY(String dt) {
		// 01-Jun-2016
		DateFormat df = new SimpleDateFormat("MMM-yyyy", Locale.ENGLISH);
		Date startDate = null;
		// String dt1 = dt.substring(0,4)+"/"+dt.substring(4,
		// 6)+"/"+dt.substring(6, 8);
		try {
			startDate = df.parse(dt);
			String newDateString = df.format(startDate);
			System.out.println(newDateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return startDate;
	}

    /**
     *
     * @param lDate
     * @param f
     * @return
     * @throws Exception
     */
    public static String DateToString(Date lDate, String f) throws Exception {
		String dateText = null;
		DateFormat df = new SimpleDateFormat(f);
		if (null != lDate) {
			dateText = df.format(lDate);
		}
		return dateText;
	}

    /**
     *
     * @param date
     * @param days
     * @return
     */
    public static Date addDays(Date date, int days) {
		Calendar cal = GregorianCalendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, days); // minus number would decrement the days
		return cal.getTime();
	}

	/**
	 * @param date
	 * @param months
	 * @return
	 */
	public static Date addMonths(Date date, int months) {
		Calendar cal = GregorianCalendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, months); // minus number would decrement the
											// days
		return cal.getTime();
	}

    /**
     *
     * @param date
     * @return
     */
    public static Date getEndofMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, 1);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		cal.add(Calendar.MILLISECOND, -1);

		return cal.getTime();
	}

}
