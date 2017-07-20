package com.xiaoxiaomo.collection;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

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
public class Test02 {


    public static void main(String[] args) {
        Map<Student,String> map = new TreeMap<Student,String>(new Comparator<Student>(){
            public int compare(Student s1, Student s2) {
                int result = s1.name.compareTo(s2.name) ;
                if( result == 0 ){
                    return s1.age.compareTo(s2.age) ;
                }
                return -1 ;
            }
        }) ;
        map.put( new Student("张三",23) , "重庆") ;
        map.put( new Student("张三",23) , "西安") ;
        map.put( new Student("李四",17) , "新疆") ;
        map.put( new Student("王五",19) , "云阳") ;
        map.put( new Student("赵六",21) , "北京") ;

//        for ( Map.Entry<Student,String> entry : map.entrySet()) {
//            System.out.println(entry.getKey().name+"-"+entry.getKey().name+"-"+entry.getValue());
//        }




        Map<Student2,String> map2 = new TreeMap<Student2,String>() ;
        map2.put( new Student2("张三",23) , "重庆") ;
        map2.put( new Student2("张三",23) , "西安") ;
        map2.put( new Student2("李四",17) , "新疆") ;
        map2.put( new Student2("王五",19) , "云阳") ;
        map2.put( new Student2("赵六",21) , "北京") ;
        for ( Map.Entry<Student2,String> entry : map2.entrySet()) {
            System.out.println(entry.getKey().name+"-"+entry.getKey().name+"-"+entry.getValue());
        }
    }


    /**
     * 学生
     */
    static class Student {
        private String name ;
        private Integer age ;

        public Student(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

//        @Override
//        public int compare(Student s1, Student s2) {
//            int result = s1.name.compareTo(s2.name) ;
//            if( result == 0 ){
//                return s1.age.compareTo(s2.age) ;
//            }
//            return -1 ;
//        }

    }


    static class Student2 {
        private String name ;
        private Integer age ;

        public Student2(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

    }


    static class MyComparator implements Comparator<Student>{

        @Override
        public int compare(Student s1, Student s2) {
            int result = s1.name.compareTo(s2.name) ;
            if( result == 0 ){
                return s1.age.compareTo(s2.age) ;
            }
            return -1 ;
        }

    }

}
