package com.jinglei.game.server.logic;

import java.nio.charset.StandardCharsets;

import com.alibaba.fastjson.JSON;
import com.jinglei.channel.NettyClientChannel;
import com.jinglei.game.SysLog;
import com.jinglei.packets.ctos.Table;
import com.jinglei.packets.stoc.TabbleInfo;
import com.jinglei.server.logic.CommonLogic;


/**
 * <pre>
 * 	Class Name  : 			Logic_TableInfo
 * 	Description :           處理 Client Talbe 封包，邏輯處理 Function
 *  Request 	:			Table
 *  Responses	:			TabbleInfo
 * 	Modification Information
 * 			Receive Packet:
 * 				Table
 *						BetRange   int  選擇押注區(目前填入1即可)
 *
 *			Send Packet:
 *				TabbleInfo
 *						BetMin   			int 	最小押注20
 *						BetMax   			int		最大押注6250
 *						Grid[15]    		int[]	15格的資料 顯示用
 *						UserPoint   		int		玩家現有金額
 *						TableJpBonus1		int     小彩金,顯示用
 *						TableJpBonus2		int     中彩金,顯示用
 * 						GameJpBonus         int		遊戲彩金,累積彩金金額,顯示用
 * 						PlatformJpBouns		int     平台彩金,累積彩金金額,顯示用		
 * 
 *
 * </pre>
 *
 * @author Bear Wu
 * @since 2016. 11. 14.
 * @version 
 *
 */
public class Logic_TableInfo implements CommonLogic {
	
	/*
	 * 		Logic_TableInfo construct
	 */
	public Logic_TableInfo() {
		super();
	}

	@Override
	public void executeLogic(byte[] packet_data, NettyClientChannel channel) {
		try {
			SysLog.PrintError("Logic_TableInfo Run !!");
			
			if ( packet_data != null && channel != null ) {
				String json_text = new String(packet_data, StandardCharsets.UTF_8);
				
				Table receive = JSON.parseObject(json_text, Table.class);
				if ( receive != null && channel != null) {
					TabbleInfo responses = new TabbleInfo();
					
					if ( responses != null ) {						
						/*
						 * new com.alibaba.fastjson.serializer.PascalNameFilter()
						 * 字首不會轉成小寫
						 */	
						//channel.writeJSON(JSON.toJSONString(responses, SerializerFeature.WriteClassName));
						SysLog.PrintError(String.format("Logic_TableInfo Command:%s WriteJSON:[%s]!!", "TabbleInfo",JSON.toJSONString(responses,new com.alibaba.fastjson.serializer.PascalNameFilter())));
						channel.writeJSON(JSON.toJSONString(responses,new com.alibaba.fastjson.serializer.PascalNameFilter()));
					}					
				}
			}			
		}
		catch (Exception e) {
		
		}
		finally	{
			SysLog.PrintError("Logic_TableInfo Run finally!!");
			
		}

	}

	@Override
	public String getLogicName() {
		//return new String(Logic_TableInfo());
		return new String(this.getClass().getName());
	}

	@Override
	public CommonLogic newInstance() {
		return new Logic_TableInfo();
	}

}
