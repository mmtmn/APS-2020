import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class CSVReader {

    public static void main(String[] args) {
        String fileName = "bd_alunos.csv";
        File file = new File(fileName);
        try {
            Scanner inputStream = new Scanner(file);
            while(inputStream.hasNext()){
                String data = inputStream.next();
                System.out.println(data);
            }
            inputStream.close();

        } catch (FileNotFoundException e)  {
            e.printStackTrace();
        }
    }

}