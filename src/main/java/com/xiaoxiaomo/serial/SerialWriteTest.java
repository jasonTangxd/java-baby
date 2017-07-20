package com.xiaoxiaomo.serial;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 序列化测试
 * <p>
 * Created by xiaoxiaomo on 2012/4/27.
 */
public class SerialWriteTest {
    public static void main(String[] args) {

        //实现序列化
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("d:\\person.txt"));
            Person person = new Person("person", 25);
            oos.writeObject(person);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != oos) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


/**
 * 序列化测试用对象
 */
class Person implements Serializable {

    private static final long serialVersionUID = -6412852654889352693L;

    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
