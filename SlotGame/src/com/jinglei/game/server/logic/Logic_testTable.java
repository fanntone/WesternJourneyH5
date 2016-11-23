package com.jinglei.game.server.logic;

import java.nio.charset.StandardCharsets;

import com.alibaba.fastjson.JSON;
import com.jinglei.channel.NettyClientChannel;
import com.jinglei.game.SysLog;
import com.jinglei.packets.ctos.FannTest;
import com.jinglei.server.logic.CommonLogic;
import com.jinglei.packets.stoc.TestTable;

public class Logic_testTable implements CommonLogic{

	public Logic_testTable() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void executeLogic(byte[] packet_data, NettyClientChannel channel) {
		try {
			SysLog.PrintError("Logic_testTable Run !!");
			
			if ( packet_data != null && channel != null ) {
				String json_text = new String(packet_data, StandardCharsets.UTF_8);
				
				FannTest receive = JSON.parseObject(json_text, FannTest.class);
				if ( receive != null && channel != null) {
					TestTable responses = new TestTable();
					
					if ( responses != null ) {
						responses.setBetMin(receive.getBetMin());
						responses.setBetMax(receive.getBetMax());
						SysLog.PrintError(String.format("Logic_testTable Command:%s WriteJSON:[%s]!!",
										  "TestTable",JSON.toJSONString(responses,new com.alibaba.fastjson.serializer.PascalNameFilter())));
						channel.writeJSON(JSON.toJSONString(responses,new com.alibaba.fastjson.serializer.PascalNameFilter()));
					}					
				}
			}			
		}
		catch (Exception e) {
		
		}
		finally	{
			SysLog.PrintError("Logic_testTable Run finally!!");
			
		}

	}

	@Override
	public String getLogicName() {
		//return new String(Logic_TableInfo());
		return new String(this.getClass().getName());
	}

	@Override
	public CommonLogic newInstance() {
		return new Logic_testTable();
	}

}
