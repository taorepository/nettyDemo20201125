package com.tao.netty.Server;

import com.tao.netty.handler.HttpInitHandler;
import com.tao.netty.handler.TestServerHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.InetAddress;
import java.net.InetSocketAddress;

/**
 * @author: wtt
 * @create: 2020/11/25
 */
public class TestServer {
    @Autowired
    private TestServerHandler testServerHandler;


    public static void main(String[] args) throws InterruptedException {

        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();

        ServerBootstrap serverBootstrap = new ServerBootstrap();

        serverBootstrap.group(bossGroup,workerGroup).channel(NioServerSocketChannel.class).
                childHandler(new HttpInitHandler());
        InetSocketAddress inetAddress = new InetSocketAddress(9300);
        ChannelFuture sync = serverBootstrap.bind(inetAddress).sync();
        sync.channel().closeFuture().sync();
    }
}
