import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.InputMismatchException; 
import java.io.IOException; 

public class StockManagement {
	
	private static int maxProducts;
	private static UserInfo user = new UserInfo();
	
	public static void main(String[] args) throws IOException { 
		Scanner scanner = new Scanner(System.in);
		String[] members = {"Boon Jia Xuan", "Lee Jia Xuan", "Leow Hui Yu", "Tan Yi Hui"};
		
		LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy | HH:mm:ss");
        String formattedDate = now.format(formatter);
        
        System.out.println("=============================================");
        System.out.println("              WELCOME TO THE SMS             ");
        System.out.println("=============================================");
        System.out.println("Current Date/Time: " + formattedDate);
        System.out.println("\nDeveloped by Group Members:");
        for (int i = 0; i < members.length; i++) {
            System.out.println((i + 1) + ". " + members[i]);
        }
        System.out.println("---------------------------------------------");
        user.inputName();
        
        int wish = -1;
        while (wish != 1 && wish != 0) {
            try {
                System.out.print("Do you wish to add product? (1- YES/ 0 - NO, EXIT): ");
                wish = scanner.nextInt();
                if (wish != 1 && wish != 0)
                    System.out.println("Please enter only 1 or 0!");
            } catch (InputMismatchException ex) {
                System.out.println("Error: Incorrect input. An integer (0 or 1) is required.");
                scanner.nextLine();
            }
        }
        
        if (wish == 0) {
            exit();
            return;
        }
        
        maxProducts = getNumProducts(scanner);
        Product[] products = new Product[maxProducts];
        addProduct(products, scanner);
        
        int choice = -1;
        do {
            try {
                choice = displayMenu(scanner);
                executeChoice(choice, products, scanner);
            } catch (InputMismatchException ex) {
                System.out.println("Error: Please select a numeric option from the menu.");
                scanner.nextLine();
            }
        } while (choice != 0);
        
        scanner.close();
	}
	
	public static int getNumProducts(Scanner sc) {
        int n = -1;
        while (n < 0) {
            try {
                System.out.print("Enter the maximum number of products to store: ");
                n = sc.nextInt();
                if (n < 0) {
                    System.out.println("Invalid input. Please enter 0 or a positive number.");
                }
            } catch (InputMismatchException ex) {
                System.out.println("Error: Integer required for product count.");
                sc.nextLine(); 
            }
        }
        return n;
    }
	
	public static void addProduct(Product[] products, Scanner sc) {
	    int[] array = new int[maxProducts];
		for(int i = 0; i < maxProducts; i++) {
			int choice = -1;
		    while (choice < 1 || choice > 4) {
                try {
                    System.out.println("\nSelect Product Type to Add for slot " + (i + 1) + ":");
                    System.out.println("1. Refrigerator");
                    System.out.println("2. TV");
                    System.out.println("3. Washing Machine");
                    System.out.println("4. Air Conditioner");
                    System.out.print("Enter choice (1/2/3/4): ");
                    choice = sc.nextInt();
                    
                    if (choice < 1 || choice > 4)
                        System.out.println("Only number 1 - 4 allowed!");
                    else
                        array[i] = choice;
                } catch (InputMismatchException ex) {
                    System.out.println("Error: Please enter a numeric choice (1-4).");
                    sc.nextLine();
                }
		    }
	    }

		for(int i = 0; i < maxProducts; i++) {
		    if (array[i] == 1) addRefrigerator(products, sc);
		    else if (array[i] == 2) addTV(products, sc);
		    else if (array[i] == 3) addWashingMachine(products, sc);
		    else addAirConditioner(products, sc);
		}
	}
	
