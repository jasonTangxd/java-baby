package com.xiaoxiaomo.work;

/**
 * 写一个单例（使用懒汉式，考虑线程安全的问题）
 * Created by xiaoxiaomo on 2012/4/12.
 */
public class Test5 {

    //1.私有化
    private Test5() {
    }

    private static Test5 instance = null ;

    public static synchronized Test5 getInstance(){
        if( instance == null  ){
            instance = new Test5() ;
        }
        return instance ;
    }


}
