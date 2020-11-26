package com.tao.netty.serverhandler;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.CharsetUtil;

/**
 * @author: wtt
 * @create: 2020/11/26
 */
public class HeartBeetHandler extends ChannelInboundHandlerAdapter {
    private static final ByteBuf HEARTBEAT_SEQUENCE = Unpooled.unreleasableBuffer(
                           Unpooled.copiedBuffer("HEARTBEAT", CharsetUtil.UTF_8));

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        System.out.println("kehuduan lianjin laile---------------");
        System.out.println(evt.getClass());
        if (evt instanceof IdleStateEvent) {
            System.out.println("kehuduan lianjin laile");
            ctx.writeAndFlush(HEARTBEAT_SEQUENCE).addListener(ChannelFutureListener.CLOSE);
            ctx.channel().close();
        }else{
            super.userEventTriggered(ctx,evt);
        }
    }
}
