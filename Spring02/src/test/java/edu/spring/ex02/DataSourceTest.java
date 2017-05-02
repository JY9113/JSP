package edu.spring.ex02;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class DataSourceTest {
	private static final Logger logger =
			LoggerFactory.getLogger(DataSourceTest.class);
	
	// Spring Framework�� �����ϴ� DataSource ��ü�� ���Թ���
	// root-context.xml���� bean���� ����� DataSource ��ü�� ���Թ���
	@Autowired
	private DataSource ds;
	
	@Test
	public void testDataSource() {
		Connection conn = null;
		try {
			conn = ds.getConnection();
			logger.info("DataSource ���� ����");
			
		} catch (Exception e) {
			logger.error("DataSource ���� ����: " + e.getMessage());
		} finally {
			try {
				conn.close();
				logger.info("DataSource ���� ��ȯ ����");
			} catch (Exception e) {
				logger.error("DataSource ���� ��ȯ ����: " + e.getMessage());
			}
		}
	}

} // end class DataSourceTest







