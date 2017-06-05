package project.spring.together.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import project.spring.together.domain.TeamVO;

public interface TeamService {	
	List<TeamVO> read(String company_name);
	String readTeamMember(String company_name, String team_name);
}

