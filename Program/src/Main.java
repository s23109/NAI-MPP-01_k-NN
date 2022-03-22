import java.io.BufferedReader;
import java.io.FileNotFoundException;
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
            String[] agrumenty ;
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
                String []argumenty ;
                int pomo = 0;
                while ((line = bufferedReader.readLine())!=null){
                    zbior_testowy.put(pomo, (Element_testowy) Operacje_na_obiektach.utworz_obiekt(line));
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


            for (Map.Entry mapElement : zbior_testowy.entrySet()) {
                //oblicz odległość od każdego

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
