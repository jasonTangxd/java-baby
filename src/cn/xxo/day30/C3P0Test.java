package cn.xxo.day30;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

/**
 * c3p0连接池用法
 * @author gs
 *
 */
public class C3P0Test {
	public static void main(String[] args) throws Exception {
		
//		c3p0Test1();
		
		c3p0Test2();

		c3p0Test3();
	}

	private static void c3p0Test3() throws SQLException {
//		ComboPooledDataSource source = new ComboPooledDataSource("xrxy");
//		Connection connection = source.getConnection();
//		Statement statement = connection.createStatement();
//		int i = statement.executeUpdate("delete from student where name = 'zhangsan'");
//		if( i==1 ){
//			System.out.println("成功");
//		}
//		statement.close();

		ComboPooledDataSource source = new ComboPooledDataSource("xrxy") ;
		QueryRunner runner = new QueryRunner(source);

		Student query = runner.query("", new BeanHandler<Student>(Student.class));


	}


	private static void c3p0Test2() throws Exception {
//		ComboPooledDataSource cpds = new ComboPooledDataSource();
		ComboPooledDataSource cpds = new ComboPooledDataSource("crxy");
		Connection conn = cpds.getConnection();

		Statement statm = conn.createStatement();
		ResultSet rs = statm.executeQuery("select * from student");
		
		while(rs.next()){
			System.out.print(rs.getString(1));
			System.out.print(" | ");
			System.out.print(rs.getString(2));
			System.out.print(" | ");
			System.out.print(rs.getString(3));
			System.out.print(" | ");
			System.out.print(rs.getString(4));
			System.out.println(" | ");
			
		}
		rs.close();
		statm.close();
		conn.close();
	}

	private static void c3p0Test1() throws Exception {
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		cpds.setDriverClass( "com.mysql.jdbc.Driver" ); //loads the jdbc driver            
		cpds.setJdbcUrl( "jdbc:mysql:///crxy" );
		cpds.setUser("root");                                  
		cpds.setPassword("123");
		
		Connection conn = cpds.getConnection();
		Statement statm = conn.createStatement();
		ResultSet rs = statm.executeQuery("select * from student");
		
		while(rs.next()){
			System.err.print(rs.getString(1));
			System.err.print(" | ");
			System.err.print(rs.getString(2));
			System.err.print(" | ");
			System.err.print(rs.getString(3));
			System.err.print(" | ");
			System.err.print(rs.getString(4));
			System.err.println(" | ");
			
		}
		rs.close();
		statm.close();
		conn.close();
		
		
	}
}
