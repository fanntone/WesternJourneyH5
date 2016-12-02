package com.jinglei.game.server.logic;

import java.nio.charset.StandardCharsets;

import com.alibaba.fastjson.JSON;
import com.jinglei.channel.NettyClientChannel;
import com.jinglei.game.SysLog;
import com.jinglei.game.attribute.ActorKeys;
import com.jinglei.game.attribute.impl.GClonePlayer;
import com.jinglei.game.manage.ActorManage;
import com.jinglei.game.manage.UtilTimeManage;
import com.jinglei.game.server.common.StatusCode;
import com.jinglei.hibernate.read.account_data;
import com.jinglei.hibernate.read.dao.DataBaseReadDAO;
import com.jinglei.packets.ctos.JoinGame;
import com.jinglei.packets.stoc.JoinGameResult;
import com.jinglei.server.logic.CommonLogic;


/**
 * <pre>
 * 	Class Name  : 			Logic_JoinGameResult
 * 	Description :           處理 Client 登入遊戲 封包，邏輯處理 Function
 * 							收到玩家要登入  封包
 *  Request 	:			JoinGame
 *  Responses	:			JoinGameResult
 * 	Modification Information
 * 			Receive Packet:
 * 				JoinGame
 *						Account    		String  	玩家帳號
 * 						PassWord   		String  	玩家密碼
 *
 *			Send Packet:
 *				JoinGameResult
 * 						StateCode		int  	狀態碼
 *						MemberID		int  	玩家唯一碼
 *						CurrencyID		int  	玩家幣別
 *						Account			String 	玩家帳號
 * 						NickName		String 	玩家暱稱
 * 						PassWord		String 	玩家密碼
 * 						ErrorCount		int  	密碼錯誤次數
 * 						Points			int  	玩家現有點數
 * 						GameID			int  	玩家在線狀態
 * 						UseInfo			int  	帳號是否可用
 * 						LanguageID		int		玩家所使用的語言
 * 						EquipmentID		int		玩家所使用的裝置
 * 
 *
 * </pre>
 *
 * @author Bear Wu
 * @since 2016. 11. 14.
 * @version 
 *
 */
public class Logic_JoinGameResult implements CommonLogic {

	/*
	 * 		Logic_JoinGameResult construct
	 */
	public Logic_JoinGameResult() {
		super();
	}
	
//	@Override
//	public void executeLogic(byte[] packet_data, NettyClientChannel channel) {
//		try {
//			SysLog.PrintError(String.format("[Logic:%s]  Run Date:%d  Channel HashCode:%d Runing Begin...!!!", getLogicName(),UtilTimeManage.getCurrentTimeToNumber(),channel.getHashCode()));
//			
//			if ( packet_data != null && channel != null ) {
//				
//				boolean[] check_bool = { false };
//				int[]     check_code = { 0 };
//				
//				String json_text = new String(packet_data, StandardCharsets.UTF_8);
//				
//				JoinGame receive = JSON.parseObject(json_text, JoinGame.class);
//				if ( receive != null && channel != null) {					
//					Task exeTask = TaskManage.getTaskObjectByType(TaskExecuteEnum.TEE_JoinGame.getType(),check_code);
//					if ( check_code[0] >= 1 && exeTask != null) {
//						/*
//						 *  channel.hashCode() -> 所產生 hashCode() 在編碼上有可能會沖撞
//						 *  要使用  getHashCode
//						 */
//						SysLog.PrintError(String.format("[Logic:%s]  Check Hash Code:%d",getLogicName(),channel.hashCode()));
//						exeTask.put(TaskKeys.CHANNEL_HASH_CODE, channel.getHashCode());
//						exeTask.put(TaskKeys.JSON_STRINGS, json_text);
//						TaskManage.addTask(exeTask);
//					}				
//				}
//			}			
//		}
//		catch (Exception e) {
//		
//		}
//		finally	{
//			SysLog.PrintError(String.format("[Logic:%s]  Run Date:%d  Runing Endded...!!!", getLogicName(),UtilTimeManage.getCurrentTimeToNumber()));	
//		}
//
//	}
	
