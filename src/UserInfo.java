import java.util.Scanner;

public class UserInfo {

    private String name;
    private String userID = "guest";

    //Setter
    public void setName(String name) { this.name = name; }
    public void setUserID(String name) {
        int lastSpace = name.lastIndexOf(" ");
        String surname = name.substring(lastSpace + 1);
        this.userID = name.charAt(0) + surname;
    }

    // Getters
    public String getUserID() { return userID; }
    public String getName() { return name; }

    public void inputName() {
    	Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter your first name and surname: ");
            String inputName = scanner.nextLine().trim();
            
            if (checkName(inputName)) {
                setName(inputName);
                
                for (int i = 0; i < name.length(); i++) {
        			if (Character.isSpaceChar(name.charAt(i))) {
        				setUserID(inputName);
        				break;
        			}
                }
                break;
            } 
            else {
                System.out.println("Invalid input! Please use only letters and spaces.\n");
            }
        }
        scanner.close();
    }
    
    public boolean checkName(String name) {
        if (name.isEmpty()) return false;
        
        for (int i = 0; i < name.length(); i++) {
            char ch = name.charAt(i);
            if (!Character.isLetter(ch) && !Character.isSpaceChar(ch)) {
                return false;
            }
        }
        return true;
    }
}
