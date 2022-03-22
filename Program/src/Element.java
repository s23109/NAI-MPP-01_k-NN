import java.util.List;


public class Element {

String name_of_object;
List<Double> coordinates;



    public Element(String name_of_object, List<Double> coordinates) {
        this.name_of_object = name_of_object;
        this.coordinates = coordinates;
    }



    public boolean czy_ta_sama_nazwa (Element porownywany){
        return this.name_of_object.equals(porownywany.name_of_object);
    }

    public List<Double> getCoordinates() {
        return coordinates;
    }
}
