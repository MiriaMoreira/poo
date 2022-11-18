import java.util.ArrayList;
import java.util.Date;


public class Project {
    
    public int idp;
    public String title;
    public String description;
    Period project_period;
    String coordinator;
    ArrayList<String> p_involved = new ArrayList<String>();
    ArrayList<Activities> activities;
    

    Project(int idp, String title, String description, Period project_period, 
    		String coordinator, ArrayList<String> p_involved){

        this.idp = idp;
        this.title = title;
        this.description = description;
        this.project_period = project_period;
        this.coordinator = coordinator;
        this.p_involved = p_involved;
    
    }
}
