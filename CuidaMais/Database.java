import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextArea;


public class Database {

    private List<Cuidador> cuidadores = new ArrayList<>();
    private List<Familiar> familiares = new ArrayList<>();
    private List<Anuncio> anuncios = new ArrayList<>();
    private JTextArea display;
    private int id;

    
        public void addCuidador (String cpf, String nome, int idade, String telefone, String area){
            Cuidador cuidador = new Cuidador(cpf, nome, idade, telefone, area);
            cuidadores.add(cuidador);
        }
    
        public void addFamiliar (String cpf, String nome, int idade, String parentesco){
            Familiar familiar = new Familiar(cpf, nome, idade, parentesco);
            familiares.add(familiar);
        }
    
        public void addAnuncio (Cuidador cuidador, String descricao, Double valor){
            Anuncio anuncio = new Anuncio(id++,cuidador, descricao, valor);
            anuncios.add(anuncio);
        }
    
        
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
    
    
        public void listarAnuncios(Cuidador cuidador, JTextArea display) {

            boolean temAnuncio = false;
            display.setText("SEUS ANÚNCIOS:\n"); 
        
            for (Anuncio anuncio : this.anuncios) {
                if (anuncio.getCpfCuidador().equals(cuidador.getCpf())) {
                    temAnuncio = true;
                    display.append("\nID: " + anuncio.getId() +
                                   "\nDESCRIÇÃO: " + anuncio.getDescricao() +
                                   "\nVALOR: R$ " + anuncio.getValor() +
                                   "\n---------------\n");
                }
            }

            if (!temAnuncio) {

                display.setText("VOCÊ NÃO TEM ANÚNCIOS CADASTRADOS");
                
            }
        }        
        
    
        public void listarAnuncios(JTextArea display) {
            boolean temAnuncio = false;
            display.setText("---------------\n");
            display.append("CUIDA+ ANÚNCIOS\n");
        
            for (Anuncio anuncio : this.anuncios) {
                temAnuncio = true;
                display.append("\nCUIDADOR: " + anuncio.getNomeCuidador() +
                                "\nESPECIALIDADE: " + anuncio.getEspecialidadeCuidador() +
                               "\nDESCRIÇÃO: " + anuncio.getDescricao() +
                               "\nVALOR: R$ " + anuncio.getValor() +
                               "\nTELEFONE PARA CONTATO: " + anuncio.getTelefoneCuidador() +
                               "\n---------------\n");
            }

            if (!temAnuncio) {

                display.setText("NÃO HÁ ANÚNCIO CADASTRADO");
                
            }
        }
        
        public void listarAnuncio(Cuidador cuidador, Anuncio anuncio, JTextArea display) {
            display.setText("DADOS DO ANÚNCIO\n" +
            "ID: " + anuncio.getId() + "\n" +
            "DESCRIÇÃO: " + anuncio.getDescricao() + "\n" +
            "VALOR: R$ " + anuncio.getValor());

        }

    public void setAnuncio(Anuncio anuncio) {

        this.anuncios.add(anuncio);
    }
    public List<Anuncio> getAnuncios() {
        return this.anuncios;
    }

    public void editarAnuncio(Cuidador cuidador, int id, String descricao, Double valor, JTextArea display) {
        Anuncio anuncio = getAnuncio(id);
        if (anuncio.getCpfCuidador().equals(cuidador.getCpf())) {
            anuncio.setDescricao(descricao);
            anuncio.setValor(valor);
            display.append("DESCRIÇÃO E VALOR ALTERADO COM SUCESSO!");
        } else {
            display.append("VOCÊ NÃO POSSUI NENHUM ANÚNCIO COM ESSE ID.");
        }
    }
    public void editarAnuncio(Cuidador cuidador, int id, String descricao, JTextArea display) {
        Anuncio anuncio = getAnuncio(id);
        if (anuncio.getCpfCuidador().equals(cuidador.getCpf())) {
            anuncio.setDescricao(descricao);
            display.append("DESCRIÇÃO ALTERADA COM SUCESSO!");
        } else {
            display.append("VOCÊ NÃO POSSUI NENHUM ANÚNCIO COM ESSE ID.");
        }
        
    }
    public void editarAnuncio(Cuidador cuidador, int id, Double valor, JTextArea display) {
        Anuncio anuncio = getAnuncio(id);
        if (anuncio.getCpfCuidador().equals(cuidador.getCpf())) {
            anuncio.setValor(valor);
            display.append("VALOR ALTERADO COM SUCESSO!");
        } else {
            display.append("VOCÊ NÃO POSSUI NENHUM ANÚNCIO COM ESSE ID.");
        }
    }

    public void deletarAnuncio(Cuidador cuidador, Anuncio anuncio, JTextArea display) {
        if (anuncio.getCpfCuidador().equals(cuidador.getCpf())) {
            this.anuncios.remove(anuncio);
            display.setText("ANÚNCIO DE ID " + anuncio.getId() + " REMOVIDO COM SUCESSO!");
        } else {
            display.append("VOCÊ NÃO POSSUI NENHUM ANÚNCIO COM ESSE ID."); 
        }
    }
    public Anuncio getAnuncioDoCuidador(Cuidador cuidador, int id) {
        for (Anuncio anuncio : anuncios) {
            if (anuncio.getId() == id && anuncio.getCpfCuidador().equals(cuidador.getCpf())) {
                return anuncio; 
            }
        }
        return null;
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

    public int getId(){
        return id;
    }

    public void limparDisplay() {
        display.setText("");
    }

    

}

