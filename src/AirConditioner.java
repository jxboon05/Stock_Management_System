
public class AirConditioner extends Product {

	private String type;
    private double horsePower;
    private String energyRating;

    // Constructor
    public AirConditioner(String productName, double price, int quantity, int itemNum,
                          String type, double horsePower, String energyRating) {
    	super(productName, price, quantity, itemNum);
        this.type = type;
        this.horsePower = horsePower;
        this.energyRating = energyRating;
    }

    // Getter
    public String getType() { return type; }
    public double getHorsePower() { return horsePower; }
    public String getEnergyRating() { return energyRating; }
    
    //Setter
    public void setEnergyRating(String energyRating) { this.energyRating = energyRating; }
    public void setType(String type) { this.type = type; }
    public void setHorsePower(double horsePower) { this.horsePower = horsePower; }

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
		str.append("\nHorse Power (HP): " + String.format("%.2f", horsePower));
		str.append("\nEnergy Rating: " + energyRating);
		return str.toString();
    }
    
}
