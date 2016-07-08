package com.xxo.day30;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

import com.xxo.uitls.JDBCUtils;

/**
 * JDBC事务管理
 * 
 * @author xiaoxiaomo
 *
 */
public class Test3 {
	public static void main(String[] args) throws Exception {
		// 事务操作
		// Transaction1();

		// 事务操作2
//		Transaction2();

		//事务操作3
//		Transaction3();
		
		//事务操作4
		Transaction4();
		
	}

	private static void Transaction4() {
		// 获取连接
		Connection conn = null;
		Savepoint setSavepoint = null ;
		PreparedStatement pstatm = null;
		try {
			
			conn = JDBCUtils.getConnection();
			// 关闭自动提交 打开事务
			conn.setAutoCommit(false);
			setSavepoint = conn.setSavepoint();
			
			String sql = "insert into test values(null,?)" ;
			pstatm = conn.prepareStatement(sql);
			int count = 0;
			for(int i = 1 ; i<=10000 ;i++){
				if(i == 8922){
					int j = 1 / 0;
				}
				pstatm.setString(1, i+"name");
				pstatm.addBatch();
				
				if(i % 500 == 0){
					pstatm.executeBatch();
					pstatm.clearBatch();
				}
				if(i % 1000 == 0){
					pstatm.executeBatch();
					pstatm.clearBatch();
					setSavepoint = conn.setSavepoint(); //8000
				}
//				count ++;
			}
			pstatm.executeBatch();// 执行剩余记录
			// 提交事务
			conn.commit();
			
		} catch (Exception e) {
			try {
				//设置事务回滚点
				//如果失败 需要回滚
				conn.rollback(setSavepoint);
				conn.commit();  //记住设置事务回滚点时 需要提交
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			// 关闭连接
			JDBCUtils.close(conn, pstatm);
		}
	}

	private static void Transaction3() {
		// 获取连接
		Connection conn = null;
		Savepoint setSavepoint = null ;
		Statement pstatm = null;
		try {
			
			conn = JDBCUtils.getConnection();
			// 关闭自动提交 打开事务
			conn.setAutoCommit(false);
			setSavepoint = conn.setSavepoint();
			
			String sql = null;
			
			pstatm = conn.createStatement();
			
			for(int i = 0 ; i<=10000 ;i++){
				if(i == 8922){
					int j = 1 / 0;
				}
				sql = "insert into test values(null,'"+i+"name')" ;
				
				pstatm.addBatch(sql);
				
				if(i % 500 == 0){
					pstatm.executeBatch();
					pstatm.clearBatch();
				}
				
				if(i % 1000 == 0){
					setSavepoint = conn.setSavepoint(); //8000
					pstatm.clearBatch();
				}
				
			}
			// 提交事务
			conn.commit();
			
		} catch (Exception e) {
			try {
				//设置事务回滚点
				//如果失败 需要回滚
				conn.rollback(setSavepoint);
				conn.commit();  //记住设置事务回滚点时 需要提交
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			// 关闭连接
			JDBCUtils.close(conn, pstatm);
		}

	}

	private static void Transaction2() {
		// 获取连接
		Connection conn = null;
		Statement statm = null;

		try {
			
			conn = JDBCUtils.getConnection();
			// 关闭自动提交 打开事务
			conn.setAutoCommit(false);
			statm = conn.createStatement();

			String sql1 = "update account set money = money - 100 where name='zhangsan'";
			statm.executeUpdate(sql1);
			
			//手动制造错误
			int i = 1 / 0;
			
			String sql2 = "update account set money = money + 100 where name='lisi'";
			statm.executeUpdate(sql2);
			
			// 提交事务
			conn.commit();
			
		} catch (Exception e) {
			try {
				//如果失败 需要回滚
				conn.rollback();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			// 关闭连接
			JDBCUtils.close(conn, statm);
		}

	}

	private static void Transaction1() throws SQLException {
		// 获取连接
		Connection conn = JDBCUtils.getConnection();
		Statement statm = conn.createStatement();

		// 关闭自动提交 打开事务
		conn.setAutoCommit(false);

		String sql = "update account set money = money - 100 where name='zhangsan'";
		int b = statm.executeUpdate(sql);
		System.out.println(b);

		// 提交事务
		conn.commit();

		// 关闭连接
		JDBCUtils.close(conn, statm);
	}
}
