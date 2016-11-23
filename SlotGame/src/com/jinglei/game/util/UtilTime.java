package com.jinglei.game.util;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Random;

public class UtilTime {
	
	 /**
     * <pre>
     * 	Function Name  :   getNowDate()
     * 	Description   :    取得現在時間 
     * 	Modification 
     * 
     *  @return  Date 返回時間格式  YYYY-MM-DD hh:mm:ss

     * </pre>
     *
     * @author Bear Wu
     * @since 2016. 03. 09.
     * @version 
     *
     */
	public static Date  getNowDate() {
		Date  currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(currentTime);
		ParsePosition pos = new ParsePosition(8);
		Date currentTime_2 = formatter.parse(dateString, pos);
		
		return currentTime_2;		
	}


	/**
     * <pre>
     * 	Function Name  :   getNowDateShort()
     * 	Description   :    取得現在時間 
     * 	Modification 
     * 
     *  @return  Date 返回時間格式  YYYY-MM-DD
     * </pre>
     *
     * @author Bear Wu
     * @since 2016. 03. 09.
     * @version 
     *
     */
	 public static Date getNowDateShort() {
		  Date currentTime = new Date();
		  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		  String dateString = formatter.format(currentTime);
		  ParsePosition pos = new ParsePosition(8);
		  Date currentTime_2 = formatter.parse(dateString, pos);
		  return currentTime_2;
	 }
	 
	/**
	 * <pre>
	 * 	Function Name  :   getCurrentTimeToNumber()
	 * 	Description   :    取得現在時間 
	 * 	Modification 
	 * 
	 *  @return  long    yyyyMMddHHmmss
	 * </pre>
	 *
	 * @author Bear Wu
	 * @since 2016. 03. 09.
	 * @version 
	 *
	 */
	 public static long  getCurrentTimeToNumber() {
		  Date currentTime = new Date();
		  SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		  String dateString = formatter.format(currentTime);
		  return Long.parseLong(dateString);
	 }
	 
	/**
	 * <pre>
	 * 	Function Name  :   getCurrentTimeToNumber()
	 * 	Description   :    取得現在小時時間 
	 * 	Modification 
	 * 
	 *  @return  long    HHmmss
	 * </pre>
	 *
	 * @author Bear Wu
	 * @since 2016. 03. 09.
	 * @version 
	 *
	 */
	 public static long  getCurrentHourToNumber() {
		 Date currentTime = new Date();
		 SimpleDateFormat formatter = new SimpleDateFormat("HHmmss");
		 String dateString = formatter.format(currentTime);
		 return Integer.parseInt(dateString);
	 }	


	 /**
	  * <pre>
	  * 	Function Name  :   getStringDate()
	  * 	Description   :    取得現在時間 
	  * 	Modification 
	  * 
	  *  @return  String 返回時間格式  YYYY-MM-DD hh:mm:ss
	  * </pre>
	  *
	  * @author Bear Wu
	  * @since 2016. 03. 09.
	  * @version 
	  *
	  */
	 public static String getStringDate() {
		  Date currentTime = new Date();
		  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		  String dateString = formatter.format(currentTime);
		  return dateString;
	 }

	 /**
	  * <pre>
	  * 	Function Name  :   getStringDateShort()
	  * 	Description   :    取得現在時間 
	  * 	Modification 
	  * 
	  *  @return  String 返回時間格式  YYYY-MM-DD
	  * </pre>
	  *
	  * @author Bear Wu
	  * @since 2016. 03. 09.
	  * @version 
	  *
	  */
	 public static String getStringDateShort() {
		  Date currentTime = new Date();
		  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		  String dateString = formatter.format(currentTime);
		  return dateString;
	 }
	 
	 /**
	  * <pre>
	  * 	Function Name  :   getTimeShort()
	  * 	Description   :    取得現在時間  時:分:秒  hh:mm:ss
	  * 	Modification 
	  * 
	  *  @return  String 返回時間格式  時:分:秒  hh:mm:ss
	  * </pre>
	  *
	  * @author Bear Wu
	  * @since 2016. 03. 09.
	  * @version 
	  *
	  */
	 public static String getTimeShort() {
		  SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
		  Date currentTime = new Date();
		  String dateString = formatter.format(currentTime);
		  return dateString;
	 }


