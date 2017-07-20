package com.xiaoxiaomo.work;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * 声明类Student，包含3个成员变量：name、age、score，
 * 创建5个对象装入TreeSet，按照成绩排序输出结果
 * （考虑成绩相同的问题，若成绩相同再根据年龄，年龄相同再根据姓名排序  ）
 * Created by xiaoxiaomo on 2012/4/12.
 */
public class Test6 {

    public static void main(String[] args) {
        TreeSet<Student> students = new TreeSet<Student>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if( o1.score != o2.score ){
                    return -(int)(o1.score - o2.score) ;
                }

                if( o1.age != o2.age ){
                    return -(o1.age - o2.age) ;
                }

                return -(o1.name.compareTo( o2.name ));
            }
        }) ;

        students.add(new Student( "zhangsan" , 18 , 99) ) ;
        students.add(new Student( "lishi" , 28 , 89) ) ;
        students.add(new Student( "wangwu" , 19 , 99) ) ;
        students.add(new Student( "zhaoliu" , 19 , 100) ) ;
        students.add(new Student( "qitian" , 18 , 89) ) ;

        for (Student student : students) {
            System.out.println(student.name);
        }

    }








    static class Student{
        private String name ;
        private int age ;
        private double score ;

        public Student(String name, int age, double score) {
            this.name = name;
            this.age = age;
            this.score = score;
        }
    }
}
