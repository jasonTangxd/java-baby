package cn.xxo.momo.factory;

/**
 * 计算一个任何一个程序所用时间
 * 模板设计模式
 * 提取不变的方法，抽取出变的信息
 * Created by Jason on 2016/3/23.
 */
public class Template {

    public static void main(String[] args){
        //计算程序执行时间

        DefiniteCode code = new DefiniteCode() ;
        long time = code.computeTime() ;
        System.out.println("程序运行的具体时间：" + time);
    }
}


abstract class TemplateTools{

    /**
     * 提取一个不变的公共方法
     * @return
     */
    public final long computeTime(){
        long startTime =  System.currentTimeMillis() ;
        //执行代码
        code();
        return System.currentTimeMillis() - startTime ;
    }

    /**
     * 抽象出一个变得方法
     */
    abstract void code() ;


}

/**
 *
 */
class DefiniteCode extends TemplateTools{
    //任何代码
    public void code(){
        System.out.println("呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵");
        System.out.println("呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵");
        System.out.println("呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵");
        System.out.println("呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵");
        System.out.println("呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵");
        System.out.println("呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵");
        System.out.println("呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵");
        System.out.println("呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵");
        System.out.println("呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵");
        System.out.println("呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵");
        System.out.println("呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵");
        System.out.println("呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵");
        System.out.println("呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵");
        System.out.println("呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵");
        System.out.println("呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵");
        System.out.println("呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵");
        System.out.println("呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵");
        System.out.println("呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵");
        System.out.println("呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵");
    }
}
