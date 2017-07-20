package com.xiaoxiaomo.collection;

import java.util.*;

/**
 * 1、每一个学生（Student）都有自己的籍贯
     有属性：姓名，年龄
     注意：姓名和年龄相同则视为同一个学生，需要保证学生的唯一性。
     提示：
     1°、描述学生。
     2°、定义map容器。将学生作为键，籍贯作为值。存入。
     3°、获取map集合中的元素。要求使用map的两种获取元素的方式来获取
 * Created by xiaoxiaomo on 2012/4/5.
 */
public class Test01 {


    public static void main(String[] args) {
        Map<Student2,String> map = new HashMap<Student2,String>() ;
        map.put( new Student2("张三",23) , "重庆") ;
        map.put( new Student2("张三",23) , "重庆") ;
        map.put( new Student2("张三",23) , "重庆") ;

        for ( Map.Entry<Student2,String> entry : map.entrySet()) {
            System.out.println(entry.getKey().name+" "+entry.getKey().age+"-"+entry.getValue());
        }
    }


    static class Student2 implements Comparable<Student2>{

        private String name ;
        private Integer age ;

        @Override
        public int compareTo(Student2 o) {
            return 0;
        }

        public Student2(String name, Integer age) {
            this.name = name;
            this.age = age;
        }
    }


    /**
     * 学生
     */
    static class Student{
        private String name ;
        private Integer age ;

        public Student(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Student student = (Student) o;

            if (name != null ? !name.equals(student.name) : student.name != null) return false;
            return !(age != null ? !age.equals(student.age) : student.age != null);

        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (age != null ? age.hashCode() : 0);
            return result;
        }
    }

}
