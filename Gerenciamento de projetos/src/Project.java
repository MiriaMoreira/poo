import java.util.ArrayList;
import java.util.Date;


public class Project {
    
    public int idp;
    public String title;
    public String description;
    Date begin;
    Date end;
    String coordinator;
    ArrayList<String> p_involved = new ArrayList<String>();

    Project(int idp, String title, String description, Date begin, Date end, String coordinator, ArrayList<String> p_involved){

        this.idp = idp;
        this.title = title;
        this.description = description;
        this.begin = begin;
        this.end = end;
        this.coordinator = coordinator;
        this.p_involved = p_involved;

    }
}
