package com.xxo.jvm;

import java.lang.ref.WeakReference;

/**
 * Created by xiaoxiaomo on 2012/7/6.
 */
public class ReferenceTest {

    public static void main(String[] args) {

        //此时 p是堆中的Person对象的引用
        Person p=new Person(1);
       // Person p2=p;
        //System.out.println(p.getId());

        //softReference引用的是p所引用的对象，跟p本身没任何关系
        // 垃圾回收只会在内存溢出前回收只被软引用引用的对象
       // SoftReference<Person> softReference=new SoftReference<Person>(p);
        //WeakReference
        //垃圾回收会只被弱引用引用的对象
        WeakReference<Person> weakReference=new WeakReference<Person>(p);
        //使p和Person对象断开 强引用
       // PhantomReference<Person> phantomReference=new PhantomReference<>(p,new ReferenceQueue<>());


        p=null;

        System.gc();

        System.out.println(weakReference.get().getId());




    }


   static class Person{

        public Person(Integer id) {
            this.id = id;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        private  Integer id;

       @Override
       protected void finalize() throws Throwable {
           System.out.println("ssss");
       }
   }
}
