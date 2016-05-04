package cn.xxo.day15.jdknew;

import java.util.Arrays;
import static java.util.Arrays.*;
/*
packa/Student
packb/Studnet
import packa.Student;
import packb.Student;
class Test {
	void method() {
		new packa.Student();
	}
}
如果我们同时在一个class文件里面，引入两个不同包，但类名称相同的对象，在要创建这个相同类名的对象的时候，需要指定全类名加以区分
在进行静态导入的时候，方法重名的时候，需要我们加类型进行区分
java.util.Date;
java.sql.Date;
new java.util.Date();
*/
public class StaticImportDemo {

	public static void main(String[] args) {
		Integer[] arr = {1, 2, 3, 4};
		System.out.println(asList(arr));
		System.out.println(Arrays.toString(arr));
	}

}
