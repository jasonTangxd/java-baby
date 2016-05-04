package cn.xxo.day10;

/**
 * Created by zenith on 2016/3/28.
 */
public class Deamo  {


    public static void main(String[] args) {

        new Deamo().test();

    }

    private void test() {

        DeamoTest deamoTest=new  DeamoTest();

        //线程1
        Thread thread=new Thread(deamoTest);

        //线程2
        new Thread(deamoTest).start();

        //守护线程设置
        thread.setDaemon(true);

        // 准备就绪 等待运行
        thread.start();



        System.out.println("main end");

    }

    /**
     * 多线程
     */
    class DeamoTest implements Runnable{


        @Override
        public void run() {

            System.out.println("begin");


            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("end");
        }
    }

}
