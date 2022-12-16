public class Concluded extends State {

    @Override
    public State changeStatus() {
        State nextState = new Concluded();
        return nextState;
    }

    @Override
    public String status() {
        return "Concluido";
    }
    
}
