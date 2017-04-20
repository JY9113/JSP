package edu.web.member.persistence;

import static edu.web.member.domain.MemberVO.*;

import java.util.List;

import edu.web.member.domain.MemberVO;

public interface MemberDAO {
	public static final String SQL_SELECT_ALL = "select * from " + MEMBER_TABLE;
	public static final String SQL_SELECT_BY_ID = "select * from " + MEMBER_TABLE + " where " + COL_USERID + " = ?";
	public static final String SQL_INSERT = "insert into " + MEMBER_TABLE + "(" + COL_USERID + ", " + COL_PWD + ", "
																+ COL_EMAIL + ", " + COL_ACTIVE + ") values(?, ?, ?, ?)";
	public static final String SQL_DELETE = "delete from " + MEMBER_TABLE + " where " + COL_USERID + " = ?";
	public static final String SQL_UPDATE = "update " + MEMBER_TABLE + " set " + COL_PWD + " = ?, " +
																COL_EMAIL + " = ?, " + COL_ACTIVE + " = ? where " + COL_USERID + " = ?";
	
	public abstract int insert(MemberVO vo);
	public abstract int delete(String userid);
	public abstract int update(MemberVO vo);
	public abstract List<MemberVO> selectAll();
	public abstract MemberVO selectByID(String userid);
}
