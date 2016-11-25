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
	
	public CGGSLTableInfo receive_ = new CGGSLTableInfo();
	public CGGCliTableInfo responses_ = new CGGCliTableInfo();
	public CGThisGroup this_group_ = new CGThisGroup();
	CGJourneyBarProb prob_ = new CGJourneyBarProb();
	
	public void OnReceive(byte[] packet_data) {
		String json_text = new String(packet_data, StandardCharsets.UTF_8);
		this.receive_ = JSON.parseObject(json_text, CGGSLTableInfo.class);
	}
	
	public void OnResponse(NettyClientChannel channel) {
		String json2string = JSON.toJSONString(this.responses_,
											   new com.alibaba.fastjson.serializer.PascalNameFilter());
		SysLog.PrintInfo(String.format("Logic_CGGSLTableInfo Command:%s WriteJSON:[%s]!!",
						"CGGCliTableInfo",
						json2string));
		channel.writeJSON(json2string);
	}
	
	public boolean OnPerformLogic(NettyClientChannel channel) {		
		if(this.receive_.Auto_ != 1)
			return false;
		
		Integer id = (Integer)channel.get(ActorKeys.MEMBER_ID);
		GClonePlayer player = ActorManage.GetClonePlayer(id);
		Object states = player.get(ActorKeys.PLAY_GROUP_STATES);
		if( states != null && states != CGJourneyBarStatus.JOURNEYBAR_STATUS_WAIT_PLAY)
			return false;
		else
			player.put(ActorKeys.PLAY_GROUP_STATES, CGJourneyBarStatus.JOURNEYBAR_STATUS_BET_TIME);
					
		LoadTurnStopRecord(this_group_.CSGrpNo_, this_group_.GameMode);
		SetResponsesData();
		SetCGGCliRandomTimesResult();
		player.put(ActorKeys.PLAY_GROUP_STATES, CGJourneyBarStatus.JOURNEYBAR_STATUS_BET_TIME);
				
		return true;			
	}
	
	public boolean LoadTurnStopRecord(int group_index, CGGameGrpModes group_mode) {
		return true;
	}
	
	public void SetCGGCliRandomTimesResult() {
		for(int i = 0; i < 12; i++) {
			Random rd = new Random();
			this.responses_.iRandomTimes_[i] = rd.nextInt(46);
		}	
	}
	
	public void SetResponsesData() {
		this.responses_ = new CGGCliTableInfo();
		this.responses_.SeatNo_ = this_group_.CSGrpNo_;
		this.responses_.iUserPoint_ = prob_.GetRatioPoint(1);
		this.responses_.iJPBonus_ = this_group_.pJPBonusList[0];
		this.responses_.iPlatformJpBouns_ = this_group_.pJPBonusList[0];
		this.responses_.iTurnStop_ = 1;
		this.responses_.PairerMinBet_ = 1000;
		this.responses_.PairerMaxBet_ = 80000;
		this.responses_.NationPointRatio_ = 3;
	}

}
