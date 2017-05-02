package edu.spring.ex02.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.spring.ex02.domain.MemberVO;
import edu.spring.ex02.persistence.MemberDAO;

@Service
public class MemberServiceImple implements MemberService{
	
	@Autowired
	MemberDAO dao;

	@Override
	public List<MemberVO> read_all() {
		return dao.select_all();
	}

	@Override
	public MemberVO read_member(String userid) {
		return dao.select_by_id(userid);
	}

	@Override
	public int create_member(MemberVO vo) {
		return dao.insert(vo);
	}

	@Override
	public int update(MemberVO vo) {
		return dao.update(vo);
	}

	@Override
	public int delete(String userid) {
		return dao.delete(userid);
	}

}
