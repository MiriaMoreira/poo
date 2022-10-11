import java.util.Scanner;

public class User {
    int type;
    String name;
    private String password;
    String email;
    
    User(int type, String name, String email, String password){
        this.type = type;
        this.name = name;
        this.email = email;
        
        this.password = password;
    }
    public boolean equals(Object obj) {
    	if(obj instanceof User) {
    		User user = (User)obj;
    		if(user.email == this.email) {
    			return true;
    		}
    	}
		return false;
    	
    }
    
    boolean verify( String password) {
    	if(password.equals(this.password))
    		return true;
    	return false;
    }
    
    String getEmail() {
    	return this.email;
    }
    
}
