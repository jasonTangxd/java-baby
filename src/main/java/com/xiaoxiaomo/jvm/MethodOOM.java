package com.xiaoxiaomo.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoxiaomo on 2012/7/6.
 * VM Args：-XX:PermSize=2m -XX:MaxPermSize=2m
 */
public class MethodOOM {
    public static void main(String[] args) {

        //保持引用，防止自动垃圾回收
        List<String> list = new ArrayList<>();

        int i = 0;

        while(true){
            //通过intern方法向常量池中手动添加常量
            list.add(String.valueOf(i++).intern());
        }
    }

}
