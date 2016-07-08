package com.xxo.util;

/**
 * Created by xiaoxiaomo on 2012/3/30.
 */
public class Demo01 {

    public static void main(String[] args) {

        //1：反转字符串"woainimenmemeda"成为"adememneminiaow"
        //System.out.println(reString("woainimenmemeda")) ;

        //2：子串"nba"在字符串"nbaernbatynbauinbaopnba"出现的次数
        //System.out.println(countStr("nba", "nbaernbatynbauinbaopnba")) ;


        //3：获取两个字符中最大相同子串
        //nboprnttynbanb
        //nbaernbatynbauinbaopnba
        System.out.println(maxLenStr("nboprnttynbanb", "nbaernbatynbauinbaopnba")) ;
    }

    /**
     * 倒叙字符串
     * @param str
     */
    public static String reString(String str){
        int length = str.length() ;
        char[] newStr = new char[length] ;
        //遍历字符串
        for (int i = 0; i < length; i++) {
            newStr[length-i-1] = str.charAt(i) ;
        }
        return new String(newStr);
    }

    /**
     * 子字符串在父字符串出现的次数
     * @param strChirld
     * @param stringFather
     * @return
     */
    public static int countStr(String strChirld , String stringFather){
        int count = 0 ;
        int clength = strChirld.length() ;
        while ( stringFather.length() >= clength  ) {
            if( stringFather.contains(strChirld) ){
                count ++ ;
                stringFather = stringFather.substring(stringFather.indexOf(strChirld)+clength) ;
            }
        }
        return count ;
    }

    /**
     * 获取两个字符中最大相同子串
     * @param str
     * @param string
     * @return
     */
    public static int maxLenStr(String str , String string){
        int max = 0 ;
        int length = str.length() ;

        int run = 0 ;//每次匹配长度
        int nextInx = 0 ;//下次运行开始位置
        for (int j = 0; j < string.length() ;) {
            String pre = str.substring(nextInx,run+nextInx+1);
            //当前匹配进行中
            if( string.contains(pre) ){
                run ++ ;
                j++ ;
            }

            //当前匹配结束
            else{

                if( run > max ){
                    max = run ;
                }
                run = 0 ;
                nextInx++ ;//
            }
        }

        return max ;
    }

}
