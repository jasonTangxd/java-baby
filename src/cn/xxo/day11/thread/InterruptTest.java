package cn.xxo.day11.thread;

/**
 * Created by zenith on 2016/3/28.
 */
public class InterruptTest {


    public static void main(String[] args) {


        new InterruptTest().test();

    }

    private void test() {


        //work begin
        Thread thread=new Thread(new Test());
        thread.start();
        

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread.interrupt();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(thread.getState().name());

    }


    /**
     * 多线程
     */
    class Test implements Runnable{


        @Override
        public void run() {

           while (true){

               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   System.out.println("sleeping Interrupted");
                   break;
               }

               System.out.println("work");
               if (Thread.currentThread().isInterrupted()){
                   System.out.println("Interrupted");
                   break;
               }

           }
        }
    }
}