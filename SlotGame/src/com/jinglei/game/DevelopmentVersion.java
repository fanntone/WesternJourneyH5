package com.jinglei.game;

/*
 * 版本控制  功能  開關控制
 * @title   				DevelopmentVersion
 * @						開發中  版本控制  定義功能  開關
 * @
 * @description 			開發中  版本控制 定義/差異
 * @
 * @example					
 * @						定義  只要該功能有問題  將設為  false 
 * @							public final boolean VERSION_GASHAPON = true;
 * @						編寫功能
 * @							if (DevelopmentVersion.VERSION_GASHAPON) {
 * @								....   轉蛋功能編寫
 * @							}
 * @
 * @author Bear Wu 2015.12.11
 */
public interface DevelopmentVersion {
		
	/*
	 * 是否關閉 輸出錯誤訊息
	 */
		public final boolean VERSION_PRINT_ERROR = true;
	
	/*
	 * 是否關閉 輸出錯誤訊息
	 */
		public final boolean VERSION_PRINT_EXCEPTION = true;
			
	/*
	 * 是否關閉 輸出警告訊息
	 */
		public final boolean VERSION_PRINT_WARRING = false;		
			
	/*
	 * 是否關閉  輸出資訊訊息
	 */
		public final boolean VERSION_PRINT_INFO = false;
			
	/*
	 * 是否關閉  輸出偵錯訊息
	 */
		public final boolean VERSION_PRINT_DEBUG = true;	

	/*
	 * 是否關閉 壓力測試
	 */
		public final boolean VERSION_PRESSURE_TEST = false;
		
	/*
	 * 是否關閉  台灣時間為基準 
	 */
		public final boolean VERSION_LOCALE_TAIWAN_TIME = true;
		
	/*
	 * 是否關閉  
	 */
		public final boolean VERSION_CYCLE_COST = true;
		
	/*
	 * 是否關閉  
	 */
		public final boolean VERSION_NOSQL_REDIS_WINDOWS = true;
}
