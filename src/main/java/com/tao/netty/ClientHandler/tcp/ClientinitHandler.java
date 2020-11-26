package com.tao.netty.ClientHandler.tcp;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author: wtt
 * @create: 2020/11/26
 */
public class ClientinitHandler extends ChannelInitializer<NioSocketChannel> {
    @Override
    protected void initChannel(NioSocketChannel nioSocketChannel) throws Exception {
//        nioSocketChannel.pipeline().addLast(new StringEncoder());
//        nioSocketChannel.pipeline().addLast("httpAggregator",new HttpObjectAggregator(512*1024));
        nioSocketChannel.pipeline().addLast(new TestHandler());

    }
}
