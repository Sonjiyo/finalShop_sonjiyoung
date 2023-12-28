package menu_admin;

import controller.MallController;
import dao.FileDAO;
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
		System.out.println("[1] 회원관리\n[2] 상품관리\n[3] 게시판관리\n[4] 로그아웃\n[5] 파일저장\n[0] 종료");
		int sel = Util.getValue("입력", 0, 5);
		if(sel==0) {
			if (sel == 0) {
				System.out.println("[ 프로그램 종료 ]");
				mallCont.setNext(null);
			}
		}else if(sel==1) {
			mallCont.setNext("AdminMember");
		} else if(sel==2) {
			mallCont.setNext("AdminItem");
		} else if(sel==3){
			mallCont.setNext("AdminBoard");
		} else if(sel==4) {
			mallCont.setNext("MallMain");
			mallCont.setLoginId(null);
		} else {
			FileDAO.saveAllFiles();
		}
		return false;
	}
	
	
}
