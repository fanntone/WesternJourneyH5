package com.jinglei.game.manage;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.SimpleTimeZone;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;

import com.jinglei.game.DevelopmentVersion;
import com.jinglei.game.SysLog;

/*
 * 處理產生 時間轉換  Manage
 * @title   		UtilTimeManage
 *     		
 * @description 	處理產生 時間轉換  Manage
 * 
 *	Pattern 	Example
 *  dd-MM-yy 	31-01-12
 *  dd-MM-yyyy 	31-01-2012
 *  MM-dd-yyyy 	01-31-2012
 *  yyyy-MM-dd 	2012-01-31
 *  yyyy-MM-dd HH:mm:ss 		2012-01-31 23:59:59
 *  yyyy-MM-dd HH:mm:ss.SSS 	2012-01-31 23:59:59.999
 *  yyyy-MM-dd HH:mm:ss.SSSZ 	2012-01-31 23:59:59.999+0100
 *  EEEEE MMMMM yyyy HH:mm:ss.SSSZ 	Saturday November 2012 10:45:42.720+0100
 *  
 *  SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", new Locale("en", "US"));
 *  SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", new Locale("zh", "TW"));  //台灣  
 *
 * @author Bear Wu 2016.03.18
 */
public class UtilTimeManage {
	
	private static volatile int     beginID   = 0;
	private static volatile int     remainder = 1000;
	
	private static volatile int     iNextID   = new Random().nextInt(1000) + beginID;
	
	public static int	getSerialNumber() {
		++iNextID;
		
		if ( (iNextID % remainder) == 0 ) {
			iNextID = beginID;
		}
		else {
			iNextID %= remainder;
		}

		return iNextID;
	}
	
	
	/*
	 *  UtilTimeManage Instance
	 */
	private static UtilTimeManage  instance = null;
	
	/*
	 *  取得 UtilTimeManage Management Instance
	 */
	public static synchronized UtilTimeManage getInstance()  {
        if (instance == null) {
        	instance = new UtilTimeManage();
        }

        return instance;
    }
	
	
	public static String  getManageName() {
		return "UtilTimeManage";
	}
	
	public static Date getTaiwanDate() {
		return Calendar.getInstance(Locale.TAIWAN).getTime();
	}
	 
	/**
	 * <pre>
	 * 	Function Name  :   getCurrentDateToLog()
	 * 	Description   :    取得現在時間 
	 * 	Modification 
	 * 
	 *  @return  String    EEEEE MMMMM yyyy HH:mm:ss
	 * </pre>
	 *
	 * @author Bear Wu
	 * @since 2016. 03. 09.
	 * @version 
	 *
	 */
	 public static String  getCurrentDateToLog() {
		 if ( DevelopmentVersion.VERSION_LOCALE_TAIWAN_TIME) {
			 return UtilTimeManage.getTWCurrentDateToLog();
		 }

		  Date currentTime = new Date();
		  SimpleDateFormat formatter = new SimpleDateFormat("EEEEE MMMMM yyyy HH:mm:ss");
		  formatter.setTimeZone(new SimpleTimeZone(SimpleTimeZone.UTC_TIME, "UTC"));
		  String dateString = formatter.format(currentTime);
		  return dateString;
	 }
	 
	/**
	 * <pre>
	 * 	Function Name  :   getTWCurrentDateToLog()
	 * 	Description   :    取得現在 台灣時間 
	 * 	Modification 
	 * 
	 *  @return  String    EEEEE MMMMM yyyy HH:mm:ss
	 * </pre>
	 *
	 * @author Bear Wu
	 * @since 2016. 03. 09.
	 * @version 
	 *
	 */
	 public static String  getTWCurrentDateToLog() {
		  Date currentTime = new Date();
		  //SimpleDateFormat formatter = new SimpleDateFormat("EEEEE MMMMM yyyy HH:mm:ss",Locale.TAIWAN);
		  SimpleDateFormat formatter = new SimpleDateFormat("EEEEE MMMMM yyyy HH:mm:ss");
		  formatter.setTimeZone(TimeZone.getTimeZone("Asia/Taipei"));
		  //格林威治
		  //formatter.setTimeZone(TimeZone.getTimeZone("GMT"));
		  //formatter.setTimeZone(new SimpleTimeZone(SimpleTimeZone.UTC_TIME, "Asia/Taipei"));
		  //台灣時間
		  //formatter.setTimeZone(TimeZone.getTimeZone("Asia/Taipei"));
		  String dateString = formatter.format(currentTime);
		  return dateString;
	 }
	 
	/**
	 * <pre>
	 * 	Function Name  :   getLocaleDateToLog(Locale locale)
	 * 	Description   :    取得現在時間 
	 * 	Modification 
	 * 
	 *  @return  String    EEEEE MMMMM yyyy HH:mm:ss
	 * </pre>
	 *
	 * @author Bear Wu
	 * @since 2016. 03. 09.
	 * @version 
	 *
	 */
//	 public static String  getLocaleDateToLog(Locale locale) {		 
//		  Date currentTime = new Date();
//		  SimpleDateFormat formatter = new SimpleDateFormat("EEEEE MMMMM yyyy HH:mm:ss",locale);		  
//		  String dateString = formatter.format(currentTime);
//		  return dateString;
//	 }
	 
	/**
	 * <pre>
	 * 	Function Name  :   getLocaleDateToLog(Locale locale)
	 * 	Description   :    取得現在時間 
	 * 	Modification 
	 * 
	 *  @return  String    EEEEE MMMMM yyyy HH:mm:ss
	 * </pre>
	 *
	 * @author Bear Wu
	 * @since 2016. 03. 09.
	 * @version 
	 *
	 */
	 public static String  getTaiwanDateToLog() {
		  Date currentTime = new Date();
		  //SimpleDateFormat formatter = new SimpleDateFormat("EEEEE MMMMM yyyy HH:mm:ss",Locale.TAIWAN);
		  SimpleDateFormat formatter = new SimpleDateFormat("EEEEE MMMMM yyyy HH:mm:ss");	
		  formatter.setTimeZone(TimeZone.getTimeZone("Asia/Taipei"));
		  String dateString = formatter.format(currentTime);
		  return dateString;
	 }
	 
	 
	/**
	 * <pre>
	 * 	Function Name  :   getLocaleTimeToNumber()
	 * 	Description   :    取得Locale 時間 
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
//	 public static long  getLocaleTimeToNumber(Locale locale) {
//		  Date currentTime = new Date();
//		  SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss",locale);		  
//		  String dateString = formatter.format(currentTime);
//		  return Long.parseLong(dateString);
//	 } 	
	 
	 /**
	  * <pre>
	  * 	Function Name  :   getTaiwanTimeToNumber()
	  * 	Description   :    取得 Taiwan Locale 時間 
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
	 public static long  getTaiwanTimeToNumber() {
		  Date currentTime = new Date();
		  //SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss",Locale.TAIWAN);
		  SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		  formatter.setTimeZone(TimeZone.getTimeZone("Asia/Taipei"));
		  String dateString = formatter.format(currentTime);
		  return Long.parseLong(dateString);
	 } 
	 
	 /**
	  * <pre>
	  * 	Function Name  :   changeRecordDateToUTCTime(Long record_date)
	  * 	Description   :    資料庫  yyyyMMddHHmmss  轉換為  UTC TIME
	  * 	Modification 
	  * 
	  * 	@param 	arg1	Long before
	  * 
	  *  	@return  int   
	  * </pre>
	  *
	  * @author Bear Wu
	  * @since 2016. 05. 18.
	  * @version 
	  *
	  */
	 public static Long changeRecordDateToUTCTime(Long record_date) {
		 if ( DevelopmentVersion.VERSION_LOCALE_TAIWAN_TIME) {
			 return UtilTimeManage.changeRecordDateToTaiwan(record_date);
		 }		 
		 
		 SimpleDateFormat myFormatter = new SimpleDateFormat("yyyyMMddHHmmss");
		 myFormatter.setTimeZone(new SimpleTimeZone(SimpleTimeZone.UTC_TIME, "UTC"));

		  try {
			  Date change_date = myFormatter.parse(record_date.toString());	
			  return change_date.getTime();  
		  } 
		  catch (Exception e) {
			  SysLog.PrintException("["+getManageName()+"].[getAfterMinutes] unknow exception in sortCountryRanking: "+ e.getMessage() +"!!!");
			  return (long)0;
		  }
	 }	
	 
	 /**
	  * <pre>
	  * 	Function Name  :   changeRecordDateToTaiwan(Long record_date)
	  * 	Description   :    資料庫  yyyyMMddHHmmss  轉換為  Taiwan Time
	  * 	Modification 
	  * 
	  * 	@param 	arg1	Long before
	  * 
	  *  	@return  int   
	  * </pre>
	  *
	  * @author Bear Wu
	  * @since 2016. 05. 18.
	  * @version 
	  *
	  */
	 public static Long changeRecordDateToTaiwan(Long record_date) {
		 //SimpleDateFormat myFormatter = new SimpleDateFormat("yyyyMMddHHmmss",Locale.TAIWAN);
		 SimpleDateFormat myFormatter = new SimpleDateFormat("yyyyMMddHHmmss");
		 myFormatter.setTimeZone(TimeZone.getTimeZone("Asia/Taipei"));
		// myFormatter.setTimeZone(new SimpleTimeZone(SimpleTimeZone.UTC_TIME, "UTC"));

		  try {
			  Date change_date = myFormatter.parse(record_date.toString());	
			  return change_date.getTime();  
		  } 
		  catch (Exception e) {
			  SysLog.PrintException("["+getManageName()+"].[getAfterMinutes] unknow exception in sortCountryRanking: "+ e.getMessage() +"!!!");
			  return (long)0;
		  }
	 }	
	 
	 /**
	  * <pre>
	  * 	Function Name  :   changeRecordTimeToUTC(Long record_time)
	  * 	Description   :    資料庫  Date().getTime  轉換為  UTC TIME   yyyyMMddHHmmss
	  * 	Modification 
	  * 
	  * 	@param 	arg1	Long before
	  * 
	  *  	@return  int   
	  * </pre>
	  *
	  * @author Bear Wu
	  * @since 2016. 05. 18.
	  * @version 
	  *
	  */
	 public static Long changeRecordTimeToUTC(Long record_time) {
		 
		 if ( DevelopmentVersion.VERSION_LOCALE_TAIWAN_TIME) {
			 return UtilTimeManage.changeRecordTimeToTaiwan(record_time);
		 }	
		 
		 Date changeTime = new Date(record_time);
		 SimpleDateFormat myFormatter = new SimpleDateFormat("yyyyMMddHHmmss");
		 myFormatter.setTimeZone(new SimpleTimeZone(SimpleTimeZone.UTC_TIME, "UTC"));

		  try {
			  String dateString = myFormatter.format(changeTime);
			  return Long.parseLong(dateString);
		  } 
		  catch (Exception e) {
			  SysLog.PrintException("["+getManageName()+"].[getAfterMinutes] unknow exception in sortCountryRanking: "+ e.getMessage() +"!!!");
			  return (long)0;
		  }
	 }
	 