	 /**
	  * <pre>
	  * 	Function Name  :   strToDateLong(String strDate)
	  * 	Description   :    將長時間格式字串轉換為時間 年-月-日  時:分:秒  yyyy-MM-dd HH:mm:ss
	  * 	Modification 
	  * 
	  *  @return  Date 
	  * </pre>
	  *
	  * @author Bear Wu
	  * @since 2016. 03. 09.
	  * @version 
	  *
	  */
	 public static Date strToDateLong(String strDate) {
		  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		  ParsePosition pos = new ParsePosition(0);
		  Date strtodate = formatter.parse(strDate, pos);
		  return strtodate;
	 }

	 /**
	  * <pre>
	  * 	Function Name  :   dateToStrLong(java.util.Date dateDate)
	  * 	Description   :    將長時間轉換為字串  yyyy-MM-dd HH:mm:ss
	  * 	Modification 
	  * 
	  * 	@param 		java.util.Date dateDate
	  * 
	  *  	@return  String 
	  * </pre>
	  *
	  * @author Bear Wu
	  * @since 2016. 03. 09.
	  * @version 
	  *
	  */
	 public static String dateToStrLong(java.util.Date dateDate) {
		  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		  String dateString = formatter.format(dateDate);
		  return dateString;
	 }

	 /**
	  * <pre>
	  * 	Function Name  :   dateToStr(java.util.Date dateDate)
	  * 	Description   :    將短時間轉換為字串  yyyy-MM-dd
	  * 	Modification 
	  * 
	  * 	@param 		java.util.Date dateDate
	  * 
	  *  	@return  String 
	  * </pre>
	  *
	  * @author Bear Wu
	  * @since 2016. 03. 09.
	  * @version 
	  *
	  */
	 public static String dateToStr(java.util.Date dateDate) {
		  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		  String dateString = formatter.format(dateDate);
		  return dateString;
	 }
	 
	 /**
	  * <pre>
	  * 	Function Name  :   strToDate(String strDate)
	  * 	Description   :    將短時間轉換為字串  yyyy-MM-dd
	  * 	Modification 
	  * 
	  * 	@param 		String strDate
	  * 
	  *  	@return  Date 
	  * </pre>
	  *
	  * @author Bear Wu
	  * @since 2016. 03. 09.
	  * @version 
	  *
	  */
	 public static Date strToDate(String strDate) {
		  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		  ParsePosition pos = new ParsePosition(0);
		  Date strtodate = formatter.parse(strDate, pos);
		  return strtodate;
	 }


	 
	 /**
	  * <pre>
	  * 	Function Name  :   getNow()
	  * 	Description   :    取得現在時間
	  * 	Modification 
	  * 
	  *  	@return  Date 
	  * </pre>
	  *
	  * @author Bear Wu
	  * @since 2016. 03. 09.
	  * @version 
	  *
	  */
	 public static Date getNow() {
		  Date currentTime = new Date();
		  return currentTime;
	 }


	 /**
	  * <pre>
	  * 	Function Name  :   getLastDate(long day)
	  * 	Description   :    提取一個月中的最後一天
	  * 	Modification 
	  * 
	  *  	@return  Date 
	  * </pre>
	  *
	  * @author Bear Wu
	  * @since 2016. 03. 09.
	  * @version 
	  *
	  */	 
	 public static Date getLastDate(long day) {
		  Date date = new Date();
		  long date_3_hm = date.getTime() - 3600000 * 34 * day;
		  Date date_3_hm_date = new Date(date_3_hm);
		  return date_3_hm_date;
	 }

	 /**
	  * <pre>
	  * 	Function Name  :   getStringToday()
	  * 	Description   :    得到現在時間
	  * 	Modification 
	  * 
	  *  	@return  String   yyyyMMdd HHmmss 
	  * </pre>
	  *
	  * @author Bear Wu
	  * @since 2016. 03. 09.
	  * @version 
	  *
	  */
	 public static String getStringToday() {
		  Date currentTime = new Date();
		  SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd HHmmss");
		  String dateString = formatter.format(currentTime);
		  return dateString;
	 }


