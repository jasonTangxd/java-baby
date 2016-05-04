package cn.xxo.momo.thread;

/**
 * 同步代码块
 * Created by xiaoxiaomo on 2016/3/28.
 */
public class SyncTest {

    private Integer num  = 0 ;

    public static void main(String[] args) {
        new SyncTest().syn() ;
    }

    private void syn() {
        //启动10个线程
        for (int i = 0; i < 10; i++) {
            new Thread(new TestSyn()).start() ;
        }
    }

    class TestSyn implements Runnable{

        @Override
        public void run() {

            /**
             * 同步代码块
             */
            //runing 2


            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(String.format("name:%s",Thread.currentThread().getName()));

            synchronized (num) {  // 间接的被转化为单线程了，相当于串行执行代码
                if(  num < 5 ){

//                    try {
//                        Thread.sleep(3000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }

                    System.out.println(String.format(
                            "name:%s,   num:%s",Thread.currentThread().getName(),num));
                    num ++ ;
                }
            // runing 1


                System.out.println(num);
            }
        }
    }
}
