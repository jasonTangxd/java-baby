package cn.xxo.day10;

/**
 * Created by zenith on 2016/3/28.
 */
public class SyncTest {


    Integer num=0;
    public static void main(String[] args) {

        new SyncTest().test();


    }

    private void test() {

        for (int i = 0; i < 10; i++) {

            new Thread(new Test()).start();
        }

    }


    class Test implements Runnable{

        @Override
        public void run() {

            synchronized (num) {
                if (num < 5) {
                    //System.out.println(String.format("thread:%s   num:%s Do some thing", Thread.currentThread().getName(), num));
                    num++;
                    System.out.println(num);
                }

            }



        }
    }
}
