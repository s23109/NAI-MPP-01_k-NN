import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

       final boolean manual_input = true ;

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
           //     System.out.print("| Poprawny : " + testSet.getValue().name_of_object + "\n");
                System.out.println((testSet.getValue().name_of_object.equals(guess))?" Poprawny":" Zły, Prawdziwy: " + testSet.getValue().name_of_object);
            }

        }
        else {
            // manual input
            String[] user_input= null;
            Scanner in = new Scanner(System.in);

            System.out.println("Aktualne k:" + k
                    +"\nAby wyjść wpisz qqq");
            List <Element_user> user_elements = new ArrayList<>();
            while (true){
                System.out.println("Podaj lokalizacje zmiennej oddzielonej przecinkami (double)");
                user_input = (in.next()).split(",");
        //       System.out.println(user_input[0]);
                if (user_input[0].equals("qqq")){
                    break;
                }
                List<Double> coodrinates = new ArrayList<>();

                try {
                    for (String ele : user_input
                    ) {
                        coodrinates.add(Double.parseDouble(ele));
                    }
                }
                catch (Exception e ){
                    //potencjalny argument nie jest liczbą
                    System.out.println("Jeden z argumentów nie jest liczbą");
                    continue;
                }
                user_elements.add(new Element_user(coodrinates));


                List<Object_info> distances = new ArrayList<>();

                for (Map.Entry<Integer, Element> treningset: zbior_treningowy.entrySet()
                ) {

                    try {
                        distances.add(new Object_info(treningset.getKey(),treningset.getValue().name_of_object , Operacje_na_obiektach.distance_euklides(treningset.getValue().getCoordinates(), coodrinates) ));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                //działa ;)
                List <Object_info> distances_sorted = distances.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());

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

                System.out.println("Zgadywana wartość: " + guess +" z celnością " + nazwa_ilosc.get(guess)*100/k + "%");


            }


        }




    // /psvm
    }

// /main
}
