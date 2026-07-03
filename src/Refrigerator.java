
public class Refrigerator extends Product {

	private String doorDesign;
	private String color;
	private double capacity;
	
	//Constructor
	public Refrigerator (String productName, double price, int quantity, int itemNum,
			String doorDesign, String color, double capacity) {
		super(productName, price, quantity, itemNum);
		this.doorDesign = doorDesign;
		this.color = color;
		this.capacity = capacity;
	}
	
	//Getter
	public String getDoorDesign() { return doorDesign; }
	public String getColor() { return color; }
	public double getCapacity() { return capacity; }
	
	//Setter
	public void setDoorDesign(String doorD) { doorDesign = doorD; }
	public void setColor(String c) { color = c; }
	public void setCapacity(double c) { capacity = c; }
	
	//Methods
	@Override
	public double stockValue() {
		return InventoryValue();
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append(super.toString());
		str.append("\nDoor Design: " + doorDesign);
		str.append("\nColor: " + color);
		str.append("\nCapacity (in Litres): " + String.format("%.2f", capacity));
		return str.toString();
	}
	
}
