package com.xiaoxiaomo.util;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by xiaoxiaomo on 2012/4/2.
 */
public class SynDemo {

    Integer num=0;
    private Lock lock=new ReentrantLock();
    private AtomicInteger number=new AtomicInteger(0);

    public static void main(String[] args) {
        new SynDemo().syn() ;
    }

    private void syn() {
        //启动10个线程
        for (int i = 0; i < 10; i++) {
            new Thread(new TestSyn()).start() ;
            new Thread(new LockTest()).start() ;
            new Thread(new LockFreeTest()).start() ;
        }
    }

    class TestSyn implements Runnable{

        @Override
        public void run() {
            synchronized (num) {  // 间接的被转化为单线程了，相当于串行执行代码
                if(  num < 5 ){
                    System.out.println(String.format(
                            "name:%s,   num:%s",Thread.currentThread().getName(),num));
                    num ++ ;
                }
                System.out.println(num);
            }
        }
    }

    /**
     * 使用lock方式
     */
    class LockTest implements Runnable{

        @Override
        public void run() {

            lock.lock();
            if (num < 5) {
                System.out.println(String.format("thread:%s   num:%s Do some thing", Thread.currentThread().getName(), num));
                num++;

            }
            lock.unlock();
        }
    }

    class LockFreeTest implements Runnable{

        @Override
        public void run() {

            if (number.get() < 5) {
                System.out.println(String.format("thread:%s   num:%s Do some thing",
                        Thread.currentThread().getName(),
                        number.getAndIncrement()));
                //num++;
                // System.out.println(num);

            }
        }
    }
}
