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
	private CGThisGroup this_group_ = new CGThisGroup();
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
		
		LoadProbBankRecord();
		InitProbData();
		LoadTurnStopRecord();
		
		if(this.receive_.Auto_ != 1)
			return false;
		
		SetResponsesData();
		SetRandomTimes();
		SetPlayGroupStates(player);
				
		return true;
	}
	
	private boolean LoadTurnStopRecord() {
		return true;
	}
	
	private void SetRandomTimes() {
		prob_.RandomPai();
		for(int i = 0; i < 12; i++) {
			this.responses_.iRandomTimes_[i] = prob_.CliRandomTimesResult_.iRandomTimes_[i];
		}
	}
	
	private void SetResponsesData() {
		this.responses_.SeatNo_ = this_group_.CSGrpNo_;
		this.responses_.iUserPoint_ = prob_.GetRatioPoint(1);
		this.responses_.iJPBonus_ = this_group_.pJPBonusList[0];
		this.responses_.iPlatformJpBouns_ = this_group_.pJPBonusList[0];
		this.responses_.iTurnStop_ = 1;
		this.responses_.PairerMinBet_ = 1000;
		this.responses_.PairerMaxBet_ = 80000;
		this.responses_.NationPointRatio_ = 3;
	}

	private Integer GetGroupId(NettyClientChannel channel) {
		return (Integer)channel.get(ActorKeys.MEMBER_ID);
	}
	
	private GClonePlayer GetGClonePlayer(Integer id)  {
		return ActorManage.GetClonePlayer(id);
	}
	
	private String GetPlayGroupStates(GClonePlayer player) {
		return player.get(ActorKeys.PLAYER_STATES);
	}
	
	private void SetPlayGroupStates(GClonePlayer player) {
		player.put(ActorKeys.PLAYER_STATES,
				   CGJourneyBarStatus.JOURNEYBAR_STATUS_BET_TIME);
	}
	
	private void LoadProbBankRecord() {
		prob_.LoadBankRecord(this_group_.CSGrpNo_,
							 this_group_.GameMode,
							 this_group_.PointRatioL,
							 this_group_.PointRatioR);
	}
	
	private void InitProbData() {
		prob_.InitData(this_group_);		
	}
}
