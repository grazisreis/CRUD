public class Principal {
    
    public static void main(String[] args) {
        Database database = new Database();
        Interface interface1 = new Interface(database);
        interface1.setVisible(true);


    }  
}
