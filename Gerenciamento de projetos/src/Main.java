import java.util.ArrayList;
import java.util.Scanner;

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
                    		login(u, projects);
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

    public static void login(User user, ArrayList<Project> projects){
       
        int value = -1;

        Scanner input = new Scanner(System.in);

        while(value != 0){

            System.out.println("================================================\n");
            System.out.println("Bem vindo(a), selecione o que gostaria de fazer:\n");
            System.out.println("0 - logoff");
            System.out.println("1 - Alterar Dados do usuario");
            System.out.println("2 - Projetos");
            System.out.println("3 - Consultar");
            System.out.println("================================================\n");
            
            value = input.nextInt();

            switch(value){

                case 1:
                    System.out.println("O que gostaria de alterar?");
                    System.out.println("1 - Alterar nome");
                    System.out.println("2 - Alterar email");
                    System.out.println("3 - Alterar senha");
                    System.out.println("4 - Alterar Tipo");

                    int option = input.nextInt();
                    input.nextLine();

                    switch(option){
                        case 1:
                            System.out.println("Digite o novo nome:");
                            String name = input.nextLine();
                            user.setName(name);
                            break;
                        case 2:
                            System.out.println("Digite oo novo email:");
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
                            break;
                    }
                    break;

                case 2:
                    System.out.println("Selecione um projeto para vizualizar/alterar ou crie um novo projeto:");
                    int i = 1;
                    if(user.type == 2 || user.type == 3){
                        System.out.println("1 - Criar Projeto");
                        i++;
                    }
                    if(user.projects.isEmpty()){
                        
                        System.out.println("Voce ainda nao possui nenhum projeto");

                    } else{

                        for(Project project : user.projects){
                            System.out.println(i + " - " + project);
                            i++;
                        }

                    }
                    break;

                case 3:
                    break;

                default:
                    break;
            }
        }
    }


}
