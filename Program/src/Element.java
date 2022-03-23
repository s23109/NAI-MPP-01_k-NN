import java.util.List;


public class Element {

    String name_of_object;
List<Double> coordinates;

    public Element(String name_of_object, List<Double> coordinates) {
        this.name_of_object = name_of_object;
        this.coordinates = coordinates;
    }

    public List<Double> getCoordinates() {
        return coordinates;
    }
}
