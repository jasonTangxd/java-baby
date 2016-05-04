package cn.xxo.day20;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.*;

/**
 * 通过udp协议发送数据
 * Created by xiaoxiaomo on 2016/4/12.
 *
 */
public class UdpSendDemo {

	private static final int TIMEOUT = 3000;  //设置接收数据的超时时间
	private static final int MAXNUM = 5;      //设置重发数据的最多次数

	/**
	 * 1：获取socket对象
	 * 2：对数据进行封包
	 * 3：通过socket对象把数据包发送出去
	 * 4：把连接关闭
	 * @param args
	 */
	public static void main(String[] args) {

		//1. 获取socket对象
		DatagramSocket ds = null;
		try {
			ds = new DatagramSocket(9000); //如果只是用于发送不填写端口
		} catch (SocketException e) {
			System.out.println("创建一个socket对象失败！");
		}

		//2. 封包数据
		String sendMsg = "UDP ......你好！" ;

		DatagramPacket p = null;
		try {
			/**
			 * @param buf 字节流数据包
			 * @param length 流数据包长度 eg,InetAddress.getByName("192.168.3.102")
			 * @param address  发送地址
			 * @param port 端口号
			 */
			p = new DatagramPacket(sendMsg.getBytes(),sendMsg.getBytes().length,InetAddress.getLocalHost(),3000);
		} catch (UnknownHostException e) {
			System.out.println("找不到该hosts所对应的地址！");
		}

		//3. 发送数据包
		boolean isReceived = false; //是否接收到数据的标志位
		int tries = 0;  //重发数据的次数
		try {
			ds.setSoTimeout(TIMEOUT); //设置超时时间
			//直到接收到数据，或者重发次数达到预定值，则退出循环
			while(!isReceived && tries<MAXNUM) {

				ds.send(p); //发送数据

				try{
					//定义用来接收数据的DatagramPacket实例
					DatagramPacket dp_receive = new DatagramPacket(new byte[1024], 1024);
					//接收从服务端发送回来的数据
					ds.receive(dp_receive);
					//如果接收到的数据不是来自目标地址，则抛出异常
					if(!dp_receive.getAddress().equals( InetAddress.getLocalHost() )){
						throw new IOException("地址出错");
					}
					//如果接收到数据。则将receivedResponse标志位改为true，从而退出循环
					isReceived = true;
				}catch(InterruptedIOException e){
					//如果接收数据时阻塞超时，重发并减少一次重发的次数
					tries += 1;
					System.out.println("Time out,次数：" + tries );
				}
			}
		} catch (IOException e) {
			System.out.println("发送数据失败！");
		}


		if(isReceived){
			//成功
			System.out.println("发送成功！");
		}else{
			//失败
			System.out.println("重发信息"+tries+"次后，失败！");
		}


		//4. 关闭连接
		if( ds != null ){
			ds.close();
		}
	}

}
