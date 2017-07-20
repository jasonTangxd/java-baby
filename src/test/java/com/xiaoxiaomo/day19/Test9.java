package com.xiaoxiaomo.day19;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * 保存对象
 * @author xiaoxiaomo
 *
 */
public class Test9 {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		//序列化时 需要指定的对象
//		FileOutputStream fos = new FileOutputStream("d:\\object.txt");
		
		FileInputStream fis = new FileInputStream("d:\\object.txt");
		
//		ObjectOutputStream oos = new ObjectOutputStream(fos);
//		oos.writeObject(new Person("zhangsan",28));
//		oos.close();
		
		//读取时也需要 
		ObjectInputStream ois = new ObjectInputStream(fis);
		Person p = (Person)ois.readObject();
		System.out.println(p.getName());
		System.out.println(p.getAge());
		
	}
}
