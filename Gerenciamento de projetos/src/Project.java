import java.util.ArrayList;

public class Project {
    
    public int idp;
    public String title;
    public String description;
    public String status;
    Period project_period;
    String coordinator;
    ArrayList<String> p_involved = new ArrayList<String>();
    ArrayList<Activities> activities;
    public int payments = 1;
    

    public void setParameters(int idp, String title, String description, Period project_period, 
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

    public void setTitle(String title){
        this.title = title;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setPeriod(Period period){
        this.project_period = period;
    }

    public void setCoordinator(String coordinator){
        this.coordinator = coordinator;
    }

    public void Payment(){
        this.payments += 1;
    }

    @Override
    public String toString(){
        return  "ID do projeto: " + this.idp + "\n" + 
                "Titulo " + this.title + "\n" + 
                "Descricao: " + this.description + "\n" +
                "Status: " + this.status + "\n" +
                "Data de inicio: " + this.project_period.toString_begin(this.project_period) + "\n" +
                "Data de termino: " + this.project_period.toString_end(this.project_period) + "\n" +
                "Coordenador do projeto: " + this.coordinator + "\n";
    }

    public String report(){
        return this.toString() + 
                "Quantidade de participantes: " + this.p_involved.size() + "\n" +
                "Meses pagos: " + this.payments + "\n";
    }
}
