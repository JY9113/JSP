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
	
	private int bno; // �� ��ȣ
	private String title; // �� ����
	private String content; // �Խñ�
	private String userid; // �Խñ� �ۼ��� ���̵�
	private Date regdate; // �Խñ� �ۼ�(����) ��¥
	
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
