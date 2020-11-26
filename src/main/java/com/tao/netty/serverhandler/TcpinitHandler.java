package com.tao.netty.serverhandler;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

/**
 * @author: wtt
 * @create: 2020/11/26
 */
public class TcpinitHandler extends ChannelInitializer <NioSocketChannel>{
    @Override
    protected void initChannel(NioSocketChannel nioSocketChannel) throws Exception {
        ChannelPipeline pipeline = nioSocketChannel.pipeline();
        pipeline.addLast(new IdleStateHandler(0, 0, 10, TimeUnit.SECONDS));
        pipeline.addLast(new HeartBeetHandler());
        pipeline.addLast(new TestServerHandler());
    }
}
