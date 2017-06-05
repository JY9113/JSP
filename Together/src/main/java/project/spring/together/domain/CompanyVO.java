package project.spring.together.domain;

public class CompanyVO {
	private int company_num;
	private String company_name;
	private String company_logo;
	
	
	public CompanyVO() {}	
	
	public CompanyVO(int company_num, String company_name, String company_logo) {
		super();
		this.company_num = company_num;
		this.company_name = company_name;
		this.company_logo = company_logo;
	}
	public int getCompany_num() {
		return company_num;
	}
	public void setCompany_num(int company_num) {
		this.company_num = company_num;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getCompany_logo() {
		return company_logo;
	}
	public void setCompany_logo(String company_logo) {
		this.company_logo = company_logo;
	}
}
