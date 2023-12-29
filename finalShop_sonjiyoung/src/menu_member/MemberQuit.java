package menu_member;

import controller.MallController;
import dao.CartDAO;
import dao.MemberDAO;
import mall.MenuCommand;
import util.Util;

public class MemberQuit implements MenuCommand{
	private MallController mallCont;

	@Override
	public void init() {
		mallCont = MallController.getInstance();
	}

	@Override
	public boolean update() {
		MemberDAO dao = MemberDAO.getInstance();

		String id = Util.getValue("아이디");
	
		if(id.equals("admin")) {
			System.out.println("어드민계정은 탈퇴할 수 없습니다.");
			mallCont.setNext("AdminMain");
			return false;
		}
		if (dao.getMemberById(id)!=-1) {
			dao.removeMember(id);
			CartDAO.getInstance().removeMemberCartList(id);
			System.out.println("[회원 탈퇴 완료]");
		} else {
			System.out.println("존재하지 않는 아이디입니다.");
		}
		mallCont.setNext("AdminMain");
		return false;
	}

}
