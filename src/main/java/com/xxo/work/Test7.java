package com.xxo.work;

import java.util.Calendar;
import java.util.Date;

/**
 * 打印昨天的当前时刻
 * Created by xiaoxiaomo on 2012/4/12.
 */
public class Test7 {

    public static void main(String[] args) {
        Date d = new Date() ;
//        d.setTime(System.currentTimeMillis() - 1000 * 60 * 60 * 24);
//
//        System.out.println(d);


        Calendar c = Calendar.getInstance() ;
        c.setTime( d );
        c.add(Calendar.DAY_OF_MONTH, -1);
        d = c.getTime() ;
        System.out.println(d);



    }
}
