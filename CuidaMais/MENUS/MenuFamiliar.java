public class MenuFamiliar extends Menu {
    Database database;
    Familiar familiar;

    public MenuFamiliar(Database database, Familiar familiar) {
        this.database = database;
        this.familiar = familiar;
    }

    public void exibirMenu() {
        System.out.println("MENU FAMILIAR");
        System.out.println("[1] VER ANÚNCIOS");
        System.out.println("[2] VOLTAR AO MENU");
        System.out.println("[3] FECHAR PROGRAMA");
        System.err.println("Escolha uma opção");

        int resposta = scanner.nextInt();

        switch (resposta) {
            case 1: 
                listarAnuncios();
                break;
            case 2:
                super.exibirMenu(database);
                break;
            case 3:
                System.exit(0);
            default:
                System.out.println("Responda corretamente.");
        }

    }

    public void listarAnuncios() {
        
        this.database.listarAnuncios();

        this.exibirMenu();

    }
}
