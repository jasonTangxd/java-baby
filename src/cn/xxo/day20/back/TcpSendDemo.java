package cn.xxo.day20.back;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * tcp发送端
 * @author lenovo
 *
 */
public class TcpSendDemo {
	
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
		Socket socket = new Socket("192.168.3.62",4000);
		//2:获取输出流
		OutputStream out = socket.getOutputStream();
		//3:通过输出流写数据
		out.write("TCP hehe.....".getBytes());
		
		InputStream in = socket.getInputStream();
		byte[] bytes = new byte[1024];
		int read = in.read(bytes);
		String result = new String(bytes,0,read);
		System.out.println(System.currentTimeMillis()+"收到服务端发送的数据：----->>>>>"+result);
		//4：关闭连接
		socket.close();
		
	}

}
