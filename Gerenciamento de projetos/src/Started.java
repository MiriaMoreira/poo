public class Started extends State {

    @Override
    public State changeStatus() {
        State nextState = new InProgress();
        return nextState;
        
    }

    @Override
    public String status() {
        return "Iniciado";
    }
    
}
