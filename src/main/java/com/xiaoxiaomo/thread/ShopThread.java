package com.xiaoxiaomo.thread;

import java.util.Random;
import java.util.concurrent.*;

/**
 *
 * 1、在繁华的市中央有一个店铺，店铺里有两个美女店员：lily和rose，他们家目前存货为2支冰淇淋和2瓶可乐；
 * 2、附近有个工厂每10秒钟会给这个店铺送来5支冰淇淋和5瓶可乐；
 * 3、每隔5秒钟会有1个顾客要去这家店铺买东西，随机买1-3支冰淇淋，和1-3瓶可乐。
 * 4、冰激淋能赚3元，可乐能赚2元。
 *
 * 统计出每分钟店铺赚的钱并打印出来
 * Created by xiaoxiaomo on 2012/3/29.
 */
public class ShopThread {

    private Double iceCreamPreice  = 3.0; //冰激淋能赚3元

    private Double cokePreice = 2.0 ;    //可乐能赚2元

    private volatile Double totalPrice = 0.0 ; //总价额

    private Shop shop ;

    private volatile Integer minutes = 0 ; //系统运行时间

    public static void main(String[] args) {
        new ShopThread().test();

    }

    private void test() {

        //送货的工厂

        shop = new Shop() ;
        shop.setCoke(2);
        shop.setIceCream(2);

        new Thread( new Factory() ).start();
        new Thread( new Customer() ).start();

        new Thread( new countSumPrice() ).start();

        ScheduledExecutorService minute = Executors.newScheduledThreadPool(1) ;
        minute.scheduleAtFixedRate(new runTime(), 0, 1, TimeUnit.SECONDS) ;//系统运行时间
    }


    /**
     * 一个送货的工厂
     */
    class Factory implements Runnable {

        @Override
        public void run() {

            System.out.println("送货员已经起航，开始送货.......");

            while ( true ) {

                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //每次送货5支冰淇淋和5瓶可乐
                synchronized (shop){
                    shop.setCoke(shop.getCoke() + 5);
                    shop.setIceCream(shop.getIceCream() + 5);
                    System.out.println(String.format("送货员已经送到，目前冰淇淋：%s,目前可乐：%s",shop.getCoke(),shop.getIceCream()));
                }
            }

        }
    }


    /**
     * 每隔5秒钟会有1个顾客要去这家店铺买东西
     */
    class Customer implements Runnable {

        @Override
        public void run() {

            while ( true ) {
                System.out.println("顾客，开始开始来买东西了.......");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }



                ExecutorService executor = Executors.newFixedThreadPool(1) ;
                executor.submit(new Clerk() );
                //executor.submit(new Thread(new Clerk(), "rose"));

            }

        }
    }

    /**
     * 店员等待顾客来买东西
     */
    class Clerk implements Runnable {

        @Override
        public void run() {

            System.out.println("顾客到达！");
            System.out.println(Thread.currentThread().getName()+"，正在卖东西给顾客.......");

            int rCoke = new Random().nextInt(3)+1 ;
            int rIce = new Random().nextInt(3)+1 ;

            System.out.println(
                    String.format("顾客，买冰淇淋：%s,买可乐：%s",rIce,rCoke));

            //每次送货5支冰淇淋和5瓶可乐
            synchronized (shop){

                //是否有足够的冰淇淋
                if( shop.getIceCream() > rIce ){
                    shop.setIceCream(shop.getIceCream() -rIce);
                    totalPrice += iceCreamPreice*rIce ;
                    System.out.println(
                            String.format("顾客购买冰淇淋成功！冰淇淋还有：%s",shop.getIceCream()));
                }

                //是否有足够的可乐
                if( shop.getCoke() > rCoke ){
                    shop.setCoke(shop.getCoke() - rCoke);
                    totalPrice += cokePreice*rCoke ;
                    System.out.println(
                            String.format("顾客购买可乐成功！可乐还有：%s",shop.getCoke()));
                }
            }


        }
    }




    class countSumPrice implements Runnable{

        @Override
        public void run() {
            while ( true ){

                //每分钟统计一次
                System.out.println("开始统计money了.......");
                try {
                    Thread.sleep(60000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("一分钟过去了，我终于统计完了，总金额为："+totalPrice);

            }
        }
    }




    /**
     * 每秒+1
     */
    class runTime implements Runnable{
        @Override
        public void run() {
            System.out.println("系统运行时间:"+ minutes ++ );
        }
    }


}

class Shop{
    //存货为2支冰淇淋
    private int iceCream ;

    //2瓶可乐
    private int coke  ;

    public int getIceCream() {
        return iceCream;
    }

    public void setIceCream(int iceCream) {
        this.iceCream = iceCream;
    }

    public int getCoke() {
        return coke;
    }

    public void setCoke(int coke) {
        this.coke = coke;
    }
}
