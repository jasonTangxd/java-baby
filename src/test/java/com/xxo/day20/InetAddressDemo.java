package com.xxo.day20;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo {
	
	public static void main(String[] args) throws Exception {
		InetAddress host = InetAddress.getByName("www.baidu.com");
		String ip = host.getHostAddress();
		String name = host.getHostName();
		System.out.println(ip+"--"+name);
	}

	//局域网中的其他机器
	private static void localRemoteinfo() throws UnknownHostException {
		InetAddress host = InetAddress.getByName("xxo171.xxo");
		String ip = host.getHostAddress();
		String name = host.getHostName();
		System.out.println(ip+"--"+name);
	}

	//获取本机信息
	private static void getLocalInfo() throws UnknownHostException {
		InetAddress localHost = InetAddress.getLocalHost();
		String ip = localHost.getHostAddress();
		String name = localHost.getHostName();
		System.out.println(ip+"--"+name);
	}
}
