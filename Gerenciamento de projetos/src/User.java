import java.util.Scanner;

public class User {
    String type;
    String name;
    private String password;
    String username;
    
    User(String type, String name, String username, String password){
        this.type = type;
        this.name = name;
        this.username = username;
        
        this.password = password;
    }
}
