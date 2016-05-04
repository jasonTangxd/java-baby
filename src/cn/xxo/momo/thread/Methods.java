package cn.xxo.momo.thread;

/**
 * Created by zenith on 2016/3/28.
 */
public class Methods {


    public static void main(String[] args) {


        new Methods().test();

    }

    private void test() {


        //one
        Thread th=  new Thread(new Hi());
        //two
        //new Thread(new Hi()).start();
        System.out.println("begin main");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



        //beign interrupt
        System.out.println("begin interrupt");
        th.interrupt();
        System.out.println("end interrupt");




        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("end main");
    }


    /**
     * 实现一个接口
     */
    class Hi implements Runnable{


        @Override
        public void run() {


            while (true){

                Thread th=Thread.currentThread();
               // System.out.println("begin");
//            if (th.getName()=="hello"){
//                Thread.yield();
//            }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    break;
                }


               if (th.isInterrupted()){

                   break;
               }

                //System.out.println("this is a hi thread");
                //在线程类获取
                System.out.println(String.format("id:%s name %s",th.getId(),th.getName()));


            }

        }
    }

}
