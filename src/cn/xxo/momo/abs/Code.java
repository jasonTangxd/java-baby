package cn.xxo.momo.abs;

import cn.xxo.momo.sort.MaopaoSort;

/**
 * Created by Jason on 2016/3/22.
 */
public class Code extends Employee{

    /**
     * @param id
     * @param name
     * @param sex
     * @param salary
     */
    public Code( int id , String name , int sex , double salary ){
        setId(id);
        setName(name);
        setSex(sex);
        setSalary(salary);
    }

    @Override
    public void work(int[] arr) {
        System.out.println("员工开始工作");
        MaopaoSort.sortMaoPao(arr);
        MaopaoSort.formatPrint(arr);
    }
}
