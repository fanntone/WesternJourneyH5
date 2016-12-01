package com.jinglei.game.attribute.impl;


import com.jinglei.game.SysLog;
import com.jinglei.game.attribute.ActorKeys;
import com.jinglei.game.attribute.GPlayerSession;
import com.jinglei.channel.NettyClientChannel;
import io.netty.util.internal.chmv8.ConcurrentHashMapV8;
/*
 * 
 * public ConcurrentHashMap(int initialCapacity,
 *                        	float loadFactor,
 *                        	int concurrencyLevel)創建一個帶有指定初始容量、加載因子和並發級別的新的空映射。
 *
 *			參數：
 *				initialCapacity - 初始容量。該實現執行內部大小調整，以容納這些元素。
 *				loadFactor - 加載因子閾值，用來控制重新調整大小。在每bin 中的平均元素數大於此閾值時，可能要重新調整大小。
 *				concurrencyLevel - 當前更新線程的估計數。該實現將執行內部大小調整，以盡量容納這些線程。
 *			拋出：
 *				IllegalArgumentException - 如果初始容量為負，或者加載因子或concurrencyLevel 為非正。
 */

public class GClonePlayer implements GPlayerSession {	
	
	private final ConcurrentHashMapV8<String, Object> mapAttachment = new ConcurrentHashMapV8<String, Object>(32);	
	
	/*
	 * 	GClonePlayer Construct
	 * 	@param arg1   NettyClientChannel channel->玩家連線 Channel
	 */
	public GClonePlayer(NettyClientChannel channel) {
		setChannel(channel);	
		if ( channel.get(ActorKeys.MEMBER_ID) != null ) {
			setMemberID(channel.get(ActorKeys.MEMBER_ID));
		}	
	}
	
	public GClonePlayer(Integer sakuraid) {
		setMemberID(sakuraid);
	}
	
	/*
	 * 	GClonePlayer Construct
	 * 	@param arg1   NettyClientChannel channel->玩家連線 Channel
	 */
	public GClonePlayer(NettyClientChannel channel,Integer accountSID) {
		setChannel(channel);
		setMemberID(accountSID);
		setSessionID(channel.getHashCode());
	}	
	
	/*
	 * (non-Javadoc)
	 * @see com.jinglei.game.attribute.GPlayerSession#getMemberID()
	 */
	private volatile Integer m_viMemberID = 0;
	@Override
	public Integer getMemberID() {
		return this.m_viMemberID;
	}

	@Override
	public void setMemberID(Integer value) {
		this.m_viMemberID = value;		
	}

	
	/*
	 * (non-Javadoc)
	 * @see com.jinglei.game.attribute.GPlayerSession#getSessionID()
	 */
	private volatile Integer m_viSessionID = 0;
	@Override
	public Integer getSessionID() {
		return this.m_viSessionID;
	}

	@Override
	public void setSessionID(Integer value) {
		this.m_viSessionID = value;		
	}

	
	/*
	 * (non-Javadoc)  玩家連線 io
	 * @see com.jinglei.game.attribute.GPlayerSession#getChannel()
	 */
	private volatile NettyClientChannel m_objChannel = null;	
	@Override
	public NettyClientChannel getChannel() {
		return this.m_objChannel;
	}

	@Override
	public void setChannel(NettyClientChannel channel) {
		try {
			if ( channel != null ) {			
				this.m_objChannel = channel;				
			}			
		}
		catch (Exception e) {
			
		}
		finally	{
			SysLog.PrintDebug("[GClonePlayer] setChannel Run finally!!");			
		}
		
	}

	@Override
	public void Login() {
		try {
			
		}
		catch (Exception e) {
			
		}
		finally	{
			SysLog.PrintDebug("[GClonePlayer] Login Run finally!!");			
		}		
	}

	@Override
	public void Logout() {
		try {
			
		}
		catch (Exception e) {
			
		}
		finally	{
			SysLog.PrintDebug("[GClonePlayer] Logout Run finally!!");			
		}
		
	}

	/*
	 * (non-Javadoc)
	 * @see com.jinglei.game.attribute.GPlayerSession#Close()
	 */
	@Override
	public void Close() {		
		try {
			if ( this.m_objChannel != null ) {
				this.m_objChannel.close();
				this.m_objChannel = null;
			}			
		}
		catch (Exception e) {
			
		}
		finally	{
			SysLog.PrintDebug("[GClonePlayer] Close Run finally!!");			
		}		
	}

	
	/******************************************************************************
	 * 可以針對同一個 ClonePlayer 放入 Attachment.
	 * @param key_name String key 的名稱.
	 * @param value_obj 型別為 T 的 value 物件.
	 *****************************************************************************/
	
