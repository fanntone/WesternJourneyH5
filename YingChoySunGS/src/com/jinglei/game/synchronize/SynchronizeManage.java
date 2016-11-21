package com.jinglei.game.synchronize;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.jinglei.game.DevelopmentVersion;
import com.jinglei.game.SysLog;
import com.jinglei.game.attribute.ActorKeys;
import com.jinglei.game.attribute.impl.GClonePlayer;
import com.jinglei.channel.NettyClientChannel;
import com.jinglei.game.manage.SettingManage;
import com.jinglei.game.manage.UtilTimeManage;
import com.jinglei.game.service.Service;
import com.jinglei.game.service.ServiceExecuteEnum;
import com.jinglei.game.service.ServiceKeys;
import com.jinglei.game.service.ServiceManage;
import com.jinglei.game.setting.DataComposeKey;

/*
 * 					同步資料 管理
 * @title   		SynchronizeManage
 *     		
 * @description 	SynchronizeManage
 *
 * @author Bear Wu 2016.04.12
 */
public class SynchronizeManage {
	
	/*
	 *  SynchronizeManage Instance
	 */
	private static SynchronizeManage  instance = null;	
	
	/*
	 *  Attribute Unit 同步 Lock
	 */
	private static volatile Lock lockSyncAttributeUnit = new ReentrantLock();
	
	/*
	 *  User Role 同步 Lock
	 */	
	private static volatile Lock lockSyncRole = new ReentrantLock();
	
	/*
	 *  User Pet 同步 Lock
	 */
	private static volatile Lock lockSyncPet = new ReentrantLock();
	
	/*
	 *  User Item 同步 Lock
	 */	
	private static volatile Lock lockSyncItem = new ReentrantLock();
	
	/*
	 *  User Standing 同步 Lock
	 */	
	private static volatile Lock lockSyncStanding = new ReentrantLock();
	
	/*
	 *  User Farming 同步 Lock
	 */	
	private static volatile Lock lockSyncFarming = new ReentrantLock();	
	
	/*
	 *  User Map Stage 同步 Lock
	 */	
	private static volatile Lock lockSyncMapStage = new ReentrantLock();	
	
	/*
	 *  User Team 同步 Lock
	 */	
	private static volatile Lock lockSyncUserTeam = new ReentrantLock();
	
	/*
	 *  User Friend 同步 Lock
	 */	
	private static volatile Lock lockSyncUserFriend = new ReentrantLock();
	
	/*
	 *  Gashapon History 同步 Lock
	 */	
	private static volatile Lock lockSyncGashaponHistory = new ReentrantLock();
	
	/*
	 *  MissionLog 同步 Lock
	 */	
	private static volatile Lock lockSyncMissionLog = new ReentrantLock();
	
	/*
	 *  Item History 同步 Lock
	 */	
	private static volatile Lock lockSyncItemHistory = new ReentrantLock();	
	
	/*
	 *  ProgressLog 同步 Lock
	 */	
	private static volatile Lock lockSyncProgressLog = new ReentrantLock();	
	
	private SynchronizeManage() {		
		InitialThreads();
		//InitialSynchronizeService();
	}
	
	/*
	 *  取得 SynchronizeManage Management Instance
	 */
	public static synchronized SynchronizeManage getInstance()  {
        if (instance == null) {
        	instance = new SynchronizeManage();
        }

        return instance;
    }
	
	public static String getManageName() {
		return "SynchronizeManage";
	}
	

	/*
	 * 儲存要處理 Service
	 */
	//private static Queue<Service> serviceQueue = new ConcurrentLinkedQueue<Service>();	
	
	private static ConcurrentHashMap<Long,Service> serviceMap = new ConcurrentHashMap<Long,Service>();
	
	/*
	 *  增加新的要處理 Service
	 */
	//public static synchronized boolean addService(Long excDate,Service service) {
	public static  boolean addService(Long excDate,Service service) {
		synchronized (SynchronizeManage.serviceMap) {
			if ( SynchronizeManage.serviceMap != null && service != null) {
				if (!SynchronizeManage.serviceMap.containsKey(excDate)) {
					SynchronizeManage.serviceMap.put(excDate, service);
				}
				else {
					long newExc = excDate + new Random().nextInt(1000) + 1;
					SynchronizeManage.serviceMap.put(newExc, service);
				}
				return true;
			}
		}
		return false;
	}
	
	/*
	 *  從 Map 中取出要處理 Service
	 */
	//public static synchronized Service getService() {
	public static  Service getService() {
		Long  checkDate = UtilTimeManage.getCurrentTimeToService();
		synchronized (SynchronizeManage.serviceMap) {			
			if ( !SynchronizeManage.serviceMap.isEmpty() ) {
				for ( Long excDate : SynchronizeManage.serviceMap.keySet()) {
					if ( excDate <= checkDate ) {
						return SynchronizeManage.serviceMap.remove(excDate);
					}					
				}
			}
		}
			
		return null;
	}
	
