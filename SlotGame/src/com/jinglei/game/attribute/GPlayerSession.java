package com.jinglei.game.attribute;

import org.apache.poi.ss.formula.functions.T;

import com.jinglei.channel.NettyClientChannel;


/******************************************************************************
 * <p>
 * Title: GPlayerSession 的 interface
 * </p>
 *
 * <p>
 * Description:  instanceof
 * 				Java 的  instanceof 運算子是一個二元運算子，
 *				二元運作子接受兩個參數，通常是用來比較兩個參數間的關係，
 *				常見的二元運算子有 ==, > , < 等等
 *				那麼 instanceof 這個運算子是用來比較什麼關係呢？
 *				他的用法是這樣的：objectA instanceof ClassName，
 *				這是要測試某一物件 objectA 是否為某類別 (class)或其子類別 (subclass) 實例 (instance)，
 *				或是 objectA 是不是某介面 (interface) 的實作。
 *				當 objectA 屬於該 class (或其衍生類別) 的 instance 就會回傳 true；否則傳回 false。
 *				所以 instanceof 可以被用在繼承的關係中，
 *				 需特別注意的是，比較時物件與類別間要有繼承關係，否則會有compile error如：
 *				"myInstanceof.java": Error #: 365 : cannot compare java.lang.Long with java.lang.String
 *
 *				另外要說明的是，我們知道在 Java 中所有的 class 都是繼承 Object 這個 class，
 *				所以理論上任意的 objectA instanceof Object 都應該回傳 true，
 *				這是錯的！當 objectA 指向 null 時這個條件判斷會回傳 false 喔！千萬注意！
 *				另外 Java 中還有基本型別如 int, byte, boolean 等，
 *				這些基本型別沒辦法使用 instanceof 這個運算子，
 *				必須是 Integer, Byte, Boolean 這些物件化的才可以使用喔！
 *
 *				除了任意物件都會繼承 Object 外，任何陣列也都繼承Object，
 *				所以所有的物件陣列都將同時繼承 Object 和 Object[]。
 *				基本型別的陣列同樣會繼承Object，
 *				但因為基本型別不是物件，所以基本型別陣列不會繼承 Object[]。
 *  
 * </p>
 *
 * <p>
 * Copyright: Copyright (c) 2015
 * </p>
 * 
 * @since 
 * @author  bear Wu
 * @version 
 *****************************************************************************/


public interface GPlayerSession {	
	
	/////////////////////////////////////////////////	
	/*
	 * 取玩家 DB ID
	 */
	public abstract Integer getMemberID();
	
	/*
	 * 設玩家 DB ID
	 */	
	public abstract void   setMemberID(Integer value);	
	
	/*
	 * 取 Session ID
	 */
	public abstract Integer getSessionID();
	
	/*
	 * 設玩家 Session ID
	 */	
	public abstract void   setSessionID(Integer value);
	
	/*
	 *  取得 Channel
	 */
	public abstract NettyClientChannel getChannel();
	
	/*
	 * 設定 Channel
	 */
	public abstract void setChannel(NettyClientChannel channel);
	
	
	/*
	 *   玩家登入
	 */
	public abstract void Login();
	
	/*
	 *  玩家登出
	 */
	public abstract void Logout();
	
	/*
	 * 玩家 斷線
	 */
	public abstract void Close();
	
	/******************************************************************************
	 * 可以針對同一個 ClonePlayer 放入 Attachment.
	 * @param key_name String key 的名稱.
	 * @param value_obj 型別為 T 的 value 物件.
	 *****************************************************************************/
	@SuppressWarnings("hiding")
	public abstract <T>  boolean put(String key_name,T value_obj);
	
	/******************************************************************************
	 * 可以針對同一個 ClonePlayer 放入 Attachment.
	 * @param key_name String key 的名稱.
	 * @param value_obj 型別為 T 的 value 物件.
	 *****************************************************************************/
	@SuppressWarnings("hiding")
	public abstract <T>  boolean Insert(String key_name,T value_obj);
	
	/******************************************************************************
	 * 取回放在 Attachment 中的東西, 取出之後, 內容物並不會消失!!
	 * @param key_name String key 的名稱.
	 * @return 型別為 T 的 value 物件. 如果沒有取到, 會傳回 null.
	 *****************************************************************************/
	@SuppressWarnings("hiding")
	public abstract <T> T get(String key_name);
	
	/******************************************************************************
	 * 取回放在 Attachment 中的東西, 取出之後, 內容物會被刪除!!
	 * @param key_name String key 的名稱.
	 * @return 型別為 T 的 value 物件. 如果沒有取到, 會傳回 null.
	 *****************************************************************************/
	@SuppressWarnings("hiding")
	public <T> T remove(String key_name);	
	
	/******************************************************************************
	 * 檢查 Attachment 中的 Key 值是否有 Value
	 * @param key_name String key 的名稱.
	 * @return boolean true/false
	 *****************************************************************************/	
	public abstract boolean ContainsKey(String key);
	
	/******************************************************************************
	 * 檢查 Attachment 中的 Key 值是否有 Value 且  Value 物件是否與 T value_obj 相同
	 * @param key_name String key 的名稱.
	 * @return boolean true/false
	 *****************************************************************************/		
	@SuppressWarnings("hiding")
	public abstract <T> boolean ContainsObject(String key,T value_obj);
	
	/******************************************************************************
	 * 檢查 Attachment Key 所保存物件是否為 T value_obj
	 * @param arg 1 key_name String key 的名稱.
	 * @param arg 2 T value_obj  檢查物值
	 * @return 型別為 T 的 value 物件. 如果沒有取到, 會傳回 null.
	  *****************************************************************************/    
	 @SuppressWarnings("hiding")
	public abstract <T> T getContainsObject(String key,T value_obj);
}
