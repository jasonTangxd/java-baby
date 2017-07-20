package com.xiaoxiaomo.pool.mpool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Hashtable;

/**
 * Created by xiaoxiaomo on 2012/4/27.
 */
public class ConnPoolManager {

    // 连接池存放
    public Hashtable<String,ConnPoolImp> pools = new Hashtable<String, ConnPoolImp>();

    // 初始化
    private ConnPoolManager(){
        init();
    }
    // 单例实现
    public static ConnPoolManager getInstance(){
        return Singtonle.instance;
    }
    private static class Singtonle {
        private static ConnPoolManager instance =  new ConnPoolManager();
    }


    // 初始化所有的连接池
    public void init(){
        for(int i =0;i<DBInitInfo.beans.size();i++){
            DBbean bean = DBInitInfo.beans.get(i);
            ConnPool pool = new ConnPool(bean);
            if(pool != null){
                pools.put(bean.getPoolName(), pool);
                System.out.println("Info:Init connection successed ->" +bean.getPoolName());
            }
        }
    }

    // 获得连接,根据连接池名字 获得连接
    public Connection getConnection(String poolName){
        Connection conn = null;
        if(pools.size()>0 && pools.containsKey(poolName)){
            conn = getPool(poolName).getConnection();
        }else{
            System.out.println("Error:Can't find this connecion pool ->"+poolName);
        }
        return conn;
    }

    // 关闭，回收连接
    public void close(String poolName,Connection conn){
        ConnPoolImp pool = getPool(poolName);
        try {
            if(pool != null){
                pool.releaseConn(conn);
            }
        } catch (SQLException e) {
            System.out.println("连接池已经销毁");
            e.printStackTrace();
        }
    }

    // 清空连接池
    public void destroy(String poolName){
        ConnPoolImp pool = getPool(poolName);
        if(pool != null){
            pool.destroy();
        }
    }

    // 获得连接池
    public ConnPoolImp getPool(String poolName){
        ConnPoolImp pool = null;
        if(pools.size() > 0){
            pool = pools.get(poolName);
        }
        return pool;
    }
}
