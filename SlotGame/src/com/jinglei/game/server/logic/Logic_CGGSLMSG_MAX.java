package com.jinglei.game.server.logic;

import com.jinglei.channel.NettyClientChannel;
import com.jinglei.game.SysLog;
import com.jinglei.server.logic.CommonLogic;

public class Logic_CGGSLMSG_MAX implements CommonLogic {

	@Override
	public void executeLogic(byte[] packet_data, NettyClientChannel channel) {
		try	{
			SysLog.PrintInfo("Logic_CGGSLMSG_MAX Run Start!!");
		}
		catch(Exception e) {
			SysLog.PrintError("Logic_CGGSLMSG_MAX Run Error!!");
		}
		finally {
			SysLog.PrintInfo("Logic_CGGSLMSG_MAX Run Finally!!");
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
		return new Logic_CGGSLMSG_MAX();
	}

}
