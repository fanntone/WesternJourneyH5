package com.jinglei.game.server.common;

//傳送給 Client 的訊息
public enum CGGameCliMsg {
    GCLIMSG_GAME_RELOGIN_USER(0),	//登入遊戲
    GCLIMSG_TABLE_INFO(1),			//回傳本桌的資訊
    GCLIMSG_RESULT(2),				//轉動的結算
    GCLIMSG_RANDOM_TIMES_RESULT(3),	//隨機倍率結果
//  GCLIMSG_EXIT_GAME,				//離開遊戲
//  GCLIMSG_RECORD_INFO, 			//玩家每局記錄,共50局
//  GCLIMSG_BUYIN_POINT, 			//玩家要買點數VX
//  GCLIMSG_BUYIN_SUCCESS, 			//買點成功VX
	GCLIMSG_UNITE_ID(4), 			//通知遊戲下一局將號
	GCLIMSG_TRAILER_PRIZE(5), 		//通知遊戲預告中大獎中免費遊戲中BONUS遊戲
    GCLIMSG_MAX(6);
	
    private int value_;

    private CGGameCliMsg(int value) {
        this.value_ = value;
    }

    public int GetValue() {
    	return value_;
    }
}
