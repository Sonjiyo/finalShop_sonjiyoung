package dao;

import java.util.ArrayList;

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
}
