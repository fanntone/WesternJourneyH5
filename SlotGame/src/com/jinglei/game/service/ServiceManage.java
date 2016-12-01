package com.jinglei.game.service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import com.jinglei.game.SysLog;

/*
 * 					Server 服務 管理
 * @title   		ServiceManage
 *     		
 * @description 	ServiceManage
 *
 * @author Bear Wu  on 2016.11.03
 */
public class ServiceManage {
	/*
	 *  ServiceManage Instance
	 */
	private static ServiceManage  instance = null;
	
	/*
	 * 取得 ServiceManage Management Instance
	 */	
	public static synchronized  ServiceManage getInstance() {
		if ( instance == null ) {
			instance = new ServiceManage();
		}
		
		return instance;
	}
	
	
	/*
	 *  Service Manage Constructor
	 */
	private ServiceManage() {
		InitialThreads();
	}	
	
	/*
	 *  取得  Manage Name
	 */
	public static String  getManageName() {
		return "ServiceManage";
	}
	
	/*
	 * 儲存要處理 Service
	 */
	private static LinkedBlockingQueue<Service> serviceQueue = new LinkedBlockingQueue<Service>();
	
	/*
	 *  增加新的要處理 Service
	 */
	public static synchronized boolean addService(Service service) {
		//synchronized (ServiceManage.serviceMap) {
			try {
				if ( ServiceManage.serviceQueue != null && service != null) {
					ServiceManage.serviceQueue.put(service);
					return true;
				}
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
				SysLog.PrintError(String.format("[Manage:%s] unknow exception in addService(Service service) Error:〔%s...Exception!!!", ServiceManage.getManageName(),e.getMessage()));

				return false;				
			}
			finally {
	
	        }
		//}

		
		return false;
	}	

	
	/*
	 *  從 Map 中取出要處理 Service
	 */
	//public static synchronized Service getService() {
	public static  Service getService() {		

		//synchronized (ServiceManage.serviceMap) {
			try {
				if ( !ServiceManage.serviceQueue.isEmpty()) {
					return ServiceManage.serviceQueue.take();
				}
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
				SysLog.PrintError(String.format("[Manage:%s] unknow exception in addService(Service service) Error:〔%s...Exception!!!", ServiceManage.getManageName(),e.getMessage()));
	
				return null;				
			}
			finally {
	
	        }			
		//}		

		return null;
	}	

	/*
	 * 取得  Queue 中 待處理 Service 數量
	 */
	public static synchronized int getServiceSize() {
		return ServiceManage.serviceQueue.size();
	}
	
	/*
	 * 依  ServiceExecuteEnum 取得該 Service Instance
	 */
	public static synchronized Service     getServiceObject(ServiceExecuteEnum service,int[] check_code) {
		check_code[0] = 0;	
		Service rtnService = null;
		
		try {
			rtnService = (Service) Class.forName(service.getClassPath()).newInstance();
			
			if ( rtnService != null ) {
				check_code[0] = 1;
				return rtnService;			
			}
			else {
				SysLog.PrintError(String.format("[Manage:%s] Server Type:〔%d〕  Class Path:【%s】 ,Service is NULL ,麻煩查明 Service Class/newInstance() 未被實作....Failure!!!", ServiceManage.getManageName(),service.getType(),service.getClassPath()));
			}
			
			return null;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			rtnService = null;
			SysLog.PrintException(String.format("[Manage:%s] unknow exception in addService(Service service) Error:〔%s...Exception!!!", ServiceManage.getManageName(),e.getMessage()));			
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
			for (ServiceExecuteEnum func : ServiceExecuteEnum.values()) {
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
				SysLog.PrintError(String.format("[Manage:%s] Server Type:〔%d〕   ,Service is NULL ,麻煩查明 Service Class/newInstance() 未被實作....Failure!!!", ServiceManage.getManageName(),service_type));
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
	private static  int  processors = 4;
	
	private static List<Thread>   listThread = new CopyOnWriteArrayList<Thread>();
	
	public  static boolean InitialThreads() {
		for ( int i=0; i< processors;++i) {
			listThread.add(new ServiceWorkThreads(i,"SERVICE_WORKTHREAD_"+i));			
		}
		
		return ThreadStart();
	}
	
	public  static boolean  ThreadStart() {
		try {
			for ( Thread thread : listThread) {
				thread.start();
				Thread.sleep(32);
			}
			return true;
		} 
		catch (InterruptedException e) {
				e.printStackTrace();
		}
		
		return false;
	}
	

	@SuppressWarnings("deprecation")
	public static boolean ThreadStop() {
		try {
			for ( Thread thread : listThread) {
				thread.stop();
				Thread.sleep(32);
			}
			
			return true;
		} 
		catch (InterruptedException e) {
				e.printStackTrace();
		}
		
		return false;		
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
				try {					
					int nCount = 0;
					while (true) {
						Service  serviceExecute = ServiceManage.getService();
						
						if ( serviceExecute != null ) {	
							SysLog.PrintDebug("["+getManageName()+"] Run Service :"+serviceExecute.getServiceName()+"...!!!" );
							//清除
							//serviceExecute.clearAttachment();
							serviceExecute =  null;
							/*
							 *   Thread Sleep
							 */
							++nCount;					
							if ( nCount >= 10) {
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
}

