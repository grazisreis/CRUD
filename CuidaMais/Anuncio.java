public class Anuncio {
    private static int idGerado = 0;
    private int id;
    private String nomeCuidador;
    private String descricao;
    private String telefoneCuidador;

    public Anuncio(Cuidador cuidador, String descricao) {
        this.id = gerarId();
        this.nomeCuidador = cuidador.getNome();
        this.descricao = descricao;
        this.telefoneCuidador = cuidador.getTelefone();
    }

    public static int gerarId() {
        idGerado += 1;
        return idGerado;
    }

    
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
    public void setNomeCuidador(String nomeCuidador) {
        this.nomeCuidador = nomeCuidador;
    }
    public String getNomeCuidador() {
        return nomeCuidador;
    }
    
    
    public void setTelefoneCuidador(String telefoneCuidador) {
        this.telefoneCuidador = telefoneCuidador;
    }
    public String getTelefoneCuidador() {
        return telefoneCuidador;
    }


    public int getId() {
        return id;
    }


}
