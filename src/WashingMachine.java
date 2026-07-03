
public class WashingMachine extends Product {
	
	private String type;
	private double loadCapacity;
	private int spinSpeed;
	
	//Constructor
	public WashingMachine (String productName, double price, int quantity, int itemNum,
			double loadCapacity, String type, int spinSpeed) {
		super(productName, price, quantity, itemNum);
		this.type = type;
		this.loadCapacity = loadCapacity;
		this.spinSpeed = spinSpeed;
	}
	
	//Getter
	public String getType() { return type; }
    public double getCapacity() { return loadCapacity; }
    public int getSpinSpeed() { return spinSpeed; }
    
    //Setter
    public void setType(String t) { type = t; }
    public void setCapacity(double c) { loadCapacity = c; }
    public void setSpinSpeed(int s) { spinSpeed = s; }
    
    //Methods
    @Override
	public double stockValue() {
		return InventoryValue();
	}
    
    @Override
    public String toString() {
		StringBuilder str = new StringBuilder();
		str.append(super.toString());
		str.append("\nType: " + type);
		str.append("\nLoad Capacity (kg): " + String.format("%.2f", loadCapacity));
		str.append("\nSpin Speed (RPM): " + spinSpeed);
		return str.toString();
    }

}
