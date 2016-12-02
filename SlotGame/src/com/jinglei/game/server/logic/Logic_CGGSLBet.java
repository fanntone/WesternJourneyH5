package com.jinglei.game.server.logic;

import java.nio.charset.StandardCharsets;

import com.alibaba.fastjson.JSON;
import com.jinglei.channel.NettyClientChannel;
import com.jinglei.game.SysLog;
import com.jinglei.game.attribute.ActorKeys;
import com.jinglei.game.attribute.impl.GClonePlayer;
import com.jinglei.game.manage.ActorManage;
import com.jinglei.game.server.common.CGJPBonus;
import com.jinglei.game.server.common.CGProbability;
import com.jinglei.game.server.common.CGGruupStates;
import com.jinglei.game.server.common.CGThisGroup;
import com.jinglei.hibernate.read.account_data;
import com.jinglei.hibernate.read.dao.DataBaseReadDAO;
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
	CGProbability prob_ = new CGProbability();
	
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
		//if( CGThisGroup.States_ != CGGruupStates.JOURNEYBAR_STATUS_BET_TIME.GetValue())
		//	return true;
		
		OnPerformWinResult(channel);
		OnPlayerRecordToDBServer();
		return true;
	}
		
	public GClonePlayer GetGClonePlayer(Integer id)  {
		return ActorManage.GetClonePlayer(id);
	}
	
	public void OnPerformWinResult(NettyClientChannel channel) {
		// 計算賽局機率與開獎結果, 然後丟給各別玩家
		// 沒中獎示範
		responses_.BetResult = 0;
		responses_.SampleSlotStopList[0] = 0;
		responses_.BonusSlotPoints = 0;	
		responses_.BossSlotStopList[0] = 0;
		responses_.BossSlotStopList[1] = 1; 
		responses_.OpenStyle = 0;	
		responses_.OpenStyleWinResult = 0;
		
		responses_.SampleSlotWinPoints = 0;
		responses_.BonusSlotPoints = 0;
		responses_.GetJPBoints = 0;
		responses_.PlayerTotalWinPoints = responses_.SampleSlotWinPoints +
										  responses_.BonusSlotPoints +
										  responses_.GetJPBoints;
		responses_.PlayerCurrentPoints = GeyPlayerCurrnetPoints(channel) +
										 responses_.PlayerTotalWinPoints +
										 responses_.GetJPBoints;

		responses_.JPBonus = GetJPBonus();
	}

	public void OnPlayerRecordToDBServer() {
		// 紀錄玩家輸贏到DB
		
	}
	
	public int GeyPlayerCurrnetPoints(NettyClientChannel channel) {
		SysLog.PrintInfo("GeyPlayerCurrnetPoints Begin");
		// 得到使用者資料要從MEMBER_ID去得到GClonePlayer物件,
		// 接著才能從這個物件去存取ACCOUNT_DATA
		account_data accountData = DataBaseReadDAO.findAccountData("A0001");
		SysLog.PrintInfo(accountData.getPoints().toString());
		SysLog.PrintInfo("GeyPlayerCurrnetPoints End");
		
//		int id = channel.get(ActorKeys.MEMBER_ID);
//		GClonePlayer player = GetGClonePlayer(id);
//		account_data adata = player.get(ActorKeys.ACCOUNT_DATA);
//	    adata.setPoints(accountData.getPoints());
		return accountData.getPoints();
	}
	
	public int GetJPBonus() {
		CGJPBonus.JP_1 = CGJPBonus.JP_1 - responses_.GetJPBoints;
		return CGJPBonus.JP_1;
	}
}
