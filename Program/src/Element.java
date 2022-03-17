import java.util.List;


public class Element {

String name_of_object;
List<String> coordinates;



    public Element(String name_of_object, List<String> coordinates) {
        this.name_of_object = name_of_object;
        this.coordinates = coordinates;
    }



    public boolean czy_ta_sama_nazwa (String testowana){
        return name_of_object.equals(testowana);
    }
}
