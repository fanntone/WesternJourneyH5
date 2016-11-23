package com.jinglei.game.service.impl;

import com.alibaba.fastjson.JSON;
import com.jinglei.channel.NettyClientChannel;
import com.jinglei.hibernate.read.account_data;
import com.jinglei.hibernate.read.dao.AccountDataDAO;
import com.jinglei.game.SysLog;
import com.jinglei.game.attribute.ActorKeys;
import com.jinglei.game.attribute.impl.GClonePlayer;
import com.jinglei.game.manage.ActorManage;
import com.jinglei.game.manage.UtilTimeManage;
import com.jinglei.game.server.common.StatusCode;
import com.jinglei.game.service.Service;
import com.jinglei.game.service.ServiceKeys;
import com.jinglei.packets.ctos.JoinGame;
import com.jinglei.packets.stoc.JoinGameResult;

/**
 * <pre>
 * 	Class Name  : 			Service_JoinGame
 *  Inherit Class	:		Service	
 * 	Description :           處理玩家登入遊戲
 *  Request 	:			
 *  Responses	:			
 * 	Modification Information
 *
 * 
 *
 * </pre>
 *
 * @author Bear Wu
 * @since 2016. 11. 21.
 * @version 
 *
 */
public class Service_JoinGame extends Service {
	
	public Service_JoinGame() {
		super();
	}

	@Override
	public Service newInstance() {
		return new Service_JoinGame();
	}

	@Override
	public String getServiceName() {
		return new String("Service_JoinGame()");
	}

	@Override
	public int Execute() {
		SysLog.PrintError(String.format("[Service:%s]  Run Date:%d  Runing Begin...!!!", getServiceName(),UtilTimeManage.getCurrentTimeToNumber()));
		
		try {	
			// _SERVICE_ERROR_ Begin
			_SERVICE_ERROR_: {	
				boolean[] check_bool = { false };
				int[]     check_code = { 0 };
				
				Integer   				channel_hashcode  = get(ServiceKeys.CHANNEL_HASH_CODE,check_bool);
				
				if ( channel_hashcode == null || !check_bool[0]) {
					SysLog.PrintError(String.format("[Service:%s] Channel Hashcode is NULL....!!",getServiceName()));
					break _SERVICE_ERROR_;					
				}
				
				NettyClientChannel 	player_channel 	  = ActorManage.getChannel(channel_hashcode, false);
				
				if (player_channel == null ) {
					SysLog.PrintError(String.format("[Service:%s] Channel Hashcode:%d Player Channel is NULL....!!",getServiceName(),channel_hashcode));
					break _SERVICE_ERROR_;
				}			
				
				String					json_strings	  = get(ServiceKeys.JSON_STRINGS,check_bool);
				
				if ( json_strings == null || json_strings.isEmpty() ||	!check_bool[0]) {
					SysLog.PrintError(String.format("[Service:%s] JSON Strings  is Error....Failure!!",getServiceName()));
					break _SERVICE_ERROR_;
				}
				
				
				JoinGame receive = JSON.parseObject(json_strings, JoinGame.class);
				
				if ( receive == null || 
					 receive.getAccount().isEmpty() || receive.getAccount().equals("")) {
					SysLog.PrintError(String.format("[Service:%s] JoinGame Parse Object is NULL....Failure!!",getServiceName()));
					break _SERVICE_ERROR_;
				}
				
				AccountDataDAO.getInstance();
				account_data accountData = AccountDataDAO.findAccountData(receive.getAccount());
				
				if ( accountData == null ) {
					SysLog.PrintError(String.format("[Service:%s] MySQL get account is NULL....Failure!!",getServiceName()));
					break _SERVICE_ERROR_;
				}
				
				GClonePlayer player = new GClonePlayer(player_channel,accountData.getMemberID());
				
				if ( player != null ) {
					player_channel.put(ActorKeys.MEMBER_ID, new Integer(accountData.getMemberID()));
					
					player.put(ActorKeys.ACCOUNT_DATA, accountData.Clone());
					ActorManage.AddClonePlayer(accountData.getMemberID(),player);					
					ActorManage.AddOnlinePlayer(String.format("%s:%s", accountData.getAccount(),accountData.getPassWord()),accountData.getMemberID());
					
					JoinGameResult responses = new JoinGameResult(accountData);
					
					if ( responses != null && responses.getStateCode() >= 1) {						
						/*
						 * new com.alibaba.fastjson.serializer.PascalNameFilter()
						 * 字首不會轉成小寫
						 */	
						//channel.writeJSON(JSON.toJSONString(responses, SerializerFeature.WriteClassName));
						SysLog.PrintError(String.format("[Service:%s] Execute:%s WriteJSON:[%s]!!",getServiceName(), "JoinGameResult",JSON.toJSONString(responses,new com.alibaba.fastjson.serializer.PascalNameFilter())));
						player_channel.writeJSON(JSON.toJSONString(responses,new com.alibaba.fastjson.serializer.PascalNameFilter()));
						return StatusCode.Success.getCode();
					}	
				}
				else {
					SysLog.PrintError(String.format("[Service:%s] new GClonePlayer is NULL....Failure!!",getServiceName()));
				}
			}
			// _SERVICE_ERROR_ Endded				
			return StatusCode.Failure.getCode();

		}
		catch (Exception e)
		{
			SysLog.PrintError(String.format("[Service:%s] unknow exception in Execute() Error:〔%s...Exception!!!", getServiceName(),e.getMessage()));
			e.printStackTrace();
		}
		finally
		{
			SysLog.PrintError(String.format("[Service:%s] Runing Ended...!!!", getServiceName()));
		}
		
		return StatusCode.Failure.getCode();
	}

	@Override
	public long CalculateNextExecutionTime() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void BuildService() {
		// TODO Auto-generated method stub
		
	}
	


}
