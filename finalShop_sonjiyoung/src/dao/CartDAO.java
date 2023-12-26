package dao;

import java.util.ArrayList;

import dto.Board;
import dto.Cart;

public class CartDAO {
	private ArrayList<Cart> cartList;
	private CartDAO() {
		cartList = new ArrayList<Cart>();
	}
	private static CartDAO instance = new CartDAO();
	
	static public CartDAO getInstance() {
		return instance;
	}

	public void loadCartData(String data) {
		String[] dataList = data.split("\n");
		for(int i=0; i<dataList.length; i++) {
			String[] temp = dataList[i].split("/");
			cartList.add(new Cart(temp[0],temp[1],temp[2],temp[3]));
		}
		System.out.println("[cart 데이터 로드 완료]");
	}
	
	public String saveCartData() {
		String data = "";
		if(cartList.size()==0) return data;
		for(Cart c : cartList) {
			data += c.dataString();
		}
		data = data.substring(0,data.length()-1);
		return data;
	}
}
