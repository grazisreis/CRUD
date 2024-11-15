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
        System.out.println("\n---------------\n");
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
        System.out.println("---------------\n");
    }

    public void listarAnuncios() {
        System.out.println("---------------");
        System.out.println("CUIDAMAIS+ ANÚNCIOS ");
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

    public void listarAnuncio(Cuidador cuidador, Anuncio anuncio) {
        System.out.println("\nDADOS DO ANÚNCIO\n");
        System.out.println("Id: " + anuncio.getId());
        System.out.println("Descrição: " + anuncio.getDescricao());
        System.out.println("Valor: R$ " + anuncio.getValor());
    }

    public void setAnuncio(Cuidador cuidador, String descricao, float valor) {
        Anuncio anuncio = new Anuncio(cuidador, descricao, valor);
        anuncios.add(anuncio);
    }
    public List<Anuncio> getAnuncios() {
        return this.anuncios;
    }

    public void editarAnuncio(Cuidador cuidador, int id, String descricao, float valor) {
        Anuncio anuncio = getAnuncio(id);
        anuncio.setDescricao(descricao);
        System.out.println("Descrição alterada com sucesso! ");
        anuncio.setValor(valor);
        System.out.println("Valor alterado com sucesso! ");
    }
    public void editarAnuncio(Cuidador cuidador, int id, String descricao) {
        Anuncio anuncio = getAnuncio(id);
        anuncio.setDescricao(descricao);
        System.out.println("Descrição alterada com sucesso! ");
    }
    public void editarAnuncio(Cuidador cuidador, int id, float valor) {
        Anuncio anuncio = getAnuncio(id);
        anuncio.setValor(valor);
        System.out.println("Valor alterado com sucesso! ");
    }

    public void deletarAnuncio(Cuidador cuidador, Anuncio anuncio) {
        this.anuncios.remove(anuncio);
        System.out.println("Anúncio de ID " + anuncio.getId() + "removido com sucesso! ");
    }

    public Anuncio getAnuncio(int id) {
        for (Anuncio anuncio : this.anuncios) {
            if(anuncio.getId() == id) {
                return anuncio;
            }
        }
        return null;
    }

    public Cuidador getCuidador(String cpf) {
        for (Cuidador cuidador : this.cuidadores) {
            if(cuidador.getCpf().equals(cpf)) {
                return cuidador;
            }
        }
        return null;
    }

    public Familiar getFamiliar(String cpf) {
        for (Familiar familiar : this.familiares) {
            if(familiar.getCpf().equals(cpf)) {
                return familiar;
            }
        }
        return null;
    }


}

