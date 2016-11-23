package com.jinglei.game.manage;

/**
 * <pre>
 * 	Class Name  : 			CycleCostUnit
 * 	Description :           週期成本
 * 	Modification Information
 *
 * </pre>
 *
 * @author Bear Wu
 * @since 2016. 06. 21.
 * @version 
 *
 */
public class CycleCostUnit {

	private  static  long   cycle_begin = 0;
	private  static  long   cycle_ended = 0;	
	private  static  String cycle_name = "";
	
	public CycleCostUnit(String name) {
		CycleCostUnit.cycle_name  = name;
		CycleCostUnit.cycle_begin = System.currentTimeMillis();
	}
	
	public long CycleBegin() {
		CycleCostUnit.cycle_begin = System.currentTimeMillis();
		return CycleCostUnit.cycle_begin;
	}
	
	public long CycleEnded() {
		CycleCostUnit.cycle_ended = System.currentTimeMillis();
		
		return CycleCostUnit.cycle_ended - CycleCostUnit.cycle_begin;
	}
	
	public long getBegin() {
		return CycleCostUnit.cycle_begin;
	}
	
	public long getEnded() {
		return CycleCostUnit.cycle_ended;
	}
	
	public String getCycleName() {
		return CycleCostUnit.cycle_name;
	}
}
