package com.jinglei.game.server.common;

//傳送給 Server Logic 的訊息
public enum CGGameSLMsg {
    GSLMSG_GAME_RELOGIN_USER(0),	//登入遊戲
    GSLMSG_TABLE_INFO(1),			//第一次登入時，需要取得本桌的資訊
    GSLMSG_BET(2),					//押注的資訊
    GSLMSG_RANDOM_TIMES_INFO(3),	//客端要求下一局隨機倍率
    GSLMSG_GET_AND_NEXT(4),		//玩家要得分，並進入下一局
//  GSLMSG_EXIT_GAME,			//玩家離開遊戲
//  GSLMSG_BUYIN_POINT, 		//玩家要買點數VX
//  GSLMSG_BUYIN_SUCCESS, 		//買點成功VX
//  GSLMSG_RECORD_INFO, 		//玩家每局記錄,共50局
//  GSLMSG_JPBONUS_BOARD, 		//通知SERVER 廣播中到彩金
    GSLMSG_MAX(5);
	
    private int value_;

    private CGGameSLMsg(int value) {
        this.value_ = value;
    }

    public int GetValue() {
    	return value_;
    }
}
