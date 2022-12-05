import java.util.ArrayList;
import java.util.Date;


public class Project {
    
    public int idp;
    public String title;
    public String description;
    public String status;
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
        this.status = "Em processo de criacao";
    
    }

    public void setStatus() {
    	this.status = "Em processo de criacao";
    }
    
    public void nextStatus(String status){
        switch(status){
            case "Em processo de criacao":
                this.status = "Iniciado";
                break;
            
            case "Iniciado":
                this.status = "Em andamento";
                break;
            case "Em andamento":
                this.status = "Concluido";
                break;
            default:
                this.status = "Em processo de criacao";
                break;
        }
    }
    
    public String getStatus() {
    	return this.status;
    }
}
