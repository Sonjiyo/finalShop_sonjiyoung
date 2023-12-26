package menu_admin;

import controller.MallController;
import mall.MenuCommand;
import util.Util;

public class _AdminMain implements MenuCommand {
	private MallController mallCont;

	@Override
	public void init() {
		mallCont = MallController.getInstance();
	}

	@Override
	public boolean update() {
		System.out.println("[1]회원관리 [2]상품관리 [3]게시판관리 [0]로그아웃");
		int sel = Util.getValue("입력", 0, 3);
		if(sel==0) {
			
		}else if(sel==1) {
			mallCont.setNext("AdminMember");
		} else if(sel==2) {
			mallCont.setNext("AdminItem");
		} else {
			mallCont.setNext("AdminBoard");
		}
		return false;
	}
	
	
}
