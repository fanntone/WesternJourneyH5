package com.jinglei.game.server.common;

public enum CGPlayerState {
	PL_STATE_READY_GAME,           															///< 已成局並且等待遊戲開始進行中
	PL_STATE_GET_DB_POINTS,																	///< 已取得DBSrv中的玩家點數並且DB已設定該玩家登入了遊戲伺服器
	PL_STATE_GS_CONNECTED,         															///< Socket已連線至GS
	PL_STATE_RUN_GAME,             															///< 遊戲中
	PL_STATE_QUIT_QUEUE,           															///< 離開局中
	PL_STATE_LOGOUT_GS,																											///< 登出GS
	PL_STATE_MAX,
}
