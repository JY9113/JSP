package edu.spring.ex01.domain;

public class ProductVO {
	private String pname; // 상품 이름
	private int price; // 상품 가격
	 
	public ProductVO() {}
	public ProductVO(String pname, int price) {
		this.pname = pname;
		this.price = price;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
