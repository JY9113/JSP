package edu.web.member.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.web.dbcp.connmgr.ConnMgr;
import edu.web.member.domain.MemberVO;

public class MemberDAOImple implements MemberDAO{
	private static MemberDAOImple instance;
	
	private MemberDAOImple(){}
	
	public static MemberDAOImple getInstance() {
		if(instance == null) {
			instance = MemberDAOImple.getInstance();
		}
		return instance;
	}
	
	@Override
	public int delete(String userid) {
		System.out.println("MemberDAOImple delete() »£√‚");
		
		Connection conn = ConnMgr.getConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(SQL_DELETE);
			pstmt.setString(1, userid);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnMgr.close(conn, pstmt);
		}
		return result;
	}
	
	@Override
	public int insert(MemberVO vo) {
		Connection conn = ConnMgr.getConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(SQL_INSERT);
			pstmt.setString(1, vo.getUserid());
			pstmt.setString(2, vo.getPwd());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getActive());
			result = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return result;
	}

	@Override
	public int update(MemberVO vo) {
		Connection conn = ConnMgr.getConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(SQL_UPDATE);
			pstmt.setString(1, vo.getPwd());
			pstmt.setString(2, vo.getEmail());
			pstmt.setString(3, vo.getActive());
			pstmt.setString(4, vo.getUserid());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnMgr.close(conn, pstmt);
		}		
		return result;
	}
	
	@Override
	public List<MemberVO> selectAll() {
		Connection conn = ConnMgr.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MemberVO> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(SQL_SELECT_ALL);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String userid = rs.getString(1);
				String pwd = rs.getString(2);
				String email = rs.getString(3);
				String active = rs.getString(4);
				MemberVO vo = new MemberVO(userid, pwd, email, active);
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
	public MemberVO selectByID(String userid) {
		Connection conn = ConnMgr.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVO vo = null;
		try {
			pstmt = conn.prepareStatement(SQL_SELECT_BY_ID);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			
			if(rs != null) {
				String getUserid = rs.getString(1);
				String pwd = rs.getString(2);
				String email = rs.getString(3);
				String active = rs.getString(4);
				vo = new MemberVO(getUserid, pwd, email, active);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnMgr.close(conn, pstmt, rs);
		}
		return vo;
	}
}
