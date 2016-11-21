package com.jinglei.game.server.logic;

import java.nio.charset.StandardCharsets;

import com.alibaba.fastjson.JSON;
import com.jinglei.channel.NettyClientChannel;
import com.jinglei.game.SysLog;
import com.jinglei.packets.ctos.Freegame;
import com.jinglei.packets.stoc.FreegameResult;
import com.jinglei.server.logic.CommonLogic;


/**
 * <pre>
 * 	Class Name  : 			Logic_FreeGameResult
 * 	Description :           處理 Client  Freegame 封包，邏輯處理 Function
 * 							要求  Free Game Next Times 結果
 *  Request 	:			Freegame
 *  Responses	:			FreegameResult
 * 	Modification Information
 * 			Receive Packet:
 * 				Freegame
 *						FreeTime   int  還有幾次Free Game
 *
 *			Send Packet:
 *				FreegameResult
 * 						LastTime			int  	剩餘次數
 *						UserPoint			int  	現有金額
 *						LineWinPoints		int  	贏得連線金額
 *						FreeTotalWinPoint	int  	累積贏得金額(含一般遊戲贏得的金額 不含freegame中 中的JP)
 *						Wheel[15]			int[]  	15格資料(1:9, 2:10, 3:11, 4:Q, 
 *														   5:K, 6:A, 7:銅板, 8:元寶, 
 *														   9:鳳凰, 10:帆船, 11:烏龜, 12:元寶-金, 
 *														   13:鳳凰-金, 14:帆船-金, 15:烏龜-金, 
 *														   16:Scatter(免費遊戲), 17:wild鬼牌)
 *													Grid[15] 跟 Wheel[15]  要傳直式  15輪的資料  要從左邊 1~3,4~6
 *															1,4,7,10,13
 *															2,5,8,11,14
 *															3,6,9,12,15
 *															
 *						Line				int		有中的線
 *						Farme				int     該線中幾格
 *						TableJpBonus1		int     小彩金,顯示用
 *						TableJpBonus2		int     中彩金,顯示用
 *						GameJpBonus			int		遊戲彩金,累積彩金金額,顯示用
 *						PlatformJpBouns		int		平台彩金,累積彩金金額,顯示用
 *						GetJPPoint			int		贏得JP彩金的金額
 *						AwardKind1			int     獎項(0:無,1:普通開獎, 2:FreeSpin, 3:小遊戲)
 *						AwardKind2			int     指定彩金種類 0:無,1:活動彩金,2:福氣彩金小彩金,3:魚躍彩金中彩金,4:長壽彩金該遊戲彩金,5:發財彩金平台總彩金.	
 * 
 *
 * </pre>
 *
 * @author Bear Wu
 * @since 2016. 11. 14.
 * @version 
 *
 */
public class Logic_FreeGameResult implements CommonLogic {
	
	/*
	 * 		Logic_FreeGameResult construct
	 */
	public Logic_FreeGameResult() {
		super();
	}

	@Override
	public void executeLogic(byte[] packet_data, NettyClientChannel channel) {
		try {
			SysLog.PrintError("Logic_FreeGameResult Run !!");
			
			if ( packet_data != null && channel != null ) {
				String json_text = new String(packet_data, StandardCharsets.UTF_8);
				
				Freegame receive = JSON.parseObject(json_text, Freegame.class);
				if ( receive != null && channel != null) {
					FreegameResult  responses = new FreegameResult();
					
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
			SysLog.PrintError("Logic_FreeGameResult Run finally!!");
			
		}
	}

	@Override
	public String getLogicName() {
		// TODO Auto-generated method stub
		//return new String(Logic_FreeGameResult());
		return new String(this.getClass().getName());
	}

	@Override
	public CommonLogic newInstance() {
		// TODO Auto-generated method stub
		return new Logic_FreeGameResult();
	}

}
