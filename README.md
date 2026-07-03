# Stock Management System

## Overview
A JavaFX desktop application for managing household appliance inventory. The system allows users to manage products, track stock levels, and perform inventory operations through a graphical user interface.

## Features
- User authentication
- Add, update, and delete products
- Inventory management
- Product categorization
- JavaFX graphical interface

## Technologies Used
- Java
- JavaFX
- Eclipse IDE

## Setup & Installation
### Prerequisites
* Java Development Kit (JDK) 21
* JavaFX SDK 21 (Matching your Mac architecture)

### Configuration in Eclipse
1. Clone or download this repository.
2. Import the project into Eclipse as a Java Project.
3. Right-click the project -> **Build Path** -> **Configure Build Path**.
4. Under the **Libraries** tab, select **Modulepath**, click **Add External JARs...**, and add all the `.jar` files from your downloaded JavaFX `lib` folder.
5. Go to **Run** -> **Run Configurations...** -> **Arguments** tab.
6. In the **VM arguments** box, add the following line (replace with your local path):
   ```text
   --module-path "/path/to/javafx-sdk-21/lib" --add-modules javafx.controls,javafx.fxml