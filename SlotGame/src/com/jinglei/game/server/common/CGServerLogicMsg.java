package com.jinglei.game.server.common;


//傳送給 Server Logic 的訊息
public enum CGServerLogicMsg {
	SLMSG_FIRST,
	SLMSG_GROUP_SETTED,							// GameServer 傳送給 Server Logic 第一筆訊息,用以表示成局了
	SLMSG_USER_INFO,							// 取得某玩家的資訊
	SLMSG_GAME_CONTINUE,						// 一局遊戲結束,回應是否繼續遊戲
	SLMSG_GAME_HOLD,							// 一局遊戲結束,回應是否暫停遊戲
	SLMSG_BROADCAST,							// 將某段資料廣播給該局的其他玩家
	SLMSG_WAIT_SYNC,							// 向 SLB 請求同步(被動式)
	SLMSG_TALK_TEXT,							// 某個玩家鍵入對話文字
	SLMSG_TALK_SOUND,							// 某個玩家選擇對話語音
	SLMSG_READY,								// 等候區的玩家已經準備好隨時可以入局了
	SLMGS_UI_CTRL,								// 玩家點選了某個UI介面
	SLMGS_SPEC_TIME_TAG,
	SLMGSR_ASSIGN_USER_WIN_GAME_ID,				// 指定玩家贏得指定的遊戲獎項
	SLMGSR_ASSIGN_USER_PROBABILITY,				// 指定玩家的贏獎機率
	SLMGSR_ASSIGN_TABLE_PROBABILITY,			// 指定桌的贏獎機率
	SLMGSR_OPEN_BONUS,							// 開啟寶箱的結果
	SLMSGR_REMOTE_CONTROL_USER_BONUS,			// 指定中彩金
	SLMSGR_REMOTE_CONTROL_USER_RANDOMBONUS,		// 指定隨機彩金中獎
	SLMSGR_REMOTE_CONTROL_USER_AWARDS,			// 指定中大獎
    SLMSGR_UPDATE_APIPOINTS,					// 更新API傳來點數
	SLMSG_USER_BUY_IN,							// 玩家BUYIN
	SLMSG_GM_LOGIN,								// GM登入
	SLMSG_USER_LEAVE_KEEP_TABLE,				// 玩家發生斷線留座
	SLMSG_USER_BACK_KEEP_TABLE,					// 玩家斷線留座返回
	SLMSG_RUN_LOGIC,							// 執行遊戲邏輯
	SLMSG_SET_GRP_LOOPS,						// 設定遊戲的局數
	SLMSG_READ_SRAND,							// 讀取亂數種子
	SLMSG_NEED_WAIT,							// 請求同步訊號
	SLMSG_SRAND,								// 設定亂數種子
	SLMSG_GAME_SCORE,							// 寫回玩家戰績
	SLMSG_GAME_BANKER_POINTS,					// 遊戲莊家的點數
	SLMSG_POINT_REFRESH	,						// 網頁交易
	SLMSG_ABSOLUTE_POINTS,						// DB回傳的絕對值點數
	SLMSG_USER_JOIN_GAME,						// 玩家即時加入戰局
	SLMSG_DONKEY_MSG,							// 驢子用的訊息
	SLMSG_ONLINE_CHECK,							// 用來檢查各家的連線狀態
	SLMSG_USER_LEAVE,							// 有玩家離線
	SLMSG_HOST_MSG,								// 主機程式訊息
	SLMSG_MAX									// 使用者自訂的訊息從 SLMSG_MAX + 1 開始
}
