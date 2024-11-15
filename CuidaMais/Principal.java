public class Principal {
    
    public static void main(String[] args) {
        Database database = new Database();

        Menu menu = new Menu();
        while (true) {
            menu.exibirMenu(database);
        }    
    }  
}
