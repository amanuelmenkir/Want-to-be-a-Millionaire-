import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;

public class Question {
    static int hintQuantity = 2;
    static String list = "0123456789";             // this list has ten elements because we have ten questions in text files


    static boolean check_answer ;
    static String choice = "";
    static String answer = "";
    static String hint = "";
    //This method returns random number and removes that number from list
    public static String reduceRandomList(){
        String a = String.valueOf(randomNumber(Question.list));
        list= list.replace(a,"");      //randomly chosen number will be replaced with empty space
        System.out.println(a);
        System.out.println(list);

        return a;
    }
    //This method generates random number from string
    public static char randomNumber(String list){
        Random rn = new Random();
        int length = list.length();
        char randomChar = '\0';
        int randIndex = rn.nextInt(length) ;
        while (randomChar==' ' || randomChar=='\0'){
            randomChar = list.charAt(randIndex);
            randIndex = rn.nextInt(length);
        }
        return randomChar;
    }
    //This method opens text file and reads questions based on random number
    public static void randomQuestion( String i,String fileName) throws IOException {
        int newi = Integer.valueOf(i) *7;           // random number is multiplied by seven to start reading from beginning of question
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
        if(hintQuantity > 1){
            System.out.println(hint);
            Question.hintQuantity -=1;
            System.out.println("You have "+ hintQuantity  + " hints left");

        }
        else if(hintQuantity ==1){
            System.out.println("You have "+ hintQuantity  + " hint left");
            Question.hintQuantity -=1;
            System.out.println(hint);

        }
        else{
            System.out.println("You can't use more hint.");
        }
    }


    public static void main(String[] args) throws IOException {
        // randomQuestion(Question.randomNumber(Question.reduceRandomList()),"easy.txt");
        // System.out.println(checkChoice());
        // reduceRandomList();

    }


}
