package dto;

public class Member {
	private static int num = 1000;
	private int memberNum;
	private String id;
	private String pw;
	private String memberName;
	
	public Member() {
	}
	
	public Member(String id, String pw, String memberName) {
		this.memberNum = num++;
		this.id = id;
		this.pw = pw;
		this.memberName = memberName;
	}
	
	public Member(String memberNum, String id, String pw, String memberName) {
		super();
		this.memberNum = Integer.parseInt(memberNum);
		this.id = id;
		this.pw = pw;
		this.memberName = memberName;
		num++;
	}
	
	public String dataString() {
		return memberNum+"/"+id+"/"+pw+"/"+memberName+"\n";
	}

	public int getMemberNum() {
		return memberNum;
	}
	public String getId() {
		return id;
	}
	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getMemberName() {
		return memberName;
	}

	@Override
	public String toString() {
		return "[%-5d] [%10s] [%10s] [%10s]".formatted(memberNum,id,pw,memberName);
	}
	
}
