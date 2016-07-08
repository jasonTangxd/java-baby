package com.xxo.thread;

/**
 * 多线程join练习
 * Created by xiaoxiaomo on 2012/3/28.
 */
public class HelloJoin {

    public static void main(String[] args) throws InterruptedException {

        new HelloJoin().testJoin() ;

        //Thread.sleep(1000);
        System.out.println("Main end");
    }

    private void testJoin() throws InterruptedException {

        Thread th1 = new Thread(new Thread01()) ;
        Thread th2 = new Thread(new Thread02()) ;

        th1.start() ;   //th1就绪
        th2.start() ;   //th2就绪

        //直接start不join有如下结果:
//        Main end
//        Thread01 start
//        Thread02 start
//        Thread02 end
//        Thread01  end

        th1.join();
        System.out.println("在这里th1 一定 end ");
        System.out.println("th2由于在之前start所以它end没有在这里是不确定的，需要更具它的执行时间");
        System.out.println("如果执行时间长就很可能没有end，如果执行时间短就可能end");
        th2.join();
        System.out.println("在这里th2 一定 end ");
        System.out.println("在这里当前线程一定没有end ");


        //如果添加join会执行下面的结果
//        Thread01 start
//        Thread02 start
//        Thread02 end
//        Thread01  end
//        Main end

    }


    /**
     * 第一个线程
     */
    class Thread01 implements Runnable{

        @Override
        public void run() {

            System.out.println("Thread01 start");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Thread01  end");
        }
    }


    /**
     * 第二个线程
     */
    class Thread02 implements Runnable{

        @Override
        public void run() {

            System.out.println("Thread02 start");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread02 end");
        }
    }




}
