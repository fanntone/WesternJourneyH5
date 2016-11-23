package com.jinglei.packets.ctos;

import com.jinglei.server.logic.JSONBean;

public class CGSLGameReLogin implements JSONBean {
	
//	struct CGSLGameReLogin
//	{
//		Char			GameType;		        			// 遊戲型態
//		Char			SeatNo;								// 座位號
//		Int				nPoints;							// 目前玩家在大廳的點數
//		wchar_t			CardName[CARDNAME_LENGTH];			// 玩家名稱. CARDNAME_LENGTH * 2bytes
//		wchar_t			NickName[NICKNAME_LENGTH];			// 玩家暱稱  NICKNAME_LENGTH * 2bytes
//	};
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return new String("CGSLGameReLogin");
	}
	
	public CGSLGameReLogin() {
	}
	
	private int GameType_ = 0;
	private int SeatNo_ = 0;
	private int nPoints_ = 0;
	private String CardName_ = "";
	private String NickName_ = "";
	
	public int getGameType() {
		return this.GameType_;
	}
	
	public void setGameType(int game_type) {
		this.GameType_ = game_type;
	}
	
	public int getSeatNo() {
		return this.SeatNo_;
	}
	
	public void setSeatNo(int seat_no) {
		this.SeatNo_ = seat_no;
	}
	
	public int getnPoints() {
		return this.nPoints_;
	}
	
	public void setnPoints(int npoints) {
		this.nPoints_ = npoints;
	}
	
	public String getCardName() {
		return this.CardName_;
	}
	
	public void setCardName(String card_name) {
		this.CardName_ = card_name;
	}
	
	public String getNickName_() {
		return this.NickName_;
	}
	
	public void setNickName_(String nick_name) {
		this.NickName_ = nick_name;
	}
}
