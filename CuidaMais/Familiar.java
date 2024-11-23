public class Familiar extends Usuario {

    private String graudeParentesco;

    public Familiar(String cpf, String nome, int idade, String graudeParentesco) {
        super(cpf, nome, idade);
        this.graudeParentesco = graudeParentesco;
    }

    public String getGraudeParentesco() {
        return graudeParentesco;
    }

    @Override
    public String exibirInformacoes() {
        return "FAMILIAR: " + getNome().toUpperCase() + "\nCPF: " + getCpf() + "\nGRAU DE PARENTESCO: " + getGraudeParentesco().toUpperCase();
    }



}




