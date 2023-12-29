package menu_member;

import controller.MallController;
import dao.CartDAO;
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
		
	}

	@Override
	public boolean update() {
		String sel = ItemDAO.getInstance().selectCategory();
		if(sel.isEmpty()) {
			mallCont.setNext("MemberMain");
			return false;
		}
		ItemDAO.getInstance().printCategoryItem(sel);
		CartDAO.getInstance().inputCartList(sel, mallCont.getLoginId());
		return false;
	}

}
