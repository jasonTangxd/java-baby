package cn.xxo.momo.thread;

/**
 * 创建线程的两种方式
 * 继承
 * 实现
 * Created by xiaoxiaomo on 2016/3/28.
 */
public class CreateThread {

    public static void main(String[] args){

        //创建一个线程，继承
        //new CreateThread().creaateThreadp() ;

        //实现
        new CreateThread().creaateThreadp2() ;
    }

    public void creaateThreadp() {

        //创建一个线程
        Thread hello = new Hello("hello") ;

        //设置优先级，越高越大
        //hello.setPriority(10);

        //默认手动创建为非守护线程
        //ture:设置为守护线程,此时只要主线程结束了，守护线程就结束了
        //false:设为非守护线程，此时主线程结束了，该线程还可以继续执行
        hello.setDaemon(true);

        //就绪，等待cpu调度
        hello.start();

        String info = String.format("id:%s,name:%s,Priority:%s,isDaemon:%s" ,
                hello.getId(),hello.getName(),hello.getPriority(),hello.isDaemon()) ;

        System.out.println(info);
    }


    private void creaateThreadp2() {
        Hi hi = new Hi() ;
        new Thread(hi).start();
    }


    /**
     * 继承Thread类
     */
    class Hello extends Thread{
        public Hello(String name) {
            super(name);
        }
        @Override
        public void run() {

            //System.out.print( "this is hello Thread ! " );

            while ( true ) {
                System.out.println( String.format("id:%s,name:%s",
                        Thread.currentThread().getId(), Thread.currentThread().getName()));
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 实现Runnable
     */
    class Hi implements Runnable{
        @Override
        public void run() {
            Thread th = new Thread() ;
             System.out.println( String.format("id:%s,name:%s",th.getId(), th.getName()));

        }
    }

}
