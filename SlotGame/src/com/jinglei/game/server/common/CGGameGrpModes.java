package com.jinglei.game.server.common;

public enum CGGameGrpModes {
	GAME_GRP_MODE_AUTO_LV1(0),
	GAME_GRP_MODE_AUTO_LV2(1),
	GAME_GRP_MODE_AUTO_LV3(2),
	GAME_GRP_MODE_AUTO_LV4(3),
	GAME_GRP_MODE_CUSTOM(3),
	GAME_GRP_MODE_MAX(4),
	GAME_GRP_MODE_AUTO_NUM(5);
	
    private int value_;

    private CGGameGrpModes(int value) {
        this.value_ = value;
    }

    public int GetValue() {
    	return value_;
    }
}
