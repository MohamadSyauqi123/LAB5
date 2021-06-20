package ItemProduct;

import java.io.Serializable;

public class ItemProduct implements Serializable{

	private int itemProductId;
	private String name;
	private float price;
	
	public int getItemProductId() {
		return itemProductId;
	}
	public void setItemProductId(int itemProductId) {
		this.itemProductId = itemProductId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
}
