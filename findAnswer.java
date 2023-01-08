import java.io.IOException;
import java.util.Scanner;

public class findAnswer {
    static Scanner scanner = new Scanner(System.in);
    public static boolean correct;

    public static void getQuestions() throws IOException{
        int i = 0;


        do{

            if (i < 4){
                Question.randomQuestion("easy.txt");
                System.out.println("Enter 'e' if you want hint! ");
                String userHintChoise = scanner.nextLine();
                Question.HintOption(userHintChoise);


                if(!Question.checkChoice()){
                    correct = false;
                    System.out.println("Sorry,Your answer is wrong! Thanks for playing");
                }
                else {
                    correct = true;
                    i++;
                    System.out.println("Your answer is correct!"+"\nPress Q to quit ir C to continue");
                    String userInput = scanner.nextLine();
                    if (userInput.equalsIgnoreCase("Q")){
                        break;
                    }
                }
            }
            else if (i >= 4 && i <= 8){
                Question.randomQuestion("medium.txt");
                Question.HintOption("");

                if(!Question.checkChoice()){
                    correct = false;
                    System.out.println("Sorry,Your answer is wrong! Thanks for playing");
                }
                else {
                    correct = true;
                    i++;
                    System.out.println("Your answer is correct!"+"\nPress Q to quit ir C to continue");
                    String userInput = scanner.nextLine();
                    if (userInput.equalsIgnoreCase("Q")){
                        break;
                    }
                }
            }
            else if (i > 8){
                Question.randomQuestion("hard.txt");
                Question.HintOption(""); //Calling the hinOption method

                if(!Question.checkChoice()){
                    correct = false;
                    System.out.println("Sorry,Your answer is wrong! Thanks for playing");
                }
                else {
                    correct = true;
                    i++;
                    System.out.println("Your answer is correct!"+"\nPress Q to quit ir C to continue");
                    String userInput = scanner.nextLine();
                    if (userInput.equalsIgnoreCase("Q")){
                        break;
                    }
                }
            }
        }
        while(correct);

    }
    public static void main(String[] args) throws IOException {

        getQuestions();

    }

}
