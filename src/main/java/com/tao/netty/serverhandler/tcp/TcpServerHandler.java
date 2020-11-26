package com.tao.netty.serverhandler.tcp;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

/**
 * @author: wtt
 * @create: 2020/11/25
 */
public class TcpServerHandler extends SimpleChannelInboundHandler<FullHttpRequest> {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("jinlai kehuuan le");
        System.out.println(ctx.pipeline().channel().id());
        String msg = "我给你答复了";
        int length = msg.getBytes().length;
        ByteBuf buffer = Unpooled.buffer(length);
        buffer.writeBytes( msg.getBytes());
        ctx.writeAndFlush(buffer);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, FullHttpRequest fullHttpRequest) throws Exception {

    }
}
