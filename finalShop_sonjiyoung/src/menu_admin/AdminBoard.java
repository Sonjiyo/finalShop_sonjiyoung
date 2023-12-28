package menu_admin;

import controller.MallController;
import dao.BoardDAO;
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
			if (sel == 0) {
				System.out.println("[ 프로그램 종료 ]");
				mallCont.setNext(null);
			}
		}else if(sel==1) {
			BoardDAO.getInstance().printBoard();
		} else if(sel==2) {
			BoardDAO.getInstance().removeBoard(mallCont.getLoginId());
		} else {
			mallCont.setNext("AdminMain");
		}
		return false;
	}

}