	public static void addRefrigerator(Product[] products, Scanner sc) {
        try {
            System.out.println("\n--- Adding Refrigerator ---");
            System.out.print("Item number: ");
            int itemNum = sc.nextInt();
            sc.nextLine(); 
            
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Door design: ");
            String door = sc.nextLine();
            System.out.print("Color: ");
            String color = sc.nextLine();
            
            System.out.print("Capacity (in Litres): ");
            double capacity = sc.nextDouble();
            System.out.print("Quantity available: ");
            int quantity = sc.nextInt();
            System.out.print("Price (RM): ");
            double price = sc.nextDouble();
            
            for (int i = 0; i < products.length; i++) {
                if (products[i] == null) {
                    products[i] = new Refrigerator(name, price, quantity, itemNum, door, color, capacity);
                    System.out.println("Refrigerator added successfully!");
                    return; 
                }
            }
        } catch (InputMismatchException ex) {
            System.out.println("Error: Invalid data type entered for Refrigerator. Operation cancelled.");
            sc.nextLine();
        }
	}
	
	public static void addTV(Product[] products, Scanner sc) {
        try {
            System.out.println("\n--- Adding TV ---");
            System.out.print("Item number: ");
            int itemNum = sc.nextInt();
            sc.nextLine();
            
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Screen type: ");
            String screenType = sc.nextLine();
            System.out.print("Resolution: ");
            String resolution = sc.nextLine();
            
            System.out.print("Display size: ");
            double size = sc.nextDouble();
            System.out.print("Quantity available: ");
            int qty = sc.nextInt();
            System.out.print("Price (RM): ");
            double price = sc.nextDouble();
            
            for (int i = 0; i < products.length; i++) {
                if (products[i] == null) {
                    products[i] = new TV(name, price, qty, itemNum, screenType, resolution, size);
                    System.out.println("TV added successfully!");
                    return;
                }
            }
        } catch (InputMismatchException ex) {
            System.out.println("Error: Invalid input data for TV.");
            sc.nextLine();
        }
	}
	
	public static void addWashingMachine(Product[] products, Scanner sc) {
        try {
            System.out.println("\n--- Adding Washing Machine ---");
            System.out.print("Item number: ");
            int itemNum = sc.nextInt();
            sc.nextLine();
            
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Price (RM): ");
            double price = sc.nextDouble();
            System.out.print("Quantity available: ");
            int qty = sc.nextInt();
            System.out.print("Load Capacity (kg): ");
            double loadCapacity = sc.nextDouble();
            sc.nextLine(); 
            
            System.out.print("Type (Front Load/Top Load): ");
            String type = sc.nextLine();
            System.out.print("Spin Speed (RPM): ");
            int spinSpeed = sc.nextInt();

            for (int i = 0; i < products.length; i++) {
                if (products[i] == null) {
                    products[i] = new WashingMachine(name, price, qty, itemNum, loadCapacity, type, spinSpeed);
                    System.out.println("Washing Machine added successfully!");
                    return;
                }
            }
        } catch (InputMismatchException ex) {
            System.out.println("Error: Incorrect data format for Washing Machine.");
            sc.nextLine();
        }
	}
	
	public static void addAirConditioner(Product[] products, Scanner sc) {
        try {
            System.out.println("\n--- Adding Air Conditioner ---");
            System.out.print("Item number: ");
            int itemNum = sc.nextInt();
            sc.nextLine(); 
            
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Price (RM): ");
            double price = sc.nextDouble();
            System.out.print("Quantity available: ");
            int qty = sc.nextInt();
            
            sc.nextLine();
            System.out.print("Type (Inverter/Non-Inverter): ");
            String type = sc.nextLine();
            System.out.print("Horse Power (HP): ");
            double horsePower = sc.nextDouble();
            
            sc.nextLine();
            System.out.print("Energy Rating (e.g., 5-Star): ");
            String energyRating = sc.nextLine();

            for (int i = 0; i < products.length; i++) {
                if (products[i] == null) {
                    products[i] = new AirConditioner(name, price, qty, itemNum, type, horsePower, energyRating);
                    System.out.println("Air Conditioner added successfully!");
                    return;
                }
            }
        } catch (InputMismatchException ex) {
            System.out.println("Error: Incorrect format for Air Conditioner.");
            sc.nextLine();
        }
	}
	
