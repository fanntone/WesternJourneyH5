package com.jinglei.game.server.logic;

import com.jinglei.channel.NettyClientChannel;
import com.jinglei.game.SysLog;
import com.jinglei.server.logic.CommonLogic;
import java.nio.charset.StandardCharsets;
import com.alibaba.fastjson.JSON;
import com.jinglei.packets.ctos.CGSLGameReLogin;
import com.jinglei.packets.stoc.CGCliGameReLogin;

public class Logic_CGSLGameReLogin implements CommonLogic {

	public Logic_CGSLGameReLogin() {
		super();
	}
	
	@Override
	public void executeLogic(byte[] packet_data, NettyClientChannel channel) {
		try	{
			SysLog.PrintInfo("Logic_CGSLGameReLogin Run !!");
			
			if ( packet_data != null && channel != null ) {
				String json_text = new String(packet_data, StandardCharsets.UTF_8);
				CGSLGameReLogin receive = JSON.parseObject(json_text, CGSLGameReLogin.class);
				
				if ( receive != null && channel != null) {
					CGCliGameReLogin responses = new CGCliGameReLogin();
					
					if ( responses != null ) {
						String json2string = JSON.toJSONString(responses,
															   new com.alibaba.fastjson.serializer.PascalNameFilter());
						SysLog.PrintInfo(String.format("Logic_CGSLGameReLogin Command:%s WriteJSON:[%s]!!",
										 "CGCliGameReLogin",
										 json2string));
						channel.writeJSON(json2string);
					}
				}	
			}	
		}
		catch(Exception e) {
			SysLog.PrintError("Logic_CGSLGameReLogin Run Error!!");
		}
		finally {
			SysLog.PrintInfo("Logic_CGSLGameReLogin Run finally!!");
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
		return new Logic_CGSLGameReLogin();
	}

}
