package com.xiaoxiaomo.sort;

/**
 * 冒泡排序
 * Created by xiaoxiaomo on 2012/3/22.
 */
public class MaopaoSort {


    public static void main(String[] args){
        int[] arr = {78,4,3,889,12} ;
        //演变过程
        //第一次遍历
        //78>4   ====> 4,78,3,889,12
        //78>3   ====> 4,3,78,889,12
        //78<889 ====> 4,3,78,889,12
        //78>12  ====> 4,3,12,889,78

        //第二次遍历
        //4>3    ====> 3,4,12,889,78
        //4<12   ====> 3,4,12,889,78
        //4<889  ====> 3,4,12,889,78

        //第三次遍历
        //12<889 ====> 3,4,12,889,78
        //12<78  ====> 3,4,12,889,78

        //第四次遍历
        //889>78 ====> 3,4,12,78,889


        //遍历次数n=5：1+2+3+4 = 4*（1+4）/2=10=n*(n-1)/2
        //遍历次数n=6：1+2+3+4+5 = 5*（1+5）/2=15=n*(n-1)/2
        MaopaoSort.sortMaoPao(arr);

        for (int i = 0 ; i < arr.length ; i++){
            System.out.print(arr[i]+" ");
        }
    }

    /**
     * 冒泡排序
     * @param arr
     */
    public static void sortMaoPao( int[] arr ){

        for ( int i = 0 ; i < arr.length -1 ; i++ ){    //1. 第一个数和后面的比较，最后一个元素就不用比较了，所以长度是length-1

            for (int j = 0 ; j < arr.length-1-i ; j++){ //2. 交换好的数据每次循环就在增加，所以要比较的元素在减少，所以就是length-1-i
                if( arr[j] < arr[j+1] ){                  //3. 如，从小到大，就需要把大的数据沉底，小的让它冒出来
                    int temp = arr[j] ;
                    arr[j] = arr[j+1] ;
                    arr[j+1] = temp ;
                }
            }
        }
    }


    /**
     * 普通打印出数组
     * @param arr
     */
    public static void commPrint( int[] arr ){
        for (int i = 0 ; i < arr.length ; i++ ){
            System.out.print(arr[i] + " ");
        }
    }


    /**
     * 格式化打印出数组
     * @param arr
     */
    public static void formatPrint( int[] arr ){
        System.out.print("[");
        for (int i = 0 ; i < arr.length ; i++ ){
            System.out.print(arr[i]);

            if( i < arr.length -1 ){
                System.out.print(",");
            }
        }
        System.out.print("]");
    }

}
