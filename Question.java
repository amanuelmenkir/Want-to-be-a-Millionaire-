import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Question {
    static ArrayList<Integer> list = new ArrayList<Integer>();
    static int hintQuantity = 3;        //Quantity of hints
    static boolean check_answer ;
    static String choice = "";
    static String answer = "";
    static String hint = "";
    //This method adds numbers from 0 to 10 in the list and shuffles to get random sequence
    public static void randomNum() {
        for (int i = 0; i < 10; i++) list.add(i);
        Collections.shuffle(list);
    }
    //This method opens text file and reads questions based on random number
    public static void randomQuestion( int i,String fileName) throws IOException {

        int newi = list.get(i) *7;           // random number is multiplied by seven to start reading from beginning of question
        System.out.println(newi);
        for (int l = 0; l < 5; l++) {               // This for loop prints question and four choices
            String line = Files.readAllLines(Paths.get(String.valueOf(fileName))).get((newi+l));
            System.out.println(line);

        }
        System.out.println("1. HINT ");

        answer = Files.readAllLines(Paths.get(String.valueOf(fileName))).get(newi +5);      //This is answer for question based on random number
        hint = Files.readAllLines(Paths.get(String.valueOf(fileName))).get(newi+6);         //This is hint for question based on random number
    }

    public static String getChoice(){
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter Your answer");
        choice = myObj.nextLine();
        return choice;
    }
    public static void checkChoice(){
        getChoice();
        if(choice.equalsIgnoreCase("1")){
            HintOption(hintQuantity);
            getChoice();

        }
        else if (choice.equalsIgnoreCase("a")||choice.equalsIgnoreCase("b")||
        choice.equalsIgnoreCase("c") || choice.equalsIgnoreCase("d")){
            checkAnswer();
        }
        else {
            System.out.println("Please enter valid input");
            checkChoice();
        }

    }
    public static boolean checkAnswer(){
        if(choice.equalsIgnoreCase(answer)){
            check_answer = true;
        }
        else check_answer = false;
        return check_answer;
    }
    public static void HintOption(int hintQuantity){
        if(hintQuantity > 2){
            System.out.println(hint);
            Question.hintQuantity -=1;
            System.out.println("You have "+ (hintQuantity -1) + " hints left");


        }
        else if(hintQuantity ==2){
            System.out.println(hint);
            Question.hintQuantity -=1;
            System.out.println("You have "+ (hintQuantity -1) + " hint left");


        }
        else {
            System.out.println("You can't use more hint.");
        }
    }


    public static void main(String[] args) throws IOException {
        // randomQuestion(Question.randomNumber(Question.reduceRandomList()),"easy.txt");


    }


}
