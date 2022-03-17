import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {


        System.out.println("Start programu");

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("Dane+Polecenie/iris.data.txt"));
            String line = null;
            while ((line = bufferedReader.readLine())!=null){
                //System.out.println(line);
                //Wstępna ,,obróbka danych'' ;)

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
