public class InProgress extends State {

    @Override
    public State changeStatus() {
        State nextState = new Concluded();
        return nextState;
    }

    @Override
    public String status() {
        return "Em Andamento";
    }
    
}
