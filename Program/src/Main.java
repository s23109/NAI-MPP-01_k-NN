import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

       final boolean manual_input = false ;

        System.out.println("Start programu");

        final Integer k = 25 ;

        Map<Integer,Element> zbior_treningowy;
        Map<Integer,Element> zbior_testowy;
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
                    zbior_testowy.put(pomo, Operacje_na_obiektach.utworz_obiekt(line) );
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


            for (Map.Entry<Integer, Element> testSet : zbior_testowy.entrySet()) {
                //oblicz odległość od każdego
                List<Object_info> distances = new ArrayList<>();

                for (Map.Entry<Integer, Element> treningset: zbior_treningowy.entrySet()
                     ) {

                    try {
                       distances.add(new Object_info(treningset.getKey(),treningset.getValue().name_of_object , Operacje_na_obiektach.distance_euklides(treningset.getValue().getCoordinates(), testSet.getValue().getCoordinates()) ));
                          } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                //działa ;)
                List <Object_info> distances_sorted = distances.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());

//                for (Object_info obj : distances_sorted
//                     ) {
//                    System.out.println(obj.distance + " " + obj.id);
//                }



                //get key : (String) mapElement.getKey();
                //get value : (int)mapElement.getValue();

                //zobacz który jest najbliższy
                ArrayList<String> closest = new ArrayList<>();


                for (int i = 0; i < k; i++) {
                    closest.add(distances_sorted.get(i).name);
                }

                Map <String, Integer>  nazwa_ilosc = new LinkedHashMap<>();
                String guess = closest.get(0);

                for (String ele: closest
                     ) {
                    nazwa_ilosc.put(ele,Collections.frequency(closest,ele));
                    if (nazwa_ilosc.get(guess) < nazwa_ilosc.get(ele)) {
                        guess = ele;
                    }

                }
                //jest mapa typ - ilość najbliższych


                String answer = testSet.getValue().name_of_object;

                System.out.print("ID: " + testSet.getKey() +
                        " Zgadywany: |" + guess  + "| Dokładność:" + nazwa_ilosc.get(guess)*100/k + "%");


                //sprawdź czy ,,strzał był poprawny''
                System.out.print("| Poprawny : " + testSet.getValue().name_of_object + "\n");

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
