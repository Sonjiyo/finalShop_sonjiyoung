package menu_member;

import controller.MallController;
import dao.CartDAO;
import mall.MenuCommand;
import util.Util;

public class MemberCart implements MenuCommand{
	private MallController mallCont;

	@Override
	public void init() {
		mallCont = MallController.getInstance();
		System.out.println("============[ 구매내역 ]============");
		System.out.println("[1] 쇼핑하기\n[2] 뒤로가기\n[0] 종료");
		System.out.println("=======================");
		CartDAO.getInstance().printMyCartList(mallCont.getLoginId());
		
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
			mallCont.setNext("MemberShopping");
		} else {
			mallCont.setNext("MemberMain");
		}
		
		return false;
	}

}
