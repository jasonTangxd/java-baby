package cn.xxo.momo.clazz;

/**
 * 静态内部类
 * Created by Jason on 2016/3/27.
 */
public class Demo04 {
    public static void main(String[] args) {
        Outer04.Inner i = new Outer04.Inner();
        i.method();
    }
}

class Outer04 {
    private String name = "xiaoxiaomo";
    private static int num = 8 ; //静态

    static class Inner{
        //String s = name ; //不能使用非静态变量
        String str  = "这里可以" ;
        public void method(){
            System.out.println("num:"+num+" str:"+str);
        }
    }
}