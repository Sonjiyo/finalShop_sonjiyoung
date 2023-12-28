package dao;

import java.util.ArrayList;

import dto.Item;
import util.Util;

public class ItemDAO {
	private ArrayList<Item> itemList;
	private ArrayList<String> cateList;
	private ItemDAO() {
		itemList = new ArrayList<Item>();
		cateList = new ArrayList<String>();
	}
	
	private static ItemDAO instance = new ItemDAO();
	
	static public ItemDAO getInstance() {
		return instance;
	}
	
	public void print() {
		imputCategory();
		//cateList.forEach(System.out::println);
	}
	
	private void imputCategory() {
		for(Item i : itemList) {
			cateList.add(i.getCategoryName());
		}
		cateList.stream().distinct().toList().forEach(System.out::println);
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
	
	private boolean isItemListEmpty() {
		if(itemList.size()==0) {
			System.out.println("아이템이 없습니다.");
			return true;
		}
		return false;
	}
	
	private void printItemList() {
		if(isItemListEmpty()) return;
		System.out.println("====== 카테고리별 아이템 목록 ======");
		itemList.stream().sorted().forEach(System.out::println);
	}
	
	private int checkItemName(String name) {
		for(int i =0; i<itemList.size(); i++) {
			if(itemList.get(i).getItemName().equals(name)) return i;
		}
		return -1;
	}
	
	public void imputItemList() {
		printItemList();
		String name = Util.getValue("추가할 아이템 입력");
		if(checkItemName(name)!=-1) {
			System.out.println("이미 등록된 아이템입니다.");
			return;
		}
		String category = Util.getValue("카테고리 입력");
		int price = Util.getValue("가격 입력", 100, 1000000);
		itemList.add(new Item(category,name,price));
		System.out.println("[아이템 추가 완료]");
	}
	
	public void removeItemList() {
		System.out.println("[아이템 삭제 시 구매 내역이 사라집니다]");
		String name = Util.getValue("삭제할 아이템 입력");
		int idx = checkItemName(name);
		if(idx==-1) {
			System.out.println("존재하지 않는 아이템입니다.");
			return;
		}
		itemList.remove(idx);
		System.out.println("[아이템 삭제 완료]");
	}
	
}