	/*
	 * 取得  Queue 中 待處理 Service 數量
	 */
	public static synchronized int getServiceSize() {
		return SynchronizeManage.serviceMap.size();
	}
	
	/*
	 * 依  ServiceExecuteEnum 取得該 Service Instance
	 */
	public static synchronized Service     getServiceObject(SynchronizeExecuteEnum service,int[] check_code) {
		check_code[0] = 0;	
		Service rtnService = null;
		
		try {
			rtnService = (Service) Class.forName(service.getClassPath()).newInstance();
			
			if ( rtnService != null ) {
				check_code[0] = 1;
				return rtnService;			
			}
			else {
				SysLog.PrintError("["+getManageName()+"] Server Type: " + service.getType()+" Class Path:"+service.getClassPath()+",Service is NULL ,麻煩查明 Service newInstance() 未被實作....Failure!!!");
			}
			
			return null;
		}
		catch (Exception e)
		{
			rtnService = null;
			SysLog.PrintException("["+getManageName()+"] unknow exception in getServiceObject: "+ e.getMessage() +"");
			e.printStackTrace();
		}
		finally
		{

		}	
		
		return rtnService;
	}
	
	
	/*
	 * 依  Type 依照 ServiceExecuteEnum 取得該 Service Instance
	 */
	public static synchronized Service getServiceObjectByType(int service_type,int[] check_code) {
		
		check_code[0] = 0;
		Service rtnService = null;
		
		try {
			for (SynchronizeExecuteEnum func : SynchronizeExecuteEnum.values()) {
				if ( func.getType() == service_type) {
					check_code[0] = 1;
					rtnService = (Service) Class.forName(func.getClassPath()).newInstance();
					break;
				}	
			}
			
			if ( rtnService != null ) {
				check_code[0] = 1;
				return rtnService;			
			}
			else {
				SysLog.PrintError("["+getManageName()+"] Server Type: " + service_type+" ,Service is NULL ,麻煩查明 Service newInstance() 未被實作....Failure!!!");
			}
			
			return null;
		}
		catch (Exception e)
		{
			rtnService = null;
			SysLog.PrintException("["+getManageName()+"] unknow exception in getServiceObjectByType: "+ e.getMessage() +"");
			e.printStackTrace();
		}
		finally
		{

		}
		
		return rtnService;
	}
	
	/*
	 *  取得主機中 CPU 的數目，建立和 CPU 數目相等的執行緒來處理完成 IO 操作結果，經驗法則中，建立
	 *  Runtime.getRuntime().availableProcessors() * 2 個線程，是比較好的。一般在單 CPU 建立和 CPU 數目相等的執行緒就可以了。
	 */
	//private static  int  processors = Runtime.getRuntime().availableProcessors();	
	private static  int  processors = 1;
	
	private static List<Thread>   listThread = new CopyOnWriteArrayList<Thread>();
	
	
	/**
	  * <pre>
	  * 	Function Name  : 		InitialThreads	 

	  *  @return		   :		boolean true/false
	  *  Description    : 			初始 Synchronize Threads
	  *  Modification Information
	   *
	  * </pre>
	  *
	  * @author Bear Wu
	  * @since 2016.05.05
	  * @version 
	  *
	 */
	public  static boolean InitialThreads() {
		if ( processors > 1 ) {
			processors /= 2;
		}
		
//		for ( int i=0; i< processors;++i) {
//			listThread.add(new ServiceWorkThreads(i,"SERVICE_WORKTHREAD_"+i));			
//		}
		
		listThread.add(new ServiceWorkThreads(0,"SERVICE_WORKTHREAD"));
		listThread.add(new CreateServiceWorkThreads(1,"CREATE_SERVICE_WORKTHREAD"));
		
		return ThreadStart();
	}
	
	
	/**
	  * <pre>
	  * 	Function Name  : 		ThreadStart()	 

	  *  @return		   :		boolean true/false
	  *  Description    : 			啟始  Synchronize Threads
	  *  Modification Information
	   *
	  * </pre>
	  *
	  * @author Bear Wu
	  * @since 2016.05.05
	  * @version 
	  *
	 */
	public  static boolean  ThreadStart() {
		try {
			for ( Thread thread : listThread) {
				thread.start();
				Thread.sleep(32);
			}
		} 
		catch (InterruptedException e) {
				e.printStackTrace();
		}
		
		return true;
	}
	
