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
		//�¼�ѭ����
		//��һ���߳��飬����һ��Nio�̣߳�ʵ���Ͼ���Reactor�߳�
		EventLoopGroup bossGroup=new NioEventLoopGroup();//���ڷ���˽��ܿͻ�������
		EventLoopGroup workerGroup =new NioEventLoopGroup();//���ڽ���SocketChannel�������д
		try{
			//�����������
			ServerBootstrap b = new ServerBootstrap();
			//׼�������������
			b.group(bossGroup,workerGroup)//��һ������ΪparentGroup���ڶ���ΪchildGroup
			.channel(NioServerSocketChannel.class)//����ChannelΪNioServerSocketChannel
			.option(ChannelOption.SO_BACKLOG, 1024)//TCP�Ĳ�������
			.childHandler(new ChildChannelHandler());//��Ӧ��Handler��
			
			//�󶨶˿ڣ�ͬ���ȴ��ɹ�
			ChannelFuture f =b.bind(port).sync();
			
			//�ȴ������������˿ڹر�
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













