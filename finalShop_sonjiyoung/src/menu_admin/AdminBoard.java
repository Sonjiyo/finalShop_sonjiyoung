package menu_admin;

import controller.MallController;
import mall.MenuCommand;
import util.Util;

public class AdminBoard implements MenuCommand{
	private MallController mallCont;
	
	@Override
	public void init() {
		mallCont = MallController.getInstance();
		System.out.println("============[ 관리자 게시판 ]============");
		System.out.println("[1] 게시글목록\n[2] 게시글삭제\n[3] 뒤로가기\n[0] 종료");
		System.out.println("=======================");
	}

	@Override
	public boolean update() {
		int sel = Util.getValue("입력", 0, 3);
		if(sel==0) {
			return false;
		}else if(sel==1) {
			
		} else if(sel==2) {
			
		} else {
			mallCont.setNext("AdminMain");
		}
		return false;
	}

}
