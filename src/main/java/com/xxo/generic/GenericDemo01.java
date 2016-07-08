package com.xxo.generic;

/**
 * Created by xiaoxiaomo on 2012/4/1.
 */
public class GenericDemo01 {

    public static void main(String[] args) {

        new GenericDemo01().print();
        new Tools().print(new Tools().print3(66666666));


    }


    /**
     */
    public void print(){
        new Tools().print("he xo ");
        new Tools().print(new Tools().print2(13123123));


        Tools<String> strs = new Tools<String>() ;
//        strs.print2()

    }



    static class Tools<T>{

        /**
         * 泛型
         * @param s
         */
        public void print( T s ){
            System.out.println("println " + s);
        }

        /**
         * 有返回值
         * @param s
         * @return
         */
        public T print2(T s){
           return s ;
        }

        public static <T> T print3(T s){
            return s;
        }

        public static <E> E print4(E e){
            return e;
        }



    }

}


