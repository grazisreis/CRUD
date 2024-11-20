public class MenuCuidador extends Menu {

    Database database;
    Cuidador cuidador;

    public MenuCuidador(Database database, Cuidador cuidador) {
        this.database = database;
        this.cuidador = cuidador;
    }
    
    public void exibirMenu() {
        System.out.println("MENU CUIDADOR");
        System.out.println("[1] LISTAR SEUS ANÚNCIOS");
        System.out.println("[2] CADASTRAR NOVO ANÚNCIO");
        System.out.println("[3] EDITAR ANÚNCIO");
        System.out.println("[4] DELETAR ANÚNCIO");
        System.out.println("[5] LISTAR TODOS OS ANÚNCIOS");
        System.out.println("[6] VOLTAR AO MENU");
        System.err.println("Escolha uma opção");

        int resposta = scanner.nextInt();
        scanner.nextLine();

        switch (resposta) {
            case 1:
                listarAnuncios();
                break;
            
            case 2:
                cadastrarAnuncio();
                break;
            
            case 3:
                editarAnuncio();
                break;
            
            case 4:
                deletarAnuncio();
                break;

            case 5:
                listarTodosAnuncios();
                break;
            
            case 6:
                voltarMenu();
                break;
            
            default:
                System.out.println("Responda corretamente. ");
        }
    }

    public void listarAnuncios() {
        
        this.database.listarAnuncios(this.cuidador);

        this.exibirMenu();

    }

    public void cadastrarAnuncio() {
        
        System.out.println("");
        System.out.println("Insira a descrição do anúncio: ");
        String descricao = scanner.nextLine();

        System.out.println("");
        System.out.println("Insira o valor: ");
        float valor = scanner.nextFloat();
        scanner.nextLine();

        this.database.setAnuncio(this.cuidador, descricao, valor);

        System.out.println("");
        System.out.println("Anúncio criado com sucesso!");
        System.out.println("");
        
        this.database.listarAnuncios(this.cuidador);

        this.exibirMenu();

    }

    public void editarAnuncio() {
        
        System.out.println("");
        System.out.println("Insira o ID do anúncio que deseja alterar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Anuncio anuncio = this.database.getAnuncio(id);

        this.database.listarAnuncio(this.cuidador, anuncio);

        System.out.println("Insira uma nova descrição ou digite 0 para manter a atual: ");
        String novaDescricao = scanner.nextLine();

        System.out.println("Insira um novo valor ou digite 0 para manter 0 atual: ");
        float novoValor = scanner.nextFloat();
        scanner.nextLine();

        if (novaDescricao.equals("0") && novoValor == 0) {
            System.out.println("Nenhuma alteração realizada. ");
        } else {
            if (!novaDescricao.equals("0") && novoValor != 0) {
                this.database.editarAnuncio(this.cuidador, id, novaDescricao, novoValor);
            } else {
                if(novaDescricao.equals("0")) {
                    this.database.editarAnuncio(this.cuidador, id, novoValor);
                } else {
                    this.database.editarAnuncio(this.cuidador, id, novaDescricao);
                }

            }
        }

        this.exibirMenu();
    }

    public void deletarAnuncio() {
        System.out.println("");
        System.out.println("Insira o ID do anúncio que deseja deletar");
        int idExcluir = scanner.nextInt();
        scanner.nextLine();

        Anuncio anuncio = this.database.getAnuncio(idExcluir);
                        
        System.out.println("Tem certeza que deseja excluir? [enter] para confirmar e qualquer caractere para cancelar");
        String confirmacao = scanner.nextLine();
        if(confirmacao.equals("")) {
            this.database.deletarAnuncio(this.cuidador, anuncio);
            this.database.listarAnuncios(this.cuidador);
        } else {
            System.out.println("Operação cancelada. ");
            this.database.listarAnuncios(this.cuidador);
        }
        this.exibirMenu();
    }

    public void listarTodosAnuncios() {
        this.database.listarAnuncios();
        this.exibirMenu();
    }

    public void voltarMenu() {
        super.exibirMenu(this.database);
    }


}
