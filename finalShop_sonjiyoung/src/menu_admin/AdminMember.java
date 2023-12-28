package menu_admin;

import controller.MallController;
import dao.MemberDAO;
import mall.MenuCommand;
import util.Util;

public class AdminMember implements MenuCommand{
	private MallController mallCont;
	
	@Override
	public void init() {
		mallCont = MallController.getInstance();
		System.out.println("============[ 관리자 회원목록 ]============");
		System.out.println("[1] 회원목록\n[2] 회원삭제\n[3] 뒤로가기\n[0] 종료");
		System.out.println("=======================");
	}

	@Override
	public boolean update() {
		int sel = Util.getValue("입력", 0, 3);
		if(sel==0) {
			if (sel == 0) {
				System.out.println("[ 프로그램 종료 ]");
				mallCont.setNext(null);
			}
		}else if(sel==1) {
			MemberDAO.getInstance().printMemberList();
		} else if(sel==2) {
			mallCont.setNext("MemberQuit");
		} else {
			mallCont.setNext("AdminMain");
		} 
		return false;
	}

}
