package cn.xxo.day20;

import java.io.OutputStream;
import java.net.Socket;

/**
 * tcp发送端
 * Created by xiaoxiaomo on 2016/4/12.
 */
public class TcpSendSimpleDemo {
	
	/**
	 * 1：创建socker客户端，需要连接到接收端
	 * 2：获取这个socket的输出流
	 * 3：通过输出流给其他服务器发送数据
	 * 4：关键连接
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		//1：获取socker对象
		Socket socket = new Socket("192.168.3.102",6000);

		//2:获取输出流
		OutputStream outputStream = socket.getOutputStream();

		//3:通过输出流写数据
		outputStream.write("TCP ... 你好!".getBytes());

		//4：关闭连接
		socket.close();
	}
}
