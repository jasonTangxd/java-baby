package cn.xxo.momo.thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zenith on 2016/3/28.
 */
public class SyncTest2 {

	private Lock lock=new ReentrantLock();

    Integer num=0;
    
    private AtomicInteger  number=new AtomicInteger(0);
    
    //static SyncTest syncTest;
    
    public static void main(String[] args) {

    	//SyncTest 
        new SyncTest2().test();
    	

    }

    private  void test() {

		for (int i = 0; i < 10; i++) {
			
           // new Thread(new Test()).start();
            //new Thread(new LockTest()).start();
            new Thread(new LockFreeTest()).start();
			//new Thread(new UnSafeTest()).start();
        }
    }


    /**
     * 使用synchronized标识
     * @author zenith
     *
     */
    class Test implements Runnable{

        @Override
        public void run() {

            synchronized (num) {
                if (num < 5) {
                    System.out.println(String.format("thread:%s   num:%s Do some thing", Thread.currentThread().getName(), num));
                    num++;
                   // System.out.println(num);
                
                }

            }
            
//            synchronized (SyncTest.class) {
//				
//			}



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
                   // System.out.println(num);
                
                }
                lock.unlock();
            
            
//            synchronized (SyncTest.class) {
//				
//			}



        }
    }
    
    /**
     * 使用原子类
     * @author zenith
     *
     */
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
               
            
            
//            synchronized (SyncTest.class) {
//				
//			}



        }
    }

    
    class UnSafeTest implements Runnable{

        @Override
        public void run() {

                if (num < 5) {
                    System.out.println(String.format("thread:%s   num:%s Do some thing", Thread.currentThread().getName(), num));
                    num++;
                   // System.out.println(num);
                
                }

        }
    }
    
}
