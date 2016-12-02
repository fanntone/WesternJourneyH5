package com.jinglei.game.probability;

import com.jinglei.hibernate.read.account_data;

/**
 * <pre>
 * 	Class Name  : 			GBaseProbability
 * 	Description :           保留  機率相關資料
 * 							之後  初始資料會存放在  Redis 上
 * 							
 *  Request 	:			
 *  Responses	:			
 * 	Modification Information
 * 			Receive Packet:
 *
 *			Send Packet:
 * 
 *
 * </pre>
 *
 * @author Bear Wu
 * @since   2016. 12. 1
 * @version 
 *
 */
public class GBaseProbability {
	
	/*
	 *   流程狀態
	 */
		public volatile Integer  ProcessStatus = 0;
		
		public Integer getProcessStatus() {
			return this.ProcessStatus;
		}
		
		public void  setProcessStatus(Integer status) {
			this.ProcessStatus = status;
		}
		
	/*
	 *  局號
	 */
		public volatile String  SerialNumber = null;
		
		public String getSerialNumber() {
			return this.SerialNumber;
		}
		
		public void  setSerialNumber(String sn) {
			this.SerialNumber = sn;
		}
		
		public String CreateSerialNumber() {
			return null;
		}
		
	
	/*
	 *   機率增減影響值 (黑白名單...)
	 */
		public volatile Integer  ProDeviation = 0;
		
		public Integer getDeviation() {
			return this.ProDeviation;
		}
		
		public void setDeviation(Integer deviation) {
			this.ProDeviation = deviation;
		}
		
	/*
	 *   玩家總壓注額
	 */
		public volatile Integer  TotalBet = 0;
		
		public Integer getTotalBet() {
			return this.TotalBet;
		}
		
		public void  setTotatlBet(Integer value) {
			this.TotalBet = value;
		}
		
	/*
	 *   玩家總贏金
	 */
		public volatile Integer  TotalWin = 0;
		
		public Integer getTotalWin() {
			return this.TotalWin;
		}
		
		public void setTotalWin(Integer value) {
			this.TotalWin = value;
		}
		
	/*
	 *   玩家總輪轉數
	 */
		public volatile Integer  TotalSpinTimes = 0;
			
		public Integer getTotalSpinTimes() {
			return this.TotalSpinTimes;
		}
			
		public void setTotalSpinTimes(Integer times) {
			this.TotalSpinTimes = times;
		}	
		
	/*
	 *   玩家總贏 輪轉 數
	 */
		public volatile Integer  TotalSpinWinTimes = 0;
				
		public Integer getTotalSpinWinTimes() {
			return this.TotalSpinWinTimes;
		}
				
		public void setTotalSpinWinTimes(Integer times) {
			this.TotalSpinWinTimes = times;
		}		
		
	/*
	 *   比倍總壓注額
	 */
		public volatile Integer DoubleUpTotalBet = 0;
		
		public Integer getDoubleUpTotalBet() {
			return this.DoubleUpTotalBet;
		}
		
		public void setDoubleUpTotalBet( Integer value) {
			this.DoubleUpTotalBet = value;
		}
		
	/*
	 *   比倍總贏 金
	 */
		public volatile Integer DoubleUpTotalWin = 0;
			
		public Integer getDoubleUpTotalWin() {
			return this.DoubleUpTotalWin;
		}
			
		public void setDoubleUpTotalWin( Integer value) {
			this.DoubleUpTotalWin = value;
		}	
		
	/*
	 *   比倍 總次數
	 */
		public volatile Integer DoubleUpTotalTimes = 0;
				
		public Integer getDoubleUpTotalTimes() {
			return this.DoubleUpTotalWin;
		}
				
		public void setDoubleUpTotalTimes( Integer value) {
			this.DoubleUpTotalTimes = value;
		}	
		
	/*
	 *   比倍 總 贏次數
	 */
		public volatile Integer DoubleUpWinTimes = 0;
					
		public Integer getDoubleUpWinTimes() {
			return this.DoubleUpWinTimes;
		}
					
		public void setDoubleUpWinTimes( Integer value) {
			this.DoubleUpWinTimes = value;
		}
		
	/*
	 *   Free Game 次數
	 */
		public volatile Integer FreeGameTotalTimes = 0;
						
		public Integer getFreeGameTotalTimes() {
			return this.FreeGameTotalTimes;
		}
						
		public void setFreeGameTotalTimes( Integer times) {
			this.FreeGameTotalTimes = times;
		}
		
