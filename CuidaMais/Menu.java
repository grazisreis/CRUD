import java.util.Scanner;

public class Menu {
    public Scanner scanner;
    public Menu(){
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu(Database database) {
        
        System.out.println("-------------");
        System.out.println(" CUIDAMAIS+");
        System.out.println("-------------");
        System.out.println("Como deseja acessar o sistema?");
        System.out.println("[1] Cuidador");
        System.out.println("[2] Familiar");
        System.out.println("[3] FECHAR");

        int resposta = scanner.nextInt();

        switch (resposta) {
            case 1:
                Cuidador usuarioCuidador;
                boolean logado = false;
                // O USUÁRIO É CUIDADOR
                System.out.println("Você selecionou a opção Cuidador.");
                System.out.println("");
                System.out.println("Digite seu CPF para fazer login. Caso queira se cadastrar, digite '0'.");

                String login = scanner.next();

                switch (login) {
                    case "0":
                        cadastrarCuidador(database, scanner);
                        break;
                    default:
                        usuarioCuidador = database.getCuidador(login);
                        if (usuarioCuidador == null) {
                            System.out.println("Usuário não cadastrado. Deseja fazer o cadastro?");
                            System.out.println("[1] SIM");
                            System.out.println("[2] NÃO");
                            resposta = scanner.nextInt();
                            switch (resposta) {
                                case 1:
                                    cadastrarCuidador(database, scanner);
                                    break;
                                case 2:
                                    exibirMenu(database);
                                    break;
                            }
                        } else {
                            logado = true;
                        }
                        if (logado) {
                            System.out.println("");
                            System.out.println("LOGADO COM SUCESSO!");
                            System.out.println("");
                            // CRUD PROPRIAMENTE DITO
                            System.out.println("Bem-vind@, " + usuarioCuidador.getNome());
                            System.out.println("");
                            MenuCuidador menuCuidador = new MenuCuidador(database, usuarioCuidador);
                            menuCuidador.exibirMenu();
                        }
                        break;
        
                    }
                    break;
            case 2:
                Familiar usuarioFamiliar;
                logado = false;
                System.out.println("Você selecionou a opção Familiar.");
                System.out.println("");
                System.out.println("Digite seu CPF para fazer login. Caso queira se cadastrar, digite '0'.");

                login = scanner.next();

                switch (login) {
                    case "0":
                        cadastrarFamiliar(database, scanner);
                        break;

                    default:
                        usuarioFamiliar = database.getFamiliar(login);
                        if (usuarioFamiliar == null) {
                            System.out.println("Usuário não cadastrado. Deseja fazer o cadastro?");
                            System.out.println("[1] SIM");
                            System.out.println("[2] NÃO");
                            resposta = scanner.nextInt();
                            switch (resposta) {
                                case 1:
                                    cadastrarFamiliar(database, scanner);
                                    break;
                                case 2:
                                    exibirMenu(database);
                                    break;
                            }
                        } else {
                            logado = true;
                        }
                        if (logado) {
                            System.out.println("");
                            System.out.println("LOGADO COM SUCESSO!");
                            System.out.println("");
                            System.out.println("Bem-vind@, " + usuarioFamiliar.getNome());
                            System.out.println("");
                            MenuFamiliar menuFamiliar = new MenuFamiliar(database, usuarioFamiliar);
                            menuFamiliar.exibirMenu();
                        }
                        break;   
            }
            break;
        case 3:
            System.exit(0);
            break;
        default:
            System.out.println("Responda corretamente");
    }
                                
    }

    public static void cadastrarCuidador(Database database, Scanner scanner) {
        System.out.println("Insira seu CPF:");
        String cpf = scanner.next();
        System.out.println("Insira seu nome:");
        String nome = scanner.next();
        System.out.println("Insira sua idade:");
        int idade = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Insira seu telefone:");
        String telefone = scanner.next();

        Cuidador usuarioCuidador = new Cuidador(cpf, nome, idade, telefone);

        database.setCuidador(usuarioCuidador);

        System.out.println("");
        System.out.println("Usuário " + usuarioCuidador.getNome() + " cadastrado com sucesso! ");
        System.out.println("");

    }

    public static void cadastrarFamiliar(Database database, Scanner scanner) {
        System.out.println("Insira seu CPF:");
        String cpf = scanner.next();
        System.out.println("Insira seu nome:");
        String nome = scanner.next();
        System.out.println("Insira sua idade:");
        int idade = scanner.nextInt();
        scanner.nextLine();

        Familiar usuario_familiar = new Familiar(cpf, nome, idade);

        database.setFamiliar(usuario_familiar);

        System.out.println("");
        System.out.println("Usuário " + usuario_familiar.getNome() + "cadastrado com sucesso! ");
        System.out.println("");




    }


    

}
