package edu.spring.ex03.service;

public interface CustomerService {

	public abstract void createCustomer() throws Exception;
	public abstract int deleteCustomer();
	public abstract int updateCustomer() throws Exception;

} // end interface CustomerService
