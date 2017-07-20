package com.xiaoxiaomo.clazz;

/**
 * 匿名内部类
 * Created by xiaoxiaomo on 2012/3/27.
 */
public class Demo03 {
    public static void main(String[] args) {
        Outer03 o = new Outer03();
        o.method("xiaoxiaomo",23);
    }
}

//抽象类
abstract class AbsDemo {
    public abstract void show();
}

class Outer03 {
    public void method(final String name,int num){
		/*new AbsDemo(){//匿名内部类,第一种调用方式
			public void show(){
				System.out.println(name);
			}
		}.show();*/

        AbsDemo a = new AbsDemo(){//第二种
            public void show(){
                System.out.println(name /*+num*/);
            }
        };  //分号不能省
        a.show();
    }
}