import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;

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

    public static void open_project(Project project){

    }

    public static void create_project(User user){
        Scanner input = new Scanner(System.in);

        System.out.println("Digite o titulo do projeto");
        String title = input.nextLine();

        System.out.println("Digite a descricao do projeto");
        String description = input.nextLine();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date ini_date = new Date();
        Date end_date = new Date();

        boolean done = false;

        while(!done){
            System.out.println("Digite a data de inicio com o formato: dd/mm/aaaa");
            String i_date = input.nextLine();
            System.out.println("Digite a data de termino com o formato: dd/mm/aaaa");
            String e_date = input.nextLine();

            try{
                ini_date = sdf.parse(i_date);
                end_date = sdf.parse(e_date);
                done = true;
            } catch (ParseException e){
                System.out.println("Formato de entrada invalido, digite seguindo o formato: dd/mm/aaaa");
            }
        }

        System.out.println("Digite o do coordenador do projeto");
        String c_name = input.nextLine();
        
        ArrayList<String> p_involved = new ArrayList<>();
        System.out.println("Digite os nomes dos participantes do projeto, digite \"fim\" quando terminar");
        String e_name = input.nextLine();

        while(!"fim".equals(e_name)){
            p_involved.add(e_name);
            e_name = input.nextLine();
            
        }
        


    }

    public static void user_changes(User user){

        System.out.println("O que gostaria de alterar?");
                    System.out.println("1 - Alterar nome");
                    System.out.println("2 - Alterar email");
                    System.out.println("3 - Alterar senha");
                    System.out.println("4 - Alterar Tipo");

                    Scanner input = new Scanner(System.in);
                    int option = input.nextInt();
                    input.nextLine();

                    switch(option){
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
                            break;
                    }
    }

    public static void login(User user, ArrayList<Project> projects){
       
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
                    user_changes(user);
                    break;

                case 2:
                    create_project(user);
                    break;

                case 3:
                    break;

                default:
                    break;
            }
        }
    }


}
