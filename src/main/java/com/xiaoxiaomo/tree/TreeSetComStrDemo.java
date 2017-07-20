package com.xiaoxiaomo.tree;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * 比较字符串长度
 * Created by xiaoxiaomo on 2012/4/1.
 */
public class TreeSetComStrDemo implements TreeSetComStr3 {

    public static void main(String[] args) {
        new TreeSetComStrDemo().Compares();


    }

    @Override
    public void Compares() {
        /**
         * treeSet 比较字符串长度
         */
        TreeSet<String> set = new TreeSet<String>(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                String str1 = (String)o1 ;
                String str2 = (String)o2 ;
                int result = str1.length() - str2.length() ;
                if( result == 0 ){

                    return str1.compareTo(str2) ;
                }
                return result;
            }
        });

        set.add("riowerk") ;
        set.add("132t") ;
        set.add("1e32") ;
        set.add("rf") ;
        set.add("hj") ;
        set.add("hjew2") ;
        set.add("riwwowerk") ;
        set.add("riytuijowerk") ;

        //遍历
        Iterator<String> it=  set.iterator() ;
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}
