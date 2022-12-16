public class InProcessOfCreation extends State {

    @Override
    public State changeStatus() {
        State nextState = new Started();
        return nextState;
    }

    @Override
    public String status() {
        return "Em processo de criacao";
    }
    
}
