package com.jinglei.game.manage;

import com.jinglei.game.SysLog;

/*
 * 					MachineManage Slot Machine 管理
 * @title   		MachineManage
 *     		
 * @description 	MachineManage
 *
 * @author Bear Wu on 2016/11/011
 */
public class MachineManage {
	
	/*
	 *  MachineManage Instance
	 */
	private static MachineManage  instance = null;
	
	private MachineManage() {	
		SysLog.PrintInfo("[Begin] MachineManage Initialize!!!");
		
		try {

		}
		catch (Exception e)
		{
			SysLog.PrintException("unknow exception : "+ e.getMessage() +"");
			e.printStackTrace();
		}
		finally
		{
			SysLog.PrintInfo("[Ended] MachineManage Initialize!!!");
		}

	}
	
	/*
	 *  初始是否成功
	 */
	private static boolean   bInitialize  = false;
	
	public static boolean    IsInitialize() {
		return MachineManage.bInitialize;
	}
	
	/*
	 *  取得 MachineManage Management Instance
	 */
	public static synchronized MachineManage getInstance()  {
        if (instance == null) {
        	instance = new MachineManage();
        }

        return instance;
    }
	
	public static String  getManageName() {
		return "MachineManage";
	}

}
