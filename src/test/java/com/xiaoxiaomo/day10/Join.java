package com.xiaoxiaomo.day10;

import java.util.Date;

/**
 * Created by xiaoxiaomo on 2012/3/28.
 */
public class Join {


    public static void main(String[] args) throws InterruptedException {


        new Join().test();

    }

    private void test() throws InterruptedException {

        //创建一个线程对象
        Thread th=new Thread(new HelloJoin());

        Thread th1=new Thread(new HelloJoin());
        //使此对象处于就绪状态
        th.start();
        th1.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {

            System.out.println(new Date().getTime());
            //main 线程阻塞 th、 th1 在运行
            th.join();
            //th 执行完毕后执行
            System.out.println(new Date().getTime());

            //main 线程阻塞 th  over、 th1(不确定)

            th1.join();

            // 保证我们接下来的代码肯定是在th1 执行完毕后执行。
            System.out.println(new Date().getTime());


        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("main");


    }


    class  HelloJoin implements Runnable{


        @Override
        public void run() {



            System.out.println(" hello begin");


            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

//            Thread th=new Thread(new HiJoin());
//            th.start();


            System.out.println("hello end");


        }
    }


    class  HiJoin implements Runnable{


        @Override
        public void run() {

            System.out.println("hi begin");


            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("hi end");


        }
    }
}
