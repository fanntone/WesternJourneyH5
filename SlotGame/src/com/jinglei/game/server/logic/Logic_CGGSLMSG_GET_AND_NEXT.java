package com.jinglei.game.server.logic;

import java.nio.charset.StandardCharsets;

import com.alibaba.fastjson.JSON;
import com.jinglei.channel.NettyClientChannel;
import com.jinglei.game.SysLog;

import com.jinglei.packets.stoc.CGGCliUniteId;
import com.jinglei.server.logic.CommonLogic;

public class Logic_CGGSLMSG_GET_AND_NEXT implements CommonLogic {

	@Override
	public void executeLogic(byte[] packet_data, NettyClientChannel channel) {
		try	{
			SysLog.PrintInfo("Logic_CGGSLMSG_GET_AND_NEXT Run Start!!");
			
			if ( packet_data != null && channel != null ) {
				CGGCliUniteId responses = new CGGCliUniteId();					
				if ( responses != null ) {
					String json2string = JSON.toJSONString(responses,
														   new com.alibaba.fastjson.serializer.PascalNameFilter());
					SysLog.PrintInfo(String.format("Logic_CGGSLMSG_GET_AND_NEXT Command:%s WriteJSON:[%s]!!",
									 "CGGCliUniteId",
									 json2string));
					channel.writeJSON(json2string);
				}
			}	
		}
		catch(Exception e) {
			SysLog.PrintError("Logic_CGGSLMSG_GET_AND_NEXT Run Error!!");
		}
		finally {
			SysLog.PrintInfo("Logic_CGGSLMSG_GET_AND_NEXT Run Finally!!");
		}
	}


	@Override
	public String getLogicName() {
		return new String(this.getClass().getName());
	}

	@Override
	public CommonLogic newInstance() {
		// TODO Auto-generated method stub
		return new Logic_CGGSLMSG_GET_AND_NEXT();
	}

}
