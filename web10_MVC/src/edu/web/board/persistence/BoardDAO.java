package edu.web.board.persistence;

import java.util.List;

import edu.web.board.domain.BoardVO;
import static edu.web.board.domain.BoardVO.*;
// DAO : Data Access Object
// DB에 직접 접근하는 클래스(인터페이스) : Persistence Layer(영속 계층)
public interface BoardDAO {
	public static final String SQL_SELECT_ALL = "select * from " + TABLE_NAME + " order by " + COL_BNO + " desc";
	public static final String SQL_INSERT = "insert into " + TABLE_NAME + " (" + COL_TITLE + ", " + COL_CONTENT + ", " + COL_USERID + ")" 
																+ " values(?, ?, ?)";
	public static final String SQL_SELECT_BY_BNO = "select * from " + TABLE_NAME + " where " + COL_BNO + " = ?";
	public static final String SQL_UPDATE = "update " + TABLE_NAME + " set " + COL_TITLE + " = ?, " + COL_CONTENT + " = ?, "
																+ COL_REGDATE + " = sysdate "+ "where " + COL_BNO + " = ?";
	public static final String SQL_DELETE = "delete from " + TABLE_NAME + " where " + COL_BNO + " = ?";
	
	public abstract List<BoardVO> select(); 
	public abstract int insert(BoardVO vo);
	public abstract BoardVO selectByBNO(int bno);
	public abstract int update(BoardVO vo);
	public abstract int delete(int bno);
	
}
