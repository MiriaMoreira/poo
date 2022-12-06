import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class Main {
    public static void main(String[] args) {
        
        System.out.println("");
        System.out.println("================================================\n");
        System.out.println("Sistema de Gerenciamento de Projetos\n");
        System.out.println("================================================\n");


        Scanner input = new Scanner(System.in);
        int n = 4;
        ArrayList<User> users = new ArrayList<>();
        ArrayList<Project> projects = new ArrayList<>();

        while(n != 0){
            System.out.println("Escolha uma opcao");
            System.out.println("0 - Sair do Sistema");
            System.out.println("1 - Fazer Login");
            System.out.println("2 - Criar Conta");
            System.out.println("================================================\n");

            n = input.nextInt();
            input.nextLine();


            String email, name, password;

            switch (n){
                case 1:
                    System.out.println("Email: ");
                    email = input.nextLine();
                    
                    System.out.println("Senha: ");
                    password = input.nextLine();
                    
                    User u = buscarEmail(users, email);
                    if(u == null)
                    	System.out.println("Usuario nao encontrado\n");
                    else {
                    	if(u.verify(password)) {
                    		login(u, projects, users);
                    	}
                    	else {
                    		System.out.println("A senha esta incorreta\n");
                    	}
                    }
                    
                    break;

                case 2:
                 
                    int type;
                    
                    System.out.println("\nDigite o seu nome completo: ");
                    name = input.nextLine();

                    System.out.println("\nDigite o seu email: ");
                    email = input.nextLine();
                    
                
                    System.out.println("\nDigite uma senha:");
                    password = input.nextLine();

                    System.out.println("\nDigite o tipo de usuario: \n");
                    System.out.println("1 - Aluno");
                    System.out.println("2 - Professor");
                    System.out.println("3 - Pesquisador");
                    System.out.println("4 - Profisional");
                    System.out.println("5 - Tecnico");
                    
                    type = input.nextInt();
                    System.out.println("================================================\n");

                    users.add(new User(type, name, email, password));
                    System.out.println("Usuario cadastrado\n");
                    break;

                default:
                    break;
            }
        }
    }
    public static User buscarEmail(ArrayList<User> users, String email) {
    	
    	for(User user: users) {	
    		if(email.equals(user.getEmail()))
    			return user;
    	}
    	return null;
    }
    
    public static User buscarNome(ArrayList<User> users, String name) {
    	
    	for(User user: users) {
    		if(name.equals(user.getName()))
    			return user;
    	}
    	return null;
    }

    public static void open_project(Project project){

    }

    public static void create_project(ArrayList<Project> projects, ArrayList<User> users){

        Scanner input = new Scanner(System.in);

        System.out.println("\nDigite o titulo do projeto: ");
        String title = input.nextLine();

        System.out.println("\nDigite a descricao do projeto: ");
        String description = input.nextLine();
        
        System.out.println("\nDuração do projeto:");
        Period project_period = setPeriod();

        System.out.println("\nDigite o do coordenador do projeto");
        String coordinator = input.nextLine();
        
        ArrayList<String> p_involved = new ArrayList<String>();
        System.out.println("\nDigite os nomes dos profissionais envolvidos no projeto, digite \"fim\" quando terminar");
        String e_name = input.nextLine();

        while(!"fim".equals(e_name)){
        	
            User user = buscarNome(users, e_name);
            
            if(user == null) {
            	System.out.println("Usuario nao encontrado");
            }
            else {
            	
            	p_involved.add(e_name);
            	System.out.println("\nDigite o valor da bolsa para " + e_name + ":");
                
                int value = input.nextInt();

                input.nextLine();
                
                System.out.println("\nPeriodo de vigencia da bolsa:");
                
                Period period = setPeriod();
                
                Bolsa bolsa = new Bolsa(value, period);
                
                user.setBolsa(bolsa);
                
            }
            e_name = input.nextLine();
        }
        
        boolean done = false;
        
        ArrayList<Activities> activities = new ArrayList<Activities>();
        
        while(!done) {
        	System.out.println("0 - concluir criacao do projeto");
        	System.out.println("1 - Adicionar Atividade");
        	
        	int value = input.nextInt();
        	
        	if(value == 1)
        		activities.add(create_activity(activities));
        	else
        		done = true;
        }
        projects.add(new Project(projects.size()+1, title, description, project_period, coordinator, p_involved));
        projects.get(projects.size()-1).setStatus();
        
        System.out.println("Projeto adicionado");
        System.out.println("Status do projeto: " + projects.get(projects.size()-1).getStatus());
        
    }
    
        
    
    public static Activities create_activity(ArrayList<Activities> activities) {
    	
    	Scanner input = new Scanner(System.in);
    	
    	System.out.println("Digite a descricao da atividade ");
    	String description = input.nextLine();
    	
    	Period period = setPeriod();
    	
    	System.out.println("Digite o nome do responsavel pela atividade ");
    	String responsible = input.nextLine();
    	
    	System.out.println("Digite os nomes pds profissionais envolvidos na atividade e a tarefa a ser executada por ele:");
    	System.out.println("**Digite \"fim\" quando terminar");
    	System.out.println("================================================\n");
    	String name = " ";
    	String task;
    	ArrayList<Task> tasks = new ArrayList<Task>();
    	
    	
    	while(!"fim".equals(name)) {
    		System.out.println("Nome do profissional: (ou fim, caso nao haja mais profissionais envolvidos na atividade)");
    		name = input.nextLine();
    		
    		if("fim".equals(name))
    			break;
    		
    		System.out.println("Digite a tarefa a ser executada por esse profissional: \n");
    		task = input.nextLine();
    		
    		tasks.add(new Task(name, task));
    	}
    	
    	Activities activity = new Activities(activities.size()+1, description, period, responsible, tasks);
    	
    	return activity;
    	
    }
    
    public static Period setPeriod() {
    	
    	Scanner input = new Scanner(System.in);
    	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date begin = new Date();
        Date end = new Date();

        boolean done = false;

        while(!done){
            System.out.println("Digite a data de inicio com o formato: dd/mm/aaaa");
            String i_date = input.nextLine();
            System.out.println("Digite a data de termino com o formato: dd/mm/aaaa");
            String e_date = input.nextLine();

            try{
                begin = sdf.parse(i_date);
                end = sdf.parse(e_date);
                done = true;
            } catch (ParseException e){
                System.out.println("Formato de entrada invalido, digite seguindo o formato: dd/mm/aaaa");
            }
        }
        
        Period new_period = new Period(begin, end);
    	return new_period;
    }

    public static void change_user_data(User user){

        System.out.println("O que gostaria de alterar?");
            System.out.println("1 - Alterar nome");
            System.out.println("2 - Alterar email");
            System.out.println("3 - Alterar senha");
            System.out.println("4 - Alterar Tipo");

            Scanner input = new Scanner(System.in);

            int option = input.nextInt();
            input.nextLine();

            switch(option){

                case 0:
                    break;
                case 1:
                    System.out.println("Digite o novo nome:");
                    String name = input.nextLine();
                    user.setName(name);
                    break;
                case 2:
                    System.out.println("Digite o novo email:");
                    String email = input.nextLine();
                    user.setEmail(email);
                    break;
                case 3:
                    System.out.println("Digite a nova senha:");
                    String password = input.nextLine();
                    user.setPassword(password);
                    break;
                case 4:
                    System.out.println("\nDigite o tipo de usuario: \n");
                    System.out.println("1 - Aluno");
                    System.out.println("2 - Professor");
                    System.out.println("3 - Pesquisador");
                    System.out.println("4 - Profisional");
                    System.out.println("5 - Tecnico");

                    int type = input.nextInt();
                    user.setType(type);
                    break;
                default:
                    System.out.println("Opcao invalida");
                    break;
            }
    }

    public static void login(User user, ArrayList<Project> projects, ArrayList<User> users){
       
        int value = -1;

        Scanner input = new Scanner(System.in);

        while(value != 0){

            System.out.println("================================================\n");
            System.out.println("Bem vindo(a), selecione o que gostaria de fazer:\n");
            System.out.println("0 - logoff");
            System.out.println("1 - Alterar Dados do usuario");
            System.out.println("2 - Criar Projeto");
            System.out.println("3 - Editar Projeto");
            System.out.println("4 - Consultar");
            System.out.println("================================================\n");
            
            value = input.nextInt();

            switch(value){

                case 1:
                    change_user_data(user);
                    break;

                case 2:
                    create_project(projects, users);
                    break;

                case 3:
                    if(user.projects.isEmpty()){
                                
                        System.out.println("Voce ainda nao possui nenhum projeto");

                    } else{
                        int i = 0;
                        System.out.println("Selecione o projeto que gostaria de editar:");
                        for(Project project : user.projects){
                            System.out.println(i + " - " + project);
                            i++;
                        }
                        int valor = input.nextInt();
                        open_project(user.projects.get(valor));
                    }
                            
                    break;
                case 4:
                	break;

                default:
                    break;

                    }
        }
    }


}