	 /**
	  * <pre>
	  * 	Function Name  :   changeRecordTimeToTaiwan(Long record_time)
	  * 	Description   :    資料庫  Date().getTime  轉換為  Taiwan TIME   yyyyMMddHHmmss
	  * 	Modification 
	  * 
	  * 	@param 	arg1	Long before
	  * 
	  *  	@return  int   
	  * </pre>
	  *
	  * @author Bear Wu
	  * @since 2016. 05. 18.
	  * @version 
	  *
	  */
	 public static Long changeRecordTimeToTaiwan(Long record_time) {
		 
		 Date changeTime = new Date(record_time);
		 //SimpleDateFormat myFormatter = new SimpleDateFormat("yyyyMMddHHmmss",Locale.TAIWAN);
		 SimpleDateFormat myFormatter = new SimpleDateFormat("yyyyMMddHHmmss");
		 myFormatter.setTimeZone(TimeZone.getTimeZone("Asia/Taipei"));
		// myFormatter.setTimeZone(new SimpleTimeZone(SimpleTimeZone.UTC_TIME, "UTC"));

		  try {
			  String dateString = myFormatter.format(changeTime);
			  return Long.parseLong(dateString);
		  } 
		  catch (Exception e) {
			  SysLog.PrintException("["+getManageName()+"].[getAfterMinutes] unknow exception in sortCountryRanking: "+ e.getMessage() +"!!!");
			  return (long)0;
		  }
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
		 if ( DevelopmentVersion.VERSION_LOCALE_TAIWAN_TIME) {
			 return UtilTimeManage.getTaiwanCurrentTimeToNumber();
		 }
		 
		  Date currentTime = new Date();
		  SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		  formatter.setTimeZone(new SimpleTimeZone(SimpleTimeZone.UTC_TIME, "UTC"));
		  String dateString = formatter.format(currentTime);
		  return Long.parseLong(dateString);
	 }
	 
	 /**
	  * <pre>
	  * 	Function Name  :   getTaiwanCurrentTimeToNumber()
	  * 	Description   :    取得現在時間   依  台灣時間
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
	 public static long  getTaiwanCurrentTimeToNumber() {
		  Date currentTime = new Date();
		  //SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss",Locale.TAIWAN);
		  SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		  formatter.setTimeZone(TimeZone.getTimeZone("Asia/Taipei"));
		 // formatter.setTimeZone(new SimpleTimeZone(SimpleTimeZone.UTC_TIME, "UTC"));
		  String dateString = formatter.format(currentTime);
		  return Long.parseLong(dateString);
	 } 
	 

	 /**
	  * <pre>
	  * 	Function Name  :   getTaiwanCurrentTimeToService()
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
		 public static long  getTaiwanCurrentTimeToService() {
			 Date currentTime = new Date();
			 String dateString = "";
			 try {
				  //SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssSSS",Locale.TAIWAN);
				  SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");
				  formatter.setTimeZone(TimeZone.getTimeZone("Asia/Taipei"));
				  //formatter.setTimeZone(new SimpleTimeZone(SimpleTimeZone.UTC_TIME, "UTC"));
				  dateString = formatter.format(currentTime);	

				  return (Long.parseLong(dateString) + UtilTimeManage.getSerialNumber());
			} 
			catch (Exception e) {
				SysLog.PrintException("["+getManageName()+"].[getCurrentTimeToServiceNumber] unknow exception in sortCountryRanking: "+ e.getMessage() +"!!!");
				e.printStackTrace();
			}
			 
			return Long.parseLong(dateString);
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
	 public static long  getCurrentTimeToService() {
		 
		 if ( DevelopmentVersion.VERSION_LOCALE_TAIWAN_TIME) {
			 return UtilTimeManage.getTaiwanCurrentTimeToService();
		 }
		 
		 Date currentTime = new Date();
		 String dateString = "";
		 try {
			  SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");
			  formatter.setTimeZone(new SimpleTimeZone(SimpleTimeZone.UTC_TIME, "UTC"));
			  dateString = formatter.format(currentTime);	

			  return (Long.parseLong(dateString)+UtilTimeManage.getSerialNumber());
		} 
		catch (Exception e) {
			SysLog.PrintException("["+getManageName()+"].[getCurrentTimeToService] unknow exception in sortCountryRanking: "+ e.getMessage() +"!!!");
			e.printStackTrace();
		}
			 
		return (UtilTimeManage.getCurrentTimeToService() + getSerialNumber());
	 }
		 
	 /**
	  * <pre>
	  * 	Function Name  :   getCurrentTimeToNumber()
	  * 	Description   :    取得現在小時時間 UTC
	  * 	Modification 
	  * 
	  *  @return  long    HHmm
	  * </pre>
	  *
	  * @author Bear Wu
	  * @since 2016. 03. 09.
	  * @version 
	  *
	  */
	 public static long  getCurrentHourToNumber() {
		 if ( DevelopmentVersion.VERSION_LOCALE_TAIWAN_TIME) {
			 return UtilTimeManage.getTWCurrentHourToNumber();
		 }
			 
		 Date currentTime = new Date();
		 SimpleDateFormat formatter = new SimpleDateFormat("HHmm");
		 formatter.setTimeZone(new SimpleTimeZone(SimpleTimeZone.UTC_TIME, "UTC"));
		 String dateString = formatter.format(currentTime);
		 return Integer.parseInt(dateString);
	 }	 
	 
	 /**
	  * <pre>
	  * 	Function Name  :   getTWCurrentTimeToNumber()
	  * 	Description   :    取得現在小時時間  Taiwan
	  * 	Modification 
	  * 
	  *  @return  long    HHmm
	  * </pre>
	  *
	  * @author Bear Wu
	  * @since 2016. 03. 09.
	  * @version 
	  *
	  */
	 public static long  getTWCurrentHourToNumber() {			 
		 Date currentTime = new Date();
		 SimpleDateFormat formatter = new SimpleDateFormat("HHmm");
		 formatter.setTimeZone(TimeZone.getTimeZone("Asia/Taipei"));
		// formatter.setTimeZone(new SimpleTimeZone(SimpleTimeZone.UTC_TIME, "UTC"));
		 String dateString = formatter.format(currentTime);
		 return Integer.parseInt(dateString);
	 }	
		 
	 /**
	  * <pre>
	  * 	Function Name  :   getCurrentDateToNumber()
	  * 	Description   :    取得現在日期時間 
	  * 	Modification 
	  * 
	  *  @return  long    yyyyMMdd
	  * </pre>
	  *
	  * @author Bear Wu
	  * @since 2016. 08. 08.
	  * @version 
	  *
	  */
	  public static long  getCurrentDateToNumber() {
		 if ( DevelopmentVersion.VERSION_LOCALE_TAIWAN_TIME) {
			 return UtilTimeManage.getTWCurrentDateToNumber();
		 }
		  
		 Date currentTime = new Date();
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		 formatter.setTimeZone(new SimpleTimeZone(SimpleTimeZone.UTC_TIME, "UTC"));
		 String dateString = formatter.format(currentTime);
		 return Integer.parseInt(dateString);
	 }
	  
	 /**
	  * <pre>
	  * 	Function Name  :   getTWCurrentDateToNumber()
	  * 	Description   :    取得現在日期時間 
	  * 	Modification 
	  * 
	  *  @return  long    yyyyMMdd
	  * </pre>
	  *
	  * @author Bear Wu
	  * @since 2016. 08. 08.
	  * @version 
	  *
	  */
	  public static long  getTWCurrentDateToNumber() {
			 Date currentTime = new Date();
			 SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
			 formatter.setTimeZone(TimeZone.getTimeZone("Asia/Taipei"));
			 //formatter.setTimeZone(new SimpleTimeZone(SimpleTimeZone.UTC_TIME, "UTC"));
			 String dateString = formatter.format(currentTime);
			 return Integer.parseInt(dateString);
	  }	  
			 
	  /**
	   * <pre>
	   * 	Function Name  :   changeRecordDateToUTCTime(Long record_date)
	   * 	Description   :    資料庫  yyyyMMddHHmmss  轉換為  UTC TIME
	   * 	Modification 
	   * 
	   * 	@param 	arg1	Long before
	   * 
	   *  	@return  int   
	   * </pre>
	   *
	   * @author Bear Wu
	   * @since 2016. 05. 18.
	   * @version 
	   *
	   */
	   public static Long changeRecordDateToNumber(Long record_date) {
		   
			 if ( DevelopmentVersion.VERSION_LOCALE_TAIWAN_TIME) {
				 return UtilTimeManage.changeTWRecordDateToNumber(record_date);
			 }
				 
			SimpleDateFormat myFormatter = new SimpleDateFormat("yyyyMMddHHmmss");
			myFormatter.setTimeZone(new SimpleTimeZone(SimpleTimeZone.UTC_TIME, "UTC"));

			try {
				Date before_date = myFormatter.parse(record_date.toString());					 
				SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
				formatter.setTimeZone(new SimpleTimeZone(SimpleTimeZone.UTC_TIME, "UTC"));

				String dateString = formatter.format(before_date);
				return Long.parseLong(dateString);
			} 
			catch (Exception e) {
				SysLog.PrintException("["+getManageName()+"].[getAfterMinutes] unknow exception in sortCountryRanking: "+ e.getMessage() +"!!!");
				return (long)0;
			}
	   }	
	 
	   
	   /**
		* <pre>
		* 	Function Name  :   changeRecordDateToUTCTime(Long record_date)
		* 	Description   :    資料庫  yyyyMMddHHmmss  轉換為  UTC TIME
		* 	Modification 
		* 
		* 	@param 	arg1	Long before
		* 
		*  	@return  int   
		* </pre>
		*
		* @author Bear Wu
		* @since 2016. 05. 18.
		* @version 
		*
		*/
		public static Long changeTWRecordDateToNumber(Long record_date) {					 
			SimpleDateFormat myFormatter = new SimpleDateFormat("yyyyMMddHHmmss");
			myFormatter.setTimeZone(TimeZone.getTimeZone("Asia/Taipei"));

			try {
				Date before_date = myFormatter.parse(record_date.toString());					 
				SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
				formatter.setTimeZone(TimeZone.getTimeZone("Asia/Taipei"));

				String dateString = formatter.format(before_date);
				return Long.parseLong(dateString);
			} 
			catch (Exception e) {
				SysLog.PrintException("["+getManageName()+"].[getAfterMinutes] unknow exception in sortCountryRanking: "+ e.getMessage() +"!!!");
				return (long)0;
			}
		}	   

		 
	 /**
	  * <pre>
	  * 	Function Name  :   getTwoDay(long date1, long date2)
	  * 	Description   :   得到二個日期的間隔天數
	  * 	Modification 
	  * 
	  * 	@param 	arg1	long	date1
	  * 	@param 	arg2	long	date2
	  * 
	  *  	@return  String   
	  * </pre>
	  *
	  * @author Bear Wu
	  * @since 2016. 03. 09.
	  * @version 
	  *
	  */
	 public static int getTwoDay(long date1, long date2) {
		  int day = 0;
		  try {
			  if ( date2 >= date1) {
				   java.util.Date date = new Date(date1);
				   java.util.Date mydate = new Date(date2);
				   day = (int)((date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000));
			  }
			  else {
				  return -1;
			  }
		  } 
		  catch (Exception e) {
			  SysLog.PrintException("["+getManageName()+"].[getTwoDay] unknow exception in sortCountryRanking: "+ e.getMessage() +"!!!");
			  return -1;
		  }
			  
		  return day;
	 }
		 
