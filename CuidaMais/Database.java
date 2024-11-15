import java.util.ArrayList;
import java.util.List;


public class Database {

    private List<Cuidador> cuidadores = new ArrayList<>();

    public List<Cuidador> getCuidadores() {
        return new ArrayList<>(cuidadores);
    }

    public void setCuidadores(List<Cuidador> cuidadores) {
        new ArrayList<>(cuidadores);
        this.cuidadores = cuidadores;
    }

}
