package com.xiaoxiaomo.single;

/**
 * 单例模式
 * 饿汉模式
 * Created by xiaoxiaomo on 2012/3/22.
 */
public class SingleDemo01 {

    //1.私有化构造函数
    private SingleDemo01(){}

    //2. 创建实例化对象,类加载的时候创建
    private static SingleDemo01 instance = new SingleDemo01();

    //3. 提供统一实例化入口
    public static SingleDemo01 getInstance(){
        return  instance ;
    }

}