	 /**
	  * <pre>
	  * 	Function Name  :   getAfterMinutes(Long before)
	  * 	Description   :    取得現在時間與之前時間相差幾分鐘
	  * 	Modification 
	  * 
	  * 	@param 	arg1	Long before
	  * 
	  *  	@return  int   
	  * </pre>
	  *
	  * @author Bear Wu
	  * @since 2016. 03. 09.
	  * @version 
	  *
	  */
	 public static int getAfterMinutes(Long before) {
		 if ( DevelopmentVersion.VERSION_LOCALE_TAIWAN_TIME) {
				return UtilTimeManage.getTWAfterMinutes(before);
		 }
		 
		 SimpleDateFormat myFormatter = new SimpleDateFormat("yyyyMMddHHmm");
		 myFormatter.setTimeZone(new SimpleTimeZone(SimpleTimeZone.UTC_TIME, "UTC"));
		  int minutes = 0;
		  try {
			  Date before_date = myFormatter.parse(before.toString());
			  Date currentTime = new Date();
			  String dateString = myFormatter.format(currentTime);
			  Date checkDate = myFormatter.parse(dateString);			  
				  
			  if ( checkDate.getTime() > before_date.getTime()) {
				  minutes = (int)((checkDate.getTime() - before_date.getTime()) / (60 * 1000));
			  }
			  else {
				  return 0;
			  }
		  } 
		  catch (Exception e) {
			  SysLog.PrintException("["+getManageName()+"].[getAfterMinutes] unknow exception in sortCountryRanking: "+ e.getMessage() +"!!!");
			  return -1;
		  }
			  
		  return minutes;
	 }	
	 
	 /**
	  * <pre>
	  * 	Function Name  :   getTWAfterMinutes(Long before)
	  * 	Description   :    取得現在時間與之前時間相差幾分鐘  依 台灣 時間
	  * 	Modification 
	  * 
	  * 	@param 	arg1	Long before
	  * 
	  *  	@return  int   
	  * </pre>
	  *
	  * @author Bear Wu
	  * @since 2016. 07. 11.
	  * @version 
	  *
	  */
	 public static int getTWAfterMinutes(Long before) {
		 SimpleDateFormat myFormatter = new SimpleDateFormat("yyyyMMddHHmm");
		 myFormatter.setTimeZone(TimeZone.getTimeZone("Asia/Taipei"));
		  int minutes = 0;
		  try {
			  Date before_date = myFormatter.parse(before.toString());
			  Date currentTime = new Date();
			  String dateString = myFormatter.format(currentTime);
			  Date checkDate = myFormatter.parse(dateString);			  
				  
			  if ( checkDate.getTime() > before_date.getTime()) {
				  minutes = (int)((checkDate.getTime() - before_date.getTime()) / (60 * 1000));
			  }
			  else {
				  return 0;
			  }
		  } 
		  catch (Exception e) {
			  SysLog.PrintException("["+getManageName()+"].[getTWAfterMinutes] unknow exception in sortCountryRanking: "+ e.getMessage() +"!!!");
			  return -1;
		  }
			  
		  return minutes;
	 }		 
	 
	 /**
	  * <pre>
	  * 	Function Name  :   getAfterMinutesBySeconds(Long before)
	  * 	Description   :    取得現在時間與之前時間相差幾分鐘 依秒為準
	  * 	Modification 
	  * 
	  * 	@param 	arg1	Long before
	  * 
	  *  	@return  int   
	  * </pre>
	  *
	  * @author Bear Wu
	  * @since 2016. 03. 09.
	  * @version 
	  *
	  */
	 public static int getAfterMinutesBySeconds(Long before) {
		 if ( DevelopmentVersion.VERSION_LOCALE_TAIWAN_TIME) {
				return UtilTimeManage.getTWAfterMinutesBySeconds(before);
		 }		 
		 
		 SimpleDateFormat myFormatter = new SimpleDateFormat("yyyyMMddHHmmss");
		 myFormatter.setTimeZone(new SimpleTimeZone(SimpleTimeZone.UTC_TIME, "UTC"));
		  int minutes = 0;
		  try {
			  Date before_date = myFormatter.parse(before.toString());
			  Date currentTime = new Date();
			  String dateString = myFormatter.format(currentTime);
			  Date checkDate = myFormatter.parse(dateString);			  
				  
			  if ( checkDate.getTime() > before_date.getTime()) {
				  minutes = (int)((checkDate.getTime() - before_date.getTime()) / (60 * 1000));
			  }
			  else {
				  return 0;
			  }
		  } 
		  catch (Exception e) {
			  SysLog.PrintException("["+getManageName()+"].[getAfterMinutes] unknow exception in getAfterMinutesBySeconds: "+ e.getMessage() +"!!!");
			  return -1;
		  }
			  
		  return minutes;
	 }	
	 
	 /**
	  * <pre>
	  * 	Function Name  :   getAfterMinutesBySeconds(Long before)
	  * 	Description   :    取得現在時間與之前時間相差幾分鐘 依秒為準
	  * 	Modification 
	  * 
	  * 	@param 	arg1	Long before
	  * 
	  *  	@return  int   
	  * </pre>
	  *
	  * @author Bear Wu
	  * @since 2016. 03. 09.
	  * @version 
	  *
	  */
	 public static int getTWAfterMinutesBySeconds(Long before) { 
		 
		 SimpleDateFormat myFormatter = new SimpleDateFormat("yyyyMMddHHmmss");
		 myFormatter.setTimeZone(TimeZone.getTimeZone("Asia/Taipei"));

		  int minutes = 0;
		  try {
			  Date before_date = myFormatter.parse(before.toString());
			  Date currentTime = new Date();
			  String dateString = myFormatter.format(currentTime);
			  Date checkDate = myFormatter.parse(dateString);			  
				  
			  if ( checkDate.getTime() > before_date.getTime()) {
				  minutes = (int)((checkDate.getTime() - before_date.getTime()) / (60 * 1000));
			  }
			  else {
				  return 0;
			  }
		  } 
		  catch (Exception e) {
			  SysLog.PrintException("["+getManageName()+"].[getTWAfterMinutesBySeconds] unknow exception in getAfterMinutesBySeconds: "+ e.getMessage() +"!!!");
			  return -1;
		  }
			  
		  return minutes;
	 }		 
	 
	 

	 
	 /**
	  * <pre>
	  * 	Function Name  :   getPassMinuteToNumber(Long before)
	  * 	Description   :    取得現在時間 之後幾分鐘時間
	  * 	Modification 
	  * 
	  * 	@param 	arg1	Long current  		現在時間->yyyyMMddHHmmss
	  *     @param  arg2    int passMinutes     經過時間
	  *     @param  arg3    long[] rtnService   回傳 Service 所使用時間
	  * 
	  *  	@return  long   
	  * </pre>
	  *
	  * @author Bear Wu
	  * @since 2016. 04. 27.
	  * @version 
	  *
	  */	 
	 public static long  getPassMinuteToNumber(Long current,int passMinutes,long[] rtnService) {
		 if ( passMinutes < 1 ) {
			 passMinutes = 1;
		 }
		 
		 if ( DevelopmentVersion.VERSION_LOCALE_TAIWAN_TIME) {
			  return UtilTimeManage.getTWPassMinuteToNumber(current,passMinutes,rtnService);
		 }
		 
		 Long checkCurrentTime = (long)0;
		 if ( current > (UtilTimeManage.getCurrentTimeToNumber() * 100)) {
			 checkCurrentTime = current / 1000;
		  }
		  else {
			  checkCurrentTime = current;
		  }			 
		 
		 SimpleDateFormat myFormatter = new SimpleDateFormat("yyyyMMddHHmmss");
		 myFormatter.setTimeZone(new SimpleTimeZone(SimpleTimeZone.UTC_TIME, "UTC"));
		 
		 SimpleDateFormat myServiceFormatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		 myServiceFormatter.setTimeZone(new SimpleTimeZone(SimpleTimeZone.UTC_TIME, "UTC"));
		
		  try {
			  Date before_date = myFormatter.parse(checkCurrentTime.toString());
			  long nextTime = before_date.getTime() + (passMinutes * ( 60 * 1000 ));
			  
			  String dateString = myFormatter.format(nextTime);
			  
			  /*
			   * 依毫秒算
			   * 1微秒 = 1000 毫秒
			   */
			  Long currentService = (long)0;

			  if ( current > (UtilTimeManage.getCurrentTimeToNumber() * 100)) {
				  currentService = current;
			  }
			  else {
				  currentService = current * 1000;
			  }
			  
			  Date service_date = myServiceFormatter.parse(currentService.toString());
			  
			  long nextServiceTime = service_date.getTime() + (passMinutes * ( 60 * 1000));

			  String serviceString = myServiceFormatter.format(nextServiceTime);
			  rtnService[0] = Long.parseLong(serviceString);
			  
			  return Long.parseLong(dateString);
		  } 
		  catch (Exception e) {
			  SysLog.PrintException("["+getManageName()+"].[getPassMinuteToNumber] unknow exception in sortCountryRanking: "+ e.getMessage() +"!!!");
			  return -1;
		  }
	} 
	 
