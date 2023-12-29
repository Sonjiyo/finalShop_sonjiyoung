package dto;

public class Cart implements Comparable<Cart>{
	private static int num = 1;
	private int cartNum;
	private String id;
	private int itemNum;
	private int itemCnt;
	
	public Cart() {
	}
	public int getCartNum() {
		return cartNum;
	}
	public String getId() {
		return id;
	}
	public int getItemNum() {
		return itemNum;
	}
	public int getItemCnt() {
		return itemCnt;
	}
	
	public void setItemCnt(int itemCnt) {
		this.itemCnt += itemCnt;
	}
	public Cart(String cartNum, String id, String itemNum, String itemCnt) {
		super();
		this.cartNum = Integer.parseInt(cartNum);
		this.id = id;
		this.itemNum = Integer.parseInt(itemNum);
		this.itemCnt = Integer.parseInt(itemCnt);
		this.cartNum++;
	}

	public Cart(String id, int itemNum, int itemCnt) {
		this.cartNum=++num;
		this.id = id;
		this.itemNum = itemNum;
		this.itemCnt = itemCnt;
	}
	
	public String dataString() {
		return cartNum+"/"+id+"/"+itemNum+"/"+itemCnt+"\n";
	}
	@Override
	public int compareTo(Cart o) {
		if(itemCnt>o.itemCnt) {
			return -1;
		}else if(itemCnt<o.itemCnt) {
			return 1;
		}
		return 0;
	}
	@Override
	public String toString() {
		return "Cart [cartNum=" + cartNum + ", id=" + id + ", itemNum=" + itemNum + ", itemCnt=" + itemCnt + "]";
	}
	
}
