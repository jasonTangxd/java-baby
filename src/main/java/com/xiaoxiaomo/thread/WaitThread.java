package com.xiaoxiaomo.thread;

/**
 * Created by xiaoxiaomo on 2012/3/29.
 */
public class WaitThread {

    private Integer num = 0 ;
    public static void main(String[] args) {


        new WaitThread().test() ;
    }

    private void test() {

        Thread th = new Thread( new WaitThread01() ,"th1" );
        th.start();


        new Thread( new WaitThread01(),"th2" ).start();

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (num){
            num.notify();
//            num.notifyAll();
        }

//        new Thread( new WaitThread01(),"th3" ).start();
//        new Thread( new WaitThread01(),"th4" ).start();
//        new Thread( new WaitThread01(),"th5" ).start();


    }


    class WaitThread01 implements Runnable{

        @Override
        public void run() {


           // System.out.println(Thread.currentThread().getName()+"在同步代码块之前哦1，num:"+num);
            num++ ;
            System.out.println(Thread.currentThread().getName()+",同步代码块之前，num:"+num);

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            synchronized (num){


                //System.out.println("线程"+Thread.currentThread().getName()+",在同步代码块中start,num:"+num);
                System.out.println("线程"+Thread.currentThread().getName());

                try {
                    Thread.sleep(10000);

                    num.wait();
                    //Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println("线程"+Thread.currentThread().getName()+"被打断！");
                }

                num++ ;

                System.out.println("线程"+Thread.currentThread().getName()+",在同步代码块中end,num:"+num);

            }



            //System.out.println(Thread.currentThread().getName()+"在同步代码块之后哦1，num:"+num);
            num++ ;
            System.out.println(Thread.currentThread().getName()+",同步代码块之后，num:"+num);

        }
    }

}