	 /**
	  * <pre>
	  * 	Function Name  :  getTWPassMinuteToNumber(Long current,int passMinutes,long[] rtnService)
	  * 	Description   :    取得現在時間 之後幾分鐘時間  依 台灣時間
	  * 	Modification 
	  * 
	  * 	@param 	arg1	Long current  		現在時間->yyyyMMddHHmmss
	  *     @param  arg2    int passMinutes     經過時間
	  *     @param  arg3    long[] rtnService   回傳 Service 所使用時間
	  * 
	  *  	@return  long   
	  * </pre>
	  *
	  * @author Bear Wu
	  * @since 2016. 07. 11.
	  * @version 
	  *
	  */	 
	 public static long  getTWPassMinuteToNumber(Long current,int passMinutes,long[] rtnService) {
		 if ( passMinutes < 1 ) {
			 passMinutes = 1;
		 }
		 
		 Long checkCurrentTime = (long)0;
		 if ( current > (UtilTimeManage.getCurrentTimeToNumber() * 100)) {
			 checkCurrentTime = current / 1000;
		  }
		  else {
			  checkCurrentTime = current;
		  }			 
		 
		 //SimpleDateFormat myFormatter = new SimpleDateFormat("yyyyMMddHHmmss",Locale.TAIWAN);
		 SimpleDateFormat myFormatter = new SimpleDateFormat("yyyyMMddHHmmss");
		 myFormatter.setTimeZone(TimeZone.getTimeZone("Asia/Taipei"));
		 
		 //SimpleDateFormat myServiceFormatter = new SimpleDateFormat("yyyyMMddHHmmssSSS",Locale.TAIWAN);
		 SimpleDateFormat myServiceFormatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		 myServiceFormatter.setTimeZone(TimeZone.getTimeZone("Asia/Taipei"));
		
		  try {
			  Date before_date = myFormatter.parse(checkCurrentTime.toString());
			  long nextTime = before_date.getTime() + (passMinutes * ( 60 * 1000 ));
			  
			  String dateString = myFormatter.format(nextTime);
			  
			  /*
			   * 依毫秒算
			   * 1微秒 = 1000 毫秒
			   */
			  Long currentService = (long)0;

			  if ( current > (UtilTimeManage.getCurrentTimeToNumber() * 100)) {
				  currentService = current;
			  }
			  else {
				  currentService = current * 1000;
			  }
			  
			  Date service_date = myServiceFormatter.parse(currentService.toString());
			  
			  long nextServiceTime = service_date.getTime() + (passMinutes * ( 60 * 1000));

			  String serviceString = myServiceFormatter.format(nextServiceTime);
			  rtnService[0] = Long.parseLong(serviceString);
			  
			  return Long.parseLong(dateString);
		  } 
		  catch (Exception e) {
			  SysLog.PrintException("["+getManageName()+"].[getTWPassMinuteToNumber] unknow exception in sortCountryRanking: "+ e.getMessage() +"!!!");
			  return -1;
		  }
	} 
	 
	 /**
	  * <pre>
	  * 	Function Name  :   getPassSecondToNumber(Long before)
	  * 	Description   :    取得現在時間 之後幾秒鐘時間
	  * 	Modification 
	  * 
	  * 	@param 	arg1	Long current  		現在時間->yyyyMMddHHmmss
	  *     @param  arg2    int passSecond     經過時間
	  *     @param  arg3    long[] rtnService   回傳 Service 所使用時間
	  * 
	  *  	@return  long   
	  * </pre>
	  *
	  * @author Bear Wu
	  * @since 2016. 04. 27.
	  * @version 
	  *
	  */	 
	 public static long  getPassSecondToNumber(Long current,int passSecond,long[] rtnService) {
		 if ( passSecond < 1 ) {
			 passSecond = 1;
		 }
		 
		 if ( DevelopmentVersion.VERSION_LOCALE_TAIWAN_TIME) {
			  return UtilTimeManage. getTWPassSecondToNumber(current,passSecond,rtnService);
		 }
		 
		 Long checkCurrentTime = (long)0;
		 if ( current > (UtilTimeManage.getCurrentTimeToNumber() * 100)) {
			 checkCurrentTime = current / 1000;
		  }
		  else {
			  checkCurrentTime = current;
		  }	
		 
		 SimpleDateFormat myFormatter = new SimpleDateFormat("yyyyMMddHHmmss");
		 myFormatter.setTimeZone(new SimpleTimeZone(SimpleTimeZone.UTC_TIME, "UTC"));
		 
		 SimpleDateFormat myServiceFormatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		 myServiceFormatter.setTimeZone(new SimpleTimeZone(SimpleTimeZone.UTC_TIME, "UTC"));
		
		  try {
			  Date before_date = myFormatter.parse(checkCurrentTime.toString());
			  long nextTime = before_date.getTime() + (passSecond  * 1000 );			  
			  
			  String dateString = myFormatter.format(nextTime);
			  
			  /*
			   * 依毫秒算
			   * 1微秒 = 1000 毫秒
			   */
			  Long currentService = (long)0;

			  if ( current > (UtilTimeManage.getCurrentTimeToNumber() * 100)) {
				  currentService = current;
			  }
			  else {
				  currentService = current * 1000;
			  }
			  
			  Date service_date = myServiceFormatter.parse(currentService.toString());

			  /*
			   * 依毫秒算
			   * 1微秒 = 1000 毫秒
			   */
			  long nextServiceTime = service_date.getTime() + (passSecond *  1000);			  
			  
			  String serviceString = myServiceFormatter.format(nextServiceTime);
			  rtnService[0] = Long.parseLong(serviceString);
			  
			  return Long.parseLong(dateString);
		  } 
		  catch (Exception e) {
			  SysLog.PrintException("["+getManageName()+"].[getPassSecondToNumber] unknow exception in sortCountryRanking: "+ e.getMessage() +"!!!");
			  return -1;
		  }
	} 
	 
	 /**
	  * <pre>
	  * 	Function Name  :   getTWPassSecondToNumber(Long current,int passSecond,long[] rtnService)
	  * 	Description   :    取得現在時間 之後幾秒鐘時間 依 台灣時間
	  * 	Modification 
	  * 
	  * 	@param 	arg1	Long current  		現在時間->yyyyMMddHHmmss
	  *     @param  arg2    int passSecond     經過時間
	  *     @param  arg3    long[] rtnService   回傳 Service 所使用時間
	  * 
	  *  	@return  long   
	  * </pre>
	  *
	  * @author Bear Wu
	  * @since 2016. 07. 11.
	  * @version 
	  *
	  */	 
	 public static long  getTWPassSecondToNumber(Long current,int passSecond,long[] rtnService) {
		 if ( passSecond < 1 ) {
			 passSecond = 1;
		 }
		 
		 Long checkCurrentTime = (long)0;
		 if ( current > (UtilTimeManage.getCurrentTimeToNumber() * 100)) {
			 checkCurrentTime = current / 1000;
		  }
		  else {
			  checkCurrentTime = current;
		  }	
		 
		 //SimpleDateFormat myFormatter = new SimpleDateFormat("yyyyMMddHHmmss",Locale.TAIWAN);
		 SimpleDateFormat myFormatter = new SimpleDateFormat("yyyyMMddHHmmss");
		 myFormatter.setTimeZone(TimeZone.getTimeZone("Asia/Taipei"));
		 
		 //SimpleDateFormat myServiceFormatter = new SimpleDateFormat("yyyyMMddHHmmssSSS",Locale.TAIWAN);
		 SimpleDateFormat myServiceFormatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		 myServiceFormatter.setTimeZone(TimeZone.getTimeZone("Asia/Taipei"));
		
		  try {
			  Date before_date = myFormatter.parse(checkCurrentTime.toString());
			  long nextTime = before_date.getTime() + (passSecond  * 1000 );			  
			  
			  String dateString = myFormatter.format(nextTime);
			  
			  /*
			   * 依毫秒算
			   * 1微秒 = 1000 毫秒
			   */
			  Long currentService = (long)0;

			  if ( current > (UtilTimeManage.getCurrentTimeToNumber() * 100)) {
				  currentService = current;
			  }
			  else {
				  currentService = current * 1000;
			  }
			  
			  Date service_date = myServiceFormatter.parse(currentService.toString());

			  /*
			   * 依毫秒算
			   * 1微秒 = 1000 毫秒
			   */
			  long nextServiceTime = service_date.getTime() + (passSecond *  1000);			  
			  
			  String serviceString = myServiceFormatter.format(nextServiceTime);
			  rtnService[0] = Long.parseLong(serviceString);
			  
			  return Long.parseLong(dateString);
		  } 
		  catch (Exception e) {
			  SysLog.PrintException("["+getManageName()+"].[getTWPassSecondToNumber] unknow exception in sortCountryRanking: "+ e.getMessage() +"!!!");
			  return -1;
		  }
	} 
	 
	 /**
	  * <pre>
	  * 	Function Name  :   getPassHourToNumber(Long before)
	  * 	Description   :    取得現在時間 之後幾小時時間
	  * 	Modification 
	  * 
	  * 	@param 	arg1	Long current  		現在時間->yyyyMMddHHmmss
	  *     @param  arg2    int passHour     經過時間
	  *     @param  arg3    long[] rtnService   回傳 Service 所使用時間
	  * 
	  *  	@return  long   
	  * </pre>
	  *
	  * @author Bear Wu
	  * @since 2016. 04. 27.
	  * @version 
	  *
	  */	 
	 public static long  getPassHourToNumber(Long current,int passHour,long[] rtnService) {
		 if ( passHour < 1 ) {
			 passHour = 1;
		 }
		 
		 if ( DevelopmentVersion.VERSION_LOCALE_TAIWAN_TIME) {
			  return UtilTimeManage. getTWPassHourToNumber(current,passHour,rtnService);
		 }
		 
		 Long checkCurrentTime = (long)0;
		 if ( current > (UtilTimeManage.getCurrentTimeToNumber() * 100)) {
			 checkCurrentTime = current / 1000;
		  }
		  else {
			  checkCurrentTime = current;
		  }	
		 
		 SimpleDateFormat myFormatter = new SimpleDateFormat("yyyyMMddHHmmss");
		 myFormatter.setTimeZone(new SimpleTimeZone(SimpleTimeZone.UTC_TIME, "UTC"));
		 
		 SimpleDateFormat myServiceFormatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		 myServiceFormatter.setTimeZone(new SimpleTimeZone(SimpleTimeZone.UTC_TIME, "UTC"));
		
		  try {
			  Date before_date = myFormatter.parse(checkCurrentTime.toString());
			  long nextTime = before_date.getTime() + (passHour * (60 * 60 * 1000 ));
			  
			  String dateString = myFormatter.format(nextTime);
			  
			  /*
			   * 依毫秒算
			   * 1微秒 = 1000 毫秒
			   */
			  Long currentService = (long)0;

			  if ( current > (UtilTimeManage.getCurrentTimeToNumber() * 100)) {
				  currentService = current;
			  }
			  else {
				  currentService = current * 1000;
			  }
			  
			  Date service_date = myServiceFormatter.parse(currentService.toString());
			  
			  /*
			   * 依毫秒算
			   * 1微秒 = 1000 毫秒
			   */
			  long nextServiceTime = service_date.getTime() + (passHour * (60 * 60 * 1000));
			  String serviceString = myServiceFormatter.format(nextServiceTime);
			  rtnService[0] = Long.parseLong(serviceString);
			  
			  return Long.parseLong(dateString);
		  } 
		  catch (Exception e) {
			  SysLog.PrintError("["+getManageName()+"].[getPassHourToNumber] unknow exception in sortCountryRanking: "+ e.getMessage() +"!!!");
			  return -1;
		  }
	}
	 
