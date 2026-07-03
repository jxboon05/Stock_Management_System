
public class UserInfoGUI {

	private String name;
	private String userID = "guest";
	
	public void setName(String name) { this.name = name; }
	public void setUserID(String name) {
		
		for (int i = 0; i < name.length(); i++) {
			if (Character.isSpaceChar(name.charAt(i))) {
			    int lastSpace = name.lastIndexOf(" ");
			    String surname = name.substring(lastSpace + 1);
			    userID = name.charAt(0) + surname;
				break;
			}
		}
	}
	
	//Getter
	public String getUserID() { return userID; }
    public String getName() { return name; }
    
    public boolean checkName(String name) {
    	
    	for (int i = 0; i < name.length(); i++) {
            char ch = name.charAt(i);
            if (!Character.isLetter(ch) && !Character.isSpaceChar(ch))
                return false;
        }
    	return true;
    }
	
}
