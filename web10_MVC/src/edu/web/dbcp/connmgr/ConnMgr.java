package edu.web.dbcp.connmgr;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

// DBCP�� ����� Connection ����/���� ��ƿ��Ƽ Ŭ����
public class ConnMgr {
	
	private ConnMgr() {}
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Context initContext = new InitialContext();
			Context envContext =
					(Context) initContext.lookup("java:comp/env");
			DataSource ds = 
					(DataSource) envContext.lookup("dbcp/oraclexe");
			conn = ds.getConnection();
			System.out.println("DBCP ���� ����!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public static void close(Connection conn, Statement stmt) {
		try {
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			rs.close();
			close(conn, stmt);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}







