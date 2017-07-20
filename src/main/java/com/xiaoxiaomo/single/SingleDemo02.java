package com.xiaoxiaomo.single;

/**
 * 单例模式
 * 懒汉模式
 * Created by xiaoxiaomo on 2012/3/22.
 */
public class SingleDemo02 {

    private SingleDemo02(){} //1. 私有化构造函数

    private static SingleDemo02 instance = null ; //2. 实例变量

    public static synchronized SingleDemo02 getInstance(){ //3. 提供统一实例化入口，需要时创建
        if ( instance == null ){
            instance = new SingleDemo02() ;
        }
        return instance ;
    }


}
