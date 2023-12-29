package menu_member;

import controller.MallController;
import dao.MemberDAO;
import mall.MenuCommand;
import util.Util;

public class _MemberMain implements MenuCommand {
	private MallController mallCont;
	
	@Override
	public void init() {
		mallCont = MallController.getInstance();
		System.out.println("============[ 회원 s님 ]============");
		System.out.println("[1] 상품구매\n[2] 구매내역\n[3] 게시판\n[4] 나의 정보\n[5] 회원 탈퇴\n[6] 로그아웃\n[0] 종료");
		System.out.println("=======================");
	}

	@Override
	public boolean update() {
		int sel = Util.getValue("입력", 0, 6);
		if(sel==0) {
			if (sel == 0) {
				System.out.println("[ 프로그램 종료 ]");
				mallCont.setNext(null);
			}
		} else if(sel==1) {
			mallCont.setNext("MemberShopping");
		} else if(sel==2) {
			mallCont.setNext("MemberCart");
		} else if(sel==3) {
			mallCont.setNext("MemberBoard");
		} else if(sel==4) {
			mallCont.setNext("MemberInfo");
		} else if(sel==5){
			MemberDAO.getInstance().memberQuit(mallCont.getLoginId());
			mallCont.setNext("MallMain");
			mallCont.setLoginId(null);
		} else {
			mallCont.setNext("MallMain");
			mallCont.setLoginId(null);
		}
		
		return false;
	}

}
