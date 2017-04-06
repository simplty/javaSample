/**
* <p>Title: DateUtil.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2017</p>
* @author 赵涵
* @date Mar 30, 2017
* @version 1.0
*/
package net.simplty.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
* <p>Title: DateUtil</p>
* <p>Description: </p>
* @author    赵涵
* @date Mar 30, 2017
*/
public class DateUtil {

	public static final String MONTH_PATTERN = "yyyyMM";// 八位的时间格式
	public static final String DATE_PATTERN8 = "yyyyMMdd";// 八位的时间格式
	public static final String DATE_PATTERN14 = "yyyyMMddHHmmss";// 十四位的时间格式
	public static final String DATE_PATTERN_ALL = "yyyy-MM-dd HH:mm:ss";// 十四位的bi时间格式
	public static final String DATE_PATTERN = "yyyy-MM-dd";// 十四位的bi时间格式

	/**
	 * 获得当前时间
	 */
	public static String getDate(String pattern) {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		return formatter.format(date);
	}

	/**
	 * 获得当前时间
	 */
	public static String getDate() {
		return getDate(DATE_PATTERN_ALL);
	}

	/**
	 * 转换指定格式的字符串的时间
	 */
	public static String formatDate(Date date) {
		return formatDate(date, DATE_PATTERN_ALL);
	}

	/**
	 * 转换指定格式的字符串的时间
	 */
	public static String formatDate(Date date, String pattern) {
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		return formatter.format(date);
	}

	/**
	 * 将指定格式时间转换为Date类型
	 */
	public static Date formatDate(String strDate, String pattern) {
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		Date date = null;
		try {
			date = format.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
			System.out.println(" 时间格式转换异常！");
		}
		return date;
	}

	public static Date formatDate(String strDate) {
		return formatDate(strDate, DATE_PATTERN_ALL);
	}

	public static Date getTomorrowNow(Date today){
		if(today==null)
			return null;
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(today);
		calendar.add(Calendar.DAY_OF_YEAR,1);
		Date tomorrow = calendar.getTime();
		return tomorrow;
	}
	
	public static Date getTomorrowBegin(Date today){
		if(today==null)
			return null;
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(today);
		calendar.add(Calendar.DAY_OF_YEAR,1);
		Date tomorrow = calendar.getTime();
		return tomorrow;
	}
	
	public static Date getYestodayNow(Date today){
		if(today==null)
			return null;
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(today);
		calendar.add(Calendar.DAY_OF_YEAR,-1);
		Date tomorrow = calendar.getTime();
		return tomorrow;
	}
	
	public static Date getYestodayBegin(Date today){
		if(today==null)
			return null;
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(today);
		calendar.add(Calendar.DAY_OF_YEAR,-1);
		Date tomorrow = calendar.getTime();
		return tomorrow;
	}
	
	/**
	 * 得到几天前的时间
	 * 
	 * @param today 
	 * @param day 天数
	 * @return date
	 */
	public static Date getPreviuosDate(Date today, int day) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(today);
		calendar.add(Calendar.DATE, -day);
		return calendar.getTime();
	}
	
	/**
	 * 得到几天前的时间的字符串
	 * 
	 * @param today 
	 * @param day 天数
	 * @return String
	 */
	public static String getPreviuosDate(Date today, int day, String partten) {
		SimpleDateFormat format = new SimpleDateFormat(partten);
		return format.format(getPreviuosDate(today, day));
	}
	
	public static String getPreviuosMonth(Date today, int month, String partten) {
		SimpleDateFormat format = new SimpleDateFormat(partten);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(today);
		calendar.add(Calendar.MONTH, -month);
		Date resultDate =  calendar.getTime();
		return format.format(resultDate);
	}
	
	
	
	public static void main(String []s){
		Date d = new Date();
		Date m = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(m);
		cal.add(Calendar.MONTH, -1);
		
		System.out.println(formatDate(cal.getTime(),MONTH_PATTERN));
		cal.setTime(m);
		cal.add(Calendar.DATE, -1);
		System.out.println(formatDate(cal.getTime(),DATE_PATTERN8));
		System.out.println(getPreviuosDate(d,2,DATE_PATTERN8));
		System.out.println(getPreviuosMonth(d,2,MONTH_PATTERN));
		
		
	}

}

