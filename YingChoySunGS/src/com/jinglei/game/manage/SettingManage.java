package com.jinglei.game.manage;

import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import com.jinglei.game.DevelopmentVersion;
import com.jinglei.game.SysLog;
import com.jinglei.game.attribute.ActorKeys;
import com.jinglei.game.attribute.impl.GClonePlayer;

import com.jinglei.channel.NettyClientChannel;

import com.jinglei.game.server.common.StatusCode;
import com.excel.impl.ExcelData;
import com.excel.impl.ExcelRecord;
import com.excel.impl.ExcelTable;

import com.jinglei.game.setting.DataComposeKey;

/*
 * 					伺服器設定檔
 * @title   		SettingManage
 *     		
 * @description 	伺服器設定檔 Manage
 *
 * @author Bear Wu 2016.11.03
 */
public class SettingManage {
	
	/*
	 * Excel 資料表
	 */
	private static int maxBattleExperience = 0;
	private static ExcelData    gameExcel = null;
	
	public static ExcelData    getGameExcel() {
		return SettingManage.gameExcel;
	}
	
	public void setGameExcel(ExcelData  excedata) {
		SettingManage.gameExcel = excedata;
	}
	
	/*
	 * Excel 資料表
	 */
	private static ExcelData    gashaponExcel = null;
	
	public static ExcelData    getGashaponExcel() {
		return SettingManage.gashaponExcel;
	}
	
	public void setGashaponExcel(ExcelData  excedata) {
		SettingManage.gashaponExcel = excedata;
	}
	
	/*
	 *  初始是否成功
	 */
	private static boolean   bInitialize  = false;
	
	public static boolean    IsInitialize() {
		return SettingManage.bInitialize;
	}
	
	public void setInitialize(boolean  flag) {
		SettingManage.bInitialize = flag;
	}	
	
	
	/*
	 *   單入推圖關卡
	 */
	private static CopyOnWriteArrayList<Integer> singleStageList = new CopyOnWriteArrayList<Integer>();
	
	public static CopyOnWriteArrayList<Integer> getSingleStageList() {
		return SettingManage.singleStageList;
	}
		
	private static ConcurrentHashMap<String, Integer> ParametMap = new ConcurrentHashMap<String, Integer>();
	
	/*
	 *  機器人隊伍 玩家名稱
	 */
	private static String sakuraName = "Keyman";
	
	public static String getSakuraName() {
		return SettingManage.sakuraName;
	}
	
	/*
	 *  附近對戰距離
	 */
	public static  double  getNearbyDistanc() {
		if (SettingManage.ParametMap.containsKey("BATTLE_NEARBY_DISTANCE")) {
			return (double)SettingManage.ParametMap.get("BATTLE_NEARBY_DISTANCE");
		}
		
		return 5000.0;
	}
	
	/*
	 *  世界對戰距離
	 */
	public static  double  getWorldDistanc() {
		if (SettingManage.ParametMap.containsKey("BATTLE_WORLD_DISTANCE")) {
			return (double)SettingManage.ParametMap.get("BATTLE_WORLD_DISTANCE");
		}
		
		return 5000.0;
	}
	
	/*
	 *  房間列表限制
	 */
	public static  Integer  getRoomListLimit() {
		if (SettingManage.ParametMap.containsKey("BATTLE_ROOM_LIST_LIMIT")) {
			return SettingManage.ParametMap.get("BATTLE_ROOM_LIST_LIMIT");
		}
		
		return 5;
	}	
	
	/*
	 *  SettingManage Instance
	 */
	private static SettingManage  instance = null;
	
