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
			instance = new MemberServiceImple();
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
	public int update(MemberVO vo) {
		return dao.update(vo);
	}
	
	@Override
	public boolean loginCheck(String id, String pw) {
		MemberVO vo = dao.checkIdPW(id, pw);
		if(vo != null) {
			return true;
		} else {
			return false;
		}
	}
}
