public class Principal {
    
    public static void main(String[] args) {

        Database database = new Database();

        String cpf1 = "123";
        String nome1 = "Graziella";
        int idade1 = 19;
        String telefone1 = "123456";
        
        String cpf2 = "456";
        String nome2 = "Caio";
        int idade2 = 23;
        String telefone2 = "78910";

        String cpf3 = "321";
        String nome3 = "Evely";
        int idade3 = 19;
        
        database.addCuidador(cpf1,nome1,idade1,telefone1);
        database.addCuidador(cpf2, nome2, idade2, telefone2);
        database.addAnuncio(database.getCuidador(cpf2), "Dar banho, Almoço, Companhia", 1580.89 );

        database.addFamiliar(cpf3, nome3, idade3);

        Interface interface1 = new Interface(database);
        interface1.setVisible(true);
   


    }  
}
