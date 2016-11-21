package com.jinglei.game.server.logic;

import java.nio.charset.StandardCharsets;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.jinglei.channel.NettyClientChannel;
import com.jinglei.game.SysLog;
import com.jinglei.packets.ctos.Bonus;
import com.jinglei.packets.stoc.BonusResult;
import com.jinglei.server.logic.CommonLogic;

/**
 * <pre>
 * 	Class Name  : 			Logic_BonusResult
 * 	Description :           處理 Client Bonus 封包，邏輯處理 Function
 * 							收到玩家 點小遊戲 要結果封包
 *  Request 	:			Bonus
 *  Responses	:			BonusResult
 * 	Modification Information
 * 			Receive Packet:
 * 				Bonus
 *						BonusBet   		int  玩家點了第幾格
 *
 *			Send Packet:
 *				BonusResult
 * 						BonusResult			int  	給玩家的圖(0: 女童,1:男童,2:奶奶,3:公公)
 *						GetJPPoint			int  	贏得JP彩金的金額
 *						UserPoint			int  	玩家現有金額
 *						TableJpBonus1		int  	小彩金,顯示用
 *						TableJpBonus2		int  	中彩金,顯示用
 **						GameJpBonus			int  	遊戲彩金,累積彩金金額,顯示用
 **						PlatformJpBouns		int  	平台彩金,累積彩金金額,顯示用	
 * 
 *
 * </pre>
 *
 * @author Bear Wu
 * @since 2016. 11. 14.
 * @version 
 *
 */
public class Logic_BonusResult implements CommonLogic {
	
	/*
	 * 		Logic_BonusResult construct
	 */
	public Logic_BonusResult() {
		super();
	}

	@Override
	public void executeLogic(byte[] packet_data, NettyClientChannel channel) {
		try {
			SysLog.PrintDebug("Logic_BonusResult Run !!");
			
			if ( packet_data != null && channel != null ) {
				String json_text = new String(packet_data, StandardCharsets.UTF_8);
				
				Bonus receive = JSON.parseObject(json_text, Bonus.class);
				if ( receive != null && channel != null) {
					BonusResult responses = new BonusResult();	
					
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
			SysLog.PrintDebug("Logic_BonusResult Run finally!!");			
		}
	}

	@Override
	public String getLogicName() {
		//return new String("Logic_BetResult()");
		return new String(this.getClass().getName());
	}

	@Override
	public CommonLogic newInstance() {
		// TODO Auto-generated method stub
		return new Logic_BonusResult();
	}

}
