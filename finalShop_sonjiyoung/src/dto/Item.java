package dto;

public class Item {
	private static int num;
	private int itemNum;
	private String categoryName;
	private String itemName;
	private int price;
	
	public Item() {
		
	}

	public Item(String itemNum, String categoryName, String itemName, String price) {
		this.itemNum = Integer.parseInt(itemNum);
		this.categoryName = categoryName;
		this.itemName = itemName;
		this.price = Integer.parseInt(price);
		num++;
	}

	public Item(String categoryName, String itemName, int price) {
		this.itemNum=++num;
		this.categoryName = categoryName;
		this.itemName = itemName;
		this.price = price;
	}
	
	
}
