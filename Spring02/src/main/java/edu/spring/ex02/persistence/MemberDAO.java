package edu.spring.ex02.persistence;

import java.util.List;

import edu.spring.ex02.domain.MemberVO;

public interface MemberDAO {
	public abstract List<MemberVO> select_all();
	public abstract MemberVO select_by_id(String userid);
	public abstract int update(MemberVO vo);
	public abstract int delete(String userid);
	public abstract int insert(MemberVO vo);
}
