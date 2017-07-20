package com.xiaoxiaomo.util;

/**
 * Created by xiaoxiaomo on 2012/3/30.
 */
public class IntegerDemo {

    public static void main(String[] args) {
        int i = String2Int("12345678") ;
        System.out.println(i-12345678);
    }

    public static int String2Int( String str ){
        int sum = 0 ;
        for ( int i = 0; i < str.length(); i++ ) {
            int tem = 0 ;
            switch ( str.substring(i,i+1).hashCode() ) {
                case 49 : tem = 1 ; break;
                case 50 : tem = 2 ; break;
                case 51 : tem = 3 ; break;
                case 52 : tem = 4 ; break;
                case 53 : tem = 5 ; break;
                case 54 : tem = 6 ; break;
                case 55 : tem = 7 ; break;
                case 56 : tem = 8 ; break;
                case 57 : tem = 9 ; break;
            }
            //i +=  tem * Math.pow(10,str.length()-1-j) ;
            sum = sum * 10 + tem ;
        }
        return sum ;
    }
}
