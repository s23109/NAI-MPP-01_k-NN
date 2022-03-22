import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) {

       final boolean manual_input = false ;

        System.out.println("Start programu");

        Map<Integer,Element> zbior_treningowy;
        Map<Integer,Element_testowy> zbior_testowy;
        zbior_treningowy=new LinkedHashMap<>();
        BufferedReader bufferedReader = null;
        try {

            bufferedReader = new BufferedReader(new FileReader("Dane+Polecenie/iris.data.txt"));
            String line ;
            int no_of_elements = 0;


            while ((line = bufferedReader.readLine())!=null){
                //System.out.println(line);
                //Wstępna ,,obróbka danych'' ;)
                zbior_treningowy.put(no_of_elements,Operacje_na_obiektach.utworz_obiekt(line));
                no_of_elements++;
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        if (!manual_input){
            //jak auto input, to
            zbior_testowy = new LinkedHashMap<>();
            try {

                bufferedReader = new BufferedReader(new FileReader("Dane+Polecenie/iris.test.data.txt"));
                String line ;
                int pomo = 0;
                while ((line = bufferedReader.readLine())!=null){
                    zbior_testowy.put(pomo, new Element_testowy(Operacje_na_obiektach.utworz_obiekt(line)) );
                    pomo++;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            finally {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


            for (Map.Entry<Integer, Element_testowy> testSet : zbior_testowy.entrySet()) {
                //oblicz odległość od każdego
                Map <Integer,Double> distancemap = new LinkedHashMap<>();

                for (Map.Entry<Integer, Element> treningset: zbior_treningowy.entrySet()
                     ) {

                    try {
                        distancemap.put(treningset.getKey(),Operacje_na_obiektach.distance_euklides(treningset.getValue().getCoordinates(), testSet.getValue().getElement().getCoordinates()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                List <Map.Entry<Integer,Double>> sorted = new ArrayList<>(distancemap.entrySet());
                sorted.sort(Map.Entry.comparingByValue());

                for (int i = 0; i < 3; i++) {
                    System.out.println(sorted.get(i));
                }


                //get key : (String) mapElement.getKey();
                //get value : (int)mapElement.getValue();

                //zobacz który jest najbliższy

                //sprawdź czy ,,strzał był poprawny'' i dodaj dane do ,,element testowy''

            }

        }
        else {
            // manual input
            // Placeholder
        }




    // /psvm
    }

// /main
}
