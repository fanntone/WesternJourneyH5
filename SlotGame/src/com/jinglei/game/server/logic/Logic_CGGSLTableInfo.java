package com.jinglei.game.server.logic;


import java.nio.charset.StandardCharsets;

import com.alibaba.fastjson.JSON;
import com.jinglei.channel.NettyClientChannel;
import com.jinglei.game.SysLog;
import com.jinglei.game.server.common.CGGroupStates;
import com.jinglei.game.server.common.CGThisGroup;
import com.jinglei.packets.ctos.CGGSLTableInfo;
import com.jinglei.packets.stoc.CGGCliTableInfo;
import com.jinglei.server.logic.CommonLogic;

public class Logic_CGGSLTableInfo implements CommonLogic {

	@Override
	public void executeLogic(byte[] packet_data, NettyClientChannel channel) {
		try	{
			SysLog.PrintInfo("Logic_CGGSLTableInfo Run !!");
			
			OnReceive(packet_data);
			if(OnPerformLogic(channel))
				OnResponse(channel);
		}
		catch(Exception e) {
			SysLog.PrintInfo("Logic_CGGSLTableInfo Run Error!!");
		}
		finally {
			SysLog.PrintInfo("Logic_CGGSLTableInfo Run finally!!");
		}	
	}

	@Override
	public String getLogicName() {
		return new String(this.getClass().getName());
	}
	
	@Override
	public CommonLogic newInstance() {
		return new Logic_CGGSLTableInfo();
	}
	
	private CGGSLTableInfo receive_ = new CGGSLTableInfo();
	private CGGCliTableInfo responses_ = new CGGCliTableInfo();
	
	private void OnReceive(byte[] packet_data) {
		String json_text = new String(packet_data,
									  StandardCharsets.UTF_8);
		this.receive_ = JSON.parseObject(json_text,
										 CGGSLTableInfo.class);
	}
	
	private void OnResponse(NettyClientChannel channel) {
		String json2string = JSON.toJSONString(this.responses_,
											   new com.alibaba.fastjson.serializer.PascalNameFilter());
		SysLog.PrintInfo(String.format("Logic_CGGSLTableInfo Command:%s WriteJSON:[%s]!!",
						"CGGCliTableInfo",
						json2string));
		channel.writeJSON(json2string);
	}
	
	private boolean OnPerformLogic(NettyClientChannel channel) {
		if( CGThisGroup.States_ != CGGroupStates.JOURNEYBAR_STATUS_WAIT_PLAY.GetValue())
			return false;
				
		if(this.receive_.Auto_ != 1)
			return false;

		SetResponsesData();		
		CGThisGroup.States_ = CGGroupStates.JOURNEYBAR_STATUS_BET_TIME.GetValue();
		return true;
	}
	
	private void SetResponsesData() {
		this.responses_.RunGrpBeginTime = CGThisGroup.RunGrpBeginTime_;
		this.responses_.RunGrpEndTime = CGThisGroup.RunGrpEndTime_;
		this.responses_.ThisGrpNo = CGThisGroup.ThisGrpNo_;
		this.responses_.GrpType= CGThisGroup.GrpType_;
		this.responses_.CoinType = CGThisGroup.CoinType_;
		this.responses_.GameType = CGThisGroup.GameType_;
		this.responses_.BetRange = CGThisGroup.BetRange_;
		this.responses_.MaxBetLimit= CGThisGroup.MaxBetLimit_;	
		this.responses_.GrpUniID = CGThisGroup.GrpUniID_;
		this.responses_.JPBonusList = CGThisGroup.JPBonusList_;
		this.responses_.BounsHistoryRecord = CGThisGroup.BounsHistoryRecord_;
		this.responses_.SampleHistoryRecord= CGThisGroup.SampleHistoryRecord_;
		this.responses_.BounsTotalBet = CGThisGroup.BounsTotalBet_;
		this.responses_.SampleTotalBet = CGThisGroup.SampleTotalBet_;
		this.responses_.RandomPay = CGThisGroup.RandomPay_;
		this.responses_.NationCoinType= CGThisGroup.NationCoinType_;
		this.responses_.MaxBetValue = CGThisGroup.MaxBetValue_;
		this.responses_.MinBetValue= CGThisGroup.MinBetValue_;	
	}
	
}
