
public abstract class Product {
	
	private int itemNum;
	private String productName;
	private double price;
	private int quantity;
	private boolean status = true;
	
	//Constructor
	public Product() {}
	
	public Product(String productName, double price, int quantity, int itemNum) {
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
		this.itemNum = itemNum;
	}
	
	//Getter
	public int getItemNum() { return itemNum; }
	public String getProductName() { return productName; }
	public double getPrice() { return price; }
	public int getQuantity() { return quantity; }
	public boolean getStatus() {return status; }
	
	//Setter
	public void setItemNum(int Num) { itemNum = Num; }
	public void setProductName(String name) { productName = name; }
	public void setPrice(double p) { price = p; }
	public void setQuantity(int q) { quantity = q; }
	public void setStatus(boolean s) { status = s; }
	
	//Methods
	public double InventoryValue() {
		return price * quantity;
	}
	
	public void addQuantity(int q) {
		if(status)
			quantity += q;
			
	}
	
	public void deductQuantity(int q) {
		quantity -= q;
	}
	
	public abstract double stockValue();
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("Item Number: " + itemNum);
		str.append("\nProduct Name: " + productName);
		str.append("\nQuantity Available: " + quantity);
		str.append("\nPrice (RM): " + String.format("%.2f", price));
		str.append("\nInventory Value (RM): " + String.format("%.2f", InventoryValue()));
		str.append("\nProduct Status: " + (getStatus() ? "Active" : "Discontinued"));
		return str.toString();
	}
	
}
