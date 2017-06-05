package project.spring.together.persistence;

import java.util.List;

import project.spring.together.domain.TeamVO;

public interface TeamDAO {
	List<TeamVO> selectAll(String company_name);
	String selectTeamMember(String company_name, String team_name);
}
