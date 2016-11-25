package com.jinglei.game.server.logic;

import com.jinglei.channel.NettyClientChannel;
import com.jinglei.game.SysLog;
import com.jinglei.server.logic.CommonLogic;
import java.nio.charset.StandardCharsets;
import com.alibaba.fastjson.JSON;
import com.jinglei.packets.ctos.CGGSLGameReLogin;
import com.jinglei.packets.stoc.CGGCliGameReLogin;

public class Logic_CGGSLGameReLogin implements CommonLogic {

	public Logic_CGGSLGameReLogin() {
		super();
	}
	
	@Override
	public void executeLogic(byte[] packet_data, NettyClientChannel channel) {
		try	{
			SysLog.PrintInfo("Logic_CGGSLGameReLogin Run !!");
			
			if ( packet_data != null && channel != null ) {
				String json_text = new String(packet_data, StandardCharsets.UTF_8);
				CGGSLGameReLogin receive = JSON.parseObject(json_text, CGGSLGameReLogin.class);
				
				if ( receive != null && channel != null) {
					CGGCliGameReLogin responses = new CGGCliGameReLogin();
					
					if ( responses != null ) {
						String json2string = JSON.toJSONString(responses,
															   new com.alibaba.fastjson.serializer.PascalNameFilter());
						SysLog.PrintInfo(String.format("Logic_CGGSLGameReLogin Command:%s WriteJSON:[%s]!!",
										 "CGCliGameReLogin",
										 json2string));
						channel.writeJSON(json2string);
					}
				}	
			}	
		}
		catch(Exception e) {
			SysLog.PrintError("Logic_CGGSLGameReLogin Run Error!!");
		}
		finally {
			SysLog.PrintInfo("Logic_CGGSLGameReLogin Run finally!!");
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
		return new Logic_CGGSLGameReLogin();
	}

}
