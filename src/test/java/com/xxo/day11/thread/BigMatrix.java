package com.xxo.day11.thread;

import java.util.Date;
import java.util.Random;

/**
 * Created by xiaoxiaomo on 2012/3/28.
 */
public class BigMatrix {


    public static void main(String[] args) {

        Random random=new Random();


        //init matrix
        int[][] matrix=new int[3][30000000];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j]=random.nextInt();
            }
        }



        Integer result=Integer.MIN_VALUE;
        long beginDate;
        long endDate;

        beginDate=new Date().getTime();

        //begin calc normal
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                //result=Math.max(matrix[i][j],result);
                if (result<matrix[i][j]){
                    result=matrix[i][j];
                }
            }
        }
        endDate=new Date().getTime();

        System.out.println(String.format("normal result:%s costtime :%s",result,endDate-beginDate));


        //复位 result
        result=Integer.MIN_VALUE;


        // thread
        beginDate=new Date().getTime();

        Thread[] threads=new Thread[matrix.length];
        Worker[] workers=new Worker[matrix.length];

        //01初始化多个线程worker 并赋值
        for (int i = 0; i < matrix.length; i++) {
            //matrix[i]
            Worker worker=new Worker(matrix[i]);
            Thread thread=new Thread(worker);
            thread.setName("calc"+i);
            //处于就绪状态
            thread.start();


            //创建的多线程对象放到Thread数组中，以便于后面的程序调用。
            threads[i]=thread;
            workers[i]=worker;
        }

        //02join到main线程上。
        for (int i = 0; i < matrix.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //03所有worker执行完毕后才会执行该代码
        for (int i = 0; i <matrix.length ; i++) {
            Integer integer=workers[i].getResult();
            if (result<integer){
                result=integer;
            }
        }
        endDate=new Date().getTime();

        System.out.println(String.format(" thread result:%s costtime :%s",result,endDate-beginDate));

    }


    //work的作用
   static class Worker implements Runnable{

       private int[] array;

       public Integer getResult() {
           return result;
       }

       private Integer result=Integer.MIN_VALUE;


       public Worker(int[] array) {
           this.array = array;
       }

       @Override
        public void run() {

            for (int j = 0; j < array.length; j++) {
                //result=Math.max(matrix[i][j],result);
                if (result<array[j]){
                    result=array[j];
                }
            }
           System.out.println(Thread.currentThread().getName()+result);
        }
    }



}
