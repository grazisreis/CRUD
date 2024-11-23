public class Cuidador extends Usuario {

    private String telefone;
    private String area;
    
    public Cuidador(String cpf, String nome, int idade, String telefone, String area) {
        super(cpf, nome, idade);
        this.telefone = telefone;
        this.area = area;
    }

    
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getArea() {
        return area;
    }

    public String getTelefone() {
        return telefone;
    }

    @Override
    public String exibirInformacoes() {
        return "CUIDADOR: " + getNome().toUpperCase() + "\nCPF: " + getCpf() + "\nESPECIALIDADE: " + getArea().toUpperCase();
    }
    

    


}
