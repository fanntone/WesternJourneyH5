package com.jinglei.game.server.logic;


import java.nio.charset.StandardCharsets;

import com.alibaba.fastjson.JSON;
import com.jinglei.channel.NettyClientChannel;
import com.jinglei.game.SysLog;
import com.jinglei.game.attribute.ActorKeys;
import com.jinglei.game.attribute.impl.GClonePlayer;
import com.jinglei.game.manage.ActorManage;
import com.jinglei.game.server.common.CGGameGrpModes;
import com.jinglei.game.server.common.CGJourneyBarProb;
import com.jinglei.game.server.common.CGJourneyBarStatus;
import com.jinglei.game.server.common.CGThisGroup;
import com.jinglei.packets.ctos.CGGSLTableInfo;
import com.jinglei.packets.stoc.CGGCliTableInfo;
import com.jinglei.server.logic.CommonLogic;

import java.util.Random;

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
	//private CGThisGroup this_group_ = new CGThisGroup();
	private CGJourneyBarProb prob_ = new CGJourneyBarProb();
	
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
		GClonePlayer player = GetGClonePlayer(GetGroupId(channel));
		String states = GetPlayGroupStates(player);
		
		if( states == null || Integer.parseInt(states, 10) != CGJourneyBarStatus.JOURNEYBAR_STATUS_WAIT_PLAY.GetValue())
			return false;
				
		if(this.receive_.Auto_ != 1)
			return false;

		SetResponsesData();
		SetPlayGroupStates(player);
				
		return true;
	}
	
	private void SetResponsesData() {
		this.responses_.RunGrpBeginTime_ = CGThisGroup.RunGrpBeginTime_;
		this.responses_.RunGrpEndTime_ = CGThisGroup.RunGrpEndTime_;
		this.responses_.ThisGrpNo_ = CGThisGroup.ThisGrpNo_;
		this.responses_.GrpType_= CGThisGroup.GrpType_;
		this.responses_.CoinType_ = CGThisGroup.CoinType_;
		this.responses_.GameType_ = CGThisGroup.GameType_;
		this.responses_.BetRange_ = CGThisGroup.BetRange_;
		this.responses_.MaxBetLimit_= CGThisGroup.MaxBetLimit_;	
		this.responses_.GrpUniID_ = CGThisGroup.GrpUniID_;
		this.responses_.JPBonusList_ = CGThisGroup.JPBonusList_;
		this.responses_.BounsHistoryRecord_ = CGThisGroup.BounsHistoryRecord_;
		this.responses_.SampleHistoryRecord_= CGThisGroup.SampleHistoryRecord_;
		this.responses_.BounsTotalBet_ = CGThisGroup.BounsTotalBet_;
		this.responses_.SampleTotalBet_ = CGThisGroup.SampleTotalBet_;
		this.responses_.RandomPay_ = CGThisGroup.RandomPay_;
		this.responses_.NationCoinType_= CGThisGroup.NationCoinType_;
		this.responses_.MaxBetValue_ = CGThisGroup.MaxBetValue_;
		this.responses_.MinBetValue_= CGThisGroup.MinBetValue_;	
	}

	private Integer GetGroupId(NettyClientChannel channel) {
		return (Integer)channel.get(ActorKeys.MEMBER_ID);
	}
	
	private GClonePlayer GetGClonePlayer(Integer id) {
		return ActorManage.GetClonePlayer(id);
	}
	
	private String GetPlayGroupStates(GClonePlayer player) {
		return player.get(ActorKeys.PLAYER_STATES);
	}
	
	private void SetPlayGroupStates(GClonePlayer player) {
		player.put(ActorKeys.PLAYER_STATES,
				   CGJourneyBarStatus.JOURNEYBAR_STATUS_BET_TIME);
	}
	
}
