package menu_admin;

import controller.MallController;
import mall.MenuCommand;
import util.Util;

public class AdminItem implements MenuCommand{
	private MallController mallCont;
	
	@Override
	public void init() {
		mallCont = MallController.getInstance();
		System.out.println("============[ 관리자 쇼핑몰관리 ]============");
		System.out.println("[1] 아이템 추가\n[2] 아이템 삭제\n[3] 총 매출 아이템 갯수 출력(판매량 높은순으로)\n"
				+ "[4] 뒤로가기\n[0] 종료");
		System.out.println("=======================");
	}

	@Override
	public boolean update() {
		int sel = Util.getValue("입력", 0, 4);
		if(sel==0) {
			return false;
		}else if(sel==1) {
			
		} else if(sel==2) {
			
		} else if(sel==3){
			
		} else {
			mallCont.setNext("AdminMain");
		} 
		return false;
	}

}
