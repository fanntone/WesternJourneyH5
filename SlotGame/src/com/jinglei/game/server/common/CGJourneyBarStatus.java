package com.jinglei.game.server.common;

public enum CGJourneyBarStatus {
    JOURNEYBAR_STATUS_WAIT_PLAY(0),		//等待入局
    JOURNEYBAR_STATUS_BET_TIME(1),		//開始下注
    JOURNEYBAR_STATUS_RESULT(2),		//結算成績
    JOURNEYBAR_STATUS_MAX(3);
    
    private int value_;

    private CGJourneyBarStatus(int value) {
        this.value_ = value;
    }

    public int GetValue() {
    	return value_;
    }
}