	@Override
	public void executeLogic(byte[] packet_data, NettyClientChannel channel) {
		try {
			SysLog.PrintError(String.format("[Logic:%s]  Run Date:%d  Channel HashCode:%d Runing Begin...!!!", getLogicName(),UtilTimeManage.getCurrentTimeToNumber(),channel.getHashCode()));
			
			if ( packet_data != null && channel != null ) {
				
				String 			json_text 	= null;
				JoinGame 		receive	    = null;
				account_data 	accountData = null;
				
				GClonePlayer 	player 		= null;
				/*
				 *  _LOGIC_ERROR_ Begin
				 */
				_LOGIC_ERROR_: {	
					json_text = new String(packet_data, StandardCharsets.UTF_8);				
					
					receive =  JSON.parseObject(json_text, JoinGame.class);
					
					if ( receive == null || 
						 receive.getAccount().isEmpty() || receive.getAccount().equals("")) {
						SysLog.PrintError(String.format("[Logic:%s] JoinGame Parse Object is NULL....Failure!!",getLogicName()));
						break _LOGIC_ERROR_;
					}
					
					DataBaseReadDAO.getInstance();
					accountData = DataBaseReadDAO.findAccountData(receive.getAccount());
					if ( accountData == null ) {
						SysLog.PrintError(String.format("[Logic:%s] MySQL get account is NULL....Failure!!",getLogicName()));
						break _LOGIC_ERROR_;
					}
					
					player = ActorManage.GetClonePlayer(accountData.getMemberID());
					
					if ( player == null ) {
						player = new GClonePlayer(channel,accountData.getMemberID());						
					}
					else {
						player.setMemberID(accountData.getMemberID());		
					}
					
					/*
					 * 取  Redis 資料
					 */
//					GBaseProbability   baseProbability = player.get(ActorKeys.BASE_PROBABILITY);
//					
//					if ( baseProbability == null ) { 
//						baseProbability = new GBaseProbability();
//						baseProbability.setAccountData(accountData);
//						player.put(ActorKeys.BASE_PROBABILITY, baseProbability);
//					}		
					
					player.put(ActorKeys.ACCOUNT_DATA, accountData);
					
					channel.put(ActorKeys.MEMBER_ID,new Integer(accountData.getMemberID()));
					
					ActorManage.addChannel(channel);					
					ActorManage.AddClonePlayer(accountData.getMemberID(),player);					
					ActorManage.AddOnlinePlayer(String.format("%s:%s", accountData.getAccount(),accountData.getPassWord()),accountData.getMemberID());
					
					JoinGameResult responses = new JoinGameResult(accountData);
					
					if ( responses != null && responses.getStateCode() >= 1) {						
						/*
						 * new com.alibaba.fastjson.serializer.PascalNameFilter()
						 * 字首不會轉成小寫
						 */	
						//channel.writeJSON(JSON.toJSONString(responses, SerializerFeature.WriteClassName));
						SysLog.PrintError(String.format("[Logic:%s] Execute:%s channel HashCode:[%s]!!",getLogicName(), "JoinGameResult",JSON.toJSONString(responses,new com.alibaba.fastjson.serializer.PascalNameFilter())));
						SysLog.PrintError(String.format("[Logic:%s] Execute:%s WriteJSON:[%s]!!",getLogicName(), "JoinGameResult",JSON.toJSONString(responses,new com.alibaba.fastjson.serializer.PascalNameFilter())));
						channel.writeJSON(JSON.toJSONString(responses,new com.alibaba.fastjson.serializer.PascalNameFilter()));
						return ;
					}				
				}
				/*
				 *  _LOGIC_ERROR_ Endded
				 */
				
				/*
				 * 更換狀態失敗
				 */
				JoinGameResult responses = new JoinGameResult();
				
				if ( responses != null && channel != null) {		
					responses.setStateCode(StatusCode.Failure.getCode());
					/*
					 * new com.alibaba.fastjson.serializer.PascalNameFilter()
					 * 字首不會轉成小寫
					 */	
					//channel.writeJSON(JSON.toJSONString(responses, SerializerFeature.WriteClassName));
					SysLog.PrintError(String.format("[Logic:%s] Execute:%s WriteJSON:[%s]!!",getLogicName(), "JoinGameResult",JSON.toJSONString(responses,new com.alibaba.fastjson.serializer.PascalNameFilter())));
					channel.writeJSON(JSON.toJSONString(responses,new com.alibaba.fastjson.serializer.PascalNameFilter()));					
				}
			}	
			
			return;
		}
		catch (Exception e) {
		
		}
		finally	{
			SysLog.PrintError(String.format("[Logic:%s]  Run Date:%d  Runing Endded...!!!", getLogicName(),UtilTimeManage.getCurrentTimeToNumber()));	
		}

	}

	@Override
	public String getLogicName() {
		// TODO Auto-generated method stub
		return new String(this.getClass().getName());
	}

	@Override
	public CommonLogic newInstance() {
		return new Logic_JoinGameResult();
	}

}
