package com.jinglei.game.server.logic;

import java.nio.charset.StandardCharsets;

import com.alibaba.fastjson.JSON;
import com.jinglei.channel.NettyClientChannel;
import com.jinglei.game.SysLog;
import com.jinglei.packets.ctos.Guess;
import com.jinglei.packets.ctos.JoinGame;
import com.jinglei.packets.stoc.GuessResult;
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
	
	@Override
	public void executeLogic(byte[] packet_data, NettyClientChannel channel) {
		try {
			SysLog.PrintError("Logic_JoinGameResult Run !!");
			
			if ( packet_data != null && channel != null ) {
				String json_text = new String(packet_data, StandardCharsets.UTF_8);
				
				JoinGame receive = JSON.parseObject(json_text, JoinGame.class);
				if ( receive != null && channel != null) {
					JoinGameResult  responses = new JoinGameResult();
					
					if ( responses != null ) {						
						/*
						 * new com.alibaba.fastjson.serializer.PascalNameFilter()
						 * 字首不會轉成小寫
						 */	
						//channel.writeJSON(JSON.toJSONString(responses, SerializerFeature.WriteClassName));
						channel.writeJSON(JSON.toJSONString(responses,new com.alibaba.fastjson.serializer.PascalNameFilter()));
					}					
				}
			}			
		}
		catch (Exception e) {
		
		}
		finally	{
			SysLog.PrintError("Logic_JoinGameResult Run finally!!");
			
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
