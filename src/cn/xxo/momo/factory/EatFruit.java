package cn.xxo.momo.factory;

/**
 *写一个测试类，创建一个人 person类，调用吃功能，保证什么水果都可以吃。
 *在吃水果的时候，
 *如果吃到了苹果，打印一句话，真甜
 *如果吃到了榴莲，打印一句话，真"香"
 *其他的水果不打印内容
 * Created by Jason on 2016/3/23.
 */
public class EatFruit {

    public static void main(String[] args){
        Person.eat( new AppleImp() );
        Person.eat( new DurianImp() );
    }
}

/**
 * 一个人人
 */
class Person{
    public static void eat( Fruit fruit ){
        //如果是一个苹果
        if( fruit instanceof AppleImp ){
            AppleImp appleImp = (AppleImp)fruit ;
            appleImp.beiEat();
        }

        //如果是一个榴莲
        else if( fruit instanceof DurianImp ) {
            DurianImp durianImp = (DurianImp)fruit ;
            durianImp.beiEat();
        }
    }
}

/**
 * 水果
 */
interface Fruit{

    String taste ="水果的味道" ;
    void beiEat() ;
}

/**
 * 苹果
 */
class AppleImp implements Fruit{
    String taste ="真甜!" ;
    public void beiEat(){
        System.out.println(taste);
    }
}

/**
 * 榴莲
 */
class DurianImp implements Fruit{
    String taste ="真香!" ;
    public void beiEat(){
        System.out.println(taste);
    }
}



