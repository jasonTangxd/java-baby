package cn.xxo.momo.tree;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * 比较对象
 * Created by xiaoxiaomo on 2016/4/1.
 */
public class TreeSetComparaEntity {

    public static void main(String[] args) {

        /**
         * treeSet 比较字符串长度
         */
        TreeSet set = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                int result = 0 ;
                if( o1 instanceof BeautifulGirl ){
                    //转型
                    BeautifulGirl girl1 = (BeautifulGirl)o1 ;
                    BeautifulGirl girl2 = (BeautifulGirl)o2 ;
                    result = -(girl1.age - girl2.age) ;
                    if( result == 0 ){
                        result =  girl1.name.compareTo(girl2.name);
                    }
                }
                return result;
            }
        });

        set.add(new BeautifulGirl("girl-01",18)) ;
        set.add(new BeautifulGirl("girl-02",3)) ;
        set.add(new BeautifulGirl("girl-03",16)) ;
        set.add(new BeautifulGirl("girl-03",78)) ;
        set.add(new BeautifulGirl("girl-05",3)) ;
        set.add(new BeautifulGirl("girl-02",13)) ;
        set.add(new BeautifulGirl("girl-08",9)) ;

        //遍历
        Iterator it=  set.iterator() ;
        BeautifulGirl girl = null ;
        while (it.hasNext()){
            girl = (BeautifulGirl) it.next() ;
            System.out.println(girl.name + " " + girl.age) ;
        }
    }


    /**
     * Entity 对象
     */
    private static class BeautifulGirl{
        private String name ;
        private int age ;

        public BeautifulGirl(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
}
