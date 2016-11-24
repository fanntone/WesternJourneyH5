package com.jinglei.game.server.logic;

import java.nio.charset.StandardCharsets;

import com.alibaba.fastjson.JSON;
import com.jinglei.channel.NettyClientChannel;
import com.jinglei.game.SysLog;
import com.jinglei.packets.ctos.CGGSLTableInfo;
import com.jinglei.packets.stoc.CGGCliTableInfo;
import com.jinglei.server.logic.CommonLogic;

public class Logic_CGGSLTableInfo implements CommonLogic {

	@Override
	public void executeLogic(byte[] packet_data, NettyClientChannel channel) {
		try	{
			SysLog.PrintInfo("Logic_CGGSLTableInfo Run !!");
			
			if ( packet_data != null && channel != null ) {
				String json_text = new String(packet_data, StandardCharsets.UTF_8);
				CGGSLTableInfo receive = JSON.parseObject(json_text, CGGSLTableInfo.class);
				
				if ( receive != null && channel != null) {
					CGGCliTableInfo responses = new CGGCliTableInfo();
					
					if ( responses != null ) {
						String json2string = JSON.toJSONString(responses,
															   new com.alibaba.fastjson.serializer.PascalNameFilter());
						SysLog.PrintInfo(String.format("Logic_CGGSLTableInfo Command:%s WriteJSON:[%s]!!",
										 "CGGCliTableInfo",
										 json2string));
						channel.writeJSON(json2string);
					}
				}	
			}	
		}
		catch(Exception e) {
			
		}
		finally {
			SysLog.PrintInfo("Logic_CGGSLTableInfo Run finally!!");
		}	
	}

	@Override
	public String getLogicName() {
		// TODO Auto-generated method stub
		return new String(this.getClass().getName());
	}

	@Override
	public CommonLogic newInstance() {
		// TODO Auto-generated method stub
		return new Logic_CGGSLTableInfo();
	}

}