	 /**
	  * <pre>
	  * 	Function Name  :   getTWPassHourToNumber(Long current,int passHour,long[] rtnService)
	  * 	Description   :    取得現在時間 之後幾小時時間   依 台灣時間
	  * 	Modification 
	  * 
	  * 	@param 	arg1	Long current  		現在時間->yyyyMMddHHmmss
	  *     @param  arg2    int passHour     	經過時間
	  *     @param  arg3    long[] rtnService   回傳 Service 所使用時間
	  * 
	  *  	@return  long   
	  * </pre>
	  *
	  * @author Bear Wu
	  * @since 2016. 07. 11.
	  * @version 
	  *
	  */	 
	 public static long  getTWPassHourToNumber(Long current,int passHour,long[] rtnService) {
		 if ( passHour < 1 ) {
			 passHour = 1;
		 }
		 
		 Long checkCurrentTime = (long)0;
		 if ( current > (UtilTimeManage.getCurrentTimeToNumber() * 100)) {
			 checkCurrentTime = current / 1000;
		  }
		  else {
			  checkCurrentTime = current;
		  }	
		 
		 //SimpleDateFormat myFormatter = new SimpleDateFormat("yyyyMMddHHmmss",Locale.TAIWAN);
		 //SimpleDateFormat myFormatter = new SimpleDateFormat("yyyyMMddHHmmss",new Locale("zh", "TW"));
		 SimpleDateFormat myFormatter = new SimpleDateFormat("yyyyMMddHHmmss");		 
		 myFormatter.setTimeZone(TimeZone.getTimeZone("Asia/Taipei"));
		 
		 //SimpleDateFormat myServiceFormatter = new SimpleDateFormat("yyyyMMddHHmmssSSS",Locale.TAIWAN);
		 //SimpleDateFormat myServiceFormatter = new SimpleDateFormat("yyyyMMddHHmmssSSS",new Locale("zh", "TW"));
		 SimpleDateFormat myServiceFormatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		 myServiceFormatter.setTimeZone(TimeZone.getTimeZone("Asia/Taipei"));
		
		  try {
			  Date before_date = myFormatter.parse(checkCurrentTime.toString());
			  long nextTime = before_date.getTime() + (passHour * (60 * 60 * 1000 ));
			  
			  String dateString = myFormatter.format(nextTime);
			  
			  /*
			   * 依毫秒算
			   * 1微秒 = 1000 毫秒
			   */
			  Long currentService = (long)0;

			  if ( current > (UtilTimeManage.getCurrentTimeToNumber() * 100)) {
				  currentService = current;
			  }
			  else {
				  currentService = current * 1000;
			  }
			  
			  Date service_date = myServiceFormatter.parse(currentService.toString());
			  
			  /*
			   * 依毫秒算
			   * 1微秒 = 1000 毫秒
			   */
			  long nextServiceTime = service_date.getTime() + (passHour * (60 * 60 * 1000));
			  String serviceString = myServiceFormatter.format(nextServiceTime);
			  rtnService[0] = Long.parseLong(serviceString);
			  
			  return Long.parseLong(dateString);
		  } 
		  catch (Exception e) {
			  SysLog.PrintError("["+getManageName()+"].[getTWPassHourToNumber] unknow exception in sortCountryRanking: "+ e.getMessage() +"!!!");
			  return -1;
		  }
	}
	 
	 /**
	  * <pre>
	  * 	Function Name  :   getPassDayToNumber(Long before)
	  * 	Description   :    取得現在時間 之後幾天時間
	  * 	Modification 
	  * 
	  * 	@param 	arg1	Long current  		現在時間->yyyyMMddHHmmss
	  *     @param  arg2    int passDay     	經過時間
	  *     @param  arg3    long[] rtnService   回傳 Service 所使用時間
	  * 
	  *  	@return  long   
	  * </pre>
	  *
	  * @author Bear Wu
	  * @since 2016. 04. 27.
	  * @version 
	  *
	  */	 
	 public static long  getPassDayToNumber(Long current,int passDay,long[] rtnService) {
		 if ( passDay < 1 ) {
			 passDay = 1;
		 }
		 
		 if ( DevelopmentVersion.VERSION_LOCALE_TAIWAN_TIME) {
			  return UtilTimeManage. getTWPassDayToNumber(current,passDay,rtnService);
		 }
		 
		 Long checkCurrentTime = (long)0;
		 if ( current > (UtilTimeManage.getCurrentTimeToNumber() * 100)) {
			 checkCurrentTime = current / 1000;
		 }
		 else {
			  checkCurrentTime = current;
		 }	
		 
		 SimpleDateFormat myFormatter = new SimpleDateFormat("yyyyMMddHHmmss");
		 myFormatter.setTimeZone(new SimpleTimeZone(SimpleTimeZone.UTC_TIME, "UTC"));
		 
		 SimpleDateFormat myServiceFormatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		 myServiceFormatter.setTimeZone(new SimpleTimeZone(SimpleTimeZone.UTC_TIME, "UTC"));
		
		  try {
			  Date before_date = myFormatter.parse(checkCurrentTime.toString());
			  long nextTime = before_date.getTime() + (passDay * (24 * 60 * 60 * 1000 ));
			  
			  String dateString = myFormatter.format(nextTime);
			  
			  /*
			   * 依毫秒算
			   * 1微秒 = 1000 毫秒
			   */
			  Long currentService = (long)0;

			  if ( current > (UtilTimeManage.getCurrentTimeToNumber() * 100)) {
				  currentService = current;
			  }
			  else {
				  currentService = current * 1000;
			  }
			  
			  Date service_date = myServiceFormatter.parse(currentService.toString());
			  
			  /*
			   * 依毫秒算
			   * 1微秒 = 1000 毫秒
			   */
			  long nextServiceTime = service_date.getTime() + (passDay * (24 * 60 * 60 * 1000));
			  String serviceString = myServiceFormatter.format(nextServiceTime);
			  rtnService[0] = Long.parseLong(serviceString);
			  
			  return Long.parseLong(dateString);
		  } 
		  catch (Exception e) {
			  SysLog.PrintException("["+getManageName()+"].[getPassDayToNumber] unknow exception in sortCountryRanking: "+ e.getMessage() +"!!!");
			  return -1;
		  }
	 }
	 
	 /**
	  * <pre>
	  * 	Function Name  :   getTWPassDayToNumber(Long current,int passDay,long[] rtnService)
	  * 	Description   :    取得現在時間 之後幾天時間
	  * 	Modification 
	  * 
	  * 	@param 	arg1	Long current  		現在時間->yyyyMMddHHmmss
	  *     @param  arg2    int passDay     	經過時間
	  *     @param  arg3    long[] rtnService   回傳 Service 所使用時間
	  * 
	  *  	@return  long   
	  * </pre>
	  *
	  * @author Bear Wu
	  * @since 2016. 07.11.
	  * @version 
	  *
	  */	 
	 public static long  getTWPassDayToNumber(Long current,int passDay,long[] rtnService) {
		 if ( passDay < 1 ) {
			 passDay = 1;
		 }
		 
		 Long checkCurrentTime = (long)0;
		 if ( current > (UtilTimeManage.getCurrentTimeToNumber() * 100)) {
			 checkCurrentTime = current / 1000;
		 }
		 else {
			  checkCurrentTime = current;
		 }	
		 
		 //SimpleDateFormat myFormatter = new SimpleDateFormat("yyyyMMddHHmmss",Locale.TAIWAN);
		 SimpleDateFormat myFormatter = new SimpleDateFormat("yyyyMMddHHmmss");
		 myFormatter.setTimeZone(TimeZone.getTimeZone("Asia/Taipei"));

		 
		 //SimpleDateFormat myServiceFormatter = new SimpleDateFormat("yyyyMMddHHmmssSSS",Locale.TAIWAN);
		 SimpleDateFormat myServiceFormatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		 myServiceFormatter.setTimeZone(TimeZone.getTimeZone("Asia/Taipei"));
		
		  try {
			  Date before_date = myFormatter.parse(checkCurrentTime.toString());
			  long nextTime = before_date.getTime() + (passDay * (24 * 60 * 60 * 1000 ));
			  
			  String dateString = myFormatter.format(nextTime);
			  
			  /*
			   * 依毫秒算
			   * 1微秒 = 1000 毫秒
			   */
			  Long currentService = (long)0;

			  if ( current > (UtilTimeManage.getCurrentTimeToNumber() * 100)) {
				  currentService = current;
			  }
			  else {
				  currentService = current * 1000;
			  }
			  
			  Date service_date = myServiceFormatter.parse(currentService.toString());
			  
			  /*
			   * 依毫秒算
			   * 1微秒 = 1000 毫秒
			   */
			  long nextServiceTime = service_date.getTime() + (passDay * (24 * 60 * 60 * 1000));
			  String serviceString = myServiceFormatter.format(nextServiceTime);
			  rtnService[0] = Long.parseLong(serviceString);
			  
			  return Long.parseLong(dateString);
		  } 
		  catch (Exception e) {
			  SysLog.PrintException("["+getManageName()+"].[getTWPassDayToNumber] unknow exception in sortCountryRanking: "+ e.getMessage() +"!!!");
			  return -1;
		  }
	 }

		 
	 /**
	  * <pre>
	  * 	Function Name  :   getAfterMinutes(Long before)
	  * 	Description   :    取得現在時間與之前時間相差幾分鐘
	  * 	Modification 
	  * 
	  * 	@param 	arg1	Long before
	  * 
	  *  	@return  int   
	  * </pre>
	  *
	  * @author Bear Wu
	  * @since 2016. 03. 09.
	  * @version 
	  *
	  */
	 public static int getAfterHours(Long before) {
		 
		 if ( DevelopmentVersion.VERSION_LOCALE_TAIWAN_TIME) {
			  return UtilTimeManage. getTWAfterHours(before);
		 }
		 
		 SimpleDateFormat myFormatter = new SimpleDateFormat("yyyyMMddHHmm");
		 myFormatter.setTimeZone(new SimpleTimeZone(SimpleTimeZone.UTC_TIME, "UTC"));
		 
		  int Hours = 0;
		  try {
			  Date before_date = myFormatter.parse(before.toString());
			  Date currentTime = new Date();
			  String dateString = myFormatter.format(currentTime);
			  Date checkDate = myFormatter.parse(dateString);
			  
			  if ( checkDate.getTime() > before_date.getTime()) {
				  Hours = (int)((checkDate.getTime() - before_date.getTime()) / (60 * 60 * 1000));
			  }
			  else {
				  return 0;
			  }
		  } 
		  catch (Exception e) {
			  SysLog.PrintException("["+getManageName()+"].[getAfterHours] unknow exception in sortCountryRanking: "+ e.getMessage() +"!!!");
			  return -1;
		  }
		  
		  return Hours;
	 }
	 
	 /**
	  * <pre>
	  * 	Function Name  :   getTWAfterHours(Long before)
	  * 	Description   :    取得現在時間與之前時間相差幾分鐘   依  台灣時間
	  * 	Modification 
	  * 
	  * 	@param 	arg1	Long before
	  * 
	  *  	@return  int   
	  * </pre>
	  *
	  * @author Bear Wu
	  * @since 2016. 07. 11.
	  * @version 
	  *
	  */
	 public static int getTWAfterHours(Long before) {
		 //SimpleDateFormat myFormatter = new SimpleDateFormat("yyyyMMddHHmm",Locale.TAIWAN);
		 SimpleDateFormat myFormatter = new SimpleDateFormat("yyyyMMddHHmm");
		 myFormatter.setTimeZone(TimeZone.getTimeZone("Asia/Taipei"));
		 
		  int Hours = 0;
		  try {
			  Date before_date = myFormatter.parse(before.toString());
			  Date currentTime = new Date();
			  String dateString = myFormatter.format(currentTime);
			  Date checkDate = myFormatter.parse(dateString);
			  
			  if ( checkDate.getTime() > before_date.getTime()) {
				  Hours = (int)((checkDate.getTime() - before_date.getTime()) / (60 * 60 * 1000));
			  }
			  else {
				  return 0;
			  }
		  } 
		  catch (Exception e) {
			  SysLog.PrintException("["+getManageName()+"].[getTWAfterHours] unknow exception in sortCountryRanking: "+ e.getMessage() +"!!!");
			  return -1;
		  }
		  
		  return Hours;
	 }
		 
