package com.jinglei.game.server.common;

public class CGJPBonus {
	
	private static CGJPBonus  instance = null;
	
	public static synchronized  CGJPBonus getInstance() {
		if ( instance == null ) {
			instance = new CGJPBonus();
		}
		
		return instance;
	}
	
	public static int JP_1 = 10000;
	public static int JP_2 = 10000;
	public static int JP_3 = 10000;
	public static int JP_4 = 10000;
	
}
