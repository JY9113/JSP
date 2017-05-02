package edu.spring.ex02.pageutil;

// ���������� ������ �������� ��ȣ�� �� ���������� ������ �Խñ��� ������ �����ϴ� Ŭ����
// 	-> paging ó���� �ʿ��� #{start}�� #{end} ��ȣ�� �� �� ����
public class PageCriteria {
	private int page; // ���� ������ ��ȣ
	private int numsPerPage; // �� �������� �Խñ� ����
	
	public PageCriteria() {
		this.page = 1;
		this.numsPerPage = 5;
	}

	public PageCriteria(int page, int numsPerPage) {
		this.page = page;
		this.numsPerPage = numsPerPage;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getNumsPerPage() {
		return numsPerPage;
	}

	public void setNumsPerPage(int numsPerPage) {
		this.numsPerPage = numsPerPage;
	}
	
	// ���� �������� �������� ���� �� �Ϸù�ȣ
	public int getStart() {
		return (this.page-1) * this.numsPerPage + 1;
	}
	
	// ���� �������� �������� ������ ���� �Ϸù�ȣ
	public int getEnd() {
		return (this.page * this.numsPerPage);		
	}

}
