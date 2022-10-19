public class Status {
    String status;

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
                this.status = "Concuido";
                break;
            default:
                this.status = "Em processo de criacao";
                break;
        }
    }
}