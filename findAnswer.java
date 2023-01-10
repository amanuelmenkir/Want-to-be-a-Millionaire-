import java.io.IOException;
import java.util.Scanner;

public class findAnswer {
    static GameRules G=new GameRules();

    static int values [] = new int [] {500, 1000, 2000, 5000, 10000, 20000, 50000, 75000, 150000, 250000, 500000, 1000000};
    public static int newValue = 0;
    static Question question = new Question();
    int hintQuantity = 2;

    static Scanner scanner = new Scanner(System.in);
    public static boolean correct;

    public static void getQuestions() throws IOException{
        int i = 0;
        G.Greetings();


        do{

            if (i < 4){
                if (i ==0){question.list.clear();question.randomNum();}

                question.randomQuestion(i,"easy.txt");
                Question.checkChoice();

                if(!Question.checkAnswer()){
                    correct = false;
                    System.out.println("Sorry, your answer is wrong! You win nothing. Thanks for playing! xD");
                }
                else {
                    correct = true;
                    newValue = values[i];
                    System.out.println("You have won $" + newValue);
                    i++;
                    System.out.println("Your answer is correct!"+"\nPress Q to quit or C to continue");
                    String userInput = scanner.nextLine();
                    if (userInput.equalsIgnoreCase("Q")){
                        break;
                    }
                }
            }
            else if (i >= 4 && i < 8){
                if (i ==4){question.list.clear();question.randomNum();}
                question.randomQuestion(i,"medium.txt");
                Question.checkChoice();

                if(!Question.checkAnswer()){
                    correct = false;
                    System.out.println("Sorry,Your answer is wrong! You have won $" + values[3]);
                }
                else {
                    correct = true;
                    newValue = values[i];
                    System.out.println("You have won $" + newValue);
                    i++;
                    System.out.println("Your answer is correct!"+"\nPress Q to quit or C to continue");

                    String userInput = scanner.nextLine();
                    if (userInput.equalsIgnoreCase("Q")){
                        break;
                    }
                }
            }
            else if (i >= 8){
                if (i ==8){question.list.clear();question.randomNum();}
                Question.randomQuestion(i-6,"hard.txt");
                Question.checkChoice();
                if(!Question.checkAnswer()){
                    correct = false;
                    System.out.println("Sorry,Your answer is wrong! You have won $" + values[7]);
                }
                else {
                    if (i == 11){
                        System.out.println("Congratulations, you answered all of the questions correctly!"+ values[i]);
                        System.out.println("Do you want to play again? Y/N");
                        Scanner playAgain =new Scanner(System.in);
                        String playAgainResponse = playAgain.nextLine();
                        if(playAgainResponse.equalsIgnoreCase("Y")){
                            getQuestions();
                            G.Greetings();
                        }
                        else {
                            System.out.println("Thank you for playing our game.");
                            break;
                        }
                    }
                    correct = true;
                    newValue = values[i];
                    System.out.println("You have won $" + newValue);
                    i++;
                    System.out.println("Your answer is correct!"+"\nPress Q to quit or C to continue");
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