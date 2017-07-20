package com.xiaoxiaomo.single;

/**
 * 单例模式
 * 内部类
 * Created by xiaoxiaomo on 2012/3/22.
 */
public class SingleDemo03 {

    private SingleDemo03(){} //1. 私有构造函数化实例

    private static class SingleClass {  //2. 一个私有化内部类，定义一个实例化对象
        private static final SingleDemo03 INSTANCE = new SingleDemo03() ;
    }

    public static SingleDemo03 getInstance(){ //3. 提供统一入口实例化对象
        return SingleClass.INSTANCE ;
    }

}
