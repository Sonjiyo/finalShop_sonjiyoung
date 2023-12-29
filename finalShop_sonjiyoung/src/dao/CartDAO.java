package dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

import dto.Board;
import dto.Cart;
import util.Util;

public class CartDAO {
	private ArrayList<Cart> cartList;
	private CartDAO() {
		cartList = new ArrayList<Cart>();
	}
	private static CartDAO instance = new CartDAO();
	
	static public CartDAO getInstance() {
		return instance;
	}

	private void mergeCartList() {
		for(int i =0 ; i<cartList.size(); i++) {
			for(int j=0; j<cartList.size(); j++) {
				if(cartList.get(i).getItemNum()==cartList.get(j).getItemNum() &&
						cartList.get(i).getId().equals(cartList.get(j).getId()) && i!=j) {
					cartList.get(i).setItemCnt(cartList.get(j).getItemCnt());
					cartList.remove(j);
					j-=1;
				}
			}
		}
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
	
	public void inputCartList(String category, String id) {
		while(true) {
			String item = Util.getValue("구매 아이템 이름 입력");
			int itemNum = ItemDAO.getInstance().getItemNumber(category,item);
			if(itemNum==-1) {
				System.out.println("아이템 이름 오류 다시 입력 해주세요");
				continue;
			}
			int itemCnt = Util.getValue("아이템 구매 수량 입력", 1, 100);
			
			cartList.add(new Cart(id,itemNum,itemCnt));
			System.out.println("[ "+item+" "+itemCnt+"개 구매 완료 ]");
			return;
		}
	}
	
	public void printMyCartList(String id) {
		mergeCartList();
		int num = 1;
		int cnt = 0;
		int totalMoney = 0;
		for(Cart c : cartList) {
			if(c.getId().equals(id)) {
				String itemName = ItemDAO.getInstance().getItemName(c.getItemNum());
				int itemPrice = ItemDAO.getInstance().getItemPrice(c.getItemNum());
				cnt += c.getItemCnt();
				totalMoney += c.getItemCnt()*itemPrice;
				System.out.printf("[%3d]%8s(%7d원)%8d개 총 %d원\n",
						num++,itemName,itemPrice,c.getItemCnt(),c.getItemCnt()*itemPrice);
			}
		}
		if(cnt==0) {
			System.out.println("구매내역이 없습니다. 구매해주세요.");
			return;
		}
		System.out.println("=======================");
		System.out.println("총 "+cnt+"개 ( "+totalMoney+"원 )");
	}
	
	public void printCartList() {
		System.out.println("========== 판매된 아이템 목록 ==========");
		ArrayList<Cart> copy = new ArrayList<Cart>();
		
		for(Cart c :cartList) {
			copy.add(new Cart(c.getCartNum()+"",c.getId(),c.getItemNum()+"",c.getItemCnt()+""));
		}
		
		
		for(int i =0; i<copy.size(); i++) {
			for(int j=0; j<copy.size(); j++) {
				if(i!=j && copy.get(i).getItemNum()==copy.get(j).getItemNum()) {
					copy.get(i).setItemCnt(copy.get(j).getItemCnt());
					copy.remove(j);
					j-=1;
				}
			}
		}
		copy = (ArrayList<Cart>) copy.stream()
				.sorted()
				.collect(Collectors.toList());
		int num = 1;
		for(Cart c : copy) {
			String itemName = ItemDAO.getInstance().getItemName(c.getItemNum());
			String category = ItemDAO.getInstance().getCategory(c.getItemNum());
			int itemPrice = ItemDAO.getInstance().getItemPrice(c.getItemNum());
			System.out.printf("[%-3d] [%5s] [%5s] [%10d원] %-1d개\n",
					num++,category,itemName,itemPrice,c.getItemCnt());
		}
	}
	
	public void removeMemberCartList(String id) {
		cartList = (ArrayList<Cart>) cartList.stream()
							.filter(cart->!cart.getId().equals(id))
							.collect(Collectors.toList());
		System.out.println("[ 구매내역에서 회원 삭제 완료 ] ");
	}
	
	public void removeItemCartList(int itemNum) {
		cartList = (ArrayList<Cart>) cartList.stream()
							.filter(cart->cart.getItemNum()!=itemNum)
							.collect(Collectors.toList());
		System.out.println("[ 구매내역에서 아이템 삭제 완료 ] ");
	}
}
