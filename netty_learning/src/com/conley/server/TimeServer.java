package com.conley.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class TimeServer {
	public void bind(int port) throws Exception{
		//事件循环组
		//是一个线程组，包含一组Nio线程，实际上就是Reactor线程
		EventLoopGroup bossGroup=new NioEventLoopGroup();//用于服务端接受客户端连接
		EventLoopGroup workerGroup =new NioEventLoopGroup();//用于进行SocketChannel的网络读写
		try{
			//浏览器启动类
			ServerBootstrap b = new ServerBootstrap();
			//准备连接相关内容
			b.group(bossGroup,workerGroup)//第一个参数为parentGroup，第二个为childGroup
			.channel(NioServerSocketChannel.class)//设置Channel为NioServerSocketChannel
			.option(ChannelOption.SO_BACKLOG, 1024)//TCP的参数设置
			.childHandler(new ChildChannelHandler());//对应得Handler类
			
			//绑定端口，同步等待成功
			ChannelFuture f =b.bind(port).sync();
			
			//等待服务器监听端口关闭
			f.channel().closeFuture().sync();
			

		}catch(Exception e ){
			
		}finally{
			bossGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
		}
	}
	
	private class ChildChannelHandler extends ChannelInitializer<SocketChannel>{
		protected void initChannel(SocketChannel arg0) throws Exception {
			arg0.pipeline().addLast(new TimeServerHandler());
			
		}		
	}
	
	public static void main (String[] args)throws Exception{
		int port=8080;
		if(args !=null && args.length>0){
			try{
				port=Integer.valueOf(args[0]);
				
			}catch(NumberFormatException e ){
				
			}
		}
		new TimeServer().bind(port);
	}
	
}













