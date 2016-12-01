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
import com.jinglei.game.server.common.CGThisGroup;
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
 * 		Description: Game Server 銝駁�.
 * </p>
 * 
 * <p>
 * 		Bief introduction:
 * 			@see com.jinglei.server.event.EventTypes
 * 				EventTypes :
 * 							CHANNEL_ACTIVE,  		//Channel 鋡怠������...
 * 							CHANNEL_INACTIVE,		//Channel Channel 憭望�����...
 * 							CHANNEL_REGISTERED,		//Channel 鋡怨酉������...		��蝺���  閮餃�channelMap 鋆��
 * 							CHANNEL_UNREGISTERED,	//Channel 蝘駁閮餃�����...		��蝺     ���宏�channelMap 鋆��
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
	
	public static ResourceBundle  configuration = null;		//Server ���身摰�
	private static final String SERVER_CONFIGURATION   		= "configuration";
	
	private static ServerPlugin sp = null;
	/**
	 * @param args
	 */
	@SuppressWarnings("unused")
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
				 *	���� Gashapon Manage 
				 */
				//InitGeoipManage();
				
				/*
				 * ���� Redis Manage
				 */	
					//InitRedisManage();	
					
				/*
				 * ����  Hibernate Management
				 */
					InitHibernateManagement();
					
				/*
				 *  ���� SettingManage
				 */
					//InitSettingManage();
					
				/*
				 *  ���� ServiceManager
				 */
					InitServiceManager();	
					
				/*
				 * ���� Actor Manage
				 */
					InitActorManage();
				
				sp = PluginHome.findPlugin(ServerPluginGroup.WEBSOCKET_NETTY_SERVER_PLUGIN);	
				
				if ( sp == null ) {
					strError = "[Failure] Server Plugin is NULL....Failure!!";
					break _SERVER_ERROR_;
				}
				
				//皜祈岫�

				rbLogicType = ResourceBundle.getBundle(GameServerStarter.LOGIC_TYPE_CONFIG);					
					
				if (rbLogicType == null ) {
					strError = "[Failure] Failure to read the server_logic_type_def.properties File....Failure!!!";
					break _SERVER_ERROR_;
				};
				
				/*
				 * 瘝����摩  ���釣閫�
				 */					
				if ( !sp.addLogic("com.jinglei.game.server.logic", rbLogicType)) {
					strError = "[Failure] Server Plugin addLogic by ResourceBundle... Failure!!";
					break _SERVER_ERROR_;
				}
			
				try
				{	
					// Test 
						CGThisGroup.getInstance();
					// Listener  Channel 鋡怨酉������...		��蝺���  閮餃�channelMap 鋆��
					sp.addListener(EventTypes.CHANNEL_REGISTERED, new EventListener[]{ 
						new ChannelRegistered(),
					});
								
					// Listener Channel Channel 憭望�����...	��蝺鈭�
					sp.addListener(EventTypes.CHANNEL_INACTIVE, new EventListener[]{ 
						new ChannelInactive(),
					});
					
					// Listener Channel Channel 霈��������
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
							sp.startServer(getPort(args), 32, 32);
						}
					}
					
					SysLog.PrintWarring("[Success] Server Start ���� ......Success!!");
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
		//_SERVER_ERROR_ ����
		SysLog.PrintWarring("[Failure] Server Start 憭望�� ...Error:"+strError+" ...Failure!!");
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
			SysLog.PrintError("[Help]\nport\t\t���ort");
			throw new IllegalArgumentException();
		}

		SysLog.PrintInfo(ip + ":" + port);		

		return port;
	}	
	
	/*
	 *  ���� SettingManager()
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
	 * ���� ResourceBundle
	 */
	public static ResourceBundle getResourceBundle() {
		if ( GameServerStarter.configuration != null ) {
			return GameServerStarter.configuration;
		}
		
		return null;
	}
	
	/*
	 *  ����  ActorManage  
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
	 * ���摮� Redis Manage
	 */
	public static void InitRedisManage() {
		SysLog.PrintDebug("[Init].[Begin] RedisManager !!!");
			RedisManager.getInstance();	
		SysLog.PrintDebug("[Init].[Ended] RedisManager !!!");
	}
	
	/*
	 *  ����   HibernateManagement  
	 *  鞈��  OR-M Management
	 */
	public static void InitHibernateManagement()  {
		SysLog.PrintDebug("[Init].[Begin] HibernateManagement !!!");
			HibernateManagement.getInstance();
		SysLog.PrintDebug("[Init].[Ended] HibernateManagement !!!");
	}
}