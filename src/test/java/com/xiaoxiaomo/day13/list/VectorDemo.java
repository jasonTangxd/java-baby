package com.xiaoxiaomo.day13.list;

import java.util.Enumeration;
import java.util.Vector;

public class VectorDemo {

	public static void main(String[] args) {
		Vector v = new Vector();
		v.addElement("曾叶");
		v.addElement("黄严汉");
		v.addElement("邓扬");
		v.addElement("王展鹄");
		
		/**
		 * Iterator
		 * ListIterator
		 * for(int x =0; x < col.size();x++)
		 * Enumeration:vector特有的
		 */
		/**
		 * 这是我们vector中特有的遍历的方式
		 */
		Enumeration elements = v.elements();
		while(elements.hasMoreElements()) {
			System.out.println(elements.nextElement());
		}
	}
}
