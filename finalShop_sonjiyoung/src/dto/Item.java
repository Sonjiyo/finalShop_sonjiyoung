package dto;

public class Item implements Comparable<Item>{
	private static int num = 1;
	private int itemNum;
	private String categoryName;
	private String itemName;
	private int price;
	
	public Item() {
		
	}

	public int getItemNum() {
		return itemNum;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public String getItemName() {
		return itemName;
	}

	public int getPrice() {
		return price;
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
	
	public String dataString() {
		return itemNum+categoryName+itemName+price+"\n";
	}

	@Override
	public String toString() {
		return "[%-3d] [%5s] [%5s] [%10d원]".formatted(itemNum,categoryName,itemName,price);
	}

	@Override
	public int compareTo(Item o) {
		if(o.categoryName.compareTo(categoryName)<0) {
			return -1;
		} else if(o.categoryName.compareTo(categoryName)>0){
			return 1;
		} else {
			return itemName.compareTo(o.itemName);
		}
	}
	
}
