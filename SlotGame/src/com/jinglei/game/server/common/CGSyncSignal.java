package com.jinglei.game.server.common;

/*	場景(幕)切換的訊息流程
1. GameServer 等待同步訊號
2. Client 傳送同步訊號
3. GameServer 收到各家的同步訊號,並通知 Client 已同步完成
4. Client 收到同步完成訊號並初始場景(幕)物件...等一切就緒之後傳送 SYNCSIGNAL_SCENE_START 訊號給 GameServer
5. GameServer 在收到 SYNCSIGNAL_SCENE_START 訊號, 並通知 Client...而後該場景(幕)就可以開始了
*/

//同步信號種類
public enum CGSyncSignal {
	SYNCSIGNAL_FIRST(0),
	SYNCSIGNAL_GAME(1),			//等待至遊戲幕
	SYNCSIGNAL_GAME_BALANCE(2),	//等待至遊戲結算幕
	SYNCSIGNAL_GROUP_BALANCE(3),	//等待至局結算幕
	SYNCSIGNAL_GROUP_OVER(4),		//等待該局結束
	SYNCSIGNAL_SCENE_START(5),		//該幕開始
	SYNCSIGNAL_MAX(6);				//使用者自訂的訊息從 SYNCSIGNAL_MAX + 1 開始
	
    private int value_;

    private CGSyncSignal(int value) {
        this.value_ = value;
    }

    public int GetValue() {
    	return value_;
    }
}
