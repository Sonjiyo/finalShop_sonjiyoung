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

	public boolean insertMember(String id, String pw, String name) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public Object getMemberById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object isValidMember(String id, String pw) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
