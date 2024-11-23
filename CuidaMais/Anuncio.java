public class Anuncio {
    private int id;
    private String nomeCuidador;
    private String descricao;
    private Double valor;
    private String telefoneCuidador;
    private String cpfCuidador;
    private String especialidadeCuidador;
    

    public Anuncio(int id,Cuidador cuidador, String descricao, Double valor) {
        this.id = id;
        this.nomeCuidador = cuidador.getNome();
        this.descricao = descricao;
        this.valor = valor;
        this.telefoneCuidador = cuidador.getTelefone();
        this.cpfCuidador = cuidador.getCpf();
        this.especialidadeCuidador = cuidador.getArea();
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


    public void setValor(Double valor) {
        this.valor = valor;
    }
    public Double getValor() {
        return valor;
    }


    public String getCpfCuidador() {
        return cpfCuidador;
    }
    

    public int getId() {
        return id;
    }


    public String getEspecialidadeCuidador() {
        return especialidadeCuidador;
    }


}
