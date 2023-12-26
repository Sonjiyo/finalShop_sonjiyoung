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

	public void loadItemData(String data) {
		String[] dataList = data.split("\n");
		for(int i=0; i<dataList.length; i++) {
			String[] temp = dataList[i].split("/");
			itemList.add(new Item(temp[0],temp[1],temp[2],temp[3]));
		}
		System.out.println("[item 데이터 로드 완료]");
	}
	
	public String saveItemData() {
		String data = "";
		if(itemList.size()==0) return data;
		for(Item i : itemList) {
			data += i.dataString();
		}
		data = data.substring(0,data.length()-1);
		return data;
	}
}
