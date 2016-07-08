package com.xxo.abs;

import com.xxo.sort.MaopaoSort;

/**
 * Created by xiaoxiaomo on 2012/3/22.
 */
public class Lecturer extends Employee{

    public Lecturer( int id , String name , int sex , double salary ){
        setId(id);
        setName(name);
        setSex(sex);
        setSalary(salary);
    }

    @Override
    public void work(int[] arr) {
        System.out.println("讲师开始工作");
        MaopaoSort.commPrint(arr);
        System.out.println() ;
    }

    public void teach(){
        System.out.println("讲java+大数据内容") ;
    }
}
