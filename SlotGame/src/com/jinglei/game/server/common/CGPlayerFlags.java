package com.jinglei.game.server.common;

public enum CGPlayerFlags {
    PL_FLAG_STOP_TALK(0X00000001),				///< 禁止大廳對話
    PL_FLAG_STOP_PLAY_GAME(0X00000002),			///< 禁止玩遊戲
    PL_FLAG_KICK_OUT(0X00000004),				///< 強制關閉此客端連線(LB, GAME)
    PL_FLAG_ILLEGAL_RANGE_MSG(0X00000008),		///< 訊息範圍不合法
    PL_FLAG_ILLEGAL_PARAM_MSG(0X00000010),		///< 訊息參數不合法
    PL_FLAG_ILLEGAL_FLOW_MSG(0X00000020),		///< 訊息流程不合法
    PL_FLAG_ILLEGAL_FATAL_MSG(0X00000040),		///< 訊息CRC驗証不合法, 不應存在的訊息
    PL_FLAG_DONKEY_TYPE(0X00004000),			///< Donkey
    PL_FLAG_GM_TYPE(0X00008000),				///< GM
    
    ;
    private int value;
    
    private CGPlayerFlags(int value) {
    	this.value = value;
    }
    
    public int getValue() {
    	return this.value;
    }
    
}
