package com.jinglei.game.server.logic;

import java.nio.charset.StandardCharsets;

import com.alibaba.fastjson.JSON;
import com.jinglei.channel.NettyClientChannel;
import com.jinglei.game.SysLog;

import com.jinglei.game.manage.UtilTimeManage;
import com.jinglei.game.service.Service;
import com.jinglei.game.service.ServiceExecuteEnum;
import com.jinglei.game.service.ServiceKeys;
import com.jinglei.game.service.ServiceManage;
import com.jinglei.packets.ctos.JoinGame;
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
	
	@Override
	public void executeLogic(byte[] packet_data, NettyClientChannel channel) {
		try {
			SysLog.PrintError(String.format("[Logic:%s]  Run Date:%d  Channel HashCode:%d Runing Begin...!!!", getLogicName(),UtilTimeManage.getCurrentTimeToNumber(),channel.getHashCode()));
			
			if ( packet_data != null && channel != null ) {
				int[]     check_code = { 0 };
				
				String json_text = new String(packet_data, StandardCharsets.UTF_8);			
				JoinGame receive = JSON.parseObject(json_text, JoinGame.class);
				if ( receive != null && channel != null) {					
					Service exeService = ServiceManage.getServiceObjectByType(ServiceExecuteEnum.SEE_JoinGame.getType(),check_code);
					if ( check_code[0] >= 1 && exeService != null) {
						/*
						 *  channel.hashCode() -> 所產生 hashCode() 在編碼上有可能會沖撞
						 *  要使用  getHashCode
						 */
						SysLog.PrintError(String.format("[Logic:%s]  Check Hash Code:%d",getLogicName(),channel.hashCode()));
						exeService.put(ServiceKeys.CHANNEL_HASH_CODE, channel.getHashCode());
						exeService.put(ServiceKeys.JSON_STRINGS, json_text);
						ServiceManage.addService(exeService);
					}				
				}
			}			
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
