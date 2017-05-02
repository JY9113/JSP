package edu.spring.ex02.service;

import java.util.List;

import edu.spring.ex02.domain.MemberVO;

public interface MemberService {
	public abstract List<MemberVO> read_all();
	public abstract MemberVO read_member(String userid);
	public abstract int create_member(MemberVO vo);
	public abstract int update(MemberVO vo);
	public abstract int delete(String userid);
}
