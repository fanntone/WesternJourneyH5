package com.jinglei.packets.stoc;

import com.jinglei.server.logic.JSONBean;

public class TestTable  implements JSONBean {

	@Override
	public String getName() {
		//return new String(this.getClass().getName());
		return new String("TestTable");
	}
	
	public TestTable() {
		// TODO Auto-generated constructor stub
	}
	
	public Integer BetMin = 20; 
	public void setBetMin(Integer min) {
		this.BetMin = min;
	}
	public Integer getBetMin() {
		return this.BetMin;
	}
	
	public Integer BetMax = 6250; 
	
	public Integer getBetMax() {
		return this.BetMax;
	}
	
	public void setBetMax(Integer max) {
		this.BetMax = max;
	}
	
	public TestTable(Integer min,Integer max)
	{
		this.BetMin = min;
		this.BetMax = max;
	}

}
