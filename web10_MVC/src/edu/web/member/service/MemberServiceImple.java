package edu.web.member.service;

import java.util.List;

import edu.web.member.domain.MemberVO;
import edu.web.member.persistence.MemberDAO;
import edu.web.member.persistence.MemberDAOImple;

public class MemberServiceImple implements MemberService{
	private static MemberServiceImple instance;
	private MemberDAO dao;
	
	
	private MemberServiceImple() {
		dao = MemberDAOImple.getInstance();
	}
	public static MemberServiceImple getInstance() {
		if(instance == null ) {
			instance = MemberServiceImple.getInstance();
		}
		return instance;
	}
	
	@Override
	public int create(MemberVO vo) {
		return dao.insert(vo);
	}
	
	@Override
	public int delete(String userid) {
		return dao.delete(userid);
	}
	
	@Override
	public List<MemberVO> read() {
		List<MemberVO> list = dao.selectAll();
		
		return list;
	}
	
	@Override
	public MemberVO read(String userid) {
		return dao.selectByID(userid);
	}
	
	@Override
	public int update(MemberVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}
}
