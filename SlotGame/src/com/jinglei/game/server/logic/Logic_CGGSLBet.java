package com.jinglei.game.server.logic;

import java.nio.charset.StandardCharsets;

import com.alibaba.fastjson.JSON;
import com.jinglei.channel.NettyClientChannel;
import com.jinglei.game.SysLog;
import com.jinglei.packets.ctos.CGGSLBet;
import com.jinglei.packets.stoc.CGGCliResult;
import com.jinglei.server.logic.CommonLogic;

public class Logic_CGGSLBet implements CommonLogic {

	@Override
	public void executeLogic(byte[] packet_data, NettyClientChannel channel) {
		try	{
			SysLog.PrintInfo("Logic_CGGSLBet Run Start!!");
			
			if ( packet_data != null && channel != null ) {
				String json_text = new String(packet_data, StandardCharsets.UTF_8);
				CGGSLBet receive = JSON.parseObject(json_text, CGGSLBet.class);
				
				if ( receive != null && channel != null) {
					CGGCliResult responses = new CGGCliResult();
					
					if ( responses != null ) {
						String json2string = JSON.toJSONString(responses,
															   new com.alibaba.fastjson.serializer.PascalNameFilter());
						SysLog.PrintInfo(String.format("Logic_CGGSLBet Command:%s WriteJSON:[%s]!!",
										 "CGGCliResult",
										 json2string));
						channel.writeJSON(json2string);
					}
				}	
			}	
		}
		catch(Exception e) {
			SysLog.PrintError("Logic_CGGSLBet Run Error!!");
		}
		finally {
			SysLog.PrintInfo("Logic_CGGSLBet Run Finally!!");
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
		return new Logic_CGGSLBet();
	}

}
