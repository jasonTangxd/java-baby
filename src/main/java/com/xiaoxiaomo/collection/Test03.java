package com.xiaoxiaomo.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by xiaoxiaomo on 2012/4/5.
 */
public class Test03 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>() ;
        list.add("zangsan");
        list.add("loishi");
        list.add("wangwu");
        list.add("zhaoliu");
        list.add("qiqi");
        list.add("baba");

        Collections.sort(list);

        for ( String str : list) {
            System.out.println(str + " ");
        }

        new Test03().twoQuet(list , "loishi") ;
    }

    /**
     *
     */
    private static <T> int twoQuet( List<T> list , T t ) {
        int start = 0 , end = list.size()-1 , mid;
        while ( start <= end ){
            mid =  ( start + end ) / 2 ;


            //if( start )

        }


        return -1 ;

    }


}
