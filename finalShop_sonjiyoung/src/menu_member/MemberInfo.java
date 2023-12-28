package menu_member;

import controller.MallController;
import dao.MemberDAO;
import mall.MenuCommand;
import util.Util;

public class MemberInfo implements MenuCommand{
	private MallController mallCont;

	@Override
	public void init() {
		mallCont = MallController.getInstance();
		System.out.println("============[ 내정보 ]============");
		System.out.println("[1] 비밀번호변경\n[2] 뒤로가기\n[0] 종료");
		System.out.println("=======================");
	}

	@Override
	public boolean update() {
		int sel = Util.getValue("입력", 0, 2);
		if(sel==0) {
			if (sel == 0) {
				System.out.println("[ 프로그램 종료 ]");
				mallCont.setNext(null);
			}
		} else if(sel==1) {
			MemberDAO.getInstance().changePw(mallCont.getLoginId());
		} else {
			mallCont.setNext("MemberMain");
		}
		
		return false;
	}

}
