package com.xiaoxiaomo.day20.back;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * UDP接收端代码
 * Created by xiaoxiaomo on 2012/4/12.
 *
 */
public class UdpReceiveSimpleDemo {
	/**
	 * 1：获取socket连接(需要指定监听的端口)
	 * 2：通过receive方法接收数据包
	 * 3：解包，获取数据包中的内容
	 * 4：关闭连接
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws IOException {
		//1:获取连接
		DatagramSocket ds = new DatagramSocket(3000);;

		//2：接收数据
		byte[] buf = new byte[1024];
		DatagramPacket p = new DatagramPacket(buf, 0, buf.length);
		ds.receive(p);

		//3:获取数据
		System.out.println( "信息来源："+p.getAddress().getHostAddress() );
		System.out.println( "收到数据：" + new String( p.getData(),0,p.getLength()) );

		//4：关闭连接
		ds.close();
	}
}
