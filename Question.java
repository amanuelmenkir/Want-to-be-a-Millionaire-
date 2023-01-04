import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class Question {
    static FileReader file;
    static BufferedReader buffer;
    public static void randomQuestion() throws IOException {
//        try {
//            file = new FileReader("easy.txt"); // Initializes  the FileReader
//            buffer = new BufferedReader(file); // Initializes the BufferedReader
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }
        Random rn = new Random();
        int i = (rn.nextInt(3))  * 7;
        for (int l = 0; l < 5; l++) {
            String line = Files.readAllLines(Paths.get("easy.txt")).get(i+l);
         //   String line33 = Files.readAllLines(Paths.get("easy.txt")).get(i + 1);
            System.out.println(line);
           // System.out.println(line33);
        }
    }

    public static void main(String[] args) throws IOException {
        randomQuestion();
    }


}
