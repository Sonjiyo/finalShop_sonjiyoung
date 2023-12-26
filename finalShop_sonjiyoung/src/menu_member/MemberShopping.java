package menu_member;

import controller.MallController;
import mall.MenuCommand;
import util.Util;

public class MemberShopping implements MenuCommand{
	private MallController mallCont;

	@Override
	public void init() {
		mallCont = MallController.getInstance();
		System.out.println("======== 쇼핑몰에 오신 것을 환영합니다 ========");

		System.out.println("=======================");
	}

	@Override
	public boolean update() {
		int sel = Util.getValue("입력", 0, 2);
		if(sel==0) {
			mallCont.setNext("MemberMain");
		} else if(sel==1) {
			mallCont.setNext("MemberShopping");
		} else {
			mallCont.setNext("MemberMain");
		}
		
		return false;
	}

}
