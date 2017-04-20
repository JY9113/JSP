package edu.web.member.service;

import java.util.List;

import edu.web.member.domain.MemberVO;

public interface MemberService {
	
	public abstract List<MemberVO> read();
	public abstract int create(MemberVO vo);
	public abstract MemberVO read(String userid);
	public abstract int update(MemberVO vo);
	public abstract int delete(String userid);
}
