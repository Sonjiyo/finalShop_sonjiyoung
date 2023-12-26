package dao;

import java.util.ArrayList;

import dto.Item;

public class ItemDAO {
	private ArrayList<Item> itemList;
	private ItemDAO() {
		itemList = new ArrayList<Item>();
	}
	private static ItemDAO instance = new ItemDAO();
	
	static public ItemDAO getInstance() {
		return instance;
	}
}
