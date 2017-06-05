package project.spring.together.domain;

public class MemberVO {
	private String userid;
	private String name;
	private String pwd;
	private String team;
	private String company_num;
	private String email;
	private String chat_num;
	
	public MemberVO(){}
	
	public MemberVO(String userid, String name, String pwd, String team, String company_num, String email, String chat_num) {
		super();
		this.userid = userid;
		this.name = name;
		this.pwd = pwd;
		this.team = team;
		this.company_num = company_num;
		this.email = email;
		this.chat_num = chat_num;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getCompany_num() {
		return company_num;
	}

	public void setCompany_num(String company_num) {
		this.company_num = company_num;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getChat_num() {
		return chat_num;
	}

	public void setChat_num(String chat_num) {
		this.chat_num = chat_num;
	}

}
