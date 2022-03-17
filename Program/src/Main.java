import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

       final boolean manual_input = false ;

        System.out.println("Start programu");

        Map<Integer,Element> zbior_treningowy = null;
        Map<Integer,Element_testowy> zbior_testowy = null;

        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("Dane+Polecenie/iris.data.txt"));
            String line ;
            String[] agrumenty ;
            int no_of_elements = 0;


            while ((line = bufferedReader.readLine())!=null){
                //System.out.println(line);
                //Wstępna ,,obróbka danych'' ;)
                agrumenty=line.split(",");
                List<String> temp = List.of(agrumenty);
                temp.remove(temp.size()-1);
                zbior_treningowy.put(no_of_elements,new Element(agrumenty[agrumenty.length-1],temp));
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

            try {
                bufferedReader = new BufferedReader(new FileReader("Dane+Polecenie/iris.test.data.txt"));
                String line ;
                String []argumenty ;
                int pomo = 0;
                while ((line = bufferedReader.readLine())!=null){

                    argumenty = line.split(",");
                    List<String> temp = List.of(argumenty);
                    temp.remove(temp.size()-1);
                    zbior_testowy.put(pomo, new Element_testowy(argumenty[argumenty.length-1],temp));
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


            //część obliczeniowa




        }
        else {
            // manual input
            // Placeholder
        }





    }

}
