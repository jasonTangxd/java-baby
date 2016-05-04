package cn.xxo.day10;

/**
 * Created by zenith on 2016/3/23.
 */
public class HelloThread {


    public static void main(String[] args) throws InterruptedException {

        //Random random=new Random();


        int i=0;

        int j=i+1;
        i=i+1;

        while (true){

           // System.out.println(random.nextInt(3)+1);
            Thread.sleep(1000);
        }


    }
}
