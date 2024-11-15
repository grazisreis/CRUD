import java.util.ArrayList;
import java.util.List;


public class Database {

    private List<Cuidador> cuidadores = new ArrayList<>();
    private List<Familiar> familiares = new ArrayList<>();
    private List<Anuncio> anuncios = new ArrayList<>();

    
    public void setCuidador(Cuidador cuidador) {
        this.cuidadores.add(cuidador);
    }
    public List<Cuidador> getCuidadores() {
        return this.cuidadores;
    }

    
    public void setFamiliar(Familiar familiar) {
        this.familiares.add(familiar);
    }
    public List<Familiar> getFamiliares() {
        return this.familiares;
    }


    public void listarAnuncios(Cuidador cuidador) {
        System.out.println("---------------");
        System.out.println("Seus anúncios: ");
        for (Anuncio anuncio : this.anuncios) {
            
         if (anuncio.getCpfCuidador().equals(cuidador.getCpf())) {
            System.out.println(""); 
            System.out.println("Id: " + anuncio.getId());
            System.out.println("Descrição: " + anuncio.getDescricao());
            System.out.println("Valor: R$ " + anuncio.getValor());
            System.out.println("");
            
         }
        }
        System.out.println("---------------");
    }

    public void listarAnuncios() {
        System.out.println("---------------");
        System.out.println("Seus anúncios: ");
        for (Anuncio anuncio : this.anuncios) {
            System.out.println("");
            System.out.println("Cuidador: " + anuncio.getNomeCuidador());
            System.out.println("Descrição: " + anuncio.getDescricao());
            System.out.println("Valor: R$ " + anuncio.getValor());
            System.out.println("Telefone para contato: " + anuncio.getTelefoneCuidador());   
            System.out.println("");
         }
        System.out.println("---------------");
    }


    public void setAnuncio(Cuidador cuidador, String descricao, float valor) {
        Anuncio anuncio = new Anuncio(cuidador, descricao, valor);
        anuncios.add(anuncio);
    }
    public List<Anuncio> getAnuncios() {
        return this.anuncios;
    }

}
