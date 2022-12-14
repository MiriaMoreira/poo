import java.util.ArrayList;

public class User {
    
    String name;
    private String password;
    String email;
    ArrayList<Project> projects = new ArrayList<>();
    Bolsa bolsa;
    private String city;
    
    User(String name, String email, String password, String city){
        
        this.name = name;
        this.email = email;
        this.city = city;
        this.password = password;
    }
    
    public void setBolsa(Bolsa bolsa){
    	this.bolsa = bolsa;
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

    public void setCity(String city){
        this.city = city;
    }
    
    boolean verify( String password) {
    	if(password.equals(this.password))
    		return true;
    	return false;
    }
    
    String getEmail() {
    	return this.email;
    }
    
    String getName() {
    	return this.name;
    }
    
}
