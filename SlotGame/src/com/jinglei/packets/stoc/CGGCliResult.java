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
//		int  BetResult_;					
//		int  SampleSlotStopList_[6];	    
//		int  BounsSlotStopList_;	    	
//		int  BossSlotStopList_[2];	    	
//		int  OpenStyle_;					//開獎模式: (
 
//		int	OpenStyleWinResult_;			//
//		int SampleSlotWinPoints_;	    	
//		int BonusSlotPoints_;				
//		int PlayerTotalWinPoints_;   		
//		int PlayerCurrentPoints_;			
//		int iGetJPBoint;	    			
//		int GetJPBoints_;		    		
//		int JPBonus_;						
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
		
	//0: 押注失敗  1: 押注成功
	public int BetResult = 0;
	//轉動燈號停在哪一格 (0~26)1:南天門 14:水濂洞
	public int[] SampleSlotStopList = new int[6];
	//莊閒和燈號停在哪一格 (0~2)
	public int BounsSlotStop = 0;
	//頭目燈 (0~3) 0:白骨精 1:鐵扇公主 2:海龍王 3:二郎神
	public int[] BossSlotStopList = new int[2];
	//開獎模式:
	// 0:一般		 1:七十二變 		 2:封神 		 	 3:二連
	// 4:三連		 5:仙女散花     	 	 6:四連 			 7:縱橫四海
	// 8:四大天王-紅 	 9:四大天王-綠 		10:四大天王-黃  	11:角色全中-孫
	//12:角色全中-沙	13:角色全中-牛		14:角色全中-紅  	15:顏色全中-紅
	//16:顏色全中-綠	17:顏色全中-黃 		18:四海歸一		19:JP彩金
	public int OpenStyle = 0;
	//開獎模式輸贏: (0:輸 1:贏)
	public int OpenStyleWinResult = 0;
	//贏得金額
	public int SampleSlotWinPoints = 0;
	//莊閒和3區的嬴點(0:無.大於0才有嬴) 
	public int BonusSlotPoints = 0;
	//總贏得金額 (0:輸了 大於0:贏了 含莊閒和嬴的錢)
	public int PlayerTotalWinPoints = 0;
	//現有金額
	public int PlayerCurrentPoints = 0;
	//贏得JP彩金的金額
	public int GetJPBoints = 0;
	//JP彩金的金額
	public int JPBonus = 0;
	
}
