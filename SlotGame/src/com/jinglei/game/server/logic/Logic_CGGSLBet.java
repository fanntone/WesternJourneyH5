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
import com.jinglei.packets.ctos.CGGSLBet;
import com.jinglei.packets.ctos.CGGSLTableInfo;
import com.jinglei.packets.stoc.CGGCliResult;
import com.jinglei.packets.stoc.CGGCliTableInfo;
import com.jinglei.server.logic.CommonLogic;

public class Logic_CGGSLBet implements CommonLogic {

	@Override
	public void executeLogic(byte[] packet_data, NettyClientChannel channel) {
		try	{
			SysLog.PrintInfo("Logic_CGGSLBet Run Start!!");
			
			OnReceive(packet_data);
			if(OnPerformLogic(channel))
				OnResponse(channel);
		}
		catch(Exception e) {
			SysLog.PrintError("Logic_CGGSLBet Run Error!!");
		}
		finally {
			SysLog.PrintInfo("Logic_CGGSLBet Run Finally!!");
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
		return new Logic_CGGSLBet();
	}
	
	public CGGSLBet receive_ = new CGGSLBet();
	public CGGCliResult responses_ = new CGGCliResult();
	public CGThisGroup this_group_ = new CGThisGroup();
	CGJourneyBarProb prob_ = new CGJourneyBarProb();
	
	
	public void OnReceive(byte[] packet_data) {
		String json_text = new String(packet_data,
									  StandardCharsets.UTF_8);
		this.receive_ = JSON.parseObject(json_text,
										 CGGSLBet.class);
	}
	
	public void OnResponse(NettyClientChannel channel) {
		String json2string = JSON.toJSONString(this.responses_,
											   new com.alibaba.fastjson.serializer.PascalNameFilter());
		SysLog.PrintInfo(String.format("Logic_CGGSLBet Command:%s WriteJSON:[%s]!!",
						"CGGCliResult",
						json2string));
		channel.writeJSON(json2string);
	}
	
	public boolean OnPerformLogic(NettyClientChannel channel) {
		Integer id = GetGroupId(channel);
		GClonePlayer player = GetGClonePlayer(id);
		String states = GetPlayGroupStates(player);
		if( states == null || Integer.parseInt(states, 10) != CGJourneyBarStatus.JOURNEYBAR_STATUS_BET_TIME.GetValue())
			return false;
		
		int iNowWinPoint = 0;
		int iTotalPoint = 0;
				
		BetTwelveSlot(iTotalPoint);
		BetBankPlayerSlot();
		
		SaveTurnStopRecord(this_group_.CSGrpNo_,
						   this_group_.GameMode);
		AddGrpInfoRecord(iNowWinPoint,
						 this_group_.CSGrpNo_,
						 this_group_.GameMode);
		SetPlayGroupStates(player);
		return true;
	}
	
	public void SetPlayGroupStates(GClonePlayer player) {
		player.put(ActorKeys.PLAYER_STATES,
				   CGJourneyBarStatus.JOURNEYBAR_STATUS_RESULT);
	}
	
	public Integer GetGroupId(NettyClientChannel channel) {
		return (Integer)channel.get(ActorKeys.MEMBER_ID);
	}
	
	public GClonePlayer GetGClonePlayer(Integer id)  {
		return ActorManage.GetClonePlayer(id);
	}
	
	public String GetPlayGroupStates(GClonePlayer player) {
		return player.get(ActorKeys.PLAYER_STATES);
	}

	public boolean SaveTurnStopRecord(int group_index, int group_mode) {
		return true;
	}
	
	public boolean AddGrpInfoRecord(int win_lose, int group_index, int group_mode) {
		return true;
	}
	
	public void BetTwelveSlot(int iTotalPoint) {
		for(int index = 0 ; index  < 12; index++) {
			iTotalPoint  = iTotalPoint + receive_.iBetSum_[index];
		}

	}
	
	public void BetBankPlayerSlot() {
		
	}

}
