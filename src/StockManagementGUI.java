import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class StockManagementGUI extends Application{
	
    private int num = 0;
    private int productCount = 0;
    private Product[] products; 
    private UserInfoGUI user = new UserInfoGUI();

    private HBox mainLayout = new HBox(20);
    private VBox topLeft = new VBox(5);
    private VBox bottomLeft = new VBox(10);
    private VBox leftPane = new VBox(15);
    private StackPane rightPane = new StackPane();
    
    @Override
    public void start(Stage stage) {
        
        topLeft.getChildren().add(numOfProduct(stage));
        leftPane.setPrefWidth(550);
        leftPane.setStyle("-fx-background-color: ALICEBLUE;");
        rightPane.setPrefWidth(600);
        leftPane.getChildren().addAll(topLeft, bottomLeft);
        mainLayout.getChildren().addAll(leftPane, rightPane);
        mainLayout.setStyle("-fx-background-color: white;");
        Scene scene2 = new Scene(mainLayout, 1000, 600);
        
        Scene scene1 = new Scene(userLogin(stage, scene2), 1000, 600); 
        
        stage.setTitle("Stock Management System"); 
        stage.setScene(scene1); 
        stage.show();
    }
	
	public static void main(String[] args) {
		launch(args);
	}
	
	private BorderPane userLogin(Stage stage, Scene scene2) {
	    HBox root = new HBox();
	    root.setStyle("-fx-background-color: ALICEBLUE;");

	    Image image = new Image(getClass().getResourceAsStream("image.png")); 
	    ImageView imageView = new ImageView(image);
	    imageView.setFitHeight(560); 
	    imageView.setPreserveRatio(true);
	    
	    StackPane imageContainer = new StackPane(imageView);
	    imageContainer.setPadding(new Insets(10)); 
	    imageContainer.setAlignment(Pos.CENTER);

	    VBox rightSide = new VBox(25);
	    rightSide.setPadding(new Insets(30));
	    rightSide.setAlignment(Pos.CENTER);
	    rightSide.setPrefWidth(550);

	    VBox titleBox = new VBox(5);
	    titleBox.setAlignment(Pos.CENTER);
	    Label welcomeBack = new Label("Welcome!");
	    welcomeBack.setFont(Font.font("System", FontWeight.LIGHT, 24));
	    welcomeBack.setTextFill(Color.DARKGRAY);
	    
	    Label systemTitle = new Label("Stock Management System");
	    systemTitle.setFont(Font.font("System", FontWeight.BOLD, 30));
	    systemTitle.setTextFill(Color.DARKSLATEGRAY);
	    titleBox.getChildren().addAll(welcomeBack, systemTitle);

	    HBox groupNameBox = new HBox(15);
	    groupNameBox.setAlignment(Pos.CENTER);
	    String[] members = {"Boon Jia Xuan", "Lee Jia Xuan", "Leow Hui Yu", "Tan Yi Hui"};
	    for (int i = 0; i < members.length; i++) {
	        Label name = new Label(members[i]);
	        name.setFont(Font.font("System", FontWeight.MEDIUM, 12));
	        name.setTextFill(Color.GRAY);
	        groupNameBox.getChildren().add(name);
	        if (i < members.length - 1) {
	            Label separator = new Label("|");
	            separator.setTextFill(Color.SILVER);
	            groupNameBox.getChildren().add(separator);
	        }
	    }

	    VBox inputCard = new VBox(10);
	    inputCard.setPadding(new Insets(30));
	    inputCard.setStyle("-fx-background-color: GHOSTWHITE; -fx-background-radius: 10; -fx-border-color: LIGHTSTEELBLUE; -fx-border-radius: 10;");
	    
	    Label nameTag = new Label("FULL NAME (FirstName + SurName):");
	    nameTag.setFont(Font.font("System", FontWeight.BOLD, 10));
	    nameTag.setTextFill(Color.BLACK);
	    
	    TextField nameField = new TextField();
	    nameField.setPrefHeight(30);
	    nameField.setStyle("-fx-background-radius: 5; -fx-border-color: LIGHTGRAY; -fx-border-radius: 5;");
	    
	    Button loginBtn = new Button("LOGIN TO SYSTEM");
	    loginBtn.setPrefWidth(500);
	    loginBtn.setPrefHeight(30);
	    loginBtn.setStyle("-fx-background-color: BLACK; -fx-text-fill: WHITE; -fx-font-weight: bold; -fx-background-radius: 5;");
	   
	    Label resultLabel = new Label();
	    inputCard.getChildren().addAll(nameTag, resultLabel, nameField, loginBtn);
	    
	    VBox productBox = new VBox(10);
	    productBox.setAlignment(Pos.CENTER);
	    Label productHeader = new Label("SYSTEM PRODUCTS");
	    productHeader.setFont(Font.font("System", FontWeight.BOLD, 10));
	    productHeader.setTextFill(Color.SILVER);

	    HBox productIcons = new HBox(20);
	    productIcons.setAlignment(Pos.CENTER);
	    
	    String[] items = {"Refrigerators", "TVs", "Washing Machines", "Air Conditioners"};
	    for (int i = 0; i < items.length; i++) {
	        Label item = new Label(items[i]);
	        item.setFont(Font.font("System", 11));
	        item.setTextFill(Color.DIMGRAY);
	        productIcons.getChildren().add(item);
	        if (i < items.length - 1) {
	            Circle dot = new Circle(2, Color.SILVER);
	            productIcons.getChildren().add(dot);
	        }
	    }
	    productBox.getChildren().addAll(productHeader, productIcons);

	    LocalDateTime now = LocalDateTime.now();
	    DateTimeFormatter format = DateTimeFormatter.ofPattern("EEEE, dd MMM yyyy | HH:mm:ss");
	    Label dateTimeLabel = new Label(now.format(format));
	    dateTimeLabel.setFont(Font.font("System", FontWeight.LIGHT, 11));
	    dateTimeLabel.setTextFill(Color.GRAY);
	    VBox.setMargin(dateTimeLabel, new Insets(20, 0, 0, 0)); 

	    rightSide.getChildren().addAll(titleBox, groupNameBox, inputCard, productBox, dateTimeLabel);
	    root.getChildren().addAll(imageContainer, rightSide);
	    
	    BorderPane finalPane = new BorderPane(root);
	    
	    loginBtn.setOnAction(e -> {
	    	if (nameField.getText().trim().isEmpty()) {
	            resultLabel.setTextFill(Color.RED);
	            resultLabel.setText("Please enter your name!");
	            nameField.setStyle("-fx-background-radius: 5; -fx-border-color: RED; -fx-border-radius: 5;");
	        }
	    	
	    	else if (user.checkName(nameField.getText())) {
	            user.setUserID(nameField.getText());
	            user.setName(nameField.getText());
	            
	            resultLabel.setTextFill(Color.GREEN);
	            resultLabel.setText("Login Successfully!");
	            nameField.setStyle("-fx-background-radius: 5; -fx-border-color: LIGHTGRAY; -fx-border-radius: 5;");
	            
	            loginBtn.setDisable(true);
	            
	            HBox row = new HBox(5);
	            row.setAlignment(Pos.CENTER);
	            row.setPadding(new Insets(10));
	            row.setStyle("-fx-background-color: WHITESMOKE; -fx-background-radius: 10; -fx-border-color: LIGHTSTEELBLUE; -fx-border-radius: 10;");
	            
	            Label prompt = new Label("Do you wish to add products?    ");
	            prompt.setTextFill(Color.DARKSLATEGRAY);
	            
	            Button add = new Button("Wish to Add");
	            Button exit = new Button("Exit");
	            
	            add.setStyle("-fx-background-color: DARKSLATEGRAY; -fx-text-fill: WHITE;");
	            exit.setStyle("-fx-background-color: WHITE; -fx-border-color: BLACK;");
	            row.getChildren().addAll(prompt, add, exit);
	            rightSide.getChildren().add(row);
	            
	            add.setOnAction(ev -> stage.setScene(scene2));
	            exit.setOnAction(ev -> exitPage(stage));
	        } 
	        else {
				resultLabel.setTextFill(Color.RED);
				resultLabel.setText("Invalid Name! Please Enter Again");
				nameField.setStyle("-fx-background-radius: 5; -fx-border-color: RED; -fx-border-radius: 5;");
	        }
	    });

	    return finalPane;
	}
	
	private VBox numOfProduct(Stage stage) {
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20));
        vbox.setAlignment(Pos.CENTER_LEFT);

        Label title = new Label("Setup Inventory");
        title.setFont(Font.font("System", FontWeight.BOLD, 22));
        title.setTextFill(Color.DIMGRAY);

        Label subTitle = new Label("Number of Product you wish to add: ");
        subTitle.setTextFill(Color.GRAY);

        TextField numProduct = new TextField();
        numProduct.setPrefHeight(30);
        numProduct.setMaxWidth(150);
        numProduct.setStyle("-fx-background-radius: 10; -fx-border-color: SILVER; -fx-border-radius: 10;");

        Button confirm = new Button("Confirm");
        confirm.setPrefWidth(100);
        confirm.setPrefHeight(30);
        
        confirm.setStyle("-fx-background-color: BLACK; -fx-text-fill: WHITE; -fx-font-weight: bold; -fx-background-radius: 10;");
     
        HBox hbox = new HBox(10, numProduct, confirm);
        VBox.setMargin(vbox, new Insets(20, 0, 0, 30));
        
        Label resultText = new Label();
        vbox.getChildren().addAll(title, subTitle, hbox, resultText);
        
        confirm.setOnAction(e -> {
            try {
                num = Integer.parseInt(numProduct.getText());
                if(num > 0) {
                    numProduct.setDisable(true);
                    confirm.setDisable(true);
                    resultText.setTextFill(Color.GREEN);
                    resultText.setText("Status: Success. Please choose products.");
                    products = new Product[num];
                    addProduct(stage);
                } else {
                    resultText.setTextFill(Color.RED);
                    resultText.setText("Error: Must be greater than 0.");
                }
            } catch (NumberFormatException ex) {
                resultText.setTextFill(Color.RED);
                resultText.setText("Error: Please enter an integer.");
            }
        });
        
        return vbox;
    }

    private void addProduct(Stage stage) {
    	
        rightPane.getChildren().clear();
        
        if (productCount >= num) {
        	Scene scene3 = new Scene(menu(stage), 1000, 600);
            stage.setScene(scene3);
            return;
        }
        
        bottomLeft.getChildren().clear();
        rightPane.setStyle("-fx-background-color: WHITE; -fx-border-color: LIGHTGRAY; -fx-border-width: 0 0 0 1;");
        rightPane.setPadding(new Insets(20));

        VBox selectionBox = new VBox(10); 
	    selectionBox.setPadding(new Insets(20)); 
	    selectionBox.setMaxWidth(350);
	    selectionBox.setPrefHeight(245);

        Label question = new Label("Select Product " + (productCount + 1) + ": ");
        question.setFont(Font.font("System", FontWeight.BOLD, 16));
        
        VBox mainLayout = new VBox(10);
	    mainLayout.setMaxWidth(350);
	    mainLayout.getChildren().add(question);
	    VBox.setMargin(mainLayout, new Insets(0, 0, 0, 40)); 
	    bottomLeft.getChildren().add(mainLayout);
	    
        Button btnRef = new Button("Refrigerator");
        Button btnTV = new Button("TV");
        Button btnWM = new Button("Washing Machine");
        Button btnAC = new Button("Air Conditioner");
        
        Button[] prodButtons = {btnRef, btnTV, btnWM, btnAC};
        
        for (Button btn : prodButtons) {
            btn.setMaxWidth(280);
            btn.setPrefHeight(45); 
            btn.setStyle("-fx-background-color: WHITE; -fx-text-fill: BLACK; -fx-font-size: 14px; -fx-font-weight: bold; -fx-alignment: CENTER_LEFT; -fx-padding: 10 20 10 20; " +     
                    "-fx-background-radius: 15; -fx-border-color: LIGHTGRAY; -fx-border-radius: 15; -fx-border-width: 1;");

            btn.setOnMouseEntered(e -> {
                btn.setStyle("-fx-background-color: GHOSTWHITE; -fx-text-fill: BLACK; -fx-font-size: 14px; -fx-font-weight: bold; -fx-alignment: CENTER_LEFT; -fx-padding: 10 20 10 20; -fx-background-radius: 15; -fx-border-color: SLATEGRAY; -fx-border-radius: 15; -fx-border-width: 1.5;");
                btn.setTranslateX(5); 
            });

            btn.setOnMouseExited(e -> {
                btn.setStyle("-fx-background-color: WHITE; -fx-text-fill: BLACK; -fx-font-size: 14px; -fx-font-weight: bold; -fx-alignment: CENTER_LEFT; -fx-padding: 10 20 10 20; " +     
                        "-fx-background-radius: 15; -fx-border-color: LIGHTGRAY; -fx-border-radius: 15; -fx-border-width: 1;"); 
                btn.setTranslateX(0); 
            });
        }
        
        mainLayout.getChildren().addAll(btnRef, btnTV, btnWM, btnAC);
        btnRef.setOnAction(e -> {rightPane.getChildren().add(addRefrigerator(stage));});
        btnTV.setOnAction(e -> {rightPane.getChildren().add(addTV(stage));});
        btnWM.setOnAction(e -> {rightPane.getChildren().add(addWashingMachine(stage));});
        btnAC.setOnAction(e -> {rightPane.getChildren().add(addAirConditioner(stage));});
        
    }
 
    private BorderPane addRefrigerator(Stage stage) {
        rightPane.getChildren().clear();
        BorderPane pane = new BorderPane();
        Text header = new Text("Product " + (productCount + 1) + ": Refrigerator Details");
        header.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        
        TextField nameField = new TextField();
        nameField.setPromptText("Enter product name (String)");
        
        TextField doorField = new TextField();
        doorField.setPromptText("e.g. Double Door / Side-by-Side (String)");
        
        TextField colorField = new TextField();
        colorField.setPromptText("e.g. Silver / Black (String)");
        
        TextField capacityField = new TextField();
        capacityField.setPromptText("e.g. 350.5 (Double - in Litres)");
        
        TextField quantityField = new TextField();
        quantityField.setPromptText("e.g. 10 (Integer)");
        
        TextField priceField = new TextField();
        priceField.setPromptText("e.g. 2500.00 (Double - RM)");
        
        TextField itemNumField = new TextField();
        itemNumField.setPromptText("Unique ID e.g. 101 (Integer)");
        
        Button done = new Button("Confirm and Save");
        done.setStyle("-fx-background-color: BLACK; -fx-text-fill: WHITE; -fx-font-weight: bold;");
        
        Label errorLabel = new Label(""); 
        errorLabel.setTextFill(Color.RED); 
        errorLabel.setFont(Font.font("System", FontWeight.BOLD, 12));
        errorLabel.setVisible(false); 
        
        VBox vbox = new VBox(10, header, 
             new Label("Item Number:"), itemNumField, new Label("Name:"), nameField, 
             new Label("Quantity:"), quantityField, new Label("Price:"), priceField, 
             new Label("Door Design:"), doorField, new Label("Color:"), colorField, 
             new Label("Capacity:"), capacityField, errorLabel, done);
        
        vbox.setPadding(new Insets(10));
        pane.setCenter(vbox);
        
        done.setOnAction(e -> {
            try {
                int itemNum = Integer.parseInt(itemNumField.getText());
                String name = nameField.getText();
                String door = doorField.getText();
                String color = colorField.getText();
                double capacity = Double.parseDouble(capacityField.getText());
                int quantity = Integer.parseInt(quantityField.getText());
                double price = Double.parseDouble(priceField.getText());
                
                if (name.trim().isEmpty() || door.trim().isEmpty() || color.trim().isEmpty()) {
                    errorLabel.setText("Error: All text fields must be filled!");
                    errorLabel.setVisible(true);
                    return;
                }
                
                boolean isDuplicate = false;
                for (int i = 0; i < productCount; i++) {
                    if (products[i].getItemNum() == itemNum) {
                        isDuplicate = true;
                        break;
                    }
                }
                
                if (isDuplicate) {
                    errorLabel.setText("Error: Item Number '" + itemNum + "' already exists!");
                    errorLabel.setVisible(true);
                    return;
                }
                
                if (price < 0 || quantity < 0) {
                    errorLabel.setText("Error: Price and Quantity cannot be negative!");
                    errorLabel.setVisible(true);
                    return;
                }
                
                errorLabel.setVisible(false);
                products[productCount] = new Refrigerator(name, price, quantity, itemNum, door, color, capacity);
                productCount++;
                addProduct(stage);
                
            } catch (NumberFormatException ex) {
                errorLabel.setText("Error: Please enter valid number for itemNum/Capacity/Quantity/Price!");
                errorLabel.setVisible(true);
            }
        });
        return pane;
    }

    private BorderPane addTV(Stage stage) {
        rightPane.getChildren().clear();
        BorderPane pane = new BorderPane();
        Text header = new Text("Product " + (productCount + 1) + ": TV Details");
        header.setFont(Font.font("Arial", FontWeight.BOLD, 14));

        TextField nameF = new TextField(); 
        nameF.setPromptText("Enter product name (String)");
        
        TextField screenF = new TextField(); 
        screenF.setPromptText("e.g. LED / OLED / LCD (String)");
        
        TextField resF = new TextField(); 
        resF.setPromptText("e.g. 4K / 1080p (String)");
        
        TextField sizeF = new TextField(); 
        sizeF.setPromptText("e.g. 55.0 (Double - in Inches)");
        
        TextField qtyF = new TextField(); 
        qtyF.setPromptText("e.g. 5 (Integer)");
        
        TextField priceF = new TextField(); 
        priceF.setPromptText("e.g. 1800.50 (Double - RM)");
        
        TextField itemF = new TextField();
        itemF.setPromptText("Unique ID e.g. 201 (Integer)");

        Button done = new Button("Confirm and Save");
        done.setStyle("-fx-background-color: BLACK; -fx-text-fill: WHITE; -fx-font-weight: bold;");

        Label errorLabel = new Label(""); 
        errorLabel.setTextFill(Color.RED); 
        errorLabel.setFont(Font.font("System", FontWeight.BOLD, 12));
        errorLabel.setVisible(false); 
        
        VBox vbox = new VBox(10, header, 
                new Label("Item Number:"), itemF, new Label("Name:"), nameF, 
                new Label("Quantity:"), qtyF, new Label("Price:"), priceF,
                new Label("Screen Type:"), screenF, new Label("Resolution:"), resF, 
                new Label("Display Size:"), sizeF,  errorLabel, done);
        
        vbox.setPadding(new Insets(10));
        pane.setCenter(vbox);

        done.setOnAction(e -> {
            try {
                String name = nameF.getText();
                double price = Double.parseDouble(priceF.getText());
                int qty = Integer.parseInt(qtyF.getText());
                int itemNum = Integer.parseInt(itemF.getText());
                String screen = screenF.getText();
                String res = resF.getText();
                double size = Double.parseDouble(sizeF.getText());
                
                if (name.trim().isEmpty() || screen.trim().isEmpty() || res.trim().isEmpty()) {
                    errorLabel.setText("Error: All text fields must be filled!");
                    errorLabel.setVisible(true);
                    return;
                }
                
                boolean isDuplicate = false;
                for (int i = 0; i < productCount; i++) {
                    if (products[i].getItemNum() == itemNum) {
                        isDuplicate = true;
                        break;
                    }
                }
                
                if (isDuplicate) {
                    errorLabel.setText("Error: Item Number '" + itemNum + "' already exists!");
                    errorLabel.setVisible(true);
                    return;
                }
                
                if (price < 0 || qty < 0) {
                    errorLabel.setText("Error: Price and Quantity cannot be negative!");
                    errorLabel.setVisible(true);
                    return;
                }
                
                errorLabel.setVisible(false);
                products[productCount] = new TV(name, price, qty, itemNum, screen, res, size);
                productCount++;
                addProduct(stage);
            } catch (NumberFormatException ex) { 
                errorLabel.setText("Error: Please enter valid number for ItemNum/DisplaySize/Quantity/Price!");
                errorLabel.setVisible(true);
            }
        });
        return pane;
    }

    private BorderPane addWashingMachine(Stage stage) {
        rightPane.getChildren().clear();
        BorderPane pane = new BorderPane();
        Text header = new Text("Product " + (productCount + 1) + ": Washing Machine Details");
        header.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        
        TextField nameF = new TextField();
        nameF.setPromptText("Enter product name (String)");
        
        TextField priceF = new TextField();
        priceF.setPromptText("e.g. 1200.00 (Double - RM)");
        
        TextField qtyF = new TextField();
        qtyF.setPromptText("e.g. 8 (Integer)");
        
        TextField itemF = new TextField();
        itemF.setPromptText("Unique ID e.g. 301 (Integer)");
        
        TextField capF = new TextField();
        capF.setPromptText("e.g. 7.5 (Double - in kg)");
        
        TextField typeF = new TextField();
        typeF.setPromptText("e.g. Front Load / Top Load (String)");
        
        TextField speedF = new TextField();
        speedF.setPromptText("e.g. 1200 (Integer - RPM)");

        Button done = new Button("Confirm and Save");
        done.setStyle("-fx-background-color: BLACK; -fx-text-fill: WHITE; -fx-font-weight: bold;");

        Label errorLabel = new Label(""); 
        errorLabel.setTextFill(Color.RED); 
        errorLabel.setFont(Font.font("System", FontWeight.BOLD, 12));
        errorLabel.setVisible(false); 
        
        VBox vbox = new VBox(10, header, 
                new Label("Item Number:"), itemF, new Label("Product Name:"), nameF, 
                new Label("Quantity:"), qtyF, new Label("Price:"), priceF, 
                new Label("Type:"), typeF, new Label("Load Capacity:"), capF, 
                new Label("Spin Speed:"), speedF, errorLabel, done);
        
        vbox.setPadding(new Insets(10));
        pane.setCenter(vbox);

        done.setOnAction(e -> {
            try {
                String name = nameF.getText();
                double price = Double.parseDouble(priceF.getText());
                int qty = Integer.parseInt(qtyF.getText());
                int itemNum = Integer.parseInt(itemF.getText());
                double cap = Double.parseDouble(capF.getText());
                String type = typeF.getText();
                int speed = Integer.parseInt(speedF.getText());

                if (name.trim().isEmpty() || type.trim().isEmpty()) {
                    errorLabel.setText("Error: All text fields must be filled!");
                    errorLabel.setVisible(true);
                    return;
                }
                
                boolean isDuplicate = false;
                for (int i = 0; i < productCount; i++) {
                    if (products[i].getItemNum() == itemNum) {
                        isDuplicate = true;
                        break;
                    }
                }
                
                if (isDuplicate) {
                    errorLabel.setText("Error: Item Number '" + itemNum + "' already exists!");
                    errorLabel.setVisible(true);
                    return;
                }
                
                if (price < 0 || qty < 0) {
                    errorLabel.setText("Error: Price and Quantity cannot be negative!");
                    errorLabel.setVisible(true);
                    return; 
                }
                
                errorLabel.setVisible(false);
                products[productCount] = new WashingMachine(name, price, qty, itemNum, cap, type, speed);
                productCount++;
                addProduct(stage);
            } catch (NumberFormatException ex) { 
                errorLabel.setText("Error: Please enter valid number for ItemNum/Price/Quantity/Capacity/Speed!");
                errorLabel.setVisible(true); 
            }
        });
        return pane;
    }

    private BorderPane addAirConditioner(Stage stage) {
        rightPane.getChildren().clear();
        BorderPane pane = new BorderPane();
        Text header = new Text("Product " + (productCount + 1) + ": Air Conditioner Details");
        header.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        
        TextField nameF = new TextField();
        nameF.setPromptText("Enter product name (String)");
        
        TextField priceF = new TextField();
        priceF.setPromptText("e.g. 1500.00 (Double - RM)");
        
        TextField qtyF = new TextField();
        qtyF.setPromptText("e.g. 12 (Integer)");
        
        TextField itemF = new TextField();
        itemF.setPromptText("Unique ID e.g. 401 (Integer)");
        
        TextField typeF = new TextField();
        typeF.setPromptText("e.g. Inverter / Portable (String)");
        
        TextField hpF = new TextField();
        hpF.setPromptText("e.g. 1.5 (Double - Horsepower)");
        
        TextField energyF = new TextField();
        energyF.setPromptText("e.g. 5 Stars (String)");
        
        Button done = new Button("Confirm and Save");
        done.setStyle("-fx-background-color: BLACK; -fx-text-fill: WHITE; -fx-font-weight: bold;");
        
        Label errorLabel = new Label(""); 
        errorLabel.setTextFill(Color.RED); 
        errorLabel.setFont(Font.font("System", FontWeight.BOLD, 12));
        errorLabel.setVisible(false); 

        VBox vbox = new VBox(10, header, 
                new Label("Item Number:"), itemF, new Label("Product Name:"), nameF, 
                new Label("Quantity:"), qtyF, new Label("Price:"), priceF,
                new Label("Type:"), typeF, new Label("Horse Power:"), hpF,
                new Label("Energy Rating:"), energyF, errorLabel, done);
        
        vbox.setPadding(new Insets(10));
        pane.setCenter(vbox);

        done.setOnAction(e -> {
            try {
                String name = nameF.getText();
                double price = Double.parseDouble(priceF.getText());
                int qty = Integer.parseInt(qtyF.getText());
                int itemNum = Integer.parseInt(itemF.getText());
                String type = typeF.getText();
                double hp = Double.parseDouble(hpF.getText());
                String energy = energyF.getText();
                
                if (name.trim().isEmpty() || type.trim().isEmpty() || energy.trim().isEmpty()) {
                    errorLabel.setText("Error: All text fields must be filled!");
                    errorLabel.setVisible(true);
                    return;
                }
                
                boolean isDuplicate = false;
                for (int i = 0; i < productCount; i++) {
                    if (products[i].getItemNum() == itemNum) {
                        isDuplicate = true;
                        break;
                    }
                }
                
                if (isDuplicate) {
                    errorLabel.setText("Error: Item Number '" + itemNum + "' already exists!");
                    errorLabel.setVisible(true);
                    return;
                }
                
                if (price < 0 || qty < 0) {
                    errorLabel.setText("Error: Price and Quantity cannot be negative!");
                    errorLabel.setVisible(true);
                    return; 
                }
                
                errorLabel.setVisible(false);
                products[productCount] = new AirConditioner(name, price, qty, itemNum, type, hp, energy);
                productCount++;
                addProduct(stage);
            } catch (NumberFormatException ex) {
                errorLabel.setText("Error: Please enter valid number for ItemNum/Price/Quantity/HorsePower!");
                errorLabel.setVisible(true);
            }
        });
        return pane;
    }
    
    private BorderPane menu(Stage stage) {

        BorderPane root = new BorderPane();
        VBox leftMenu = new VBox(20); 
        leftMenu.setPadding(new Insets(40));
        leftMenu.setPrefWidth(380);

        leftMenu.setStyle("-fx-background-color: ALICEBLUE;");

        Label title = new Label("INVENTORY MENU");
        title.setFont(Font.font("System", FontWeight.EXTRA_BOLD, 26)); 
        title.setTextFill(Color.DARKSLATEGRAY);
        title.setPadding(new Insets(0, 0, 10, 0));

        Button viewBtn = new Button("📦 View Product");
        Button addBtn = new Button("➕ Add Stock");
        Button deductBtn = new Button("➖ Deduct Stock");
        Button discontinueBtn = new Button("⚠ Discontinue Product");
        Button exitBtn = new Button("🚪 Exit System");
        
        Button[] menuButtons = {viewBtn, addBtn, deductBtn, discontinueBtn, exitBtn};
        
        for (Button btn : menuButtons) {
            btn.setMaxWidth(280);
            btn.setPrefHeight(45); 
            btn.setStyle("-fx-background-color: WHITE; -fx-text-fill: BLACK; -fx-font-size: 14px; -fx-font-weight: bold; -fx-alignment: CENTER_LEFT; -fx-padding: 10 20 10 20; " +     
                    "-fx-background-radius: 15; -fx-border-color: LIGHTGRAY; -fx-border-radius: 15; -fx-border-width: 1;");

            btn.setOnMouseEntered(e -> {
                btn.setStyle("-fx-background-color: GHOSTWHITE; -fx-text-fill: BLACK; -fx-font-size: 14px; -fx-font-weight: bold; -fx-alignment: CENTER_LEFT; -fx-padding: 10 20 10 20; -fx-background-radius: 15; -fx-border-color: SLATEGRAY; -fx-border-radius: 15; -fx-border-width: 1.5;");
                btn.setTranslateX(5); 
            });

            btn.setOnMouseExited(e -> {
                btn.setStyle("-fx-background-color: WHITE; -fx-text-fill: BLACK; -fx-font-size: 14px; -fx-font-weight: bold; -fx-alignment: CENTER_LEFT; -fx-padding: 10 20 10 20; " +     
                        "-fx-background-radius: 15; -fx-border-color: LIGHTGRAY; -fx-border-radius: 15; -fx-border-width: 1;"); 
                btn.setTranslateX(0); 
            });
        }
        
        leftMenu.getChildren().addAll(title, viewBtn, addBtn, deductBtn, discontinueBtn, exitBtn);
        leftMenu.setAlignment(Pos.CENTER);
        
        VBox operationPane = new VBox(20);
        operationPane.setPadding(new Insets(50));
        operationPane.setStyle("-fx-background-color: WHITE;");
        operationPane.setAlignment(Pos.CENTER);

        Label defaultText = new Label("Welcome to the System");
        defaultText.setFont(Font.font("System", FontWeight.LIGHT, 28));
        defaultText.setTextFill(Color.LIGHTGRAY);

        operationPane.getChildren().add(defaultText);

        viewBtn.setOnAction(e -> displayProducts(products, operationPane));
        addBtn.setOnAction(e -> addStockPage(operationPane));
        deductBtn.setOnAction(e -> deductStockPage(operationPane));
        discontinueBtn.setOnAction(e -> discontinueProduct(products, operationPane));
        exitBtn.setOnAction(e -> exitPage(stage));

        root.setLeft(leftMenu);
        root.setCenter(operationPane);

        return root;
    }
    
    private void displayProducts(Product[] products, VBox contentArea) {

        contentArea.getChildren().clear();
        contentArea.setAlignment(Pos.TOP_CENTER);
        contentArea.setPadding(new Insets(10));
        contentArea.setStyle("-fx-background-color: WHITE;");

        Label title = new Label("Product Inventory");
        title.setFont(Font.font("System", FontWeight.EXTRA_BOLD, 26));
        title.setTextFill(Color.DARKSLATEGRAY);
        title.setPadding(new Insets(20, 0, 10, 0));

        ComboBox<String> sortBox = new ComboBox<>();
        sortBox.getItems().addAll("Default", "Name (A-Z)", "Name (Z-A)", "Price (Low → High)", "Price (High → Low)");
        sortBox.setValue("Default");
        sortBox.setStyle("-fx-background-color: WHITE; -fx-border-color: SILVER;");

        HBox sortBar = new HBox(10, new Label("Sort By:"), sortBox);
        sortBar.setAlignment(Pos.CENTER);
        sortBar.setStyle("-fx-background-color: WHITE; -fx-border-color: LIGHTGRAY; -fx-border-width: 0 0 1 0; -fx-padding: 10 20 20 20;");

        VBox mainBox = new VBox(30); 
        mainBox.setAlignment(Pos.TOP_CENTER);
        mainBox.setStyle("-fx-background-color: WHITE;"); 

        ScrollPane scrollPane = new ScrollPane(mainBox);
        scrollPane.setFitToWidth(true);
        scrollPane.setStyle("-fx-background: WHITE; -fx-background-color: WHITE; -fx-border-color: transparent;");

        contentArea.getChildren().addAll(title, sortBar, scrollPane);

        updateProductDisplay(mainBox, sortBox.getValue());
        sortBox.setOnAction(e -> updateProductDisplay(mainBox, sortBox.getValue()));
    }

    private void updateProductDisplay(VBox mainBox, String sortValue) {
        mainBox.getChildren().clear();

        String[] categories = {"Refrigerator", "TV", "WashingMachine", "AirConditioner"};

        for (String category : categories) {

            VBox categoryBox = new VBox(15);
            categoryBox.setPadding(new Insets(15, 0, 15, 0));
            categoryBox.setAlignment(Pos.TOP_CENTER);

            Label categoryLabel = new Label(category.toUpperCase());
            categoryLabel.setFont(Font.font("System", FontWeight.EXTRA_BOLD, 13));
            categoryLabel.setTextFill(Color.WHITE);
            categoryLabel.setStyle("-fx-text-fill: WHITE; -fx-background-color: DARKSLATEGRAY; -fx-background-radius: 20; -fx-padding: 6 20 6 20;");

            VBox cardsContainer = new VBox(20); 
            cardsContainer.setAlignment(Pos.CENTER);

            boolean hasProduct = false;

            Product[] temp = new Product[productCount];
            for (int i = 0; i < productCount; i++) {
                temp[i] = products[i];
            }

            if (!sortValue.equals("Default")) {
                for (int i = 0; i < productCount - 1; i++) {
                    for (int j = i + 1; j < productCount; j++) {
                        boolean swap = false;
                        switch (sortValue) {
                            case "Name (A-Z)": swap = temp[i].getProductName().compareToIgnoreCase(temp[j].getProductName()) > 0; break;
                            case "Name (Z-A)": swap = temp[i].getProductName().compareToIgnoreCase(temp[j].getProductName()) < 0; break;
                            case "Price (Low → High)": swap = temp[i].getPrice() > temp[j].getPrice(); break;
                            case "Price (High → Low)": swap = temp[i].getPrice() < temp[j].getPrice(); break;
                        }
                        if (swap) {
                            Product t = temp[i];
                            temp[i] = temp[j];
                            temp[j] = t;
                        }
                    }
                }
            }

            for (int i = 0; i < productCount; i++) {
                if (temp[i] != null && temp[i].getClass().getSimpleName().equals(category)) {
                    hasProduct = true;
                    cardsContainer.getChildren().add(createProductCard(temp[i], i));
                }
            }

            if (!hasProduct) {
                Label empty = new Label("No inventory currently available.");
                empty.setFont(Font.font("System", FontWeight.MEDIUM, 13));
                empty.setTextFill(Color.SLATEGRAY);
                empty.setAlignment(Pos.CENTER);
                empty.setPrefWidth(700);
                empty.setPrefHeight(80);
                empty.setStyle("-fx-border-color: SILVER; -fx-border-style: dashed; -fx-border-radius: 10; -fx-border-width: 2; -fx-background-color: ALICEBLUE; -fx-background-radius: 10;");
                cardsContainer.getChildren().add(empty);
            }

            categoryBox.getChildren().addAll(categoryLabel, cardsContainer);
            mainBox.getChildren().add(categoryBox);
        }
    }
    
    private HBox createProductCard(Product product, int index) {

        HBox card = new HBox(40);
        card.setPadding(new Insets(25));
        card.setAlignment(Pos.CENTER_LEFT);
        card.setMaxWidth(700);

        ImageView icon = new ImageView();
        String type = product.getClass().getSimpleName();

        if (type.equals("Refrigerator"))
            icon.setImage(new Image(getClass().getResourceAsStream("refrigerator.png")));
        else if (type.equals("TV"))
            icon.setImage(new Image(getClass().getResourceAsStream("tv.png")));
        else if (type.equals("WashingMachine"))
            icon.setImage(new Image(getClass().getResourceAsStream("washingmachine.png")));
        else if (type.equals("AirConditioner"))
            icon.setImage(new Image(getClass().getResourceAsStream("aircon.png")));

        icon.setFitWidth(110);
        icon.setFitHeight(110);
        icon.setPreserveRatio(true);

        StackPane imageFrame = new StackPane(icon);
        imageFrame.setPrefSize(130, 130);
        imageFrame.setStyle("-fx-background-color: ALICEBLUE; -fx-background-radius: 10;");

        VBox details = new VBox(8);
        details.setAlignment(Pos.CENTER_LEFT);

        Label header = new Label("Product " + (index + 1));
        header.setFont(Font.font("System", FontWeight.EXTRA_BOLD, 12));
        header.setTextFill(Color.BLACK);

        details.getChildren().add(header);

        String[] lines = product.toString().split("\n");

        for (String line : lines) {
            TextFlow flow = new TextFlow();

            if (line.contains(":")) {
                String[] parts = line.split(":", 2);

                Text label = new Text(parts[0] + ": ");
                label.setFont(Font.font("System", FontWeight.BOLD, 13));
                label.setFill(Color.DIMGRAY);

                Text value = new Text(parts[1]);
                value.setFont(Font.font("System", 13));
                value.setFill(Color.BLACK);

                if (parts[0].toLowerCase().contains("status")) {
                    value.setFont(Font.font("System", FontWeight.BOLD, 13));
                    if (parts[1].toLowerCase().contains("true") || parts[1].toLowerCase().contains("active")) {
                        value.setText(" Active");
                        value.setFill(Color.GREEN);
                    } else {
                        value.setText(" Discontinued");
                        value.setFill(Color.RED);
                    }
                }

                flow.getChildren().addAll(label, value);
            } 
            else
                flow.getChildren().add(new Text(line));
            details.getChildren().add(flow);
        }

        card.getChildren().addAll(imageFrame, details);
        card.setStyle("-fx-background-color: WHITE; -fx-background-radius: 15; -fx-border-color: LIGHTGRAY; -fx-border-radius: 15; -fx-border-width: 1;");
        card.setOnMouseEntered(e -> {
            card.setStyle("-fx-background-color: GHOSTWHITE; -fx-background-radius: 15; -fx-border-color: SLATEGRAY; -fx-border-radius: 15; -fx-border-width: 2;");
            card.setTranslateY(-4);
        });

        card.setOnMouseExited(e -> {
            card.setStyle("-fx-background-color: WHITE; -fx-background-radius: 15; -fx-border-color: LIGHTGRAY; -fx-border-radius: 15; -fx-border-width: 1;");
            card.setTranslateY(0);
        });

        return card;
    }
 
    private void addStockPage(VBox operationPane) {
        operationPane.getChildren().clear();
        operationPane.setAlignment(Pos.CENTER);

        VBox card = new VBox(20);
        card.setAlignment(Pos.CENTER);
        card.setPadding(new Insets(40));
        card.setMaxWidth(500);
        card.setMaxHeight(400);
        card.setSpacing(20); 
        card.setFillWidth(true);
        card.setStyle("-fx-background-color: GHOSTWHITE; -fx-background-radius: 10; -fx-border-color: LIGHTSTEELBLUE; -fx-border-radius: 10;");

        Label title = new Label("Add Stock");
        title.setFont(Font.font("System", FontWeight.BOLD, 22));
        
        ComboBox<String> productSelector = new ComboBox<>();
        productSelector.setPromptText("Select a Product");
        productSelector.setPrefWidth(250); 
        productSelector.setStyle("-fx-background-color: WHITE; -fx-border-color: SILVER;");
        
        for (int i = 0; i < productCount; i++)
            productSelector.getItems().add("#" + products[i].getItemNum() + " " + products[i].getProductName() + "  • Stock: " + products[i].getQuantity());
        
        Label lblSelect = new Label("Select Product:");
        lblSelect.setMinWidth(100); 
        HBox hbox1 = new HBox(15, lblSelect, productSelector);
        hbox1.setAlignment(Pos.CENTER); 
        hbox1.setMaxWidth(400);

        Label lblQty = new Label("Quantity:");
        lblQty.setMinWidth(100); 
        TextField qtyField = new TextField();
        qtyField.setPromptText("Enter Quantity");
        qtyField.setPrefWidth(250);
        HBox hbox2 = new HBox(15, lblQty, qtyField);
        hbox2.setAlignment(Pos.CENTER);
        hbox2.setMaxWidth(400);

        Button confirm = new Button("CONFIRM");
        confirm.setPrefWidth(100);
        confirm.setStyle("-fx-background-color: DARKSLATEGRAY; -fx-text-fill: WHITE; -fx-font-weight: bold;");
        
        Label msg = new Label();

        confirm.setOnAction(e -> {
            try {
                if (productSelector.getValue() == null) {
                    msg.setText("✖ Please select a product!");
                    msg.setTextFill(Color.RED);
                    return;
                }
                
                String selectedString = productSelector.getValue();

                int selectedItemNum = Integer.parseInt(
                        selectedString.split(" ")[0].replace("#", ""));
                
                Product target = null;
                for (int i = 0; i < productCount; i++) {
                    if (products[i].getItemNum() == selectedItemNum) {
                        target = products[i];
                        break;
                    }
                }

                if (target == null || !target.getStatus()) {
                    msg.setText("✖ Error: Product is Discontinued!");
                    msg.setTextFill(Color.RED);
                    return;
                }
                
                int qty = Integer.parseInt(qtyField.getText());
                if (qty <= 0) {
                    msg.setText("✖ Quantity must be greater than 0!");
                    msg.setTextFill(Color.RED);
                    return;
                }
                
                String unitText = (qty == 1) ? "unit" : "units";
                target.addQuantity(qty);
                msg.setText("✔ Added " + qty + " " + unitText + " to " + target.getProductName());
                msg.setTextFill(Color.GREEN);
                qtyField.clear();

            } catch (NumberFormatException ex) {
                msg.setText("⚠ Please enter a valid number!");
                msg.setTextFill(Color.RED);
            }
        });

        card.getChildren().addAll(title, hbox1, hbox2, confirm, msg);
        operationPane.getChildren().add(card);
    }
    
    private void deductStockPage(VBox operationPane) {
    	 operationPane.getChildren().clear();
         operationPane.setAlignment(Pos.CENTER);

         VBox card = new VBox(20);
         card.setAlignment(Pos.CENTER);
         card.setPadding(new Insets(40));
         card.setMaxWidth(500);
         card.setMaxHeight(400);
         card.setSpacing(20); 
         card.setFillWidth(true);
         card.setStyle("-fx-background-color: GHOSTWHITE; -fx-background-radius: 10; -fx-border-color: LIGHTSTEELBLUE; -fx-border-radius: 10;");

         Label title = new Label("Deduct Stock");
         title.setFont(Font.font("System", FontWeight.BOLD, 22));
         
         ComboBox<String> productSelector = new ComboBox<>();
         productSelector.setPromptText("Select a Product");
         productSelector.setPrefWidth(250); 
         productSelector.setStyle("-fx-background-color: WHITE; -fx-border-color: SILVER;");
         
         for (int i = 0; i < productCount; i++)
             productSelector.getItems().add("#" + products[i].getItemNum() + " " + products[i].getProductName() + "  • Stock: " + products[i].getQuantity());
         
         Label lblSelect = new Label("Select Product:");
         lblSelect.setMinWidth(100); 
         HBox hbox1 = new HBox(15, lblSelect, productSelector);
         hbox1.setAlignment(Pos.CENTER); 
         hbox1.setMaxWidth(400);

         Label lblQty = new Label("Quantity:");
         lblQty.setMinWidth(100); 
         TextField qtyField = new TextField();
         qtyField.setPromptText("Enter Quantity");
         qtyField.setPrefWidth(250);
         HBox hbox2 = new HBox(15, lblQty, qtyField);
         hbox2.setAlignment(Pos.CENTER);
         hbox2.setMaxWidth(400);

         Button confirm = new Button("CONFIRM");
         confirm.setPrefWidth(100);
         confirm.setStyle("-fx-background-color: DARKSLATEGRAY; -fx-text-fill: WHITE; -fx-font-weight: bold;");
         
         Label msg = new Label();

         confirm.setOnAction(e -> {
             try {
                 if (productSelector.getValue() == null) {
                     msg.setText("✖ Please select a product!");
                     msg.setTextFill(Color.RED);
                     return;
                 }
                 
                 String selectedString = productSelector.getValue();

                 int selectedItemNum = Integer.parseInt(
                     selectedString.split(" ")[0].replace("#", ""));
                 
                 Product target = null;
                 for (int i = 0; i < productCount; i++) {
                     if (products[i].getItemNum() == selectedItemNum) {
                         target = products[i];
                         break;
                     }
                 }
                 int qty = Integer.parseInt(qtyField.getText());

                 if (Integer.parseInt(qtyField.getText()) > target.getQuantity()) {
                     msg.setText("✖ Error: Invalid amount or insufficient stock!");
                     msg.setTextFill(Color.RED);
                     return;
                 }
                 
                 if (qty <= 0) {
                     msg.setText("✖ Quantity must be greater than 0!");
                     msg.setTextFill(Color.RED);
                     return;
                 }
                 
                 String unitText = (qty == 1) ? "unit" : "units";
                 target.deductQuantity(qty);
                 msg.setText("✔ Deducted " + qty + " " + unitText + " from " + target.getProductName());
                 msg.setTextFill(Color.GREEN);
                 qtyField.clear();

             } catch (NumberFormatException ex) {
                 msg.setText("⚠ Please enter a valid number !");
                 msg.setTextFill(Color.RED);
             }
         });

         card.getChildren().addAll(title, hbox1, hbox2, confirm, msg);
         operationPane.getChildren().add(card);
    }
	
    private void discontinueProduct(Product[] products, VBox rightPane) {
        rightPane.getChildren().clear();
        rightPane.setAlignment(Pos.CENTER);

        VBox cardPane = new VBox(20);
        cardPane.setAlignment(Pos.CENTER);
        cardPane.setPadding(new Insets(40));
        cardPane.setMaxWidth(500);
        cardPane.setMaxHeight(400);
        cardPane.setSpacing(20); 
        cardPane.setFillWidth(true);
        cardPane.setStyle("-fx-background-color: GHOSTWHITE; -fx-background-radius: 10; -fx-border-color: LIGHTSTEELBLUE; -fx-border-radius: 10;");

        Label title = new Label("Discontinue Product");
        title.setFont(Font.font("System", FontWeight.BOLD, 22));

        Label noProduct = new Label("");
        noProduct.setVisible(false);
        noProduct.managedProperty().bind(noProduct.visibleProperty());
        
        Label prompt = new Label("Select Item:");
        prompt.setMinWidth(80); 
        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.setPrefWidth(250);
        comboBox.setStyle("-fx-background-color: WHITE; -fx-border-color: SILVER;");

        boolean hasActiveProducts = false;

        for (int i = 0; i < productCount; i++) {
            if (products[i] != null && products[i].getStatus()) {
                comboBox.getItems().add("#" + products[i].getItemNum() + " " + 
                products[i].getProductName());
                hasActiveProducts = true;
            }
        }

        if (!hasActiveProducts) {
        	noProduct.setText("No active products available.");
        	noProduct.setTextFill(Color.RED);
        	noProduct.setVisible(true);
            comboBox.setDisable(true);
        }

        HBox hbox = new HBox(15, prompt, comboBox);
        hbox.setAlignment(Pos.CENTER);
        hbox.setMaxWidth(400);
        
        Button confirmBtn = new Button("Confirm Discontinue");
        confirmBtn.setStyle("-fx-background-color: DARKSLATEGRAY; -fx-text-fill: WHITE; -fx-font-weight: bold;");
        Label resultLabel = new Label();

        confirmBtn.setOnAction(e -> {
            String selectedItemStr = comboBox.getValue();

            if (selectedItemStr != null) {
                boolean found = false;
                int selectedItemNum = Integer.parseInt(selectedItemStr.split(" ")[0].replace("#", ""));
                for (int i = 0; i < productCount; i++) {
                    if (products[i] != null && products[i].getItemNum() == selectedItemNum) {
                        products[i].setStatus(false); 
                        found = true;
                        break;
                    }
                }

                if (found) {
                    resultLabel.setTextFill(Color.GREEN);
                    resultLabel.setText("✔ Product discontinued successfully!");

                    comboBox.setDisable(true);
                    confirmBtn.setDisable(true);
                } else {
                    resultLabel.setTextFill(Color.RED);
                    resultLabel.setText("✖ Product not found.");
                }

            } else {
                resultLabel.setTextFill(Color.RED);
                resultLabel.setText("✖ Please select an Item.");
            }
        });

        cardPane.getChildren().addAll(title, noProduct, hbox, confirmBtn, resultLabel);
        rightPane.getChildren().add(cardPane);
    }
	
    private BorderPane exitPage(Stage stage) {
        Image image = new Image(getClass().getResourceAsStream("exit.png")); 
        ImageView imageView = new ImageView(image);
        
        imageView.setFitWidth(1000); 
        imageView.setPreserveRatio(true);
        imageView.setOpacity(0.3);
        imageView.setManaged(false);
        
        Text title = new Text("Thanks for Using!");
        title.setFont(Font.font("System", FontWeight.EXTRA_BOLD, 70));
        title.setFill(Color.DARKSLATEGRAY);
        
        Text subtitle = new Text("Inventory session ended successfully.");
        subtitle.setFont(Font.font("System", FontWeight.LIGHT, 16));
        subtitle.setFill(Color.GRAY);
        
        HBox userCard = new HBox(50);
        userCard.setAlignment(Pos.CENTER);
        userCard.setPadding(new Insets(10));
        userCard.setMaxWidth(300);
        userCard.setStyle("-fx-background-color: GHOSTWHITE; -fx-background-radius: 10; -fx-border-color: LIGHTSTEELBLUE; -fx-border-radius: 10;");

        Label nameLabel = new Label("Name : " + user.getName());
        nameLabel.setFont(Font.font("System", FontWeight.NORMAL, 14));
        nameLabel.setTextFill(Color.DARKSLATEGRAY);

        Text useridVal = new Text("ID : " + user.getUserID());
        useridVal.setFont(Font.font("System", FontWeight.NORMAL, 14));
        useridVal.setFill(Color.DARKSLATEGRAY);

        userCard.getChildren().addAll(nameLabel, useridVal);

        VBox mainContainer = new VBox(25, title, subtitle, userCard);
        mainContainer.setAlignment(Pos.CENTER);
        mainContainer.setStyle("-fx-background-color: transparent;"); 

        StackPane stack = new StackPane();
        stack.setAlignment(Pos.CENTER); 
        stack.getChildren().addAll(imageView, mainContainer);
        stack.setMaxSize(1000, 600); 
        stack.setStyle("-fx-background-color: ALICEBLUE;");
        
        BorderPane pane = new BorderPane();
        pane.setCenter(stack);
        
        Scene scene4 = new Scene(pane, 1000, 600);
        stage.setScene(scene4);

        return pane;
    }
    
}

