package com.jinglei.game;

import com.jinglei.game.attribute.ActorKeys;
import com.jinglei.channel.NettyClientChannel;
import com.jinglei.interceptor.ExecuteLogicInterceptor;
import com.jinglei.game.server.log.LogWriter;

class LogWriterInterceptor extends ExecuteLogicInterceptor
{
	@Override
	public void before(int packetId, NettyClientChannel channel)
	{
		// 設定執行緒log資訊
		String logWriter = (channel.get(ActorKeys.MEMBER_ID) == null ? "" : channel.get(ActorKeys.MEMBER_ID).toString());
		LogWriter.setName(logWriter);
	}

	@Override
	public void after(NettyClientChannel channel)
	{
		// 移除執行緒的log資訊
		LogWriter.clean();
	}

	@Override
	public void before(String class_name, NettyClientChannel channel) {
		// TODO Auto-generated method stub
		// 設定執行緒log資訊
		String logWriter = (channel.get(ActorKeys.MEMBER_ID) == null ? "" : channel.get(ActorKeys.MEMBER_ID).toString());
		LogWriter.setName(logWriter);		
	}
}