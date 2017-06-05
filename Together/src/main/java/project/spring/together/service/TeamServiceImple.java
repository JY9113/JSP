package project.spring.together.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.spring.together.domain.TeamVO;
import project.spring.together.persistence.TeamDAO;

@Service
public class TeamServiceImple implements TeamService{
	
	private static Logger logger = LoggerFactory.getLogger(TeamServiceImple.class);
	
	@Autowired
	private TeamDAO teamDao;
	
	@Override
	public List<TeamVO> read(String company_name) {
		return teamDao.selectAll(company_name);
	}
	
	@Override
	public String readTeamMember(String company_name, String team_name) {
		return teamDao.selectTeamMember(company_name, team_name);
	}
	
}
