package com.jinglei.game.server.common;

//傳送給 Client 的訊息
public enum CGClientMsg {
	CLIMSG_FIRST,
	CLIMSG_GROUP_SETTED,		//該局的所有玩家均加入戰局了
	CLIMSG_USER_INFO,			//SLMSG_USER_INFO 訊息的傳回值
	CLIMSG_BET_POINTS,			//SLMSG_BET_POINTS 訊息的傳回值
	CLIMSG_GAME_CONTINUE,		//SLMSG_GAME_CONTINUE 訊息的傳回值
	CLIMSG_GAME_HOLD,			//SLMSG_GAME_HOLD訊息的傳回值
	CLIMSG_BROADCAST,			//SLMSG_BROADCAST 訊息的傳回值
	CLIMSG_WAIT_SYNC,			//SLMSG_SYN 訊息的傳回值
	CLIMSG_TALK_TEXT,			//SLMSG_TALK_TEXT 訊息的傳回值
	CLIMSG_TALK_SOUND,			//SLMSG_TALK_SOUND 訊息的傳回值
	CLIMSG_KICK_OUT,			//被 SLB 踢出局
	CLIMSG_SERVER_MSG,			//遊戲伺服器訊息
	CLIMSG_NULL,				//空封包
	CLIMSG_GOTO_WAITING_AREA,	//至等候區(強制)
	CLIMSG_GOTO_GROUP_BALANCE,	//至場結算幕(強制)
	CLIMSG_USER_JOIN_GAME,		//玩家加入局
	CLIMSG_USER_LEAVE_GAME,		//玩家離開局
	CLIMSG_DISBAND_GROUP,		//解散該局
	CLIMSG_DISBAND_GAME,		//新的解散局封包,請回大廳
	CLIMSG_HOST_MSG,			//主機程式訊息
	CLIMSG_MAX					//使用者自訂的訊息從 CLIMSG_MAX + 1 開始
}
