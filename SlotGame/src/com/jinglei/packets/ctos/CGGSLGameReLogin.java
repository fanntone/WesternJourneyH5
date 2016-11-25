package com.jinglei.packets.ctos;

import com.jinglei.server.logic.JSONBean;

public class CGGSLGameReLogin implements JSONBean {
	
//	struct CGSLGameReLogin
//	{
//		Char			GameType;		        			// 遊戲型態
//		Char			SeatNo;								// 座位號
//		Int				nPoints;							// 目前玩家在大廳的點數
//		wchar_t			CardName[CARDNAME_LENGTH];			// 玩家名稱 CARDNAME_LENGTH * 2bytes
//		wchar_t			NickName[NICKNAME_LENGTH];			// 玩家暱稱  NICKNAME_LENGTH * 2bytes
//	};
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return new String("CGGSLGameReLogin");
	}
	
	public CGGSLGameReLogin(int GameTyep,
							int SeatNo,
							int nPoints,
							String CardName,
							String NickName) {
		GameType_ = GameTyep;
		SeatNo_ = SeatNo;
		nPoints_ = nPoints;
		CardName_ = CardName;
		NickName_ = NickName;
	}
	
	public int GameType_ = 0;
	public int SeatNo_ = 0;
	public int nPoints_ = 0;
	public String CardName_ = "";
	public String NickName_ = "";
	
}
