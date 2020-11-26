package com.tao.netty.ClientHandler;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.string.StringEncoder;

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
