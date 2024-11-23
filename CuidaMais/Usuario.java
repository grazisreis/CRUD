public abstract class Usuario {
    private String cpf;
    private String nome;
    private int idade;

    public Usuario(String cpf, String nome, int idade) {
        this.cpf = cpf;
        this.nome = nome;
        this.idade = idade;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getCpf() {
        return cpf;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }


    public void setidade(int idade) {
        this.idade = idade;
    }
    public int getIdade() {
        return idade;
    }

    public abstract String exibirInformacoes();
}
