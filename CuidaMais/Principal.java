import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


public class Principal {
    
    public static void main(String[] args) {
        Database database = new Database();
        Scanner entrada = new Scanner(System.in);
        String login;
        String resposta;
        Cuidador usuarioCuidador = null;

        while (true) {
            System.out.println("-------------");
            System.out.println(" CUIDAMAIS+");
            System.out.println("-------------");
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
                boolean logado = false;
                // O USUÁRIO É CUIDADOR
                System.out.println("Você selecionou a opção Cuidador.");
                System.out.println("Digite seu CPF para fazer login. Caso queira se cadastrar, digite '000'.");
                login = entrada.nextLine();

                if (login.equals("000")) {
                    Principal.cadastrarCuidador(database, entrada);
                    
                } else {
                    for (Cuidador cuidador : database.getCuidadores()) {
                        if (login.equals(cuidador.getCpf())) {
                            System.out.println("Cuidador: " + cuidador.getNome());
                            System.out.println("CPF: " + cuidador.getCpf());
                            System.out.println("Telefone: " + cuidador.getTelefone());
                            System.out.println("Idade: " + cuidador.getIdade() + " anos");
                            logado = true;
                            usuarioCuidador = cuidador;
                        }
                    }
                    if (logado) {
                        System.out.println("\nLOGADO COM SUCESSO!\n");
                        // CRUD PROPRIAMENTE DITO
                        System.out.println("Bem-vind@, " + usuarioCuidador.getNome());
                        System.out.println("");
                        menuCuidador(entrada, usuarioCuidador, database);

                        



                    } else {
                        System.out.println("");
                        System.out.println("CPF NÃO CADASTRADO.");
                        System.out.println("Deseja se cadastrar? [1] SIM [2] NÃO");
                        resposta = entrada.nextLine();
                        System.out.println("");
                        if (resposta.equals("1")) {
                            Principal.cadastrarCuidador(database, entrada);
                        } else {
                            Principal.voltar(entrada);
                        }
                    }
                }

            }
            if (resposta.equals("2")) {
                // O USUÁRIO É FAMILIAR
            }

        }

    }

    public static void cadastrarCuidador(Database database, Scanner entrada) {
        System.out.println("Insira seu CPF:");
        String cpf = entrada.nextLine();
        System.out.println("Insira seu nome:");
        String nome = entrada.nextLine();
        System.out.println("Insira sua idade:");
        int idade = entrada.nextInt();
        entrada.nextLine();
        System.out.println("Insira seu telefone:");
        String telefone = entrada.nextLine();

        Cuidador usuarioCuidador = new Cuidador(cpf, nome, idade, telefone);

        database.setCuidador(usuarioCuidador);

        System.out.println("");
        System.out.println("Usuário " + usuarioCuidador.getNome() + " cadastrado com sucesso! ");
        System.out.println("");

    }

    public static void cadastrarFamiliar(Database database, Scanner entrada) {
        System.out.println("Insira seu CPF:");
        String cpf = entrada.nextLine();
        System.out.println("Insira seu nome:");
        String nome = entrada.nextLine();
        System.out.println("Insira sua idade:");
        int idade = entrada.nextInt();
        entrada.nextLine();

        Familiar usuario_familiar = new Familiar(cpf, nome, idade);

        database.setFamiliar(usuario_familiar);

        System.out.println("");
        System.out.println("Usuário " + usuario_familiar.getNome() + "cadastrado com sucesso! ");
        System.out.println("");
    }

    public static void voltar(Scanner entrada) {
        System.out.println("Pressione [enter] para retornar ao Menu ou digite 0 para encerrar o programa.");
        String resposta = entrada.nextLine();
        if (resposta.equals("0")) {
            System.exit(0);
        }
    }

    public static void menuCuidador(Scanner entrada, Cuidador cuidador, Database database){
        while (true){
            System.out.println("O que deseja fazer?");
            System.out.println("[1] LISTAR SEUS ANÚNCIOS");
            System.out.println("[2] CADASTRAR NOVO ANÚNCIO");
            System.out.println("[3] EDITAR ANÚNCIO");
            System.out.println("[4] DELETAR ANÚNCIO");
            System.out.println("[5] LISTAR TODOS OS ANÚNCIOS");
            System.out.println("[6] VOLTAR AO MENU");
            String resposta = entrada.nextLine();

            switch (resposta) {
                case "1":    
                    database.listarAnuncios(cuidador);
                    break;
                
                case "2": 
                    System.out.println("\nInsira a descrição do anúncio: ");
                    String descricao = entrada.nextLine();
                    System.out.println("\nInsira o valor: ");
                    float valor = entrada.nextFloat();
                    database.setAnuncio(cuidador, descricao, valor);
                    System.out.println("\nAnúncio criado com sucesso!\n");
                    database.listarAnuncios(cuidador);
                    break;

                case "3":
                    System.out.println("\nInsira o ID do anúncio que deseja alterar: ");
                    int id = entrada.nextInt();
                    for (Anuncio anuncio : database.getAnuncios()) {
                        if (id == anuncio.getId()) {
                            System.out.println("\nDADOS DO ANÚNCIO\n");
                            System.out.println("Id = " + anuncio.getId());
                            System.out.println("Descrição: " + anuncio.getDescricao());
                            System.out.println("Valor: " + anuncio.getValor() + "\n");

                            System.out.println("Insira uma nova descrição ou aperte [enter] para manter a atual: ");
                            String novaDescricao = entrada.nextLine();
                            if (novaDescricao.equals("") == false) {
                                anuncio.setDescricao(novaDescricao);
                            }
                            
                            System.out.println("Insira um novo valor ou aperte [enter] para manter o atual: ");
                            float novoValor = entrada.nextFloat();
                            if (novoValor.equals("") == false) {
                                anuncio.setValor(valor);
                            }
                        }
                    }
                    break;
                
                case "6":
                    Principal.voltar(entrada);
                    break;
                default:
                    break;
            }
            
        }
    }

}
