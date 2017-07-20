package com.xiaoxiaomo.pool.mpool;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoxiaomo on 2012/4/27.
 */
public class DBInitInfo {
    public static List<DBbean>  beans = null;

    static{
        beans = new ArrayList<DBbean>();
        // 这里数据 可以从xml 等配置文件进行获取
        DBbean bean = new DBbean();
        bean.setDriverName("com.mysql.jdbc.Driver");
        bean.setUrl("jdbc:mysql:///xiaoxiaomo");
        bean.setUserName("root");
        bean.setPassword("root");

        bean.setMinConnections(5);
        bean.setMaxConnections(100);
        beans.add(bean);
    }
}
