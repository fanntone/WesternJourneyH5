package com.jinglei.game.server.logic;

import java.nio.charset.StandardCharsets;
import com.alibaba.fastjson.JSON;
import com.jinglei.channel.NettyClientChannel;
import com.jinglei.game.SysLog;
import com.jinglei.packets.ctos.CGGSLRandomOddsInfo;
import com.jinglei.packets.stoc.CGGCliRandomOddsResult;
import com.jinglei.server.logic.CommonLogic;

public class Logic_CGGSLRandomOddsInfo implements CommonLogic {

	@Override
	public void executeLogic(byte[] packet_data, NettyClientChannel channel) {
		try	{
			SysLog.PrintInfo("Logic_CGGSLRandomTimesInfo Run Start!!");
			
			if ( packet_data != null && channel != null ) {
				String json_text = new String(packet_data, StandardCharsets.UTF_8);
				CGGSLRandomOddsInfo receive = JSON.parseObject(json_text, CGGSLRandomOddsInfo.class);
				
				if ( receive != null && channel != null) {
					CGGCliRandomOddsResult responses = new CGGCliRandomOddsResult();
					
					if ( responses != null ) {
						String json2string = JSON.toJSONString(responses,
															   new com.alibaba.fastjson.serializer.PascalNameFilter());
						SysLog.PrintInfo(String.format("Logic_CGGSLRandomTimesInfo Command:%s WriteJSON:[%s]!!",
										 "CGGCliRandomTimesResult",
										 json2string));
						channel.writeJSON(json2string);
					}
				}	
			}	
		}
		catch(Exception e) {
			SysLog.PrintError("Logic_CGGSLRandomTimesInfo Run Error!!");
		}
		finally {
			SysLog.PrintInfo("Logic_CGGSLRandomTimesInfo Run Finally!!");
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
		return new Logic_CGGSLRandomOddsInfo();
	}

}
