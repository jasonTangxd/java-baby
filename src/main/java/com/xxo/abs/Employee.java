package com.xxo.abs;

/**
 * Created by xiaoxiaomo on 2012/3/22.
 */
abstract class Employee {

        private int id ;

        private String name ;

        private int sex ;

        private double salary ;

        /**
         * @param arr
         */
        public abstract void work(int[] arr) ;

        /**
         */
        public void teach(){}

        public int getId() {
                return id;
        }

        public void setId(int id) {
             if( id < 0 || id > 100 )  {
                System.out.println("1-100");
             }
             else{
                this.id = id;
             }

        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public int getSex() {
                return sex;
        }

        public void setSex(int sex) {
                if( sex != 0 || sex != 1 )  {
                        System.out.println("性别错误");
                }
                else{
                        this.sex = sex;
                }
        }

        public double getSalary() {
                return salary;
        }

        public void setSalary(double salary) {
                if( salary < 12000 || salary > 30000 )  {
                        System.out.println("12000-30000");
                }
                else{
                        this.salary = salary;
                }
        }
}
