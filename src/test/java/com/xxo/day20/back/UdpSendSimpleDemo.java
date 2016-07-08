package com.xxo.day20.back;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 通过udp协议发送数据
 * Created by xiaoxiaomo on 2012/4/12.
 *
 */
public class UdpSendSimpleDemo {

	/**
	 * 1：获取socket对象
	 * 2：对数据进行封包
	 * 3：通过socket对象把数据包发送出去
	 * 4：把连接关闭
	 * @param args
	 */
	public static void main(String[] args) throws IOException {

		//1. 获取socket对象
		DatagramSocket ds = new DatagramSocket();

		//2. 封包数据
		String sendMsg = "UDP ......你好！" ;

		/**
		 * @param buf 字节流数据包
		 * @param length 流数据包长度 eg,InetAddress.getByName("192.168.3.102")
		 * @param address  发送地址
		 * @param port 端口号
		 */
		DatagramPacket p =
				new DatagramPacket(sendMsg.getBytes(),sendMsg.getBytes().length,InetAddress.getLocalHost(),3000);

		//3. 发送数据包
		ds.send(p);

		//4. 关闭连接
		ds.close();
	}
}
