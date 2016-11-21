package com.jinglei.game.server.logic;

import java.nio.charset.StandardCharsets;

import com.alibaba.fastjson.JSON;
import com.jinglei.channel.NettyClientChannel;
import com.jinglei.game.SysLog;
import com.jinglei.packets.ctos.Guess;
import com.jinglei.packets.stoc.GuessResult;
import com.jinglei.server.logic.CommonLogic;


/**
 * <pre>
 * 	Class Name  : 			Logic_GuessResult
 * 	Description :           處理 Client Guess 封包，邏輯處理 Function
 * 							收到玩家要比倍  封包
 *  Request 	:			Guess
 *  Responses	:			GuessResult
 * 	Modification Information
 * 			Receive Packet:
 * 				Guess
 *						GuessBet   		int  玩家選的比倍答案(0:無 1:大,2:小,3:黑桃,4:紅心,5:方塊,6:梅花)
 *						GuessBetPoint	int	 比倍的金額,不可押比上次嬴的大,比倍點數不可以超過100萬,比倍點數不可超過玩家現有的點數
 *
 *			Send Packet:
 *				GuessResult
 * 						GuessWinLoss		int  	比倍結果 (0:輸了 1:贏了)
 *						GuessResult			int  	比倍的答案(0:無 1:大,2:小,3:黑桃,4:紅心,5:方塊,6:梅花)
 *						GuessWinPoint		int  	贏得金額
 *						UserPoint			int  	玩家現有金額	
 * 
 *
 * </pre>
 *
 * @author Bear Wu
 * @since 2016. 11. 14.
 * @version 
 *
 */
public class Logic_GuessResult implements CommonLogic {
	
	/*
	 * 		Logic_GuessResult construct
	 */
	public Logic_GuessResult() {
		super();
	}

	@Override
	public void executeLogic(byte[] packet_data, NettyClientChannel channel) {
		try {
			SysLog.PrintError("Logic_GuessResult Run !!");
			
			if ( packet_data != null && channel != null ) {
				String json_text = new String(packet_data, StandardCharsets.UTF_8);
				
				Guess receive = JSON.parseObject(json_text, Guess.class);
				if ( receive != null && channel != null) {
					GuessResult  responses = new GuessResult();
					
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
			SysLog.PrintError("Logic_GuessResult Run finally!!");
			
		}

	}

	@Override
	public String getLogicName() {
		// TODO Auto-generated method stub
		//return new String(Logic_GuessResult());
		return new String(this.getClass().getName());
	}

	@Override
	public CommonLogic newInstance() {
		// TODO Auto-generated method stub
		return new Logic_GuessResult();
	}

}