	 /**
	  * <pre>
	  * 	Function Name  :   getHour()
	  * 	Description   :    得到現在小時
	  * 	Modification 
	  * 			String.substring(int offset, int endIndex)  offset 從0開始  不包含 endIndex 
	  * 
	  *  	@return  String    HH
	  * </pre>
	  *
	  * @author Bear Wu
	  * @since 2016. 03. 09.
	  * @version 
	  *
	  */
	 public static String getHour() {
		  Date currentTime = new Date();
		  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		  String dateString = formatter.format(currentTime);
		  String hour;
		  hour = dateString.substring(11, 13);
		  return hour;
	 }

	 /**
	  * <pre>
	  * 	Function Name  :   getTime()
	  * 	Description   :    得到現在分鐘
	  * 	Modification 
	  * 			String.substring(int offset, int endIndex)  offset 從0開始   不包含 endIndex 
	  * 
	  *  	@return  String    mm
	  * </pre>
	  *
	  * @author Bear Wu
	  * @since 2016. 03. 09.
	  * @version 
	  *
	  */
	 public static String getTime() {
		  Date currentTime = new Date();
		  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		  String dateString = formatter.format(currentTime);
		  String min;
		  min = dateString.substring(14, 16);
		  return min;
	 }

	 /**
	  * <pre>
	  * 	Function Name  :   getUserDate(String sformat)
	  * 	Description   :    根據使用都傳人的時間表示格式，友回當前時間的格式 如果是yyyyMMdd,注意字母y 不能大寫
	  * 	Modification 
	  * 			String.substring(int offset, int endIndex)  offset 從0開始   不包含 endIndex 
	  * 
	  * 	@param 		String sformat
	  * 
	  *  	@return  String    yyyyMMdd
	  * </pre>
	  *
	  * @author Bear Wu
	  * @since 2016. 03. 09.
	  * @version 
	  *
	  */
	 public static String getUserDate(String sformat) {
		  Date currentTime = new Date();
		  SimpleDateFormat formatter = new SimpleDateFormat(sformat);
		  String dateString = formatter.format(currentTime);
		  return dateString;
	 }


	 /**
	  * <pre>
	  * 	Function Name  :   getTwoHour(String st1, String st2)
	  * 	Description   :   二個小時間間的差值，必須保證二個時間都是 "HH:MM"的格式，返恛字串型的分鐘
	  * 	Modification 
	  * 
	  * 	@param 	arg1	String st1
	  * 	@param 	arg2	String st2
	  * 
	  *  	@return  String   
	  * </pre>
	  *
	  * @author Bear Wu
	  * @since 2016. 03. 09.
	  * @version 
	  *
	  */
	 public static String getTwoHour(String st1, String st2) {
		  String[] kk = null;
		  String[] jj = null;
		  kk = st1.split(":");
		  jj = st2.split(":");
		  
		  if (Integer.parseInt(kk[0]) < Integer.parseInt(jj[0])) {
			  return "0";
		  }
		  else {
			   double y = Double.parseDouble(kk[0]) + Double.parseDouble(kk[1]) / 60;
			   double u = Double.parseDouble(jj[0]) + Double.parseDouble(jj[1]) / 60;
			   
			   if ((y - u) > 0) {
				   return y - u + "";
			   }
			   else {
			    return "0";
			   }
		  }
	 }


	 /**
	  * <pre>
	  * 	Function Name  :   getTwoDay(String sj1, String sj2)
	  * 	Description   :   得到二個日期的間隔天數
	  * 	Modification 
	  * 
	  * 	@param 	arg1	String sj1
	  * 	@param 	arg2	String sj2
	  * 
	  *  	@return  String   
	  * </pre>
	  *
	  * @author Bear Wu
	  * @since 2016. 03. 09.
	  * @version 
	  *
	  */
	 public static String getTwoDay(String sj1, String sj2) {
		  SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
		  long day = 0;
		  try {
			   java.util.Date date = myFormatter.parse(sj1);
			   java.util.Date mydate = myFormatter.parse(sj2);
			   day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);
		  } 
		  catch (Exception e) {
			  return "";
		  }
		  
