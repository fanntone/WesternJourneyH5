package com.jinglei.game;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.ResourceBundle;

import com.jinglei.game.LogWriterInterceptor;

import com.jinglei.interceptor.ExecuteLogicInterceptor;
import com.jinglei.game.manage.ActorManage;
import com.jinglei.game.manage.GeoipManage;
import com.jinglei.game.manage.SettingManage;

import com.jinglei.server.event.EventListener;
import com.jinglei.server.event.EventTypes;
// logic package
import com.jinglei.server.plugin.PluginHome;
import com.jinglei.server.plugin.ServerPlugin;
import com.jinglei.server.plugin.ServerPluginGroup;
import com.jinglei.game.service.ServiceManage;
import com.jinglei.hibernate.HibernateManagement;
import com.jinglei.jedis.RedisManager;

/******************************************************************************
 * <p>
 * 		Title: YingChoySunGS
 * </p>
 *
 * <p>
 * 		Description: Game Server 主類別.
 * </p>
 * 
 * <p>
 * 		Bief introduction:
 * 			@see com.jinglei.server.event.EventTypes
 * 				EventTypes :
 * 							CHANNEL_ACTIVE,  		//Channel 被啟動的時候...
 * 							CHANNEL_INACTIVE,		//Channel Channel 失效的時候...
 * 							CHANNEL_REGISTERED,		//Channel 被註冊的時候...		連線成功  註冊到channelMap 裏時
 * 							CHANNEL_UNREGISTERED,	//Channel 移除註冊的時候...		連線斷     成功移除channelMap 裏時
 * </p>
 *
 * <p>
 * Copyright: Copyright (c) 2016
 * </p>
 * 
 * @since 
 * @author Bear Wu
 * @version 
 * @see com.jinglei.server.plugin.ServerPlugin
 * @see com.jinglei.server.plugin.PluginHome
 *****************************************************************************/

public class GameServerStarter
{
	public static ResourceBundle  rbLogicType = null;
	
	private static final String LOGIC_TYPE_CONFIG = "logic_type_def";
	
	public static ResourceBundle  configuration = null;		//Server 相關設定
	private static final String SERVER_CONFIGURATION   		= "configuration";
	
