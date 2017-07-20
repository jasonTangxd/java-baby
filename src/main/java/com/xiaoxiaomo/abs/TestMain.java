package com.xiaoxiaomo.abs;

/**
 * Created by xiaoxiaomo on 2012/3/22.
 */
public class TestMain {

    public static void main(String[] args){

        int[] arr = {90,432,64,12,4,64564,2,12,54,3,65,89,1,2,12} ;


        Code code = new Code(1,"张三" ,1, 22000)  ;
        code.work(arr);


        Lecturer lecturer = new Lecturer(2,"李四" ,0, 27000)  ;
        lecturer.work(arr);

        lecturer.teach();
    }
}
