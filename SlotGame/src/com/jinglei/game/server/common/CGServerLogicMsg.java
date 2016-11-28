package com.jinglei.game.server.common;


//傳送給 Server Logic 的訊息
public enum CGServerLogicMsg {
	SLMSG_FIRST(0),
	SLMSG_GROUP_SETTED(1),							// GameServer 傳送給 Server Logic 第一筆訊息,用以表示成局了
	SLMSG_USER_INFO(2),								// 取得某玩家的資訊
	SLMSG_GAME_CONTINUE(3),							// 一局遊戲結束,回應是否繼續遊戲
	SLMSG_GAME_HOLD(4),								// 一局遊戲結束,回應是否暫停遊戲
	SLMSG_BROADCAST(5),								// 將某段資料廣播給該局的其他玩家
	SLMSG_WAIT_SYNC(6),								// 向 SLB 請求同步(被動式)
	SLMSG_TALK_TEXT(7),								// 某個玩家鍵入對話文字
	SLMSG_TALK_SOUND(8),							// 某個玩家選擇對話語音
	SLMSG_READY(9),									// 等候區的玩家已經準備好隨時可以入局了
	SLMGS_UI_CTRL(10),								// 玩家點選了某個UI介面
	SLMGS_SPEC_TIME_TAG(11),
	SLMGSR_ASSIGN_USER_WIN_GAME_ID(12),				// 指定玩家贏得指定的遊戲獎項
	SLMGSR_ASSIGN_USER_PROBABILITY(13),				// 指定玩家的贏獎機率
	SLMGSR_ASSIGN_TABLE_PROBABILITY(14),			// 指定桌的贏獎機率
	SLMGSR_OPEN_BONUS(15),							// 開啟寶箱的結果
	SLMSGR_REMOTE_CONTROL_USER_BONUS(16),			// 指定中彩金
	SLMSGR_REMOTE_CONTROL_USER_RANDOMBONUS(17),		// 指定隨機彩金中獎
	SLMSGR_REMOTE_CONTROL_USER_AWARDS(18),			// 指定中大獎
    SLMSGR_UPDATE_APIPOINTS(19),					// 更新API傳來點數
	SLMSG_USER_BUY_IN(20),							// 玩家BUYIN
	SLMSG_GM_LOGIN(21),								// GM登入
	SLMSG_USER_LEAVE_KEEP_TABLE(22),				// 玩家發生斷線留座
	SLMSG_USER_BACK_KEEP_TABLE(23),					// 玩家斷線留座返回
	SLMSG_RUN_LOGIC(24),							// 執行遊戲邏輯
	SLMSG_SET_GRP_LOOPS(25),						// 設定遊戲的局數
	SLMSG_READ_SRAND(26),							// 讀取亂數種子
	SLMSG_NEED_WAIT(27),							// 請求同步訊號
	SLMSG_SRAND(28),								// 設定亂數種子
	SLMSG_GAME_SCORE(29),							// 寫回玩家戰績
	SLMSG_GAME_BANKER_POINTS(30),					// 遊戲莊家的點數
	SLMSG_POINT_REFRESH(31),						// 網頁交易
	SLMSG_ABSOLUTE_POINTS(32),						// DB回傳的絕對值點數
	SLMSG_USER_JOIN_GAME(33),						// 玩家即時加入戰局
	SLMSG_DONKEY_MSG(34),							// 驢子用的訊息
	SLMSG_ONLINE_CHECK(35),							// 用來檢查各家的連線狀態
	SLMSG_USER_LEAVE(36),							// 有玩家離線
	SLMSG_HOST_MSG(37),								// 主機程式訊息
	SLMSG_MAX(38);									// 使用者自訂的訊息從 SLMSG_MAX + 1 開始
	
    private int value_;

    private CGServerLogicMsg(int value) {
        this.value_ = value;
    }

    public int GetValue() {
    	return value_;
    }
}
