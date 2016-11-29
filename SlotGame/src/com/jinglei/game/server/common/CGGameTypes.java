package com.jinglei.game.server.common;


public enum CGGameTypes {
	GAME_TYPE_LOBBY(0),       									///< 大廳
	GAME_TYPE_ALL(1),											///< 指所有遊戲
	GAME_TYPE_HOLDEM(2),										///< 德州撲克
	GAME_TYPE_BLACKJACK(3),      								///< 二十一點
	GAME_TYPE_BACARRA(4),		    							///< 百家樂
	GAME_TYPE_DONDEN(5),					    				///< 滿貫大亨
	GAME_TYPE_SERVEN_PK(6),				    					///< 7PK
	GAME_TYPE_SICBO(7),											///< 多人骰寶
	GAME_TYPE_BINGO_PLANET(8),									///< 賓果行星
	GAME_TYPE_BEAST_BAR(9),										///< 三個願望
	GAME_TYPE_BIG2(10),											///< 大老二
	GAME_TYPE_LANDOWNER(11),									///< 鬥地主
	GAME_TYPE_TAKE_SEVEN(12),									///< 排七
	GAME_TYPE_THIRTEEN(13),										///< 十三支
	GAME_TYPE_TW4MJ16(14),										///< 台灣四人十六張麻將
	GAME_TYPE_TW2MJ16(15),										///< 台灣二人十六張麻將
	GAME_TYPE_FRUIT_BAR(16),									///< 水果盤
	GAME_TYPE_SMARIO(17),				        				///< 小瑪莉
	GAME_TYPE_FIVE_PK(18),					    				///< 5PK
	GAME_TYPE_BRAG(19),											///< 吹牛
	GAME_TYPE_ZSERVEN_PK(20),									///< ZSevenPoker
	GAME_TYPE_GOLDEN_FLOWER(21),								///< ZSevenPoker
	GAME_TYPE_ROULETTE(22),										///< 輪盤
	GAME_TYPE_FISHSHRIMPCRAB(23),								///< ZSevenPoker
	GAME_TYPE_DRAGONTIGER(24),									///< 龍虎_23
	GAME_TYPE_FIVEDRAGONBAR(25),                				///< 五龍_24
	GAME_TYPE_HULK(26),			                				///< 無敵浩克25
	GAME_TYPE_FOOTBALL_GIRL(27),                				///< 足球女郎26
	GAME_TYPE_SINGLEBACARRA(28),                				///< 單人百家27
	GAME_TYPE_MSICBO(29),                       				///< 單人骰寶28
	GAME_TYPE_MROULETTE(30),	                				///< 單人輪盤29
	GAME_TYPE_MONKEYRACE(31),	                				///< 猴子爬樹30
	GAME_TYPE_HIGHWAYKINGS(32),	                				///< 高速公路王31
	GAME_TYPE_DOLPHINCASH(33),                  				///< 海豚32
	GAME_TYPE_BENZBAR(34),										///< 奔馳33
	GAME_TYPE_NASINGLEBACARRA(35),              				///< 國際百家34(國際版)
	GAME_TYPE_NAMSICBO(36),                     				///< 國際骰寶35(國際版) 
	GAME_TYPE_NAMROULETTE(37),                  				///< 國際輪盤36(國際版)
	GAME_TYPE_FISHMACHINE(38),	                				///< 捕魚機37
	GAME_TYPE_LUCKY88(39),										///< Lucky88 38
	GAME_TYPE_HORSERACE(40),	                				///< 賽馬39
	GAME_TYPE_CHOYSUNDOA(41),	                				///< 財神到40
	GAME_TYPE_BRUCELEE(42),										///< 李小龍41
	GAME_TYPE_LEOPARD(43),										///< 金錢豹42
	GAME_TYPE_FULUSHOUXI(44),									///< 福祿壽喜43
	GAME_TYPE_FIFTYDRAGONS(45),									///< 五十龍44
	GAME_TYPE_ZAOCAIJINBAO(46),									///< 招財進寶45
	GAME_TYPE_JOURNEYBAR(47),									///< 西遊爭霸46
	GAME_TYPE_HOLYBEASTWAR(48),									///< 聖獸單挑47
	GAME_TYPE_ANIMALPLANET(49),	                				///< 動物星球48
	GAME_TYPE_GREYHOUNDRACING(50),								///< 3D賽狗49
	GAME_TYPE_YINGCHOYSUN(51),									///< 迎財神50
	GAME_TYPE_FISHONLINE(52),									///< 多人捕魚51
	GAME_TYPE_JOURNEYBAR_H5(53),									///< 西遊爭霸(H5)53
	GAME_TYPE_MAX(99);
	
    private int value_;

    private CGGameTypes(int value) {
        this.value_ = value;
    }

    public int GetValue() {
    	return value_;
    }
}
