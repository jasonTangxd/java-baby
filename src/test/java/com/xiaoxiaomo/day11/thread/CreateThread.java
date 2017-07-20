package com.xiaoxiaomo.day11.thread;

/**
 * Created by xiaoxiaomo on 2012/3/28.
 */
public class CreateThread {


    public static void main(String[] args) {

        //测试方法
       //new CreateThread().test();
        new CreateThread().testnew();
    }



    private void test() {

        //创建一个线程
        Thread hello=new Hello("hello");
        //hello.setName("hello");
        Thread hellonew=new Hello("hellonew");
        //hellonew.setName("hellonew");
        //设置此线程为守护线程
       // hello.setDaemon(true);
//        hellonew.getName()
        //设置线程的优先级
        //hello
        hello.setPriority(1);
        //hello new
        hellonew.setPriority(10);

        //就绪 准备执行
        hello.start();
        hellonew.start();

        //print info


        //在其它线程使用获取属性
        System.out.println(String.format("id:%s,name:%s,priority:%s isDaemon:%s"
                ,hello.getId(),hello.getName(),hello.getPriority(),hello.isDaemon()));
        System.out.println(String.format("id:%s,name:%s,priority:%s isDaemon:%s"
                ,hellonew.getId(),hellonew.getName(),hellonew.getPriority(),hellonew.isDaemon()));

//
//        Thread hellonew=new Hello();
//
//        hellonew.start();

    }


    private void testnew() {

        Hi hi=new Hi();

        Thread th=new Thread(hi);
        Thread thnew=new Thread(hi);
        th.start();
        thnew.start();


    }


    /**
     * 继承Thread类
     */
    class Hello extends Thread{



        public Hello(String name) {
            super(name);
        }

        @Override
        public void run() {

         //  while (true){
              // System.out.println("this is a hello thread");
          // }

            /**
            Thread th=Thread.currentThread();
            //在线程类获取
            System.out.println(String.format("id:%s name %s",th.getId(),th.getName()));

             **/

            System.out.println(String.format("id:%s name %s",this.getId(),this.getName()));
        }
    }


    /**
     * 实现一个接口
     */
    class Hi implements Runnable{


        @Override
        public void run() {

            //System.out.println("this is a hi thread");
            Thread th=Thread.currentThread();
            //在线程类获取
            System.out.println(String.format("id:%s name %s",th.getId(),th.getName()));


        }
    }


}
