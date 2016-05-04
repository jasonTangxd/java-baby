package cn.xxo.momo.io.file;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 加载一个配置文件
 * Created by xiaoxiaomo on 2016/4/8.
 */
public class GetProperties {

    Properties prop = null ;
    FileInputStream inputStream = null ;
    //1. 创建一个构造函数，用于加载配置
    GetProperties(String pathname){
        try {

            //2. 实例化一个Properties
            prop= new Properties() ;
//            GetProperties.class.getResourceAsStream(pathname) ;

            //3. 加载一个配置（配置需要一个输入字节流）
            inputStream = new FileInputStream(pathname);
            prop.load(inputStream);
        } catch (IOException e) {
            System.out.println("加载配置失败！");
            throw new RuntimeException( pathname + " is error! ");
        } finally {

            //关闭流
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    //TODO 自己处理
                    System.err.println("关闭流异常！");
                }
            }
        }
    }

    //TEST
    static class GetPropertiesTest{
        public static void main(String[] args) {
            //实例化
            GetProperties properties = new GetProperties("test.properties");
            //获取properties
            Properties prop = properties.prop;
            //获取一个配置
            System.out.println(prop.getProperty("aaa"));
        }
    }
}

