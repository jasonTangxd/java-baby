package cn.xxo.momo.clazz;

import java.util.ArrayList;
import java.util.List;

/**
 * 目前对这种不是很理解，感觉没什么用
 * Created by Jason on 2016/3/25.
 */
public class InnerArrayList {

    //重写父类方法，局部代码块调用自己重写过的父类方法。
    List<String> list = new ArrayList<String>(){

        //代码块的顺序在前后都无所谓，可以出现在类范围的任何位置。
        {
            add("jason");
        }

        public boolean add(String s){
            System.out.println("Cannot add anything!");
            return true ;
        }
    } ;



}
