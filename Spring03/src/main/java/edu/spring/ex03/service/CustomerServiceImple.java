package edu.spring.ex03.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImple implements CustomerService {

	private static final Logger logger =
			LoggerFactory.getLogger(CustomerServiceImple.class);
	
	@Override
	public void createCustomer() throws Exception {
		logger.info("�� ���� ����");
		throw new Exception("�� ���� ���� ����");
	}

	@Override
	public int deleteCustomer() {
		logger.info("�� ���� ����");
		return 0;
	}
	
	@Override
	public int updateCustomer() throws Exception {
		logger.info("�� ���� ������Ʈ");
		return 1;
	}
} // end class CustomerServiceImple
