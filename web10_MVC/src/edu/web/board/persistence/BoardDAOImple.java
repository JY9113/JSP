package edu.web.board.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.web.board.domain.BoardVO;
import edu.web.dbcp.connmgr.ConnMgr;

public class BoardDAOImple implements BoardDAO {
	
	private static BoardDAOImple instance;
	
	private BoardDAOImple() {}
	public static BoardDAOImple getInstance() {
		if (instance == null) {
			instance = new BoardDAOImple();
		}
		
		return instance;
	}
	
	@Override
	public List<BoardVO> select() {
		System.out.println("BoardDAO.select() 호출");
		List<BoardVO> list = new ArrayList<>();
		
		// JDBC/DBCP 이용해서 DB에서 데이터 읽어오고 ArrayList return
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		conn = ConnMgr.getConnection();
		try {
			pstmt = conn.prepareStatement(SQL_SELECT_ALL);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int bno = rs.getInt(1);
				String title = rs.getString(2);
				String content = rs.getString(3);
				String userid = rs.getString(4);
				Date regdate = rs.getTimestamp(5); 
				
				// java.util.Date
				// |__java.sql.Timestamp
				
				BoardVO vo = new BoardVO(bno, title, content, userid, regdate);
				list.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnMgr.close(conn, pstmt, rs);
		}
			
		return list;
	}
	
	@Override
	public int insert(BoardVO vo) {
		System.out.println("BoardDAO insert() 호출");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		conn = ConnMgr.getConnection();
		try {
			pstmt = conn.prepareStatement(SQL_INSERT);
			
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2,  vo.getContent());
			pstmt.setString(3,  vo.getUserid());
			
			result = pstmt.executeUpdate();			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			ConnMgr.close(conn, pstmt);
		}	
		
		return result;
	}

	@Override
	public BoardVO selectByBNO(int bno) {
		System.out.println("BoardDAO selectByBNO() 호출");
		
		BoardVO vo = null;
		Connection conn = ConnMgr.getConnection();
		PreparedStatement pstmt = null;		
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(SQL_SELECT_BY_BNO);
			pstmt.setInt(1, bno);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int no = rs.getInt(1);
				String title = rs.getString(2);
				String content = rs.getString(3);
				String userid = rs.getString(4);
				Date regdate = rs.getTimestamp(5); 
				vo = new BoardVO(no, title, content, userid, regdate);
			}	
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnMgr.close(conn, pstmt, rs);
		}
		return vo;
	}
	
	@Override
	public int update(BoardVO vo) {
		System.out.println("BoardDAO update() 호출");
		
		Connection conn = ConnMgr.getConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(SQL_UPDATE);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getBno());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnMgr.close(conn, pstmt);		
		}
		return result;
	}
	
	@Override
	public int delete(int bno) {
		System.out.println("BoardDAO delete() 호출");
		
		Connection conn = ConnMgr.getConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(SQL_DELETE);
			pstmt.setInt(1, bno);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnMgr.close(conn, pstmt);
			
		}		
		return result;
	}
	
	
}
