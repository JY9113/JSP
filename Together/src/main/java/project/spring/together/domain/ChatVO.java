package project.spring.together.domain;

public class ChatVO {
	
	private int chat_num;
	private String chat_file;
	private String chat_member;
	
	public ChatVO(int chat_num, String chat_file, String chat_member) {
		super();
		this.chat_num = chat_num;
		this.chat_file = chat_file;
		this.chat_member = chat_member;
	}

	public int getChat_num() {
		return chat_num;
	}

	public void setChat_num(int chat_num) {
		this.chat_num = chat_num;
	}

	public String getChat_file() {
		return chat_file;
	}

	public void setChat_file(String chat_file) {
		this.chat_file = chat_file;
	}

	public String getChat_member() {
		return chat_member;
	}

	public void setChat_member(String chat_member) {
		this.chat_member = chat_member;
	}
	
	
	
	
}
