package com.xxo.work;

/**
 * 求1-100的所有奇数、偶数求和并打印输出
 * Created by xiaoxiaomo on 2012/4/12.
 */
public class Test2 {
    public static void main(String[] args) {

        int jshu = 0 ;
        int oshu = 0 ;
        for (int i = 0; i <= 100 ; i++) {
            if( i%2 == 0 ){
                oshu += i ;
            }
            else{
                jshu += i ;
            }
        }
        System.out.println("奇数："+ jshu);
        System.out.println("偶数："+ oshu);
    }

}
