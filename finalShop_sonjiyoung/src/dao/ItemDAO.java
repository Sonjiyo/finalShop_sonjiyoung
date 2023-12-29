package dao;

import java.util.ArrayList;
import java.util.stream.Collectors;

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
	
	public void printShoppingList() {
		imputCategory();
		for(int i=0; i<cateList.size(); i++) {
			System.out.printf("[%d] %s\n",i+1,cateList.get(i));
		}
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
		CartDAO.getInstance().removeItemCartList(itemList.get(idx).getItemNum());
		System.out.println("[아이템 삭제 완료]");
	}
	
	private void imputCategory() {
		for(Item i : itemList) {
			cateList.add(i.getCategoryName());
		}
		cateList = (ArrayList<String>) cateList.stream().distinct().collect(Collectors.toList());
	}
	
	public String selectCategory() {
		System.out.println("[0] 뒤로가기");
		System.out.println("=======================");
		int sel = Util.getValue("메뉴입력", 0, cateList.size())-1;
		if(sel==-1) return "";
		return cateList.get(sel);
	}
	
	public void printCategoryItem(String category) {
		int cnt = 1;
		System.out.println("[ "+category+"의 아이템 목록 ]");
		for(Item i : itemList) {
			if(i.getCategoryName().equals(category)) {
				System.out.printf("[%d] %s  %s원\n",cnt++,i.getItemName(),i.getPrice());
			}
		}
	}
	
	public int getItemNumber(String category, String item) {
		for(Item i : itemList) {
			if(i.getItemName().equals(item) && i.getCategoryName().equals(category)) {
				return i.getItemNum();
			}
		}
		return -1;
	}
	
	public int getItemPrice(int itemNum) {
		for(Item i : itemList) {
			if(i.getItemNum()==itemNum) {
				return i.getPrice();
			}
		}
		return -1;
	}
	
	public String getItemName(int itemNum) {
		for(Item i : itemList) {
			if(i.getItemNum()==itemNum) {
				return i.getItemName();
			}
		}
		return "";
	}
	
	public String getCategory(int itemNum) {
		for(Item i : itemList) {
			if(i.getItemNum()==itemNum) {
				return i.getCategoryName();
			}
		}
		return "";
	}
}
