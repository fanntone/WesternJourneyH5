package com.jinglei.game.server.logic;

import java.nio.charset.StandardCharsets;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.jinglei.channel.NettyClientChannel;
import com.jinglei.game.SysLog;
import com.jinglei.packets.ctos.Bet;
import com.jinglei.packets.stoc.BetResult;
import com.jinglei.server.logic.CommonLogic;

/**
 * <pre>
 * 	Class Name  : 			Logic_BetResult
 * 	Description :           處理 Client Bet 封包，邏輯處理 Function
 * 							收到玩家要押注封包
 *  Request 	:			Bet
 *  Responses	:			BetResult
 * 	Modification Information
 * 			Receive Packet:
 * 				Bet
 *						TotalBetPoint   int  總押注多少
 *						BetLine			int  押注幾條線 (25)
 *						BetAddition		押加成倍數.0:無,1:通寶,2:女童元寶,3:男童鳳凰,4:老婆婆寶船,5:老公公烏龜.
 *
 *			Send Packet:
 *				BetResult
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
public class Logic_BetResult implements CommonLogic {
	
	/*
	 * 		Logic_BetResult construct
	 */
	public Logic_BetResult() {
		super();
	}

	@Override
	public void executeLogic(byte[] packet_data, NettyClientChannel channel) {
		try {
			SysLog.PrintDebug("Logic_BetResult Run !!");
			
			if ( packet_data != null && channel != null ) {
				String json_text = new String(packet_data, StandardCharsets.UTF_8);
				
				Bet receive = JSON.parseObject(json_text, Bet.class);
				if ( receive != null && channel != null) {
					BetResult responses = new BetResult();	
					
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
			SysLog.PrintDebug("Logic_BetResult Run finally!!");			
		}
	}

	@Override
	public String getLogicName() {
		//return new String("Logic_BetResult()");
		return new String(this.getClass().getName());
	}

	@Override
	public CommonLogic newInstance() {
		return new Logic_BetResult();
	}

}
