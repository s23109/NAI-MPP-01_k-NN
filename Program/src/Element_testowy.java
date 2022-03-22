import java.util.List;
import java.util.Map;

public class Element_testowy extends Element{

    public Element_testowy(String name_of_object, List<Double> coordinates) {
        super(name_of_object, coordinates);
    }

    boolean czy_trafiony;

    Map<String,Double> jak_strzelano=null;

    public boolean isCzy_trafiony() {
        return czy_trafiony;
    }

    public void setCzy_trafiony(boolean czy_trafiony) {
        this.czy_trafiony = czy_trafiony;
    }

    public Map<String, Double> getJak_strzelano() {
        return jak_strzelano;
    }

    public void setJak_strzelano(Map<String, Double> jak_strzelano) {
        this.jak_strzelano = jak_strzelano;
    }



}
