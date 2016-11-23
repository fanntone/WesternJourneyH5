package com.jinglei.game.manage;

import java.util.concurrent.ConcurrentHashMap;

import com.jinglei.channel.NettyClientChannel;
import com.jinglei.game.SysLog;
import com.jinglei.game.attribute.impl.GClonePlayer;

import io.netty.util.internal.chmv8.ConcurrentHashMapV8;

/**
 * <pre>
 * 	Class Name  : 			ActorManage
 * 	Description :           玩家管理
 * 	Modification Information
 *
 * 
 *
 * </pre>
 *
 * @author Bear Wu
 * @since 2016. 11. 18.
 * @version 
 *
 */
public class ActorManage {	
	/*
	 *  ActorManager Instance
	 */
	private static ActorManage  instance = null;
	
	private ActorManage() {	
	}
	
	/*
	 *  取得 ActorManager Management Instance
	 */
	public static synchronized ActorManage getInstance()  {
        if (instance == null) {
        	instance = new ActorManage();
        }

        return instance;
    }	
	
	/*
	 *  取得  Manage Name
	 */
	public static String  getManageName() {
		return "ActorManage";
	}
	
	/*
	 *   依玩家  Member ID 為Key  Value -> 玩家資料結構 (GClonePlayer)
	 */
	private static ConcurrentHashMapV8<Integer,Object>   mapClonePlayer = new ConcurrentHashMapV8<Integer,Object>();
	
	public static void AddClonePlayer(Integer member_id,GClonePlayer clone) {
		if ( ActorManage.mapClonePlayer.containsKey(member_id)) {
			ActorManage.mapClonePlayer.remove(member_id);			
		}
		
		ActorManage.mapClonePlayer.put(member_id, clone);		
	}
	
	public static GClonePlayer GetClonePlayer(Integer member_id) {
		if ( ActorManage.mapClonePlayer.containsKey(member_id)) {
			return (GClonePlayer)ActorManage.mapClonePlayer.get(member_id);
		}
		
		return null;
	}
	
	public static GClonePlayer RemoveClonePlayer(Integer member_id) {
		if ( ActorManage.mapClonePlayer.containsKey(member_id)) {
			return (GClonePlayer)ActorManage.mapClonePlayer.remove(member_id);
		}
		
		return null;
	}
	
	/*
	 *   已連線玩家  玩家 帳號_密碼   為Key  Value -> Member id
	 *   
	 *   Key  = String.format("%s:%s", account_id,password);
	 */
	private static ConcurrentHashMapV8<String,Integer>   mapOnlinePlayer = new ConcurrentHashMapV8<String,Integer>();
	
	public static void AddOnlinePlayer(String key,Integer member) {
		if ( ActorManage.mapOnlinePlayer.containsKey(key)) {
			ActorManage.mapOnlinePlayer.remove(key);			
		}
		
		ActorManage.mapOnlinePlayer.put(key, member);		
	}
	
	public static Integer GetOnlinePlayer(String key) {
		if ( ActorManage.mapOnlinePlayer.containsKey(key)) {
			return ActorManage.mapOnlinePlayer.get(key);
		}
		
		return null;
	}
	
	public static Integer RemoveOnlinePlayer(String key) {
		if ( ActorManage.mapOnlinePlayer.containsKey(key)) {
			return ActorManage.mapOnlinePlayer.remove(key);
		}
		
		return null;
	}
	
	/*
	 *  依連線 Channel HashCode 為 Key   Value NettyClientChannel 
	 */
	private static ConcurrentHashMapV8<Integer,NettyClientChannel>   mapChannel = new ConcurrentHashMapV8<Integer,NettyClientChannel>();
	
	/*
	 *   增 加 某個Channel 到  ConcurrentHashMap 中
	 *   @param   Integer id  玩家編號
	 */
	public static synchronized boolean addChannel(NettyClientChannel  channel) {
		if ( channel != null ) {			
			if ( ActorManage.mapChannel.containsKey(channel.getHashCode())) {
				ActorManage.mapChannel.remove(channel.getHashCode());
			}
			
			ActorManage.mapChannel.put(channel.getHashCode(), channel);
			
			SysLog.PrintError(String.format("[Manage:%s]  addChannel Channel Hash Code:%d ...Success!!",ActorManage.getManageName(),channel.getHashCode()));
			return true;
		}
		
		return false;
	}
	
	/*
	 *    移除 某個連線 
	 * @param   int channelID  Channel Hash Code 唯一碼
	 * @return  GameServerChannel, 被移除的 GameServerChannel 物件
	 */
	public static synchronized NettyClientChannel removeChannel(int channelID) {		
		return  ActorManage.mapChannel.remove(channelID);	
	}
	
	/*
	 *    移除 某個連線
	 * @param channel NettyClientChannel 物件
	 * @return boolean, 移除成功 <b>true</b>, 否則就回傳 <b>false</b>.
	 */
	public static synchronized boolean RemoveChannel(NettyClientChannel channel) {
		if ( channel != null ) {
			if ( ActorManage.mapChannel.containsKey(channel.getHashCode())) {
				boolean rtn = ActorManage.mapChannel.remove(channel.getHashCode(),channel);
				return rtn;				
			}			
		}
		return false;
	}
	
	/*
	 *    取得  某個玩家 GameServerChannel 
	 * @param arg1 int channelID    	Channel Hash Code 唯一碼
	 * @param arg2 boolean isRemove     取出後是否移除
	 * @return  GameServerChannel,  GameServerChannel 物件
	 */
	
	public static NettyClientChannel getChannel(Integer channelID,boolean isRemove) {
		if ( isRemove ) {
			return ActorManage.mapChannel.remove(channelID);
		}
		
		 return ActorManage.mapChannel.get(channelID);
	}


}
