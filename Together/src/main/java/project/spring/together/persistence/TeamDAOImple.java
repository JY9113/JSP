package project.spring.together.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import project.spring.together.domain.CompanyVO;
import project.spring.together.domain.TeamVO;


@Repository
public class TeamDAOImple implements TeamDAO{
	
	private static final String NAMESPACE = "project.spring.together.TeamMapper";
	private static final Logger logger = LoggerFactory.getLogger(TeamDAOImple.class);
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<TeamVO> selectAll(String company_name) {
		CompanyVO vo = new CompanyVO();
		vo.setCompany_name(company_name);
		return sqlSession.selectList(NAMESPACE + ".select_team_all", vo);
	}
	
	@Override
	public String selectTeamMember(String company_name, String team_name) {
		CompanyVO vo = new CompanyVO();
		vo.setCompany_name(company_name);
		return sqlSession.selectOne(NAMESPACE + ".get_member", vo);
	}
}
