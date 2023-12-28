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
		ItemDAO.getInstance().printShoppingList();
		System.out.println("=======================");
	}

	@Override
	public boolean update() {
		String sel = ItemDAO.getInstance().selectCategory();
		if(sel.isEmpty()) return false;
		ItemDAO.getInstance().printCategoryItem(sel);
		String item = Util.getValue("구매 아이템 이름 입력 : ");
		return false;
	}

}
