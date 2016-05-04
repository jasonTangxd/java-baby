package cn.xxo.momo.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by xiaoxiaomo on 2016/4/12.
 */
public class TcpReceiveDemo {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(4000);
        InputStream in = null ;
        while ( true ) {
            //2. 获取客户端的socket对象
            Socket accept = serverSocket.accept();

             in = accept.getInputStream();

            byte[] b = new byte[1024];
            int read = in.read(b);

            System.out.println(new String(b, 0, read));

        }

    }
}
