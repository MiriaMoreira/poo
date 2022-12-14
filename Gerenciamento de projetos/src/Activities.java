import java.util.ArrayList;

public class Activities {
    
    public int IDA;
    public String description;
    Period activity_period;
    String responsible;
    ArrayList<Task> tasks;

    Activities(int ida, String description, Period activity_period, String responsible, ArrayList<Task> tasks){
    	this.IDA = ida;
    	this.description = description;
    	this.activity_period = activity_period;
    	this.responsible = responsible;
    	this.tasks = tasks;
    }
}
