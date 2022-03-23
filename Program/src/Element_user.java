import java.util.List;

public class Element_user {
    List<Double> coordinates;

    public Element_user(List<Double> coordinates) {
        this.coordinates = coordinates;
    }

    boolean czy_trafiony;

    public List<Double> getCoordinates() {
        return coordinates;
    }

    public boolean isCzy_trafiony() {
        return czy_trafiony;
    }

    public void setCzy_trafiony(boolean czy_trafiony) {
        this.czy_trafiony = czy_trafiony;
    }

}
