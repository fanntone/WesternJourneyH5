package com.jinglei.game.server.common;

public enum CGPlayerState {
	PL_STATE_READY_GAME(0),		///< 已成局並且等待遊戲開始進行中
	PL_STATE_GET_DB_POINTS(1),	///< 已取得DBSrv中的玩家點數並且DB已設定該玩家登入了遊戲伺服器
	PL_STATE_GS_CONNECTED(2),	///< Socket已連線至GS
	PL_STATE_RUN_GAME(3),		///< 遊戲中
	PL_STATE_QUIT_QUEUE(4),		///< 離開局中
	PL_STATE_LOGOUT_GS(5),																											///< 登出GS
	PL_STATE_MAX(6);
	
    private int value_;

    private CGPlayerState(int value) {
        this.value_ = value;
    }

    public int GetValue() {
    	return value_;
    }
}
