package com.xiaoxiaomo.day17;

import java.io.IOException;
import java.io.OutputStream;

/**
 * 实现一个打印程序
 * @author xiaoxiaomo
 *
 */
public class Test7 {
	public static void main(String[] args) throws IOException {
		OutputStream out = System.out;
		out.write("abcd".getBytes());
	}
}
