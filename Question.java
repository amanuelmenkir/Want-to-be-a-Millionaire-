import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;

public class Question {
    static boolean checkAnswer ;
    static String choice = "";
    static String answer = "";
    static String hint = "";
    public static void randomQuestion(String fileName) throws IOException {
        Random rn = new Random();
        int i = (rn.nextInt(10)) * 7;
        for (int l = 0; l < 5; l++) {
            String line = Files.readAllLines(Paths.get(String.valueOf(fileName))).get(i+l);
            System.out.println(line);

        }
        answer = Files.readAllLines(Paths.get(String.valueOf(fileName))).get(i+5);
        hint = Files.readAllLines(Paths.get(String.valueOf(fileName))).get(i+6);
    }

    public static String getChoice(){
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter Your answer");
        choice = myObj.nextLine();
        return choice;
    }
    public static boolean checkChoice(){
        if(getChoice().equalsIgnoreCase(answer)){
            checkAnswer = true;
        }
        else checkAnswer = false;
        return checkAnswer;
    }
    public static void HintOption(){
        if(choice.equalsIgnoreCase("e")){
            System.out.println(hint);
        }
    }


    public static void main(String[] args) throws IOException {
        randomQuestion("easy.txt");
        System.out.println(checkChoice());

    }


}