	 /**
	  * <pre>
	  * 	Function Name  :   isExpiryDate(String starting,String expiry)
	  * 	Description   :  判斷是否到期 
	  * 	Modification 
	  * 
	  * 	@param 	arg1	String starting
	  * 	@param 	arg2	String expiry
	  * 
	  *  	@return  String   
	  * </pre>
	  *
	  * @author Bear Wu
	  * @since 2016. 03. 09.
	  * @version 
	  *
	  */
	 public static boolean isExpiryDate(String starting,String expiry) {
		 if ( DevelopmentVersion.VERSION_LOCALE_TAIWAN_TIME) {
			  return UtilTimeManage.isTWExpiryDate(starting,expiry);
		 }
		 
		 SimpleDateFormat myFormatter = new SimpleDateFormat("yyyyMMddHHmm");
		 myFormatter.setTimeZone(new SimpleTimeZone(SimpleTimeZone.UTC_TIME, "UTC"));
		  try {
			   Date start_date = myFormatter.parse(starting);
			   Date expiry_date = myFormatter.parse(expiry);
			   Date currentTime = new Date();
			   String dateString = myFormatter.format(currentTime);
			   Date checkDate = myFormatter.parse(dateString);
			   
			   SysLog.PrintDebug("[isExpiryDate] Start Date:"+start_date.getTime()+" , Expiry Date:"+expiry_date.getTime()+" ,Check Date:"+checkDate.getTime());

			   if ( start_date.getTime() <= checkDate.getTime() &&
				   checkDate.getTime() <= expiry_date.getTime()) {
				   SysLog.PrintDebug("[isExpiryDate].[TRUE] Start Date:"+start_date.getTime()+" , Expiry Date:"+expiry_date.getTime()+" ,Check Date:"+checkDate.getTime());

				   return false;
			   }
		 } 
		 catch (Exception e) {
			 SysLog.PrintException("["+getManageName()+"].[isExpiryDate] unknow exception in sortCountryRanking: "+ e.getMessage() +"!!!");
			 return true;
		 }
			  
		  return true;
	 }
	 
	 /**
	  * <pre>
	  * 	Function Name  :   isTWExpiryDate(String starting,String expiry)
	  * 	Description   :  判斷是否到期   依  台灣時間
	  * 	Modification 
	  * 
	  * 	@param 	arg1	String starting
	  * 	@param 	arg2	String expiry
	  * 
	  *  	@return  boolean true/false   
	  * </pre>
	  *
	  * @author Bear Wu
	  * @since 2016. 07. 11.
	  * @version 
	  *
	  */
	 public static boolean isTWExpiryDate(String starting,String expiry) {
		 //SimpleDateFormat myFormatter = new SimpleDateFormat("yyyyMMddHHmm",Locale.TAIWAN);
		 SimpleDateFormat myFormatter = new SimpleDateFormat("yyyyMMddHHmm");
		 myFormatter.setTimeZone(TimeZone.getTimeZone("Asia/Taipei"));

		  try {
			   Date start_date = myFormatter.parse(starting);
			   Date expiry_date = myFormatter.parse(expiry);
			   Date currentTime = new Date();
			   String dateString = myFormatter.format(currentTime);
			   Date checkDate = myFormatter.parse(dateString);
			   
			   SysLog.PrintDebug("[isExpiryDate] Start Date:"+start_date.getTime()+" , Expiry Date:"+expiry_date.getTime()+" ,Check Date:"+checkDate.getTime());

			   if ( start_date.getTime() <= checkDate.getTime() &&
				   checkDate.getTime() <= expiry_date.getTime()) {
				   SysLog.PrintDebug("[isExpiryDate].[TRUE] Start Date:"+start_date.getTime()+" , Expiry Date:"+expiry_date.getTime()+" ,Check Date:"+checkDate.getTime());

				   return false;
			   }
		 } 
		 catch (Exception e) {
			 SysLog.PrintException("["+getManageName()+"].[isTWExpiryDate] unknow exception in sortCountryRanking: "+ e.getMessage() +"!!!");
			 return true;
		 }
			  
		  return true;
	 }
	 
	 /**
	  * <pre>
	  * 	Function Name  :   isExpiryDate(String starting,String expiry)
	  * 	Description   :  判斷是否到期 
	  * 	Modification 
	  * 
	  * 	@param 	arg1	String starting
	  * 	@param 	arg2	String expiry
	  * 
	  *  	@return  String   
	  * </pre>
	  *
	  * @author Bear Wu
	  * @since 2016. 03. 09.
	  * @version 
	  *
	  */
	 public static boolean isDBExpiryDate(Long starting,Long expiry) {
		 if ( DevelopmentVersion.VERSION_LOCALE_TAIWAN_TIME) {
			  return UtilTimeManage.isDBTWExpiryDate(starting,expiry);
		 }
		 
		 SimpleDateFormat myFormatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		 myFormatter.setTimeZone(new SimpleTimeZone(SimpleTimeZone.UTC_TIME, "UTC"));
		 
		  try {
			  Date start_date = myFormatter.parse(starting.toString());
			  Date currentTime = new Date();
			  String dateString = myFormatter.format(currentTime);
			  Date checkDate = myFormatter.parse(dateString);
				  
			  if ( starting >= 1 && expiry >= 1) {				   
				   Date expiry_date = myFormatter.parse(expiry.toString());		
				   SysLog.PrintDebug("[isExpiryDate] Start Date:"+starting.toString()+" , Expiry Date:"+expiry.toString()+" ,Check Date:"+dateString);
				   SysLog.PrintDebug("[isExpiryDate] Start Date:"+start_date.getTime()+" , Expiry Date:"+expiry_date.getTime()+" ,Check Date:"+checkDate.getTime());
						   
				   if ( start_date.getTime() <= checkDate.getTime() &&
						checkDate.getTime() <= expiry_date.getTime()) {
					   SysLog.PrintDebug("[isExpiryDate].[TRUE] Start Date:"+start_date.getTime()+" , Expiry Date:"+expiry_date.getTime()+" ,Check Date:"+checkDate.getTime());
		
					   return false;
				   }
			  }			  
			  else {
				  if ( starting >= 1 && expiry == 0 ) {			  
					   if ( start_date.getTime() <= checkDate.getTime() ) {
						   SysLog.PrintDebug("[isExpiryDate].[TRUE] Start Date:"+start_date.getTime()+" ,Check Date:"+checkDate.getTime());
							   return false;
					   }
				  }
				  else if ( starting == 0 && expiry == 0 ) {
					  return false;
				  }
			  }
		  } 
		  catch (Exception e) {
			  SysLog.PrintException("[Exception].unknow exception in isExpiryDate(Long starting,Long expiry) : "+ e.getMessage() +"");
			  return true;
		  }
			  
		  return true;
	 }
	 
	 /**
	  * <pre>
	  * 	Function Name  :   isTWExpiryDate(Long starting,Long expiry)
	  * 	Description   :  判斷是否到期   依  台灣時間
	  * 	Modification 
	  * 
	  * 	@param 	arg1	Long starting
	  * 	@param 	arg2	Long expiry
	  * 
	  *  	@return  boolean   
	  * </pre>
	  *
	  * @author Bear Wu
	  * @since 2016. 07. 11.
	  * @version 
	  *
	  */
	 public static boolean isDBTWExpiryDate(Long starting,Long expiry) {
		 //SimpleDateFormat myFormatter = new SimpleDateFormat("yyyyMMddHHmm",Locale.TAIWAN);
		 SimpleDateFormat myFormatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		 myFormatter.setTimeZone(TimeZone.getTimeZone("Asia/Taipei"));
		 
		  try {
			  Date start_date = myFormatter.parse(starting.toString());
			  Date currentTime = new Date();
			  String dateString = myFormatter.format(currentTime);
			  Date checkDate = myFormatter.parse(dateString);
				  
			  if ( starting >= 1 && expiry >= 1) {				   
				   Date expiry_date = myFormatter.parse(expiry.toString());				   
				   SysLog.PrintDebug("[isExpiryDate] Start Date:"+start_date.getTime()+" , Expiry Date:"+expiry_date.getTime()+" ,Check Date:"+checkDate.getTime());
						   
				   if ( start_date.getTime() <= checkDate.getTime() &&
						checkDate.getTime() <= expiry_date.getTime()) {
					   SysLog.PrintDebug("[isExpiryDate].[TRUE] Start Date:"+start_date.getTime()+" , Expiry Date:"+expiry_date.getTime()+" ,Check Date:"+checkDate.getTime());
		
					   return false;
				   }
			  }
			  else if ( starting >= 1 && expiry == 0 ) {
				   if ( start_date.getTime() <= checkDate.getTime() ) {
					   SysLog.PrintDebug("[isExpiryDate].[TRUE] Start Date:"+start_date.getTime()+" ,Check Date:"+checkDate.getTime());
						   return false;
				   }				  
			  }
		  } 
		  catch (Exception e) {
			  SysLog.PrintException("[Exception].unknow exception in isExpiryDate(Long starting,Long expiry) : "+ e.getMessage() +"");
			  return true;
		  }
			  
		  return true;
	 }
		 
	 /**
	  * <pre>
	  * 	Function Name  :   isExpiryDate(String starting,String expiry)
	  * 	Description   :  判斷是否到期 
	  * 	Modification 
	  * 
	  * 	@param 	arg1	String starting
	  * 	@param 	arg2	String expiry
	  * 
	  *  	@return  String   
	  * </pre>
	  *
	  * @author Bear Wu
	  * @since 2016. 03. 09.
	  * @version 
	  *
	  */
	 public static boolean isExpiryDate(Long starting,Long expiry) {
		 if ( DevelopmentVersion.VERSION_LOCALE_TAIWAN_TIME) {
			  return UtilTimeManage.isTWExpiryDate(starting,expiry);
		 }
		 
		 SimpleDateFormat myFormatter = new SimpleDateFormat("yyyyMMddHHmm");
		 myFormatter.setTimeZone(new SimpleTimeZone(SimpleTimeZone.UTC_TIME, "UTC"));
		 
		  try {
			  Date start_date = myFormatter.parse(starting.toString());
			  Date currentTime = new Date();
			  String dateString = myFormatter.format(currentTime);
			  Date checkDate = myFormatter.parse(dateString);
				  
			  if ( starting >= 1 && expiry >= 1) {				   
				   Date expiry_date = myFormatter.parse(expiry.toString());		
				   SysLog.PrintDebug("[isExpiryDate] Start Date:"+starting.toString()+" , Expiry Date:"+expiry.toString()+" ,Check Date:"+dateString);
				   SysLog.PrintDebug("[isExpiryDate] Start Date:"+start_date.getTime()+" , Expiry Date:"+expiry_date.getTime()+" ,Check Date:"+checkDate.getTime());
						   
				   if ( start_date.getTime() <= checkDate.getTime() &&
						checkDate.getTime() <= expiry_date.getTime()) {
					   SysLog.PrintDebug("[isExpiryDate].[TRUE] Start Date:"+start_date.getTime()+" , Expiry Date:"+expiry_date.getTime()+" ,Check Date:"+checkDate.getTime());
		
					   return false;
				   }
			  }			  
			  else {
				  if ( starting >= 1 && expiry == 0 ) {			  
					   if ( start_date.getTime() <= checkDate.getTime() ) {
						   SysLog.PrintDebug("[isExpiryDate].[TRUE] Start Date:"+start_date.getTime()+" ,Check Date:"+checkDate.getTime());
							   return false;
					   }
				  }
				  else if ( starting == 0 && expiry == 0 ) {
					  return false;
				  }
			  }
		  } 
		  catch (Exception e) {
			  SysLog.PrintException("[Exception].unknow exception in isExpiryDate(Long starting,Long expiry) : "+ e.getMessage() +"");
			  return true;
		  }
			  
		  return true;
	 }
	 