	private static ServerPlugin sp = null;
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{	
		String  strError = "Unknown error";			
		SysLog.PrintInfo("Ying Choy Sun Game Server");
		
		// _SERVER_ERROR_ Begin
		_SERVER_ERROR_: {
			try
			{
				SysLog.PrintInfo("[Init] InitDataServerManager() !!!");
				
				configuration = ResourceBundle.getBundle(GameServerStarter.SERVER_CONFIGURATION);
				
				if ( configuration == null ) { 
					throw new Exception("[ResourceBundle].[YingChoySunGS.SERVER_CONFIGURATION] Failed to read [configuration.properties] file....Failure!!!");
				}
				
				/*
				 *	初始 Gashapon Manage 
				 */
				//InitGeoipManage();
				
				/*
				 * 初始 Redis Manage
				 */	
					InitRedisManage();	
					
				/*
				 * 初始  Hibernate Management
				 */
					InitHibernateManagement();
					
				/*
				 *  初始 SettingManage
				 */
					//InitSettingManage();
					
				/*
				 *  初始 ServiceManager
				 */
					InitServiceManager();	
					
				/*
				 * 初始 Actor Manage
				 */
					InitActorManage();
				
				sp = PluginHome.findPlugin(ServerPluginGroup.WEBSOCKET_NETTY_SERVER_PLUGIN);	
				
				if ( sp == null ) {
					strError = "[Failure] Server Plugin is NULL....Failure!!";
					break _SERVER_ERROR_;
				}
				
				//測試用

				rbLogicType = ResourceBundle.getBundle(GameServerStarter.LOGIC_TYPE_CONFIG);					
					
				if (rbLogicType == null ) {
					strError = "[Failure] Failure to read the server_logic_type_def.properties File....Failure!!!";
					break _SERVER_ERROR_;
				};
				
				/*
				 * 沒有處理邏輯  先行注解
				 */					
				if ( !sp.addLogic("com.jinglei.game.server.logic", rbLogicType)) {
					strError = "[Failure] Server Plugin addLogic by ResourceBundle... Failure!!";
					break _SERVER_ERROR_;
				}
			
				try
				{						
					// Listener  Channel 被註冊的時候...		連線成功  註冊到channelMap 裏時
					sp.addListener(EventTypes.CHANNEL_REGISTERED, new EventListener[]{ 
						new ChannelRegistered(),
					});
								
					// Listener Channel Channel 失效的時候...	連線斷了
					sp.addListener(EventTypes.CHANNEL_INACTIVE, new EventListener[]{ 
						new ChannelInactive(),
					});
					
					// Listener Channel Channel 讀取資料成功
					//TODO:  add back the read complete.
					
					sp.addListener(EventTypes.CHANNEL_READ_COMPLETE, new EventListener[]{ 
						new ChannelReadComplete(),
					});
					

					// Interceptor
					sp.addExecuteLogicInterceptor(new ExecuteLogicInterceptor[]{
						new LogWriterInterceptor(),
					});				
					
					
					if ( configuration == null ) {	
						// StartServer
						sp.startServer(getPort(args), 4, 32);
					}
					else {					
						InetSocketAddress port_number = null;						
						
						if (DevelopmentVersion.VERSION_PRESSURE_TEST) {
							port_number = new InetSocketAddress(configuration.getString("Game_Server_IP"),Integer.parseInt(configuration.getString("Game_Server_Port")));				
						}	
						else {
							port_number = new InetSocketAddress(configuration.getString("Game_Server_IP"),Integer.parseInt(configuration.getString("Game_Server_Port")));	
						}
						
						if ( port_number != null ) {
							// StartServer
							sp.StartServer(port_number, 32, 32);
						}
						else {						
							// StartServer
							sp.startServer(getPort(args), 32, 32);
						}
					}
					
					SysLog.PrintWarring("[Success] Server Start 成功 ......Success!!");
					return;
				}
				catch (Exception e)
				{
					SysLog.PrintException("[Exception].unknow exception in main(String[] args) : "+ e.getMessage() +"");
					e.printStackTrace();
				}		
			}
			catch (Exception e) {
				e.printStackTrace();
					
				SysLog.PrintException("[Exception].[main(String[] args)] Exception error : " + e.getMessage());				

			}

		}
		//_SERVER_ERROR_ 處理
		SysLog.PrintWarring("[Failure] Server Start 失敗 ...Error:"+strError+" ...Failure!!");
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
			SysLog.PrintError("Too many Arguments.");
			SysLog.PrintError("[Help]\nport\t\t指定port");
			throw new IllegalArgumentException();
		}

		SysLog.PrintInfo(ip + ":" + port);		

		return port;
	}	
	
	/*
	 *  初始 SettingManager()
	 */
	public static void InitSettingManage() {
		SysLog.PrintDebug("[Init].[Begin] SettingManage !!!");
			SettingManage.getInstance();	
		SysLog.PrintDebug("[Init].[Ended] SettingManage !!!");
	}

	
	public static void InitServiceManager() {
		SysLog.PrintDebug("[Init].[Begin] ServiceManage !!!");
			ServiceManage.getInstance();	
		SysLog.PrintDebug("[Init].[Ended] ServiceManage !!!");
	}	

	/*
	 * 取得 ResourceBundle
	 */
	public static ResourceBundle getResourceBundle() {
		if ( GameServerStarter.configuration != null ) {
			return GameServerStarter.configuration;
		}
		
		return null;
	}
	
	/*
	 *  初始  ActorManage  
	 */
	public static void InitActorManage()  {
		SysLog.PrintDebug("[Init].[Begin] ActorManage !!!");
			ActorManage.getInstance();	
		SysLog.PrintDebug("[Init].[Ended] ActorManage !!!");
	}
	
	/*
	 * 
	 */
	public static void InitGeoipManage() {
		SysLog.PrintDebug("[Init].[Begin] GeoipManage !!!");
			GeoipManage.getInstance();	
		SysLog.PrintDebug("[Init].[Ended] GeoipManage !!!");
	}
	
	/*
	 * 初始暫存 Redis Manage
	 */
	public static void InitRedisManage() {
		SysLog.PrintDebug("[Init].[Begin] RedisManager !!!");
			RedisManager.getInstance();	
		SysLog.PrintDebug("[Init].[Ended] RedisManager !!!");
	}
	
	/*
	 *  初始   HibernateManagement  
	 *  資料  OR-M Management
	 */
	public static void InitHibernateManagement()  {
		SysLog.PrintDebug("[Init].[Begin] HibernateManagement !!!");
			HibernateManagement.getInstance();
		SysLog.PrintDebug("[Init].[Ended] HibernateManagement !!!");
	}
}