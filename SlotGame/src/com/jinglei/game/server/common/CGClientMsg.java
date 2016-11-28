package com.jinglei.game.server.common;

//傳送給 Client 的訊息
public enum CGClientMsg {
	CLIMSG_FIRST(0),
	CLIMSG_GROUP_SETTED(1),			//該局的所有玩家均加入戰局了
	CLIMSG_USER_INFO(1),			//SLMSG_USER_INFO 訊息的傳回值
	CLIMSG_BET_POINTS(2),			//SLMSG_BET_POINTS 訊息的傳回值
	CLIMSG_GAME_CONTINUE(3),		//SLMSG_GAME_CONTINUE 訊息的傳回值
	CLIMSG_GAME_HOLD(3),			//SLMSG_GAME_HOLD訊息的傳回值
	CLIMSG_BROADCAST(4),			//SLMSG_BROADCAST 訊息的傳回值
	CLIMSG_WAIT_SYNC(5),			//SLMSG_SYN 訊息的傳回值
	CLIMSG_TALK_TEXT(6),			//SLMSG_TALK_TEXT 訊息的傳回值
	CLIMSG_TALK_SOUND(7),			//SLMSG_TALK_SOUND 訊息的傳回值
	CLIMSG_KICK_OUT(8),				//被 SLB 踢出局
	CLIMSG_SERVER_MSG(9),			//遊戲伺服器訊息
	CLIMSG_NULL(10),				//空封包
	CLIMSG_GOTO_WAITING_AREA(11),	//至等候區(強制)
	CLIMSG_GOTO_GROUP_BALANCE(12),	//至場結算幕(強制)
	CLIMSG_USER_JOIN_GAME(13),		//玩家加入局
	CLIMSG_USER_LEAVE_GAME(14),		//玩家離開局
	CLIMSG_DISBAND_GROUP(15),		//解散該局
	CLIMSG_DISBAND_GAME(16),		//新的解散局封包,請回大廳
	CLIMSG_HOST_MSG(16),			//主機程式訊息
	CLIMSG_MAX(17);					//使用者自訂的訊息從 CLIMSG_MAX + 1 開始
	
    private int value_;

    private CGClientMsg(int value) {
        this.value_ = value;
    }

    public int GetValue() {
    	return value_;
    }
}
