public class Cuidador extends Usuario {

    private String telefone;
    
    public Cuidador(String cpf, String nome, int idade, String telefone) {
        super(cpf, nome, idade);
        this.telefone = telefone;
    }

    
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getTelefone() {
        return telefone;
    }


}
