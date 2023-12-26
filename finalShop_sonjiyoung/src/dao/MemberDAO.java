package dao;

import java.util.ArrayList;

import dto.Member;


public class MemberDAO {
	private ArrayList<Member> memberList;
	private MemberDAO() {
		memberList = new ArrayList<Member>();
	}
	private static MemberDAO instance = new MemberDAO();
	
	static public MemberDAO getInstance() {
		return instance;
	}

	public void loadMemberData(String data) {
		String[] dataList = data.split("\n");
		for(int i=0; i<dataList.length; i++) {
			String[] temp = dataList[i].split("/");
			memberList.add(new Member(temp[1],temp[2],temp[3]));
		}
		System.out.println("[member 데이터 로드 완료]");
	}
	
	public String saveMemberData() {
		String data = "";
		if(memberList.size()==0) return data;
		for(Member m : memberList) {
			data += m.dataString();
		}
		data = data.substring(0,data.length()-1);
		return data;
	}
	
	public boolean insertMember(String id, String pw, String name) {
		int num = memberList.get(memberList.size()-1).getMemberNum()+1;
		memberList.add(new Member(num+"",id,pw,name));
		return true;
	}
	
	public int getMemberById(String id) {
		for(int i=0; i<memberList.size(); i++) {
			if(memberList.get(i).getId().equals(id)) {
				return i;
			}
		}
		return -1;
	}

	public boolean isValidMember(String id, String pw) {
		for(Member m : memberList) {
			if(m.getId().equals(id) && m.getPw().equals(pw)) {
				return true;
			}
		}
		return false;
	}

	public void removeMember(String id) {
		memberList.remove(getMemberById(id));
	}
}
