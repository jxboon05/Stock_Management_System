
public class TV extends Product {
	
	private String type;
	private String resolution;
	private double size;
	
	//Constructor
	public TV (String productName, double price, int quantity, int itemNum,
			String type, String resolution, double size) {
		super(productName, price, quantity, itemNum);
		this.type = type;
		this.resolution = resolution;
		this.size = size;
	}
	
	//Getter
	public String getType() { return type; }
	public String getResolution() { return resolution; }
	public double getSize() { return size; }
	
	//Setter
	public void setType(String t) { type = t; }
	public void setResolution(String r) { resolution = r; }
	public void setSize(double s) { size = s; }
	
	//Methods
	@Override
	public double stockValue() {
		return InventoryValue();
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append(super.toString());
		str.append("\nScreen Type: " + type);
		str.append("\nResolution: " + resolution);
		str.append("\nDisplay Size: " + String.format("%.2f", size));
		return str.toString();
	}

}
