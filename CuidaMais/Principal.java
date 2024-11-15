import java.util.Scanner;
import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        ArrayList<Cuidador> arrayCuidadores= new ArrayList<>(); 

        Scanner entrada = new Scanner(System.in);
        String login;
        String resposta;

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

                Cuidador cuidador = new Cuidador(cpf, nome, idade, telefone);

                System.out.println("Usuário criado!");
            }
        }
        if (resposta.equals("2")) {
            // O USUÁRIO É FAMILIAR
        }
        


    }
}
