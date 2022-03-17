import java.util.List;


public class Element {

String name_of_object;
List<String> coordinates;



    public Element(String name_of_object, List<String> coordinates) {
        this.name_of_object = name_of_object;
        this.coordinates = coordinates;
    }

    public double distance_euklides (List<String> coordinates_of_other_object) throws Exception {
        //Ta metoda zwraca odległość która nie jest spierwiastkowana (w celu optymalizacji)
        if (this.coordinates.size() != coordinates_of_other_object.size()){
            throw new Exception("Porównywanie wektorów o innych rozmiarach niemożliwe");
        }
        double distance = 0 ;

        for (int i = 0; i < coordinates.size(); i++) {
            distance+= Math.pow((Double.parseDouble(coordinates.get(i))- Double.parseDouble(coordinates_of_other_object.get(i))),2);
        }

        return distance;
    }

}
