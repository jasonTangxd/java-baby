package com.xiaoxiaomo.thread;

/**
 * 守护线程
 * Created by xiaoxiaomo on 2012/3/28.
 */
public class Deamon  {


    public static void main(String[] args) {

        new Deamon().test();

    }

    private void test() {

        //线程1,守护线程
        DeamoTest1 deamoTest1=new DeamoTest1();
        Thread th1=new Thread(deamoTest1);

        //线程2,用户线程
        new Thread(new DeamoTest2()).start();

        //守护线程设置
        th1.setDaemon(true);
        th1.start();

        System.out.println("main -  end");

    }

    /**
     * 多线程，等会把它设为守护线程
     */
    class DeamoTest1 implements Runnable{
        @Override
        public void run() {
            System.out.println("DeamoTest1 - begin");
            try {
                //Thread.sleep(0);
                //Thread.sleep(2000);
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //如果用户线程执行的快，这个守护线程很有可能都没有执行完就结束了
            System.out.println("DeamoTest1 - end");
        }
    }

    /**
     * 多线程，等会默认它为用户线程
     */
    class DeamoTest2 implements Runnable{
        @Override
        public void run() {
            System.out.println("DeamoTest2 - begin");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("DeamoTest2 - end");
        }
    }

}
