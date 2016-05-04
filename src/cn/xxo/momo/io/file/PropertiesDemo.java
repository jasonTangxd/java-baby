package cn.xxo.momo.io.file;

import java.util.Properties;

/**
 * Created by xiaoxiaomo on 2016/4/8.
 */
public class PropertiesDemo {

    public static void main(String[] args) {
        Properties properties = System.getProperties();
        properties.list(System.out);

    }
}
