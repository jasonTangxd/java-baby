package com.xiaoxiaomo.pool.mpool;

import java.sql.Connection;
/**
 * Created by xiaoxiaomo on 2012/4/27.
 */
public class TestThreadConn implements Runnable {
    private ConnPoolImp pool;

    @Override
    public void run() {
        pool = ConnPoolManager.getInstance().getPool("testPool");
    }

    public Connection getConnection() {
        Connection conn = null;
        if (pool != null && pool.isActive()) {
            conn = pool.getConnection();
        }
        return conn;
    }

    public Connection getCurrentConnection() {
        Connection conn = null;
        if (pool != null && pool.isActive()) {
            conn = pool.getCurrentConnecton();
        }
        return conn;
    }
}
