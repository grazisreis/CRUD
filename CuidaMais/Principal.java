import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


public class Principal {
    public static void main(String[] args) {

        List<Cuidador> cuidadores = new ArrayList<>();
        Scanner entrada = new Scanner(System.in);
        String login;
        String resposta;
        int i = 0;

        while (true) {
            System.out.println("CUIDAMAIS+");
            System.out.println("Como deseja acessar o sistema?\n[1] Cuidador\n[2] Familiar");

            while (true) {
                resposta = entrada.nextLine();
                if (resposta.equals("1") || resposta.equals("2")) {
                    break;
                } else {
                    System.out.println("Responda corretamente.");
                }
            }
    
            if (resposta.equals("1")) {
                // O USUÁRIO É CUIDADOR
                System.out.println("Você selecionou a opção Cuidador.");
                System.out.println("Digite seu CPF para fazer login. Caso queira se cadastrar, digite '000'.");
                login = entrada.nextLine();

                if (login.equals("000")) {
                    System.out.println("Insira seu CPF");
                    String cpf = entrada.nextLine();
                    System.out.println("Insira seu nome");
                    String nome = entrada.nextLine();
                    System.out.println("Insira sua idade");
                    int idade = entrada.nextInt();
                    System.out.println("Insira seu telefone");
                    String telefone = entrada.nextLine(); 
                    
                    cuidadores.add(i, null);
                    i++;
                    System.out.println("Usuário criado!");
                }

                else{

                    System.out.println("Listar cadastro [3]");
                    System.out.println(cuidadores);
                }
            }
            if (resposta.equals("2")) {
                // O USUÁRIO É FAMILIAR
            }

        }
        
        


    }
}
