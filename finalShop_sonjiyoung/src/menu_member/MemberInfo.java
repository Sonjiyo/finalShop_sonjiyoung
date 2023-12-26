package menu_member;

import controller.MallController;
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
			
		} else if(sel==1) {
			mallCont.setNext("MemberShopping");
		} else {
			mallCont.setNext("MemberMain");
		}
		
		return false;
	}

}
