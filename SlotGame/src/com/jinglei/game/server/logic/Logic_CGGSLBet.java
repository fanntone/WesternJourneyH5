package com.jinglei.game.server.logic;

import java.nio.charset.StandardCharsets;

import com.alibaba.fastjson.JSON;
import com.jinglei.channel.NettyClientChannel;
import com.jinglei.game.SysLog;
import com.jinglei.game.attribute.ActorKeys;
import com.jinglei.game.attribute.impl.GClonePlayer;
import com.jinglei.game.manage.ActorManage;
import com.jinglei.game.server.common.CGJPBouns;
import com.jinglei.game.server.common.CGJourneyBarProb;
import com.jinglei.game.server.common.CGJourneyBarStatus;
import com.jinglei.game.server.common.CGThisGroup;
import com.jinglei.hibernate.read.account_data;
import com.jinglei.packets.ctos.CGGSLBet;
import com.jinglei.packets.stoc.CGGCliResult;
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
		return new String(this.getClass().getName());
	}

	@Override
	public CommonLogic newInstance() {
		return new Logic_CGGSLBet();
	}
	
	public CGGSLBet receive_ = new CGGSLBet();
	public CGGCliResult responses_ = new CGGCliResult();
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
		if( CGThisGroup.States_ != CGJourneyBarStatus.JOURNEYBAR_STATUS_BET_TIME.GetValue())
			return false;
		
		OnPerformWinResult(channel);
		OnPlayerRecordToDBServer();
		return true;
	}
		
	public GClonePlayer GetGClonePlayer(Integer id)  {
		return ActorManage.GetClonePlayer(id);
	}
	
	public void OnPerformWinResult(NettyClientChannel channel) {
		// 計算賽局機率與開獎結果, 然後丟給各別玩家
//		public int WinResult_ = 0;
//		public int[] SampleSlotStopList_ = new int[6];
//		public int BounsSlotStopList_ = 0;
//		public int[] BossSlotStopList_ = new int[2];
//		public int OpenStyle_ = 0;
//		public int OpenStyleWinResult_ = 0;
//		public double SampleSlotWinPoints_ = 0;
//		public double BounsSlotPoints_ = 0;
//		public double PlayerTotalWinPoints_ = 0;
//		public double PlayerCurrentPoints_ = 0;
//		public double GetJPBoints_ = 0;
//		public double JPBonus_ = 0;

//		沒中獎示範
		responses_.WinResult_ = 0;
		responses_.SampleSlotStopList_[0] = 0;
		responses_.BounsSlotPoints_ = 0;
		responses_.BossSlotStopList_[0] = 0;
		responses_.BossSlotStopList_[1] = 1;
		responses_.OpenStyle_ = 0;
		responses_.OpenStyleWinResult_ = 0;
		responses_.SampleSlotWinPoints_ = 0;
		responses_.BounsSlotPoints_ = 0;
		responses_.PlayerTotalWinPoints_ = 0;
		responses_.PlayerCurrentPoints_ = GeyPlayerCurrnetPoints(channel);
		responses_.GetJPBoints_ = 0;
		responses_.JPBonus_ = CGJPBouns.JP_1;
	}

	public void OnPlayerRecordToDBServer() {
		// 紀錄玩家輸贏到DB
		
	}
	
	public int GeyPlayerCurrnetPoints(NettyClientChannel channel) {
		int id = channel.get(ActorKeys.MEMBER_ID);
		GClonePlayer player = GetGClonePlayer(id);
		account_data adata = player.get(ActorKeys.ACCOUNT_DATA);
		return adata.getPoints();
	}
}
