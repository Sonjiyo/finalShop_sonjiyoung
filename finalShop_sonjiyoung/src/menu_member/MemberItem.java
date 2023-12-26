package menu_member;

import controller.MallController;
import mall.MenuCommand;
import util.Util;

public class MemberItem implements MenuCommand{
	private MallController mallCont;

	@Override
	public void init() {
		mallCont = MallController.getInstance();
		
	}

	@Override
	public boolean update() {

		
		return false;
	}

}
