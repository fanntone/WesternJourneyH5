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
		
	//0: 押注失敗  1: 押注成功
	public int BetResult = 0;
	//普通區燈號停在哪一格 (0~26) 1:南天門 14:水濂洞
	public int[] SampleSlotStopList = new int[6];
	//人神鬼燈號停在哪一格 (0~2)
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
	//人神鬼3區的嬴點(0:無.大於0才有嬴) 
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
