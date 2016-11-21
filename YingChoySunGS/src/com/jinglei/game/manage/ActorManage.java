package com.jinglei.game.manage;

import java.util.concurrent.ConcurrentHashMap;

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

}
