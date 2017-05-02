package edu.spring.ex02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import oracle.jdbc.OracleDriver;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class OracleJDBCTest {
	private static final Logger logger =
			LoggerFactory.getLogger(OracleJDBCTest.class);
	
	// Oracle JDBC ������ ���ؼ� �ʿ��� ����
	private static final String URL =
			"jdbc:oracle:thin:@localhost:1521:XE";
	private static final String USER = "scott";
	private static final String PASSWORD = "tiger";
	
	@Test
	public void testOracleConnect() {
		Connection conn = null;
		try {
			// JDBC ���̺귯���� �ε�
			DriverManager.registerDriver(new OracleDriver());
			// Connection ����
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			logger.info("Oracle ���� ����");
			
		} catch (Exception e) {
			logger.error("Oracle ���� ����: " + e.getMessage());
		} finally {
			try {
				conn.close();
				logger.info("Oracle ���� ���� ����");
			} catch (Exception e) {
				logger.error("Oracle ���� ���� ����: " + e.getMessage());
			}
		}
		
	}
	
} // end class OracleJDBCTest