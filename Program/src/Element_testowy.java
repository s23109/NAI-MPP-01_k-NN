import java.util.List;
import java.util.Map;

public class Element_testowy{

    public Element element;

    public Element_testowy(Element element) {
       this.element=element;
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

    public Element getElement() {
        return element;
    }
}
