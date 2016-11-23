package com.jinglei.game;

import com.jinglei.game.attribute.ActorKeys;
import com.jinglei.game.attribute.impl.GClonePlayer;

//import com.jinglei.game.attribute.impl.GClonePlayer;

import com.jinglei.channel.NettyClientChannel;
import com.jinglei.game.manage.ActorManage;
import com.jinglei.game.manage.UtilTimeManage;

//import com.jinglei.game.service.Service;
//import com.jinglei.game.service.ServiceKeys;
//import com.jinglei.game.synchronize.SynchronizeExecuteEnum;
//import com.jinglei.game.synchronize.SynchronizeManage;
import com.jinglei.server.event.EventListener;

/*
 * 有 Channel 連入成功 
 */
class ChannelRegistered implements EventListener
{
	@Override
	public void notify(NettyClientChannel channel)
	{ 
		try	{
			SysLog.PrintError(String.format("[ChannelRegistered] Channel Hash Code:%d ...Registered!!",channel.getHashCode()));
			channel.ClearKeyMap();			
			ActorManage.addChannel(channel);
		}
		catch(Exception e)	{
			e.printStackTrace();
		}
	}	
}

/*
 * 有Channel 斷了  連線斷開
 */
class ChannelInactive implements EventListener
{
	@Override
	public void notify(NettyClientChannel channel)
	{ 
		try {
			SysLog.PrintDebug(String.format("[ChannelInactive] Channel Hash Code:%d ...Inactive!!",channel.getHashCode()));
			int[] check_code = { 0 };
			int iNactivePlayerID = 0;
			int  room_id = 0;
			if ( channel != null ) {	
				SysLog.PrintDebug("[EventListener.java] Channel Inactive - ChannelInactive");
				GClonePlayer player = channel.get(ActorKeys.CLONE_PLAYER);				
				if ( player != null ) {
//					if ( player.ContainsKey(ActorKeys.ROOM_ID)) {
//						room_id = player.get(ActorKeys.ROOM_ID);
//						
//						SysLog.PrintDebug("[EventListener] Player:"+player.getPlayerID()+" ,Room_id:"+room_id);
//					};					
					
					iNactivePlayerID = player.getMemberID();
					check_code[0] = 0;
					long logoutDate = UtilTimeManage.getCurrentTimeToNumber();				
				}				

				channel.close();
			}		
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}	
}

/*
 * 有Channel 資料讀取成功
 */
class ChannelReadComplete implements EventListener
{
	@Override
	public void notify(NettyClientChannel channel)
	{ 
		try {
			SysLog.PrintError(String.format("[ChannelReadComplete] Channel Hash Code:%d ...ReadComplete!!",channel.getHashCode()));
			if ( channel.ContainsKey(ActorKeys.CLONE_PLAYER)) {
				GClonePlayer  player = channel.get(ActorKeys.CLONE_PLAYER);
				if ( player != null ) {
					if (player.ContainsKey(ActorKeys.USER_CHANNEL)) {				
//						NettyClientChannel pChannel = ActorManage.getChannelByUserID(player.getPlayerID());
//						if ( pChannel != null ) {
//							//比較二channel 是否相同
//							//if (channel.equals(pChannel) ) {
//							if ( pChannel.getHashCode() == channel.getHashCode()) {
//								return;
//							}							
//						}
					}

					SysLog.PrintInfo("[EventListener.java]  ChannelReadComplete Update Channel Player ID:"+player.getMemberID()+" ,Channel HashCode:"+channel.getHashCode());
					player.remove(ActorKeys.USER_CHANNEL);
					player.put(ActorKeys.USER_CHANNEL, channel);
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}	
}