package com.xxo.day20;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * UDP接收端代码
 * Created by xiaoxiaomo on 2012/4/12.
 *
 */
public class UdpReceiveDemo {
	/**
	 * 1：获取socket连接(需要指定监听的端口)
	 * 2：通过receive方法接收数据包
	 * 3：解包，获取数据包中的内容
	 * 4：关闭连接
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) {
		//1:获取连接
		DatagramSocket ds = null;
		try {
			//在3000端口监听接收到的数据
			ds = new DatagramSocket(3000);
		} catch (SocketException e) {
			//例如，该端口已被占用
			//java.net.BindException: Address already in use: Cannot bind
			System.out.println("创建一个socket对象失败！"+e.getMessage());
		}

		//这些让它一直接受数据
		while( ds != null ){

			//2：接收数据
			byte[] buf = new byte[1024];
			DatagramPacket p = new DatagramPacket(buf, 0, buf.length);
			try {
				ds.receive(p);
			} catch (IOException e) {
				//例如，ds为空等
				System.out.println("接受数据失败！");
			}

			//3:获取数据
			System.out.println( "信息来源："+p.getAddress().getHostAddress() );
			System.out.println( "收到数据：" + new String( p.getData(),0,p.getLength()) );


			//通知9000端口的客户端数据接收成功
			//数据发动到客户端的
			DatagramPacket dp_reply= new DatagramPacket(p.getData() ,p.getData().length,p.getAddress(),9000);
			try {
				ds.send(dp_reply);
			} catch (IOException e) {
				e.printStackTrace();
			}
			//由于dp_reply在接收了数据之后，其内部消息长度值会变为实际接收的消息的字节数，
			//所以这里要将dp_reply的内部消息长度重新置为1024
			dp_reply.setLength(1024);
		}
		//4：关闭连接
		//ds.close();
	}
}
