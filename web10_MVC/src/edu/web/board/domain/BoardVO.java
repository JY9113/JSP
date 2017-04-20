package edu.web.board.domain;

import java.util.Date;

// VO : Value object
// DTO : Data Transfer Object
public class BoardVO {
	public static final String TABLE_NAME = "test_board";
	public static final String COL_BNO = "bno";
	public static final String COL_TITLE = "title";
	public static final String COL_CONTENT = "content";
	public static final String COL_USERID = "userid";
	public static final String COL_REGDATE = "regdate";
	
	private int bno; // 글 번호
	private String title; // 글 제목
	private String content; // 게시글
	private String userid; // 게시글 작성자 아이디
	private Date regdate; // 게시글 작성(수정) 날짜
	
	public BoardVO() {}
	
	public BoardVO(int bno, String title, String content, String userid, Date regdate) {
		super();
		this.bno = bno;
		this.title = title;
		this.content = content;
		this.userid = userid;
		this.regdate = regdate;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}	
}
