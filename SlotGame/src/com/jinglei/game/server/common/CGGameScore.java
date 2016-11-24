package com.jinglei.game.server.common;


public class CGGameScore {

//	struct GAME_SCORE
//	{
//		Int		ID;			///< 遊戲代碼(HTTPSrv的代碼), 絕對值(RW)
//		Int		Score;		///< 相對於GameID的戰績, 絕對值(R), 相對值(W)
//		Int		Total;		///< 總遊戲次數 (每個遊戲分開算), 絕對值(R), 相對值(W)
//		Int		Win;		///< 總勝數 (每個遊戲分開算), 絕對值(R), 相對值(W)
//		Int		Loss;		///< 總敗數 (每個遊戲分開算), 絕對值(R), 相對值(W)
//		Int		Draw;		///< 平手(和局)次數 (每個遊戲分開算), 絕對值(R), 相對值(W)
//		Int		Level;		///< 目前段位 (每個遊戲分開算), 絕對值(RW)
//		Int     Fame;       ///< 玩家聲評( 0 - 10 ) 極佳 - 極壞, 絕對值(RW)
//		Int		Custom1;	///< 自定變數, 絕對值(R), 相對值(W)
//		Int		Custom2;    ///< 自定變數, 絕對值(R), 相對值(W)
//		Int		Custom3;    ///< 自定變數, 絕對值(R), 相對值(W)
//		Int		Custom4;    ///< 自定變數, 絕對值(R), 相對值(W)
//		Int		Custom5;    ///< 自定變數, 絕對值(R), 相對值(W)
//		Int		Custom6;    ///< 自定變數, 絕對值(R), 相對值(W)
//		Int     Custom7;    ///< 自定變數, 絕對值(RW)
//		Int     Custom8;    ///< 自定變數, 絕對值(RW)
//		Int     Custom9;    ///< 自定變數, 絕對值(RW)
//		Int     Custom10;   ///< 自定變數, 絕對值(RW)
//	};

	public CGGameScore() {
		
	}
	
	public int ID = 0;
	public int Score = 0;
	public int Total = 0;
	public int Win = 0;
	public int Loss = 0;
	public int Draw = 0;
	public int Level = 0;
	public int Fame = 0;
	public int Custom1 = 0;
	public int Custom2 = 0;
	public int Custom3 = 0;
	public int Custom4 = 0;
	public int Custom5 = 0;
	public int Custom6 = 0;
	public int Custom7 = 0;
	public int Custom8 = 0;
	public int Custom9 = 0;
	public int Custom10 = 0;
	
}
