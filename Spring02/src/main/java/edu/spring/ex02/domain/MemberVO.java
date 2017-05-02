package edu.spring.ex02.domain;

public class MemberVO {
	private String userid;
	private String pwd;
	private String email;
	private String active;
	
	public MemberVO() {}

	public MemberVO(String userid, String pwd, String email, String active) {
		this.userid = userid;
		this.pwd = pwd;
		this.email = email;
		this.active = active;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}
	
	

}
