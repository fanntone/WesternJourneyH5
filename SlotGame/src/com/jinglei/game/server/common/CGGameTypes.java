package com.jinglei.game.server.common;


public enum CGGameTypes {
	GAME_TYPE_LOBBY(0),       									///< 大廳
	GAME_TYPE_ALL(1),											///< 指所有遊戲
	GAME_TYPE_JOURNEYBAR_H5(3002),								///< 西遊爭霸(H5)
	GAME_TYPE_MAX(9999);
	
    private int value_;

    private CGGameTypes(int value) {
        this.value_ = value;
    }

    public int GetValue() {
    	return value_;
    }
}