	private SettingManage() {	
		SysLog.PrintInfo("[Begin] SettingManage Initialize!!!");
		
		try {
			if ( SettingManage.gameExcel == null ) {			
				SettingManage.gameExcel = new ExcelData("excel/GameData.xlsx");
				
				if ( SettingManage.gameExcel == null) {
					SysLog.PrintError("[Failure] Excel 讀檔失敗 excel/GameData.xlsx 麻煩檢查是否檔案存在...Failure!!!");		
				}
				else {
					SettingManage.gameExcel.CorrespondenceRatio("RATIO");
					SysLog.PrintInfo("[Success] Excel 讀檔成功 GameData.xlsx TableCount:"+gameExcel.getTableSize()+"...Success!!!");
					
					if ( SettingManage.gashaponExcel == null ) {
						SettingManage.gashaponExcel = new ExcelData("excel/Gashapon.xlsx");
						
						if ( SettingManage.gashaponExcel == null ) {
							SysLog.PrintError("[Failure] Excel 讀檔失敗 excel/Gashapon.xlsx 麻煩檢查是否檔案存在...Failure!!!");		
						}
						else {
							SettingManage.gashaponExcel.CorrespondenceRatio("RATIO");
							SysLog.PrintInfo("[Success] Excel 讀檔成功  Gashapon.xlsx TableCount:"+gashaponExcel.getTableSize()+"...Success!!!");
							
							if ( InitParameterSetting() ) {
								SettingManage.bInitialize = true;
							}
						}						
					}					
				}
			}			
		}
		catch (Exception e)
		{
			SysLog.PrintException("unknow exception : "+ e.getMessage() +"");
			e.printStackTrace();
		}
		finally
		{
			SysLog.PrintInfo("[Ended] SettingManage Initialize!!!");
		}

	}
	
	/*
	 *  取得 SettingManage Management Instance
	 */
	public static synchronized SettingManage getInstance()  {
        if (instance == null) {
        	instance = new SettingManage();
        }

        return instance;
    }
	
	public static String  getManageName() {
		return "SettingManage()";
	}
	
	/**
	  * <pre>
	  * 	Function Name  : 		InitParameterSetting	 
	  *  @return		   :	boolean 初始化  Server 設定檔
	  *  Description    : 		初始  Server 設定值
	  *  Modification Information
	   *
	  * </pre>
	  *
	  * @author Bear Wu
	  * @since 2016.04.18
	  * @version 
	  *
	 */	
	public static boolean InitParameterSetting() {
		SysLog.PrintInfo("[Begin].["+getManageName()+"].[InitParameterSetting] ...Run!!!");
		try {
			if ( SettingManage.gameExcel != null) {
				//ExcelTable      setting =	SettingManage.getGameExcel().getTable(2);
				ExcelTable      setting =	SettingManage.getGameExcel().getTableName("SERVER_SETTING");
				if (setting != null ) {
					int param_id_idx 		= setting.getColKeyIndex("PARAMETER_ID");
					Integer param_id     	= 0;
					int param_code_idx 		= setting.getColKeyIndex("PARAMETER_CODE");
					String  param_code   	= "N/A";
					int param_name_idx 		= setting.getColKeyIndex("PARAMETER_NAME");
					String  param_name   	= "N/A";
					int param_type_idx 		= setting.getColKeyIndex("PARAMETER_TYPE");
					Integer param_type   	= 0;
					int param_value_idx 	= setting.getColKeyIndex("PARAMETER_VALUE");
					Integer  param_value 	= 0;
					
					ConcurrentHashMap<Integer, ExcelRecord> RecordMap = setting.getTableTypeRecordMap();	
					
					if ( !RecordMap.isEmpty()) {
									
						//[Begin] FOR-LOOP  找 關卡設定 
						for (Entry<Integer, ExcelRecord> entry : RecordMap.entrySet())
						{
							ExcelRecord record = entry.getValue(); 
							if ( record != null && entry.getKey() >= 1 ) {
								param_id 			= (int) record.getRowInteger(param_id_idx);			// 參數代碼
								param_code  	 	= record.getRowString(param_code_idx);				// 參數編碼
								param_name  	 	= record.getRowString(param_name_idx);				// 參數名稱
								param_type 			= (int) record.getRowInteger(param_type_idx);		// 參數類型
								param_value 		= (int) record.getRowInteger(param_value_idx);		// 參數 設定值
								
								
								if ( param_code.equals("BATTLE_SAKURA_NAME")) {
									SettingManage.sakuraName = param_name;
								}
								
								SysLog.PrintDebug("Add Paramet Map Key:"+param_code+" , Value:"+ param_value);
								
								SettingManage.ParametMap.put(param_code, param_value);
							}
						}						
						
						return true;												
					}
				}
				else {
					SysLog.PrintError("[Failure].["+getManageName()+"] Excel GameData.xlsx Not Find Table Name:SERVER_SETTING Table 資料....Failure!!!");
					return false;
				}
				
			}
				
			return true;
		}
		catch (Exception e)
		{
			SysLog.PrintException("unknow exception : "+ e.getMessage() +"");
			e.printStackTrace();
		}
		finally
		{
			SysLog.PrintInfo("[Ended].["+getManageName()+"].[InitParameterSetting] ...Run!!!");
		}
		
		return false;
	}
}