		  return day + "";
	 }
	 
	 /**
	  * <pre>
	  * 	Function Name  :   getPreTime(String sj1, String jj)
	  * 	Description    :   時間前推或後推分鐘，其中jj表示分鐘
	  * 	Modification 
	  * 
	  * 	@param 	arg1	String sj1
	  * 	@param 	arg2	String jj
	  * 
	  *  	@return  String   
	  * </pre>
	  *
	  * @author Bear Wu
	  * @since 2016. 03. 09.
	  * @version 
	  *
	  */
	 public static String getPreTime(String sj1, String jj) {
		  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		  String mydate1 = "";
		  try {
			   Date date1 = format.parse(sj1);
			   long Time = (date1.getTime() / 1000) + Integer.parseInt(jj) * 60;
			   date1.setTime(Time * 1000);
			   mydate1 = format.format(date1);
		  } 
		  catch (Exception e) {
		  }
		  
		  return mydate1;
	 }


	 /**
	  * <pre>
	  * 	Function Name  :   getNextDay(String nowdate, String delay)
	  * 	Description    :   得到一個時間延後或前移幾天的時間，nowdate為時間,delay為前移或後延的天數
	  * 	Modification 
	  * 
	  * 	@param 	arg1	String nowdate
	  * 	@param 	arg2	String delay
	  * 
	  *  	@return  String   
	  * </pre>
	  *
	  * @author Bear Wu
	  * @since 2016. 03. 09.
	  * @version 
	  *
	  */
	 public static String getNextDay(String nowdate, String delay) {
		  try{
			  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			  String mdate = "";
			  Date d = strToDate(nowdate);
			  long myTime = (d.getTime() / 1000) + Integer.parseInt(delay) * 24 * 60 * 60;
			  d.setTime(myTime * 1000);
			  mdate = format.format(d);
			  return mdate;
		  }
		  catch(Exception e){
			  return "";
		  }
	 }


	 /**
	  * <pre>
	  * 	Function Name  :   isLeapYear(String ddate)
	  * 	Description    :   判斷是否潤年
	  * 	Modification 
	  * 
	  * 	@param 	arg1	String ddate
	  * 
	  *  	@return  boolean  
	  * </pre>
	  *
	  * @author Bear Wu
	  * @since 2016. 03. 09.
	  * @version 
	  *
	  */
	 public static boolean isLeapYear(String ddate) {
		  /**
		   *  1.被400整除是潤年
		   *  2.不能被4整除則不是潤年
		   *  3.能被4整除同時不能被100整除則是潤年
		   *  4.能被4整除同時能被100整除則不是潤年
		   */
		  Date d = strToDate(ddate);
		  GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		  gc.setTime(d);
		  int year = gc.get(Calendar.YEAR);
		  
		  if ((year % 400) == 0) {
			  return true;
		  }
		  else if ((year % 4) == 0) {
			   if ((year % 100) == 0) {
			    return false;
			   }
			   else {
				   return true;
			   }
		  } 
		 
		  return false;
	 }


	 /**
	  * <pre>
	  * 	Function Name  :   getEDate(String str)
	  * 	Description    :   返回美國時間格式  
	  * 	Modification 
	  * 
	  * 	@param 	arg1	String str
	  * 
	  *  	@return  str  
	  * </pre>
	  *
	  * @author Bear Wu
	  * @since 2016. 03. 09.
	  * @version 
	  *
	  */
	 public static String getEDate(String str) {
		  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		  ParsePosition pos = new ParsePosition(0);
		  Date strtodate = formatter.parse(str, pos);
		  String j = strtodate.toString();
		  String[] k = j.split(" ");
		  return k[2] + k[1].toUpperCase() + k[5].substring(2, 4);
	 }


	 /**
	  * <pre>
	  * 	Function Name  :   getEndDateOfMonth(String dat)
	  * 	Description    :   獲取一個月的最後一天 
	  * 	Modification 
	  * 
	  * 	@param 	arg1	String str
	  * 
	  *  	@return  str  
	  * </pre>
	  *
	  * @author Bear Wu
	  * @since 2016. 03. 09.
	  * @version 
	  *
	  */
	 public static String getEndDateOfMonth(String dat) {
		 // yyyy-MM-dd
		  String str = dat.substring(0, 8);
		  String month = dat.substring(5, 7);
		  int mon = Integer.parseInt(month);
		  
		  if (mon == 1 || mon == 3 || mon == 5 || mon == 7 || mon == 8 || mon == 10 || mon == 12) {
			  str += "31";
		  } 
		  else if (mon == 4 || mon == 6 || mon == 9 || mon == 11) {
			  str += "30";
		  } 
		  else {
			   if (isLeapYear(dat)) {
				   str += "29";
			   } 
			   else {
				   str += "28";
			   }
		  }
		  return str;
	 }


	 /**
	  * <pre>
	  * 	Function Name  :   isSameWeekDates(Date date1, Date date2)
	  * 	Description    :   判斷二個時間是否在同一週 
	  * 	Modification 
	  * 
	  * 	@param 	arg1	Date date1
	  * 	@param 	arg2	Date date2
	  * 
	  *  	@return  boolean  
	  * </pre>
	  *
	  * @author Bear Wu
	  * @since 2016. 03. 09.
	  * @version 
	  *
	  */
	 public static boolean isSameWeekDates(Date date1, Date date2) {
		  Calendar cal1 = Calendar.getInstance();
		  Calendar cal2 = Calendar.getInstance();
		  
		  cal1.setTime(date1);
		  cal2.setTime(date2);
		  int subYear = cal1.get(Calendar.YEAR) - cal2.get(Calendar.YEAR);
		  
		  if (0 == subYear) {
			   if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2.get(Calendar.WEEK_OF_YEAR)) {
				   return true;
			   }
		  } 
		  else if (1 == subYear && 11 == cal2.get(Calendar.MONTH)) {
			   // 如果12月的最後一週橫跨來年第一周的話貼最後一週即算做來年的第一週
			   if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2.get(Calendar.WEEK_OF_YEAR)) {
				   return true;
			   }
		  }
		  else if (-1 == subYear && 11 == cal1.get(Calendar.MONTH)) {
			   if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2.get(Calendar.WEEK_OF_YEAR)) {
				   return true;
			   }
		  }
		  return false;
	 }

	 /**
	  * <pre>
	  * 	Function Name  :   getSeqWeek()
	  * 	Description    :   產生週序列，即得到當前時間所在的年度是第幾週 
	  * 	Modification 
	  * 
	  *  	@return  String  
	  * </pre>
	  *
	  * @author Bear Wu
	  * @since 2016. 03. 09.
	  * @version 
	  *
	  */
	 public static String getSeqWeek() {
		  Calendar c = Calendar.getInstance(Locale.TAIWAN);
		  String week = Integer.toString(c.get(Calendar.WEEK_OF_YEAR));
		  if (week.length() == 1) {
			  week = "0" + week;
		  }
		  String year = Integer.toString(c.get(Calendar.YEAR));
		  return year + week;
	 }
	 
	 /**
	  * <pre>
	  * 	Function Name  :   getSeqWeek(Locale locale)
	  * 	Description    :   產生週序列，即得到當前時間所在的年度是第幾週 
	  * 	Modification 
	  * 
	  * 	@param 	arg1	Locale locale
	  * 
	  *  	@return  String  
	  * </pre>
	  *
	  * @author Bear Wu
	  * @since 2016. 03. 09.
	  * @version 
	  *
	  */
	 public static String getSeqWeek(Locale locale) {
		  Calendar c = Calendar.getInstance(locale);
		  String week = Integer.toString(c.get(Calendar.WEEK_OF_YEAR));
		  if (week.length() == 1) {
			  week = "0" + week;
		  }
		  String year = Integer.toString(c.get(Calendar.YEAR));
		  return year + week;
	 }

	 /**
	  * <pre>
	  * 	Function Name  :   getWeek(String sdate, String num)
	  * 	Description    :   獲得一個日期所在的週的星期幾的日期
	  * 	Modification 
	  * 				例: 要找出  2016年3月9日  所在週的星期一是幾號
	  * 
	  * 	@param 	arg1	String sdate
	  *  	@param 	arg2	String num   指定星期幾
	  * 
	  *  	@return  String  
	  * </pre>
	  *
	  * @author Bear Wu
	  * @since 2016. 03. 09.
	  * @version 
	  *
	  */
	 public static String getWeek(String sdate, String num) {
		  // 再轉換為時間
		  Date dd = UtilTime.strToDate(sdate);
		  Calendar c = Calendar.getInstance();
		  c.setTime(dd);
		  
		  if (num.equals("1")) { 
			// 返回星期一所在的日期
			  c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		  }
		  else if (num.equals("2")) {
			  // 返回星期二所在的日期
			  c.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
		  }
		  else if (num.equals("3")) {
			  // 返回星期三所在的日期
			  c.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
		  }
		  else if (num.equals("4")) {
			  // 返回星期四所在的日期
			  c.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
		  }
		  else if (num.equals("5")) {
			  // 返回星期五所在的日期
			  c.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
		  }
		  else if (num.equals("6")) {
			  // 返回星期六所在的日期
			  c.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
		  }
		  else if (num.equals("0")) {
			  // 返回星期日所在的日期
			  c.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		  }
		  
		  return new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
	 }


	 /**
	  * 根据一个日期，返回是星期几的字符串
	  * 
	  * @param sdate
	  * @return
	  */
	 
	 /**
	  * <pre>
	  * 	Function Name  :   getWeek(String sdate)
	  * 	Description    :   根據一個日期，返口是星期幾的字串
	  * 	Modification 
	  * 
	  * 	@param 	arg1	String sdate
	  * 
	  *  	@return  String  
	  * </pre>
	  *
	  * @author Bear Wu
	  * @since 2016. 03. 09.
	  * @version 
	  *
	  */
	 public static String getWeek(String sdate) {
		  // 再轉換為時間
		  Date date = UtilTime.strToDate(sdate);
		  Calendar c = Calendar.getInstance();
		  c.setTime(date);
		  // int hour=c.get(Calendar.DAY_OF_WEEK);
		  // hour 中存的就是星期幾了，其范圍1~7
		  // 1=星期日   7=星期六  依此類推
		  return new SimpleDateFormat("EEEE").format(c.getTime());
	 }
	 
	 
	 /**
	  * <pre>
	  * 	Function Name  :   getWeekStr(String sdate)
	  * 	Description    :   顯示該日期為星期幾
	  * 	Modification 
	  * 
	  * 	@param 	arg1	String sdate
	  * 
	  *  	@return  String  
	  * </pre>
	  *
	  * @author Bear Wu
	  * @since 2016. 03. 09.
	  * @version 
	  *
	  */
	 public static String getWeekStr(String sdate) {
		  String str = "";
		  str = UtilTime.getWeek(sdate);
		  if ("1".equals(str)){
			  str = "星期日";
		  }
		  else if("2".equals(str)){
			  str = "星期一";
		  }
		  else if("3".equals(str)){
			  str = "星期二";
		  }
		  else if("4".equals(str)){
			  str = "星期三";
		  }
		  else if("5".equals(str)){
			  str = "星期四";
		  }
		  else if("6".equals(str)){
			  str = "星期五";
		  }
		  else if("7".equals(str)){
			  str = "星期六";
		  }
		  return str;
	 }


	 /**
	  * <pre>
	  * 	Function Name  :   getDays(String date1, String date2)
	  * 	Description    :   兩個時間之間的天數
	  * 	Modification 
	  * 
	  * 	@param 	arg1	String date1
	  * 	@param 	arg2	String date2
	  * 
	  *  	@return  long  
	  * </pre>
	  *
	  * @author Bear Wu
	  * @since 2016. 03. 09.
	  * @version 
	  *
	  */
	 public static long getDays(String date1, String date2) {
		  if (date1 == null || date1.equals("")) {
			  return 0;
		  }
		  
		  if (date2 == null || date2.equals("")) {
			  return 0;
		  }
		  
		  // 轉換為標準時間
		  SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
		  java.util.Date date = null;
		  java.util.Date mydate = null;
		  
		  try {
			  date = myFormatter.parse(date1);
			  mydate = myFormatter.parse(date2);
		  } 
		  catch (Exception e) {
		  }
		  
		  long day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);
		  return day;
	 }

	 /**
	  * <pre>
	  * 	Function Name  :   getNowMonth(String sdate)
	  * 	Description    :   形成如下的日歷， 根據傳入的一個時間返回一個結構  星期日 星期一 星期二 星期三 星期四 星期六 是當月的各個時間
	  * 					        返回該日歷第一行星期日所在日期
	  * 	Modification 
	  * 
	  * 	@param 	arg1	String sdate
	  * 
	  *  	@return  String  
	  * </pre>
	  *
	  * @author Bear Wu
	  * @since 2016. 03. 09.
	  * @version 
	  *
	  */
	 public static String getNowMonth(String sdate) {
		  // 取該時間所在月的一號
		  sdate = sdate.substring(0, 8) + "01";	
	
		  // 得到這個月一號是星期幾
		  Date date = UtilTime.strToDate(sdate);
		  Calendar c = Calendar.getInstance();
		  c.setTime(date);
		  int u = c.get(Calendar.DAY_OF_WEEK);
		  String newday = UtilTime.getNextDay(sdate, (1 - u) + "");
		  return newday;
	 }


	 /**
	  * 取得数据库主键 生成格式为yyyymmddhhmmss+k位随机数
	  * 
	  * @param k
	  *            表示是取几位随机数，可以自己定
	  */
	 
	 /**
	  * <pre>
	  * 	Function Name  :   getNo(int k)
	  * 	Description    :   取得資料庫主鍵 生成格式為 yyyymmddhhmmss+k位隨機數
	  * 	Modification 
	  * 
	  * 	@param 	arg1	int k
	  * 
	  *  	@return  String  
	  * </pre>
	  *
	  * @author Bear Wu
	  * @since 2016. 03. 09.
	  * @version 
	  *
	  */
	 public static String getNo(int k) {
		 return getUserDate("yyyyMMddhhmmss") + getRandom(k);
	 }


	 /**
	  * <pre>
	  * 	Function Name  :   getRandom(int i)
	  * 	Description    :   返告一個隨機數
	  * 	Modification 
	  * 
	  * 	@param 	arg1	int k
	  * 
	  *  	@return  String  
	  * </pre>
	  *
	  * @author Bear Wu
	  * @since 2016. 03. 09.
	  * @version 
	  *
	  */
	 public static String getRandom(int i) {
		  Random jjj = new Random();

		  if (i == 0) {
			  return "";
		  }
		  
		  String jj = "";
		  for (int k = 0; k < i; k++) {
			  jj = jj + jjj.nextInt(9);
		  }
		  
		  return jj;
	 }


	 /**
	  * <pre>
	  * 	Function Name  :   RightDate(String date)
	  * 	Description    :   
	  * 	Modification 
	  * 
	  * 	@param 	arg1	String date
	  * 
	  *  	@return  boolean  
	  * </pre>
	  *
	  * @author Bear Wu
	  * @since 2016. 03. 09.
	  * @version 
	  *
	  */
	 public static boolean RightDate(String date) {
		  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	
		  if (date == null) {
			  return false;
		  }
		  
		  if (date.length() > 10) {
			  sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		  } 
		  else {
			  sdf = new SimpleDateFormat("yyyy-MM-dd");
		  }
		  
		  try {
			  sdf.parse(date);
		  } 
		  catch (ParseException pe) {
			  return false;
		  }
		  
		  return true;
	 }

}
