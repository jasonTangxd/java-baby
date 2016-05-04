package cn.xxo.day20;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP接受端
 * Created by xiaoxiaomo on 2016/4/12.
 */
public class TcpReceiveSimpleDemo {
	
	/**
	 * 1：创建一个socket服务端，需要监听指定端口
	 * 2：通过这个服务端对象可以获取到给指定端口发送数据的socket客户端对象
	 * 3：通过socket对象获取具体的读取流
	 * 4：通过读取流获取数据
	 * 5：关闭连接
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		//1:获取ServerSocket
		ServerSocket serverSocket = new ServerSocket(6000);

		//2:获取客户端的socket对象
		Socket socket = serverSocket.accept();//也是一个阻塞方法，获取socket客户端对象

		//3：获取socket的输入流
		InputStream in = socket.getInputStream();
		byte[] bytes = new byte[1024];

		//4：读取数据
		int read = in.read(bytes);
		System.out.println(new String(bytes, 0, read));

		//5：关闭连接
		socket.close();
		serverSocket.close();
	}
}
