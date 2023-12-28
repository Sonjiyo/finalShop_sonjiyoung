package menu_member;

import controller.MallController;
import dao.ItemDAO;
import mall.MenuCommand;
import util.Util;

public class MemberShopping implements MenuCommand{
	private MallController mallCont;

	@Override
	public void init() {
		mallCont = MallController.getInstance();
		System.out.println("======== 쇼핑몰에 오신 것을 환영합니다 ========");
		ItemDAO.getInstance().print();
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
			mallCont.setNext("MemberShopping");
		} else {
			mallCont.setNext("MemberMain");
		}
		
		return false;
	}

}
