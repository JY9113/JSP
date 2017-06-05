package project.spring.together.domain;

public class TeamVO {
	private String team_name;
	private String team_master;
	private String team_member;
	private int team_num;
	
	public TeamVO(){}
	
	public TeamVO(String team_name, String team_master, String team_member, int team_num) {
		super();
		this.team_name = team_name;
		this.team_master = team_master;
		this.team_member = team_member;
		this.team_num = team_num;
	}

	public String getTeam_name() {
		return team_name;
	}

	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}

	public String getTeam_master() {
		return team_master;
	}

	public void setTeam_master(String team_master) {
		this.team_master = team_master;
	}

	public String getTeam_member() {
		return team_member;
	}

	public void setTeam_member(String team_member) {
		this.team_member = team_member;
	}

	public int getTeam_num() {
		return team_num;
	}

	public void setTeam_num(int team_num) {
		this.team_num = team_num;
	}
}
