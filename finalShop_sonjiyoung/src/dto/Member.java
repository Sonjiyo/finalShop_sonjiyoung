package dto;

public class Member {
	private int memberNum;
	private String id;
	private String pw;
	private String memberName;
	
	public Member() {
		
	}

	public Member(String id, String pw, String memberName) {
		super();
		this.id = id;
		this.pw = pw;
		this.memberName = memberName;
	}

	public Member(String memberNum, String id, String pw, String memberName) {
		super();
		this.memberNum = Integer.parseInt(memberName);
		this.id = id;
		this.pw = pw;
		this.memberName = memberName;
	}
	
	
}
