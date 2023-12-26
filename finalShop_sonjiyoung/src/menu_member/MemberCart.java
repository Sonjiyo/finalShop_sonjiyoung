package menu_member;

import controller.MallController;
import mall.MenuCommand;
import util.Util;

public class MemberCart implements MenuCommand{
	private MallController mallCont;

	@Override
	public void init() {
		mallCont = MallController.getInstance();
		System.out.println("============[ 구매내역 ]============");
		System.out.println("[1] 상품구매\n[2] 뒤로가기\n[0] 종료");
		System.out.println("=======================");
	}

	@Override
	public boolean update() {
		int sel = Util.getValue("입력", 0, 2);
		if(sel==0) {
			mallCont.setNext("MallMain");
		} else if(sel==1) {
			mallCont.setNext("MemberShopping");
		} else {
			mallCont.setNext("MemberMain");
		}
		
		return false;
	}

}
