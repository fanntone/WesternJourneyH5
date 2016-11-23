package com.jinglei.packets.ctos;

import com.jinglei.server.logic.JSONBean;

public class FannTest implements JSONBean {

	public FannTest() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return new String("FannTest");
	}
	
	public  Integer   BetMax = 0;
	
	public Integer getBetMax() {
		return BetMax;
	}
	
	public void    setBetBetMax(Integer max) {
		this.BetMax = max;
	}
	
	public Integer   BetMin = 0;
	
	public Integer getBetMin() {
		return BetMin;
	}
	
	public void    setBetBetMin(Integer min) {
		this.BetMin = min;
	}

	public FannTest(Integer max, Integer min) {
		this.BetMax = max;
		this.BetMin = min;
	}
	
}
