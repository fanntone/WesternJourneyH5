package com.jinglei.packets.stoc;

import com.jinglei.server.logic.JSONBean;

public class CGGCliResult implements JSONBean {

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return new String("CGGCliResult");
	}
	
	public CGGCliResult() {
		
	}

//	struct CGGCliResult
//	{
//		int  iState;						//0: 押注失敗  1: 押注成功
//		int  iTurnStop[6];	    			//轉動燈號停在哪一格 (0~26)1:南天門 14:水濂洞
//		int  iBankPlayerTieStop;	    	//莊閒和燈號停在哪一格 (0~2)
//		int  iBossTurnStop[2];	    		//頭目燈 (0~3) 0:白骨精 1:鐵扇公主 2:海龍王 3:二郎神
//		int  iOpenStyle;					//開獎模式: (
//											// 0:一般		 1:七十二變 		 2:封神 		 	 3:二連
//											// 4:三連		 5:仙女散花     	 	 6:四連 			 7:縱橫四海
//											// 8:四大天王-紅 	 9:四大天王-綠 		10:四大天王-黃  	11:角色全中-孫
//											//12:角色全中-沙	13:角色全中-牛		14:角色全中-紅  	15:顏色全中-紅
//											//16:顏色全中-綠	17:顏色全中-黃 		18:四海歸一		19:JP彩金) 
//		int	 iOpenStyleWinlose;				//開獎模式輸贏: (0:輸 1:贏)
//		DInt iWinPoint;	    				//贏得金額
//		DInt iBankPlayerTiePoint;			//莊閒和3區的嬴點(0:無.大於0才有嬴) 
//		DInt iPlayerWinPoint;   			//總贏得金額 (0:輸了 大於0:贏了 含莊閒和嬴的錢)
//		DInt iUserPoint;					//現有金額
//		DInt iGetJPBoint;	    			//贏得JP彩金的金額
//		DInt iJPBonus;		    			//遊戲彩金,累積彩金金額,顯示用 
//		DInt iPlatformJpBouns;				//平台彩金,累積彩金金額,顯示用
//		int iAwardKind1;					//指定開獎種類0~10(依遊戲)
//		int iAwardKind2;					//指定彩金種類 0:無,1:活動彩金,2:該遊戲彩金.3:總平台彩金.
//	};
	
//	獎項名稱	獎項說明												可能出現關卡	獎項縮寫for英文版紀錄
//	七十二變	跑燈停止後，送出最高賠率的1燈，共二燈						白骨精		72
//	封神		跑燈停止後，隨機送出與跑燈人物相同的1燈，共2燈								AP
//	二連		跑燈停止後，再送該燈的下1燈，共2燈										DB
//	三連		跑燈停止後，再送該燈的下2燈，共3燈										TP
//	仙女散花	跑燈結束後，再隨機送1-3燈												SF
//	四連		跑燈停止後，再送該燈的下3燈，共4燈							鐵扇公主		QD
//	縱橫四海	上下左右各中1燈，共4燈												SO
//	四大天王	隨機選一個顏色，送該顏色的悟空、悟淨、紅孩兒及牛魔王各1燈，最多5燈				4K
//	角色全中	(例：悟空全中)共6燈													個別角色名
//	顏色全中	(例：紅燈全中)共8燈													個別顏色名
//	彩金		不計跑燈狀況，戰勝二郎神即可獲得JP2(意即跑燈狀況額外計算)		二郎神		JP
//	四海歸一	所有燈全中												海龍王		RO
		
	public int WinResult_ = 0;
	public int[] SampleSlotStopList_ = new int[6];
	public int BounsSlotStopList_ = 0;
	public int[] BossSlotStopList_ = new int[2];
	public int OpenStyle_ = 0;
	public int OpenStyleWinResult_ = 0;
	public int SampleSlotWinPoints_ = 0;
	public int BounsSlotPoints_ = 0;
	public int PlayerTotalWinPoints_ = 0;
	public int PlayerCurrentPoints_ = 0;
	public int GetJPBoints_ = 0;
	public int JPBonus_ = 0;
	
}
