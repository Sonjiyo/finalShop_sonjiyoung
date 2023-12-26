package dto;

public class Cart {
	private static int num;
	private int cartNum;
	private String id;
	private int itemNum;
	private int itemCnt;
	
	public Cart() {
		
	}

	public Cart(String cartNum, String id, String itemNum, String itemCnt) {
		super();
		this.cartNum = Integer.parseInt(cartNum);
		this.id = id;
		this.itemNum = Integer.parseInt(itemNum);
		this.itemCnt = Integer.parseInt(itemCnt);
		this.cartNum++;
	}

	public Cart(String id, int itemNum) {
		this.cartNum=++num;
		this.id = id;
		this.itemNum = itemNum;
	}
	
	
}