	 /**
	  * <pre>
	  * 	Function Name  :   isTWExpiryDate(Long starting,Long expiry)
	  * 	Description   :  判斷是否到期   依  台灣時間
	  * 	Modification 
	  * 
	  * 	@param 	arg1	Long starting
	  * 	@param 	arg2	Long expiry
	  * 
	  *  	@return  boolean   
	  * </pre>
	  *
	  * @author Bear Wu
	  * @since 2016. 07. 11.
	  * @version 
	  *
	  */
	 public static boolean isTWExpiryDate(Long starting,Long expiry) {
		 //SimpleDateFormat myFormatter = new SimpleDateFormat("yyyyMMddHHmm",Locale.TAIWAN);
		 SimpleDateFormat myFormatter = new SimpleDateFormat("yyyyMMddHHmm");
		 myFormatter.setTimeZone(TimeZone.getTimeZone("Asia/Taipei"));
		 
		  try {
			  Date start_date = myFormatter.parse(starting.toString());
			  Date currentTime = new Date();
			  String dateString = myFormatter.format(currentTime);
			  Date checkDate = myFormatter.parse(dateString);
				  
			  if ( starting >= 1 && expiry >= 1) {				   
				   Date expiry_date = myFormatter.parse(expiry.toString());				   
				   SysLog.PrintDebug("[isExpiryDate] Start Date:"+start_date.getTime()+" , Expiry Date:"+expiry_date.getTime()+" ,Check Date:"+checkDate.getTime());
						   
				   if ( start_date.getTime() <= checkDate.getTime() &&
						checkDate.getTime() <= expiry_date.getTime()) {
					   SysLog.PrintDebug("[isExpiryDate].[TRUE] Start Date:"+start_date.getTime()+" , Expiry Date:"+expiry_date.getTime()+" ,Check Date:"+checkDate.getTime());
		
					   return false;
				   }
			  }
			  else if ( starting >= 1 && expiry == 0 ) {
				   if ( start_date.getTime() <= checkDate.getTime() ) {
					   SysLog.PrintDebug("[isExpiryDate].[TRUE] Start Date:"+start_date.getTime()+" ,Check Date:"+checkDate.getTime());
						   return false;
				   }				  
			  }
		  } 
		  catch (Exception e) {
			  SysLog.PrintException("[Exception].unknow exception in isExpiryDate(Long starting,Long expiry) : "+ e.getMessage() +"");
			  return true;
		  }
			  
		  return true;
	 }
		 
	 /**
	  * <pre>
	  * 	Function Name  :   isExpiryDate(String starting,String expiry)
	  * 	Description   :  判斷是否到期 
	  * 	Modification 
	  * 
	  * 	@param 	arg1	String starting
	  * 	@param 	arg2	String expiry
	  * 
	  *  	@return  String   
	  * </pre>
	  *
	  * @author Bear Wu
	  * @since 2016. 03. 09.
	  * @version 
	  *
	  */
	 public static boolean isExpiryDateByDay(String starting,String expiry) {
		 if ( DevelopmentVersion.VERSION_LOCALE_TAIWAN_TIME) {
			  return UtilTimeManage.isTWExpiryDateByDay(starting,expiry);
		 }
		 
		 SimpleDateFormat myFormatter = new SimpleDateFormat("HHmm");
		 myFormatter.setTimeZone(new SimpleTimeZone(SimpleTimeZone.UTC_TIME, "UTC"));
		 
		  try {
			   Date start_date = myFormatter.parse(starting);
			   Date expiry_date = myFormatter.parse(expiry);
			   Date currentTime = new Date();
			   String dateString = myFormatter.format(currentTime);
			   Date checkDate = myFormatter.parse(dateString);
				   
			   SysLog.PrintDebug("[isExpiryDateByDay] Start Date:"+start_date.getTime()+" , Expiry Date:"+expiry_date.getTime()+" ,Check Date:"+checkDate.getTime());

			   if ( start_date.getTime() <= checkDate.getTime() &&
					checkDate.getTime() <= expiry_date.getTime()) {
				   SysLog.PrintDebug("[isExpiryDateByDay].[TRUE] Start Date:"+start_date.getTime()+" , Expiry Date:"+expiry_date.getTime()+" ,Check Date:"+checkDate.getTime());

				   return false;
			   }
		  } 
		  catch (Exception e) {
			  SysLog.PrintException("[Exception].unknow exception in isExpiryDateByDay(String starting,String expiry) : "+ e.getMessage() +"");
			  return true;
		  }
			  
		  return true;
	 }
	 
	 /**
	  * <pre>
	  * 	Function Name  :   isTWExpiryDateByDay(String starting,String expiry)
	  * 	Description   :  判斷是否到期   依  台灣時間
	  * 	Modification 
	  * 
	  * 	@param 	arg1	String starting
	  * 	@param 	arg2	String expiry
	  * 
	  *  	@return  String   
	  * </pre>
	  *
	  * @author Bear Wu
	  * @since 2016. 07. 11.
	  * @version 
	  *
	  */
	 public static boolean isTWExpiryDateByDay(String starting,String expiry) {
		 //SimpleDateFormat myFormatter = new SimpleDateFormat("HHmm",Locale.TAIWAN);
		 SimpleDateFormat myFormatter = new SimpleDateFormat("HHmm");
		 myFormatter.setTimeZone(TimeZone.getTimeZone("Asia/Taipei"));
		 
		  try {
			   Date start_date = myFormatter.parse(starting);
			   Date expiry_date = myFormatter.parse(expiry);
			   Date currentTime = new Date();
			   String dateString = myFormatter.format(currentTime);
			   Date checkDate = myFormatter.parse(dateString);
				   
			   SysLog.PrintDebug("[isExpiryDateByDay] Start Date:"+start_date.getTime()+" , Expiry Date:"+expiry_date.getTime()+" ,Check Date:"+checkDate.getTime());

			   if ( start_date.getTime() <= checkDate.getTime() &&
					checkDate.getTime() <= expiry_date.getTime()) {
				   SysLog.PrintDebug("[isExpiryDateByDay].[TRUE] Start Date:"+start_date.getTime()+" , Expiry Date:"+expiry_date.getTime()+" ,Check Date:"+checkDate.getTime());

				   return false;
			   }
		  } 
		  catch (Exception e) {
			  SysLog.PrintException("[Exception].unknow exception in isTWExpiryDateByDay(String starting,String expiry) : "+ e.getMessage() +"");
			  return true;
		  }
			  
		  return true;
	 }
		 
	 /**
	  * <pre>
	  * 	Function Name  :   isExpiryDateByDay(Integer starting,Integer expiry)
	  * 	Description   :  判斷是否到期     依  台灣時間
	  * 	Modification 
	  * 
	  * 	@param 	arg1	Integer starting
	  * 	@param 	arg2	Integer expiry
	  * 
	  *  	@return  boolean true/false   
	  * </pre>
	  * @author Bear Wu
	  * @since 2016. 07. 11.
	  * @version 
	  *
	  */
	 public static boolean isExpiryDateByDay(Integer starting,Integer expiry) {
		 if ( DevelopmentVersion.VERSION_LOCALE_TAIWAN_TIME) {
			  return UtilTimeManage.isTWExpiryDateByDay(starting,expiry);
		 }
		 
		 SimpleDateFormat myFormatter = new SimpleDateFormat("HHmm");
		 myFormatter.setTimeZone(new SimpleTimeZone(SimpleTimeZone.UTC_TIME, "UTC"));
		  try {
			   Date start_date = myFormatter.parse(starting.toString());
			   Date expiry_date = myFormatter.parse(expiry.toString());
			   Date currentTime = new Date();
			   String dateString = myFormatter.format(currentTime);
			   Date checkDate = myFormatter.parse(dateString);
			   
			   SysLog.PrintDebug("[isExpiryDateByDay] Start Date:"+start_date.getTime()+" , Expiry Date:"+expiry_date.getTime()+" ,Check Date:"+checkDate.getTime());

			   if ( start_date.getTime() <= checkDate.getTime() &&
					checkDate.getTime() <= expiry_date.getTime()) {
				   SysLog.PrintDebug("[isExpiryDateByDay].[TRUE] Start Date:"+start_date.getTime()+" , Expiry Date:"+expiry_date.getTime()+" ,Check Date:"+checkDate.getTime());
				   return false;
			   }
		  } 
		  catch (Exception e) {
			  SysLog.PrintException("[Exception].unknow exception in isExpiryDateByDay(Integer starting,Integer expiry) : "+ e.getMessage() +"");
			  return true;
		  }
			  
		  return true;
	 }
	 
	 /**
	  * <pre>
	  * 	Function Name  :   isTWExpiryDateByDay(Integer starting,Integer expiry)
	  * 	Description   :  判斷是否到期   依  台灣時間
	  * 	Modification 
	  * 
	  * 	@param 	arg1	Integer starting
	  * 	@param 	arg2	Integer expiry
	  * 
	  *  	@return  boolean  true/false   
	  * </pre>
	  *
	  * @author Bear Wu
	  * @since 2016. 07. 11.
	  * @version 
	  *
	  */
	 public static boolean isTWExpiryDateByDay(Integer starting,Integer expiry) {
		 //SimpleDateFormat myFormatter = new SimpleDateFormat("HHmm",Locale.TAIWAN);
		 SimpleDateFormat myFormatter = new SimpleDateFormat("HHmm");
		 myFormatter.setTimeZone(TimeZone.getTimeZone("Asia/Taipei"));

		  try {
			   Date start_date = myFormatter.parse(starting.toString());
			   Date expiry_date = myFormatter.parse(expiry.toString());
			   Date currentTime = new Date();
			   String dateString = myFormatter.format(currentTime);
			   Date checkDate = myFormatter.parse(dateString);
			   
			   SysLog.PrintDebug("[isExpiryDateByDay] Start Date:"+start_date.getTime()+" , Expiry Date:"+expiry_date.getTime()+" ,Check Date:"+checkDate.getTime());

			   if ( start_date.getTime() <= checkDate.getTime() &&
					checkDate.getTime() <= expiry_date.getTime()) {
				   SysLog.PrintDebug("[isTWExpiryDateByDay].[TRUE] Start Date:"+start_date.getTime()+" , Expiry Date:"+expiry_date.getTime()+" ,Check Date:"+checkDate.getTime());
				   return false;
			   }
		  } 
		  catch (Exception e) {
			  SysLog.PrintException("[Exception].unknow exception in isTWExpiryDateByDay(Integer starting,Integer expiry) : "+ e.getMessage() +"");
			  return true;
		  }
			  
		  return true;
	 }
	 
