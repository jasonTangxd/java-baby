package com.xiaoxiaomo.clazz;

/**
 * 局部内部类
 * Created by xiaoxiaomo on 2012/3/27.
 */
public class Demo02 {
    public static void main(String[] args){
        Outer02 o = new Outer02();
        o.method();
    }
}

class Outer02 {//外部
    int num = 10;
    public void method() {
        int num = 20; //在这里定义的num内部类访问不到
        class Inter02 {
            private int num = 30 ;
            public void show(){
                System.out.println("cn.xxo.momo.clazz.Outer02.this.num:"+Outer02.this.num +
                        " this.num:"+this.num+" num:"+num);
            }
        }

    }

}