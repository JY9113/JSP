package edu.web.jdbc.connmgr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.OracleDriver;

// JDBC를 사용해서 Connection 설정/해제를 담당하는 유틸리티 클래스

public class ConnMgr {
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	public static final String USER = "scott";
	public static final String PASSWD = "tiger";
	
	private ConnMgr() {}
	public static Connection getConnection() {
		Connection conn = null;
		
		
		try {
			// JDBC 드라이버를 메모리에 로드
			DriverManager.deregisterDriver(new OracleDriver());
			
			// JDBC 드라이버를 사용해서 connection 설정
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
