package com.jinglei.game;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ResourceBundle;

import com.jinglei.interceptor.ExecuteLogicInterceptor;
import com.jinglei.server.event.EventListener;
import com.jinglei.server.event.EventTypes;
import com.jinglei.server.logic.CommonLogic;
// logic package
import com.jinglei.server.plugin.PluginHome;
import com.jinglei.server.plugin.PluginNotFoundException;
import com.jinglei.server.plugin.ServerPlugin;
import com.jinglei.server.plugin.ServerPluginGroup;

/******************************************************************************
 * <p>
 * Title: ServerStarter
 * </p>
 *
 * <p>
 * Description: Game Server 主類別.
 * </p>
 *
 * <p>
 * Copyright: Copyright (c) 2014
 * </p>
 * 
 * @since 1.7
 * @author Super Handsome Jason
 * @version 1.0
 * @see com.auer.game.server.plugin.ServerPlugin
 * @see com.auer.game.server.plugin.PluginHome
 *****************************************************************************/

public class ServerStarter
{
	public static ResourceBundle  rbLogicType = null;
	
	private static final String LOGIC_TYPE_CONFIG = "logic_type_def";
	
	private static ServerPlugin sp = null;
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{	
			
		SysLog.PrintInfo("OZ Game Server");
		
		try
		{
			//ServerPlugin sp = PluginHome.findPlugin(ServerPluginGroup.NETTY_SERVER_PLUGIN);
			sp = PluginHome.findPlugin(ServerPluginGroup.NETTY_SERVER_PLUGIN);
			
			if ( sp != null ) {			
				//測試用
	//			sp.addLogic((short) 123, new SampleLogic());	
				
				/*
				 * initialization Logic Type
				 * 初始  Logic Type Function Class for PluginHome
				 */
				if ( InitLogicTypeClass() ) {					
				
//					// Listener
//					sp.addListener(EventTypes.CHANNEL_INACTIVE, new EventListener[]{ 
//							new RemovePlayerFromServerBroadcast(),
//					});
					
					// Interceptor
					sp.addExecuteLogicInterceptor(new ExecuteLogicInterceptor[]{
							new LogWriterInterceptor(),
					});
		
					try
					{	
						
						/*
						 * 初始 Actor Manage
						 */
						//InitActorManage();

						/*
						 * 初始 Game Room Manager
						 */
						//InitGameRoomManage();
						/*
						 * 初始 Hibernate Management
						 */
						//InitHibernateManagement();				
						
						// StartServer
						//sp.startServer(getPort(args), 1, 32);
						// 
						sp.startClient("127.0.0.1", 6666);
					}
					catch (Exception e)
					{
						SysLog.PrintException("unknow exception in  main(String[] args): "+ e.getMessage() +"");
						e.printStackTrace();
					}
				}
			}			
		}
		catch (PluginNotFoundException e)
		{
			e.printStackTrace();
		}
	}

	private static int getPort(String[] args) throws UnknownHostException
	{
		String ip = InetAddress.getLocalHost().getHostAddress();
		int port = 8888;

		switch (args.length)
		{
		case 0:
			break;

		case 1:
			port = Integer.valueOf(args[0]);
			break;

		default:
			SysLog.PrintDebug("Too many Arguments.");
			SysLog.PrintDebug("[Help]\nport\t\t指定port");
			throw new IllegalArgumentException();
		}

		SysLog.PrintInfo(ip + ":" + port);		

		return port;
	}
	
	public static boolean InitLogicTypeClass() {
		SysLog.PrintInfo("[Init]  InitLogicTypeClass !!!");
		//測試用
        //	sp.addLogic((short) 123, new SampleLogic());
		/*
		 * initialization Logic Type
		 * 初始  Logic Type Function Class for PluginHome
		 */
			rbLogicType = ResourceBundle.getBundle(ServerStarter.LOGIC_TYPE_CONFIG);
			
			if ( rbLogicType == null) {
				SysLog.PrintWarring("[Failure] Can not find "+ServerStarter.LOGIC_TYPE_CONFIG+".properties file...Failure!!!");
				return false;
			}
			
			CommonLogic element 	= null;
			String logicClassName 	= "";
			int iActionID 			= 0;
			for (String s : rbLogicType.keySet()) {
				try {
					iActionID = Integer.parseInt(s);
					logicClassName = rbLogicType.getString(s);
					if ( !logicClassName.isEmpty()) {
						element = (CommonLogic) Class.forName("com.auer.game.server.logic." + logicClassName).newInstance();
						if ( element != null  ) {
							sp.addLogic(iActionID, element);
						}
					};
				}
				catch (Exception e) {
					e.printStackTrace();
					SysLog.PrintException("logictype Error:Can not find Logic or logic have error!! Type = " + iActionID);
				}
			}
			
			return true;
	}	
}