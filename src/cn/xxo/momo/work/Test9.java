package cn.xxo.momo.work;

/**
 * 实现一个功能，去掉字符串中的所有空格。
 * Created by xiaoxiaomo on 2016/4/12.
 */
public class Test9 {
    public static void main(String[] args) {
        System.out.println(myTrim(" fsdfl     kfs fff sfssdd df "));
    }

    private static String myTrim(String s) {
        if( s == null || s.length() == 0 ){
            return null ;
        }

        return s.replaceAll(" ", "") ;

    }
}
