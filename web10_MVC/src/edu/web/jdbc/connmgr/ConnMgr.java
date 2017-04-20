package edu.web.jdbc.connmgr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.OracleDriver;

// JDBC�� ����ؼ� Connection ����/������ ����ϴ� ��ƿ��Ƽ Ŭ����

public class ConnMgr {
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	public static final String USER = "scott";
	public static final String PASSWD = "tiger";
	
	private ConnMgr() {}
	public static Connection getConnection() {
		Connection conn = null;
		
		
		try {
			// JDBC ����̹��� �޸𸮿� �ε�
			DriverManager.deregisterDriver(new OracleDriver());
			
			// JDBC ����̹��� ����ؼ� connection ����
			conn = DriverManager.getConnection(URL, USER, PASSWD);		
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
		
	}
	
	public static void close(Connection conn, Statement stmt) {
		try {
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public static void close(Connection conn, Statement stmt, ResultSet rs){
		try {
			rs.close();
			close(conn, stmt);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
