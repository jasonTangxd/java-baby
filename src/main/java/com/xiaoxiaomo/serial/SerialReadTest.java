package com.xiaoxiaomo.serial;

import java.io.*;

/**
 *
 * 反序列化取出对象
 *
 * Created by xiaoxiaomo on 2012/4/27.
 */
public class SerialReadTest {

    public static void main(String[] args) {

        //反序列化取出对象
        String path = "d:\\person.txt";
        ObjectInputStream inputStream = null;

        try {

            //从磁盘中读入
            inputStream = new ObjectInputStream(new FileInputStream(path));
            Person person = (Person) inputStream.readObject();

            System.out.println("Name:" + person.getName() + " Age:"+ person.getAge());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (null != inputStream)
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

    }

}
