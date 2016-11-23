package com.jinglei.game;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SysLog 
{
	public final static byte LOG_EXCEPTION  = 5;
	public final static byte LOG_ERROR 		= 4;
	public final static byte LOG_WARRING 	= 3;
	public final static byte LOG_INFO 		= 2;
	public final static byte LOG_DEBUG 		= 1;
	
	//public final static Logger log = LoggerFactory.getLogger(.class);
	public SysLog()
	{
		LoggerFactory.getLogger(this.getClass());
	}

	
	/**
	 * 
	 * @param logType 訊息類型（LOG_ERROR，ALOG_WARRING，ALOG_INFO，ALOG_DEBUG）
	 * @param logText 訊息內容
	 */
	public static void PrintLog(byte logType,String logText)
	{
		
		switch(logType)
		{
		case LOG_EXCEPTION:
			PrintError(logText);
			break;
		case LOG_ERROR:
			PrintError(logText);
			break;
		case LOG_WARRING:
			PrintWarring(logText);
			break;
		case LOG_INFO:
			PrintInfo(logText);
			break;
		case LOG_DEBUG:
			PrintDebug(logText);
			break;
		}
	}
	
	/**
	 * 輸出錯誤訊息
	 * @param logText
	 */
	public static void PrintError(String logText)
	{
		if (DevelopmentVersion.VERSION_PRINT_ERROR ) {
			Logger log = getLoggerForClass();
			log.error("["+getLoggerLineNumber()+"] : "+logText);
		}
	}
	
	/**
	 * 輸出例外訊息
	 * @param logText
	 */
	public static void PrintException(String logText)
	{
		if (DevelopmentVersion.VERSION_PRINT_EXCEPTION ) {
			Logger log = getLoggerForClass();
			log.error("["+getLoggerLineNumber()+"] : "+logText);
		}
	}
	
	/**
	 * 輸出警告訊息
	 * @param logText
	 */
	public static void PrintWarring(String logText)
	{
		if (DevelopmentVersion.VERSION_PRINT_WARRING ) {
			Logger log = getLoggerForClass();
			log.warn("["+getLoggerLineNumber()+"] : "+logText);
		}
	}

	
	/**
	 * 輸出資訊訊息
	 * @param logText
	 */
	public static void PrintInfo(String logText)
	{
		if (DevelopmentVersion.VERSION_PRINT_INFO ) {
			Logger log = getLoggerForClass();
			log.info("["+getLoggerLineNumber()+"] : "+logText);
		}
	}

	
	/**
	 * 輸出偵錯訊息
	 * @param logText
	 */
	public static void PrintDebug(String logText)
	{
		if (DevelopmentVersion.VERSION_PRINT_DEBUG ) {
			Logger log = getLoggerForClass();
			log.debug("["+getLoggerLineNumber()+"] : "+logText);
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public static Logger getLoggerForClass() {
		StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
		/*for (StackTraceElement ste : Thread.currentThread().getStackTrace()) {
		    System.out.println(ste);
		}*/
		
		//final Logger logger = LoggerFactory.getLogger(stackTraceElements[stackTraceElements.length - 2].getClassName());
		int logicHierarchyInStack = 3;
		final Logger logger = LoggerFactory.getLogger(stackTraceElements[logicHierarchyInStack].getClassName());
		return logger;
	}
	
	/*
	 * 取得 Logger 時的行數
	 */
	public static int getLoggerLineNumber() {
		StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
		int logicHierarchyInStack = 3;
		return  stackTraceElements[logicHierarchyInStack].getLineNumber();		
	}
}