	/*
	 *   連續未得獎次  得獎後歸零
	 */
		public volatile Integer ContinuousLoseTimes = 0;
							
		public Integer getContinuousLoseTimes() {
			return this.ContinuousLoseTimes;
		}
							
		public void setContinuousLoseTimes( Integer times) {
			this.ContinuousLoseTimes = times;
		}
		
		public Integer IncContinuousLoseTimes() {
			++this.ContinuousLoseTimes;
			return this.ContinuousLoseTimes;			
		}
		
		public void clearContinuousLoseTimes() {
			this.ContinuousLoseTimes  = 0;
		}		
		
	/*
	 * 特殊  項目
	 */
		/*
		 * 開出  Free Game 免費次數
		 */
			public volatile Integer SpecialFreeTimes = 0;
			
			public Integer getSpecialFreeTimes() {
				return this.SpecialFreeTimes;
			}
						
			public void setSpecialFreeTimes( Integer times) {
				this.SpecialFreeTimes = times;
			}			
		

			/*
			 * 開出  Free Game 免費剩於多少
			 */
				public volatile Integer SpecialFreeRemainder = 0;
				
				public Integer getSpecialFreeRemainder() {
					return this.SpecialFreeRemainder;
				}
							
				public void setSpecialFreeRemainder( Integer times) {
					this.SpecialFreeRemainder = times;
				}
				
				public Boolean nextFreeGame() {
					if ( this.SpecialFreeRemainder >= 0 ) {
						this.SpecialFreeRemainder -= 1;
						return true;
					}
					
					return false;					
				}
				
				public Boolean  freeGameIsEnd() {
					if ( this.SpecialFreeRemainder < 1 ) {
						this.SpecialFreeTimes = 0;
						this.SpecialFreeRemainder = 0;
						/*
						 * 切換狀態
						 */
						return true;
					}
					
					return false;
				}
				
			/*
			 * 開出 特殊總累計
			 */
				public volatile Integer SpecialTotalWin = 0;
					
				public Integer getSpecialTotalWin() {
					return this.SpecialTotalWin;
				}
								
				public void setSpecialTotalWin( Integer value) {
					this.SpecialTotalWin = value;
				}
				
			/*
			 * 特殊總贏倍
			 */
				public volatile Integer SpecialWinBet = 0;
						
				public Integer getSpecialWinBet() {
					return this.SpecialWinBet;
				}
									
				public void setSpecialWinBet( Integer value) {
					this.SpecialWinBet = value;
				}
				
			/*
			 * 進入 特殊獎項 當時 每線壓金
			 */
				public volatile Integer SpecialLineBet = 0;
							
				public Integer getSpecialLineBet() {
					return this.SpecialLineBet;
				}
										
				public void setSpecialLineBet( Integer value) {
					this.SpecialLineBet = value;
				}
			/*
			 * Double Up	
			 */
			/*
			 * 進入 特殊獎項 時進入的點數
			 */
				public volatile Integer SpecialEnterPoints = 0;
									
				public Integer getSpecialEnterPoints() {
					return this.SpecialEnterPoints;
				}
												
				public void setSpecialEnterPoints( Integer value) {
					this.SpecialEnterPoints = value;
				}
			
			/*
			 * 進入 特殊獎項 Double 連續過關次數
			 */
				public volatile Integer SpecialClearanceTimes = 0;
										
				public Integer getSpecialClearanceTimes() {
					return this.SpecialClearanceTimes;
				}
													
				public void setSpecialClearanceTimes( Integer value) {
					this.SpecialClearanceTimes = value;
				}
				
				public Integer IncSpecialClearanceTimes() {
					++this.SpecialClearanceTimes;
					return this.SpecialClearanceTimes;
				}
				
			/*
			 * 進入 特殊獎項特殊獎金
			 */
				public volatile Integer SpecialPrizeValue = 0;
								
				public Integer getSpecialPrizeValue() {
					return this.SpecialPrizeValue;
				}
											
				public void setSpecialPrizeValue( Integer value) {
					this.SpecialPrizeValue = value;
				}

	
	/*
	 * 玩家基本資料
	 */
		public volatile account_data   AccountData = null;
		
		public account_data  getAccountData() {
			return this.AccountData;
		}
		
		public void setAccountData(account_data   acc_data) {
			this.AccountData = acc_data;
		}
	
	/*
	 * 		GBaseProbability construct
	 */	
	public GBaseProbability() {
		
	}

}
