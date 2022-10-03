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

        while(n != 0){
            System.out.println("Escolha uma opcao");
            System.out.println("0 - Sair do Sistema");
            System.out.println("1 - Fazer Login");
            System.out.println("2 - Criar Conta");
            System.out.println("================================================\n");

            n = input.nextInt();
            input.nextLine();


            String username;

            switch (n){
                case 1:
                    System.out.println("Digite o nome de usuario");
                    username = input.nextLine();
                    
                    break;

                case 2:
                    String name, password, type;
                    System.out.println("Digite o nome do usuario");
                    name = input.nextLine();

                    System.out.println("Digite um nome de usuario");
                    username = input.nextLine();
                    System.out.println("Nome de usuario: " + username);
                    /*if(users.stream().anyMatch(i -> i.username == username)){
                        System.out.println("username invalido");
                    }*/
                
                    System.out.println("Digite uma senha:");
                    password = input.nextLine();

                    System.out.println("Digite o tipo de usuario: ");
                    type = input.nextLine();

                    users.add(new User(name, type, username, password));
                    break;

                default:
                    break;
            }
        }
        

        

    }
}
