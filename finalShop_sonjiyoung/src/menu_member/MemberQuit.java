package menu_member;

import controller.MallController;
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
		String pw = Util.getValue("비밀번호");
	
		if (dao.isValidMember(id, pw)) {
			dao.removeMember(id);
			System.out.println("[회원 탈퇴 완료]");
		} else {
			System.err.println("아이디 혹은 비밀번호를 확인해주세요");
			mallCont.setNext("MallMain");
		}
		return false;
	}

}