	public static int displayMenu(Scanner sc) {
        int choice = -1;
        while (choice < 0 || choice > 4) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. View products");
            System.out.println("2. Add stock");
            System.out.println("3. Deduct stock");
            System.out.println("4. Discontinue product");
            System.out.println("0. Exit");
            System.out.print("Please enter a menu option: ");
            choice = sc.nextInt();
            
            if (choice < 0 || choice > 4) {
                System.out.println("Invalid choice! Please enter a number between 0 and 4.");
            }
        }
        return choice;
    }
	
	public static void executeChoice(int choice, Product[] products, Scanner sc) {
        switch (choice) {
            case 1: viewProducts(products); break;
            case 2: addStock(products, sc); break;
            case 3: deductStock(products, sc); break;
            case 4: discontinueProduct(products, sc); break;
            case 0: exit(); break;
        }
    }
	
	public static int selectProduct(Product[] products, Scanner sc) {
        int index = -1;
        while (index < 0 || index >= products.length) {
            try {
                System.out.println("\nAvailable Products with their index:");
                for (int i = 0; i < products.length; i++) {
                    if (products[i] != null)
                        System.out.println((i+1) + ". " + products[i].getProductName());
                }
                System.out.print("Select product index: ");
                index = sc.nextInt();
                index -= 1;
                
                if (index < 0 || index >= products.length) {
                    System.out.println("Error: Index out of bounds!");
                }
            } catch (InputMismatchException ex) {
                System.out.println("Error: Index must be a valid number.");
                sc.nextLine();
            }
        }
        return index;
    }
	
	public static void viewProducts(Product[] products) {
	    System.out.println("\n=============================================");
	    System.out.println("             INVENTORY CONTENTS              ");
	    System.out.println("=============================================");
	    
	    boolean isEmpty = true;
	    for (int i = 0; i < products.length; i++) {
	        if (products[i] != null) {
	            System.out.println("Product " + (i+1) + ": ");
	            System.out.println(products[i].toString());
	            System.out.println("---------------------------------------------");
	            isEmpty = false;
	        }
	    }
	    if (isEmpty) 
	    	System.out.println("The inventory is currently empty.");
	}
	
	public static void addStock(Product[] products, Scanner sc) {
        int index = selectProduct(products, sc);
        if (products[index] != null) {
            try {
                System.out.print("Enter quantity to add: ");
                int amount = sc.nextInt();
                if (amount >= 0) {
                	if (products[index].getStatus()) {
                		products[index].addQuantity(amount);
                		System.out.println("Stock added successfully.");
                	}
                	else
                		System.out.println("Adding stock to a discountinued product is not allowed!");
                }
                else
                    System.out.println("Error: Cannot add a negative amount.");
            } catch (InputMismatchException ex) {
                System.out.println("Error: Numeric value required for stock amount.");
                sc.nextLine();
            }
        } else {
            System.out.println("Error: Cannot add stock to an empty slot.");
        }
    }
	
	public static void deductStock(Product[] products, Scanner sc) {
        int index = selectProduct(products, sc);
        if (products[index] != null) {
            try {
                System.out.print("Enter quantity to deduct: ");
                int amount = sc.nextInt();
                int currentQty = products[index].getQuantity();
                
                if (amount >= 0 && amount <= currentQty) {
                    products[index].deductQuantity(amount);
                    System.out.println("Stock deducted successfully.");
                }
               else
                    System.out.println("Error: Invalid amount or insufficient stock.");
            } catch (InputMismatchException ex) {
                System.out.println("Error: Numeric value required.");
                sc.nextLine();
            }
        } else {
            System.out.println("Error: Cannot deduct stock from an empty slot.");
        }
    }
	
	public static void discontinueProduct(Product[] products, Scanner sc) {
        int index = selectProduct(products, sc);
        if (products[index] != null && products[index].getStatus()) {
            products[index].setStatus(false);
            System.out.println("Product status updated to Discontinued.");
        } else {
            System.out.println("The product is already discontinued!");
        }
    }
	
	public static void exit() {
		System.out.println("\n---------------------------------------------");
		System.out.println("Thanks for Using!");
		System.out.println("User Name: " + user.getName());
		System.out.println("User ID: " + user.getUserID());
		System.out.println("---------------------------------------------");
	}
}