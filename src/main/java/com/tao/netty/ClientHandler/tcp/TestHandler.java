package com.tao.netty.ClientHandler.tcp;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.charset.Charset;

/**
 * @author: wtt
 * @create: 2020/11/26
 */
public class TestHandler extends SimpleChannelInboundHandler<Object> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Object o) throws Exception {
        if (o instanceof ByteBuf) {
            ByteBuf by = (ByteBuf)o;
            System.out.println(by.toString(Charset.defaultCharset()));
        }
    }
}
