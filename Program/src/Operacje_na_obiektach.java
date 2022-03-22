import java.util.List;

public class Operacje_na_obiektach {

    public static double distance_euklides (List<Double> coordinates_of_base,List<Double> coordinates_of_other_object) throws Exception {
        //Ta metoda zwraca odległość która nie jest spierwiastkowana (w celu optymalizacji)
        // wynik szacowania przynależności obiektu i tak się przez to nie zmieni
        if (coordinates_of_base.size() != coordinates_of_other_object.size()){
            throw new Exception("Porównywanie wektorów o innych rozmiarach niemożliwe");
        }
        double distance = 0 ;

        for (int i = 0; i < coordinates_of_base.size(); i++) {
            distance+= Math.pow((coordinates_of_base.get(i) - coordinates_of_other_object.get(i)),2);
        }

        return distance;
    }

    public static double distance_miejska (List<Double> coordinates_of_base,List<Double> coordinates_of_other_object) throws Exception{
        if (coordinates_of_base.size() != coordinates_of_other_object.size()){
            throw new Exception("Porównywanie wektorów o innych rozmiarach niemożliwe");
        }
        double distance = 0 ;

        for (int i = 0; i < coordinates_of_base.size(); i++) {
            distance+= Math.abs((coordinates_of_base.get(i)- coordinates_of_other_object.get(i)));
        }

        return distance;
    }

    public synchronized static Element utworz_obiekt (String input){
     String[] temp = input.split(",");
     List <? extends Object> lista = List.of(temp).subList(0,temp.length-2);
     return new Element(temp[temp.length-1],(List<Double>)lista );
    }



}