	 /*
	  *  存放時間 HashMap
	  */
	  private static ConcurrentHashMap<String,Long> mapCycleCost = new ConcurrentHashMap<String,Long>();
	 
	 /**
	  * <pre>
	  * 	Function Name  :   CycleCostBegin(String name)
	  * 	Description   :  生命週期開始
	  * 	Modification 
	  * 
	  * 	@param 	arg1	String name
	  * 
	  *  	@return  CycleCostUnit   
	  * </pre>
	  *
	  * @author Bear Wu
	  * @since 2016. 06. 21.
	  * @version 
	  *
	  */	 
	 public static CycleCostUnit  CycleCostBegin(String name) {
		 if ( DevelopmentVersion.VERSION_CYCLE_COST ) {
			 return new CycleCostUnit(name);
		 }
		 
		 return null;
	 }
	 
	 /**
	  * <pre>
	  * 	Function Name  :   CycleCostEnded(CycleCostUnit unit)
	  * 	Description   :  生命週期開始
	  * 
	  * 
	  * 				1秒=1000毫秒=1000000微秒=1000000000奈秒
	  * 				毫(m)=10的-3次方=0.001
	  * 				微(μ)=10的-6次方=0.000001
	  * 				奈(n)=10的-9次方=0.000000001 
	  * 				Sleep 以 毫秒為單位
								
	  * 	Modification 
	  * 
	  * 	@param 	arg1	String name
	  * 
	  *  	@return  CycleCostUnit   
	  * </pre>
	  *
	  * @author Bear Wu
	  * @since 2016. 06. 21.
	  * @version 
	  *
	  */	 
	 public static void  CycleCostEnded(CycleCostUnit unit) {
		if (DevelopmentVersion.VERSION_CYCLE_COST ) {
			if ( unit != null ) {
				long cost = unit.CycleEnded();
				
				if ( mapCycleCost.containsKey(unit.getCycleName())) {
					long have = mapCycleCost.get(unit.getCycleName());
					
					if ( cost <= have ) {
						return;
					}
					
					mapCycleCost.remove(unit.getCycleName());				
				}
				
				SysLog.PrintError("[CycleCost] Function:"+unit.getCycleName()+" ,Cost:"+cost+" ,毫秒[ms]" );
				mapCycleCost.put(unit.getCycleName(), cost);			
			}
		}
	 }
	 
	/**
	 * <pre>
	 * 	Function Name  :   getWeeklyStastingPoint()
	 * 	Description   :    取得每週週期的起始點時間。
	 * 	Modification
	 * 
	 *  @return  String    yyyyMMdd
	 * </pre>
	 *
	 * @author Yardly Luo
	 * @since 2016. 07. 14.
	 * @version
	 *
	 */
	public static String getWeeklyStartingPoint() {
		 if ( DevelopmentVersion.VERSION_LOCALE_TAIWAN_TIME) {
			  return UtilTimeManage.getTWWeeklyStartingPoint();
		 }
		
		
		Date nowDate = new Date();
		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
		cal.setTime(nowDate);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);

		while ((cal.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY) || cal.getTime().after(nowDate)) {
			cal.add(Calendar.DAY_OF_MONTH, -1);
		}

		Date currentTime = cal.getTime();
		String dateString = "";
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
			formatter.setTimeZone(new SimpleTimeZone(SimpleTimeZone.UTC_TIME, "UTC"));
			dateString = formatter.format(currentTime);

			return dateString;
		} catch (Exception e) {
			SysLog.PrintError("[" + getManageName()
					+ "].[getIntervalMinutesPastHour] unknow exception in sortCountryRanking: " + e.getMessage()
					+ "!!!");
			e.printStackTrace();
		}

		return null;
	}
	
	/**
	 * <pre>
	 * 	Function Name  :   getWeeklyStastingPoint()
	 * 	Description   :    取得每週週期的起始點時間。
	 * 	Modification
	 * 
	 *  @return  String    yyyyMMdd
	 * </pre>
	 *
	 * @author Yardly Luo
	 * @since 2016. 07. 14.
	 * @version
	 *
	 */
	public static String getTWWeeklyStartingPoint() {
		Date nowDate = new Date();
		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Asia/Taipei"));
		cal.setTime(nowDate);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);

		while ((cal.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY) || cal.getTime().after(nowDate)) {
			cal.add(Calendar.DAY_OF_MONTH, -1);
		}

		Date currentTime = cal.getTime();
		String dateString = "";
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
			formatter.setTimeZone(TimeZone.getTimeZone("Asia/Taipei"));
			//formatter.setTimeZone(new SimpleTimeZone(SimpleTimeZone.UTC_TIME, "UTC"));
			dateString = formatter.format(currentTime);

			return dateString;
		} catch (Exception e) {
			SysLog.PrintException("[" + getManageName()
					+ "].[getIntervalMinutesPastHour] unknow exception in sortCountryRanking: " + e.getMessage()
					+ "!!!");
			e.printStackTrace();
		}

		return null;
	}
	
	/**
	 * <pre>
	 * 	Function Name  :   getWeeklyStastingPoint()
	 * 	Description   :    取得下一週週期的起始點時間。
	 * 	Modification
	 * 
	 *  @return  long    yyyyMMddHHmmss
	 * </pre>
	 *
	 * @author Yardly Luo
	 * @since 2016. 07. 15.
	 * @version
	 *
	 */
	public static long getNextWeeklyStartingTime() {
		 if ( DevelopmentVersion.VERSION_LOCALE_TAIWAN_TIME) {
			  return UtilTimeManage.getTWNextWeeklyStartingTime();
		 }
		 
		Date nowDate = new Date();
		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
		cal.setTime(nowDate);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);

		while ((cal.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY) || cal.getTime().before(nowDate)) {
			cal.add(Calendar.DAY_OF_MONTH, 1);
		}
		
		Date currentTime = cal.getTime();
		String dateString = "";
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");
			formatter.setTimeZone(new SimpleTimeZone(SimpleTimeZone.UTC_TIME, "UTC"));
			dateString = formatter.format(currentTime);

			return Long.parseLong(dateString);
		} catch (Exception e) {
			SysLog.PrintException("[" + getManageName()
					+ "].[getIntervalMinutesPastHour] unknow exception in sortCountryRanking: " + e.getMessage()
					+ "!!!");
			e.printStackTrace();
		}

		return Long.parseLong(dateString);
	}
	
	public static long getTWNextWeeklyStartingTime() {
		Date nowDate = new Date();
		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Asia/Taipei"));
		cal.setTime(nowDate);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);

		while ((cal.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY) || cal.getTime().before(nowDate)) {
			cal.add(Calendar.DAY_OF_MONTH, 1);
		}
		
		Date currentTime = cal.getTime();
		String dateString = "";
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");
			formatter.setTimeZone(TimeZone.getTimeZone("Asia/Taipei"));
			//formatter.setTimeZone(new SimpleTimeZone(SimpleTimeZone.UTC_TIME, "UTC"));
			dateString = formatter.format(currentTime);

			return Long.parseLong(dateString);
		} catch (Exception e) {
			SysLog.PrintError("[" + getManageName()
					+ "].[getIntervalMinutesPastHour] unknow exception in sortCountryRanking: " + e.getMessage()
					+ "!!!");
			e.printStackTrace();
		}

		return Long.parseLong(dateString);
	}

	/**
	 * <pre>
	 * 	Function Name  :   getIntervalMinutesPastHour()
	 * 	Description   :    按整點後間隔幾分鐘時間的規則，取得目前時間之後最接近的結果。
	 * 	Modification 
	 * 
	 * 	@param  arg1    int intervals     間隔分鐘數
	 * 
	 *  @return  long    yyyyMMddHHmmss
	 * </pre>
	 *
	 * @author Yardly Luo
	 * @since 2016. 07. 14.
	 * @version
	 *
	 */
	public static long getIntervalMinutesPastHour(int intervals) {
		if ( DevelopmentVersion.VERSION_LOCALE_TAIWAN_TIME) {
			  return UtilTimeManage.getTWIntervalMinutesPastHour(intervals);
		}
		 
		Date nowDate = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(nowDate);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);

		while ((cal.get(Calendar.MINUTE) % intervals) != 0 || cal.getTime().before(nowDate)) {
			cal.add(Calendar.MINUTE, 1);
		}

		Date currentTime = cal.getTime();
		String dateString = "";
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");
			formatter.setTimeZone(new SimpleTimeZone(SimpleTimeZone.UTC_TIME, "UTC"));
			dateString = formatter.format(currentTime);

			return Long.parseLong(dateString);
		} catch (Exception e) {
			SysLog.PrintException("[" + getManageName()
					+ "].[getIntervalMinutesPastHour] unknow exception in sortCountryRanking: " + e.getMessage()
					+ "!!!");
			e.printStackTrace();
		}

		return Long.parseLong(dateString);
	}	 
	
	/**
	 * <pre>
	 * 	Function Name  :   getIntervalMinutesPastHour()
	 * 	Description   :    按整點後間隔幾分鐘時間的規則，取得目前時間之後最接近的結果。
	 * 	Modification 
	 * 
	 * 	@param  arg1    int intervals     間隔分鐘數
	 * 
	 *  @return  long    yyyyMMddHHmmss
	 * </pre>
	 *
	 * @author Yardly Luo
	 * @since 2016. 07. 14.
	 * @version
	 *
	 */
	public static long getTWIntervalMinutesPastHour(int intervals) {
		Date nowDate = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(nowDate);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);

		while ((cal.get(Calendar.MINUTE) % intervals) != 0 || cal.getTime().before(nowDate)) {
			cal.add(Calendar.MINUTE, 1);
		}

		Date currentTime = cal.getTime();
		String dateString = "";
		try {
			//SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");
			/*
			 * 台灣時間
			 */
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");
			formatter.setTimeZone(TimeZone.getTimeZone("Asia/Taipei"));


			dateString = formatter.format(currentTime);
			return Long.parseLong(dateString);
		} catch (Exception e) {
			SysLog.PrintException("[" + getManageName()
					+ "].[getIntervalMinutesPastHour] unknow exception in sortCountryRanking: " + e.getMessage()
					+ "!!!");
			e.printStackTrace();
		}

		return Long.parseLong(dateString);
	}	 
}