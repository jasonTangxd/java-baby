package com.xiaoxiaomo.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 *
 *
 * Created by xiaoxiaomo on 2012/4/12.
 */
public class UdpReceiveDemo {

    public static void main(String[] args) throws IOException {

        //1. 获取Socket
        DatagramSocket ds = new DatagramSocket(3000) ;
        //while (true) {
            //2. 接受数据
            byte[] bytes = new byte[1024];
            DatagramPacket packet = new DatagramPacket(bytes, 0, bytes.length);
            ds.receive(packet);

            //3. 解包（获取数据）
            String s = new String(packet.getData(), 0, packet.getLength());

            System.out.println(s);

            ds.close();
        //}
    }
}
