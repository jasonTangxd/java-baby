package com.xxo.clazz;

/**
 * Created by xiaoxiaomo on 2012/3/27.
 */
class Demo01 {
    public static void main(String[] args)  {
        Outer.Inter o = new Outer().new Inter();
        o.show();
    }
}

class Outer { //外部
    private String name = "momo" ; //cn.xxo.clazz.Outer.this.name
    int num = 10;//cn.xxo.momo.clazz.Outer.this.num
    public class Inter { //内部类,持有一个外部类的引用 外部类名.this
        int num = 20;//this.num
        public void show(){
            int num = 30;//num
            System.out.println("name:"+Outer.this.name+" cn.xxo.momo.clazz.Outer.this.num:"+
                    Outer.this.num+" this.num:"+this.num +" num:"+num );
        }
    }
    //
    public void method(){
        Inter i = new Inter();
    }
}