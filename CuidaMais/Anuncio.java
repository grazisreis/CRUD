public class Anuncio {
    private static int idGerado = 0;
    private int id;
    private String nomeCuidador;
    private String descricao;
    private float valor;
    private String telefoneCuidador;
    private String cpfCuidador;
    

    public Anuncio(Cuidador cuidador, String descricao, float valor) {
        this.id = gerarId();
        this.nomeCuidador = cuidador.getNome();
        this.descricao = descricao;
        this.valor = valor;
        this.telefoneCuidador = cuidador.getTelefone();
        this.cpfCuidador = cuidador.getCpf();
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


    public void setValor(float valor) {
        this.valor = valor;
    }
    public float getValor() {
        return valor;
    }


    public String getCpfCuidador() {
        return cpfCuidador;
    }


    
    
    
    public int getId() {
        return id;
    }


}
