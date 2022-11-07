import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;

public class User {
    int type;
    String name;
    private String password;
    String email;
    ArrayList<Project> projects = new ArrayList<>();
    
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

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setType(int type) {
        this.type = type;
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