	@Override
	public <T> boolean put(String key_name, T value_obj) {
		if ( key_name == null || key_name.equals("") || value_obj == null ) {
			return false;
		}
		
		if (mapAttachment.containsKey(key_name) ) {
			mapAttachment.remove(key_name);
		}
		
		mapAttachment.put(key_name, value_obj);
		return true;
	}
	
	/******************************************************************************
	 * 可以針對同一個 ClonePlayer 放入 Attachment.
	 * @param key_name String key 的名稱.
	 * @param value_obj 型別為 T 的 value 物件.
	 *****************************************************************************/	
	@Override
	public <T> boolean Insert(String key_name, T value_obj) {
		if ( key_name == null || key_name.equals("") || value_obj == null ) {
			return false;
		}
		
		if (mapAttachment.containsKey(key_name) ) {
			mapAttachment.remove(key_name);
		}
		
		mapAttachment.put(key_name, value_obj);
		return true;
	}
	/******************************************************************************
	 * 更新在Attachment 中的int
	 * @param key_name String key 的名稱.
	 *****************************************************************************/
	public void updateInt(String key_name,int newValue){
		if ( this.mapAttachment.containsKey(key_name)) {
			int oldValue = (int) this.mapAttachment.get(key_name);
			this.mapAttachment.replace(key_name, oldValue, newValue);
		}
	}
	/******************************************************************************
	 * 取回放在 Attachment 中的東西, 取出之後, 內容物並不會消失!!
	 * @param key_name String key 的名稱.
	 * @return 型別為 T 的 value 物件. 如果沒有取到, 會傳回 null.
	 *****************************************************************************/
	@Override
	public <T> T get(String key_name) {
		if ( this.mapAttachment.containsKey(key_name)) {
			return this.get(key_name,false);
		}
		
		return null;
	}

	/******************************************************************************
	 * 取回放在 Attachment 中的東西, 取出之後, 內容物會被刪除!!
	 * @param key_name String key 的名稱.
	 * @return 型別為 T 的 value 物件. 如果沒有取到, 會傳回 null.
	 *****************************************************************************/
	@Override
	public <T> T remove(String key_name) {
		
		return this.get(key_name,true);
	}
	
	@SuppressWarnings("unchecked")
	private <T> T get(String key_name, boolean if_remove) 
	//private Object get(String key_name, boolean if_remove)
	{
		if (key_name==null || key_name.equals(""))
			return null;
		
		Object key = this.mapAttachment.get(key_name);
		if(key == null){
			return null;
		}
		
		if(if_remove){
			this.mapAttachment.remove(key_name);	
		}
		
		return (T) key;
	}
	
	/******************************************************************************
	 * 檢查 Attachment 中的 Key 值是否有 Value
	 * @param key_name String key 的名稱.
	 * @return boolean true/false
	 *****************************************************************************/		
	@Override
	public boolean ContainsKey(String key) {
		return this.mapAttachment.containsKey(key);
	}
	
	/******************************************************************************
	 * 檢查 Attachment 中的 Key 值是否有 Value 且  Value 物件是否與 T value_obj 相同
	 * @param key_name String key 的名稱.
	 * @return boolean true/false
	 *****************************************************************************/	
	@Override
	public <T> boolean ContainsObject(String key,T value_obj) {
		if (this.mapAttachment.containsKey(key)) {
			return this.mapAttachment.get(key).getClass().equals(value_obj);
		}
		
		return false;
	}
	
	/******************************************************************************
	 * 檢查 Attachment Key 所保存物件是否為 T value_obj
	 * @param arg 1 key_name String key 的名稱.
	 * @param arg 2 T value_obj  檢查物值
	 * @return 型別為 T 的 value 物件. 如果沒有取到, 會傳回 null.
	  *****************************************************************************/ 
	@Override
	public <T> T getContainsObject(String key,T value_obj) {
		if (this.mapAttachment.containsKey(key)) {
			Object rtn = this.mapAttachment.get(key);
			if  ( rtn.getClass().equals(value_obj)) {
				return this.get(key, false);
			}
		}
		
		return null;
	}	
}