	/**
	  * <pre>
	  * 	Function Name  : 		InitialSynchronizeService()	 

	  *  @return		   :		boolean true/false
	  *  Description    : 			初始 Synchronize Service
	  *  Modification Information
	  *  	   
	  * </pre>
	  *
	  * @author Bear Wu
	  * @since 2016.05.05
	  * @version 
	  *
	 */
	public static boolean InitialSynchronizeService()
	{
		// _INIT_ERROR_ Begin
		_INIT_ERROR_: {
			int[] check_code = { 0 };
//			Service attrService = SynchronizeManage.getServiceObjectByType(SynchronizeExecuteEnum.SEE_SynchronizeAttributeJob.getType(),check_code);
//			if ( check_code[0] >= 1 && attrService != null) {
//				SynchronizeManage.addService(attrService.getNextExecutionTime(),attrService);				
//			}
//			else {
//				SysLog.PrintError("["+getManageName()+"] Add SynchronizeAttributeJob Failure!!");
//				break _INIT_ERROR_;
//			}
			
			break _INIT_ERROR_;

			
			//return true;			
		}
		/*
		 *  _INIT_ERROR_ End 
		 */	
		
		return false;
	}
	
	/**
	  * <pre>
	  * 	Function Name  : 		ThreadStop()
	  *  @return		   :		boolean true/false
	  *  Description    : 			停止 Synchronize Threads
	  *  Modification Information
	  *  	   
	  * </pre>
	  *
	  * @author Bear Wu
	  * @since 2016.05.05
	  * @version 
	  *
	 */
	@SuppressWarnings("deprecation")
	public static boolean ThreadStop() {
		try {
			for ( Thread thread : listThread) {
				thread.stop();
				Thread.sleep(32);
			}
		} 
		catch (InterruptedException e) {
				e.printStackTrace();
		}
		
		return true;		
	}
	
	
	
	public static  class ServiceWorkThreads  extends Thread {
		private int index;
		
		public ServiceWorkThreads(int idx,String name) {
			index = idx;
			setName(name);
		}
		
		public int getIndex() {
			return index;
		}
		
		/*
		 * (non-Javadoc)
		 * @see java.lang.Thread#run()
		 */
		@Override
		public void run() {
			// _WORK_ERROR_ Begin
			_WORK_ERROR_: {
				// for (;;)
				try {	
					int nCount = 0;
					int nExecRtn = 0;
					while (true) {
						Service  serviceExecute = getService();
						
						if ( serviceExecute != null ) {	
							SysLog.PrintInfo("["+getManageName()+"] Run Service :"+serviceExecute.getServiceName()+"...!!!" );
							nExecRtn = serviceExecute.Execute();							
							//清除
							//serviceExecute.clearAttachment();
							serviceExecute =  null;
							/*
							 *   Thread Sleep
							 */
							++nCount;					
							if ( nCount >= 8) {
								/*
								 * 1秒=1000毫秒=1000000微秒=1000000000奈秒
								 * 毫(m)=10的-3次方=0.001
								 * 微(μ)=10的-6次方=0.000001
								 * 奈(n)=10的-9次方=0.000000001 
								 * Sleep 以 毫秒為單位
								 */
								Thread.sleep(1);
								nCount = 0;
							} 
							continue;
						}

						nCount = 0;
						Thread.sleep(32);
					}
				}
				catch (InterruptedException e) {
					e.printStackTrace();
					break _WORK_ERROR_;
				}					

			}
			// _WORK_ERROR_ End
			ThreadStop();
		}	
	}
	
	public static  class CreateServiceWorkThreads  extends Thread {
		private int index;
		
		public CreateServiceWorkThreads(int idx,String name) {
			index = idx;
			setName(name);
		}
		
		public int getIndex() {
			return index;
		}
		
		/*
		 * (non-Javadoc)
		 * @see java.lang.Thread#run()
		 */
		@Override
		public void run() {
			// _WORK_ERROR_ Begin
			_WORK_ERROR_: {
				// for (;;)
				try {
					int[] check_code = { 0 };
					
					while (true) {
						
						Thread.sleep(500);
						
						check_code[0] = 0;
//						Service attrService = SynchronizeManage.getServiceObjectByType(SynchronizeExecuteEnum.SEE_SynchronizeAttributeJob.getType(),check_code);
//						if ( check_code[0] >= 1 && attrService != null) {
//							SynchronizeManage.addService(attrService.getNextExecutionTime(),attrService);				
//						}
//						else {
//							SysLog.PrintError("["+getManageName()+"] Add SynchronizeAttributeJob Failure!!");
//						}
						
						
						
					}					
				}
				catch (InterruptedException e) {
					e.printStackTrace();
					break _WORK_ERROR_;
				}					

			}
			// _WORK_ERROR_ End
			ThreadStop();
		}	
	}
}
