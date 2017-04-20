package edu.web.member.domain;

public class MemberVO {
	public static final String MEMBER_TABLE = "test_member";
	public static final String COL_USERID = "userid";
	public static final String COL_PWD = "pwd";
	public static final String COL_EMAIL = "email";
	public static final String COL_ACTIVE = "active";
	
	private String userid;
	private String pwd;
	private String email;
	private String active;
	
	public MemberVO(){}

	public MemberVO(String userid, String pwd, String email, String active) {
		super();
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
