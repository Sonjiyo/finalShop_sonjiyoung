package menu_member;

import controller.MallController;
import dao.BoardDAO;
import mall.MenuCommand;
import util.Util;

public class MemberBoard implements MenuCommand{
	private MallController mallCont;
	
	@Override
	public void init() {
		mallCont = MallController.getInstance();
		System.out.println("============[ 게시판 ]============");
		System.out.println("[1] 게시글보기\n[2] 게시글추가\n[3] 내게시글(삭제)\n[4] 뒤로가기\n[0] 종료");
		System.out.println("=======================");
	}

	@Override
	public boolean update() {
		int sel = Util.getValue("입력", 0, 4);
		if(sel==0) {
			if (sel == 0) {
				System.out.println("[ 프로그램 종료 ]");
				mallCont.setNext(null);
			}
		} else if(sel==1) {
			BoardDAO.getInstance().printBoard();
		} else if(sel==2) {
			BoardDAO.getInstance().inputBoard(mallCont.getLoginId());
		} else if(sel==3) {
			BoardDAO.getInstance().printMemberBoard(mallCont.getLoginId());
		} else {
			mallCont.setNext("MemberMain");
		}
		
		return false;
	}

}
