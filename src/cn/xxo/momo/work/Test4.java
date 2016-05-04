package cn.xxo.momo.work;

import java.util.ArrayList;

/**
 * 定义一个表示学生信息的类Student，要求如下：
 （1）类Student的成员变量：
 sNO 表示学号；sName表示姓名；sSex表示性别；sAge表示年龄；sJava：表示Java课程成绩。
 （2）类Student带参数的构造方法：
 在构造方法中通过形参完成对成员变量的赋值操作。
 （3）类Student的方法成员：
 getNo（）：获得学号；
 getName（）：获得姓名；
 getSex（）：获得性别；
 getAge（）获得年龄；
 getJava（）：获得Java 课程成绩
 （4）根据类Student的定义，创建五个该类的对象，输出每个学生的信息，计算并输出这五个学生Java语言成绩的平均值，
 以及计算并输出他们Java语言成绩的最大值和最小值。
 * Created by xiaoxiaomo on 2016/4/12.
 */
public class Test4 {


    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<Student>() ;
        students.add(new Student(12,"zhangs",1,18,99));
        students.add(new Student(11,"lishi",1,28,49));
        students.add(new Student(14,"wangwu",0,18,98));
        students.add(new Student(16,"zhaoiu",1,19,79));
        students.add(new Student(17,"qq",1,18,96));

        double[] pSjava = new double[5];
        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i).toString());
            pSjava[i] = students.get(i).getsJava() ;
        }

        System.out.println("平均值");
        double sun = 0 ;
        for (double v : pSjava) {
            sun += v ;
        }
        System.out.println(sun/5);

        //最大值
        double max = 0 ;
        for (double v : pSjava) {
            if( max < v ){
                max = v ;
            }
        }

        System.out.println(max);

        double min = pSjava[0] ;
        for (int i = 1; i < pSjava.length; i++) {
            if( min > pSjava[i] ){
                min = pSjava[i] ;
            }
        }


        System.out.println(min);



    }

    //学生
    static class Student{
        private int sNO ;
        private String sName ;
        private int sSex ;
        private int sAge ;
        private double sJava ;

        public Student(int sNO, String sName, int sSex, int sAge, double sJava) {
            this.sNO = sNO;
            this.sName = sName;
            this.sSex = sSex;
            this.sAge = sAge;
            this.sJava = sJava;
        }

        public int getsNO() {
            return sNO;
        }

        public String getsName() {
            return sName;
        }

        public int getsSex() {
            return sSex;
        }

        public int getsAge() {
            return sAge;
        }

        public double getsJava() {
            return sJava;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "sNO=" + sNO +
                    ", sName='" + sName + '\'' +
                    ", sSex=" + sSex +
                    ", sAge=" + sAge +
                    ", sJava=" + sJava +
                    '}';
        }
    }
}
