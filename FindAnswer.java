import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class FindAnswer {
    static GameRules G=new GameRules();
    static Sounds sounds = new Sounds();
    //static FindAnswer findAnswer = new FindAnswer();

    static int values [] = new int [] {500, 1000, 2000, 5000, 10000, 20000, 50000, 75000, 150000, 250000, 500000, 1000000};
    static DecimalFormat df = new DecimalFormat("#,###.00");

    public static String newValue = "";
    static Question question = new Question();
    int hintQuantity = 2;

    static Scanner scanner = new Scanner(System.in);
    public static boolean correct;
    public static void playAgain() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        System.out.println("Do you want to play again? Y/N");
        Scanner playAgain =new Scanner(System.in);
        String playAgainResponse = playAgain.nextLine();
        if(playAgainResponse.equalsIgnoreCase("Y")){
            System.out.println("Enter your name: ");
            Scanner sc = new Scanner(System.in);
            String playerName = sc.nextLine();
            getQuestions();

        }
        else {
            System.out.println("Thank you for playing our game.");
            System.exit(0);
        }
    }

    public static void getQuestions() throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        int i = 0;

        do{
            System.out.println("This is question #" + (i + 1));
            if (i < 4){
                if (i ==0){question.list.clear();question.randomNum();}

                question.randomQuestion(i,"easy.txt");
                sounds.playSound("easySound");
                Question.checkChoice();

                if(!Question.checkAnswer()){
                    correct = false;
                    System.out.println("Sorry, your answer is wrong! You win nothing. Thanks for playing! xD");
                    playAgain();
                }
                else {
                    correct = true;
                    newValue = df.format(values[i]);
                    System.out.println("You have won $" + newValue);
                    i++;
                    System.out.println("Your answer is correct!"+"\nIf you want to leave with the current prize money enter Q. Otherwise enter C to continue");
                    String userInput = scanner.nextLine();
                    if (userInput.equalsIgnoreCase("Q")){
                        System.out.println("Thank you for playing our game!! You have won $" + newValue);
                        System.exit(0);
                    }
                }
            }
            else if (i >= 4 && i < 8){

                if (i ==4){
                    System.out.println("You have reached your 1st checkpoint! Minimum Prize amount is: $5,000.00");
                    question.list.clear();
                    question.randomNum();
                }
                question.randomQuestion(i,"medium.txt");
                sounds.playSound("mediumSounds");

                Question.checkChoice();

                if(!Question.checkAnswer()){
                    correct = false;
                    System.out.println("Sorry, your answer is wrong! You still win $" + df.format(values[3]));
                    playAgain();
                }
                else {
                    correct = true;
                    newValue = df.format(values[i]);
                    System.out.println("You have won $" + newValue);
                    i++;
                    System.out.println("Your answer is correct!"+"\nIf you want to leave with the current prize money enter Q. Otherwise enter C to continue");
                    String userInput = scanner.nextLine();
                    if (userInput.equalsIgnoreCase("Q")){
                        System.out.println("Thank you for playing our game!! You have won $" + newValue);
                        System.exit(0);
                    }
                }
            }
            else if (i >= 8){

                if (i ==8){
                    System.out.println("You have reached your 2nd checkpoint! Minimum Prize amount is: $75,000.00");
                    question.list.clear();
                    question.randomNum();
                }
                Question.randomQuestion(i-6,"hard.txt");
                sounds.playSound("hardSounds");

                Question.checkChoice();
                if(!Question.checkAnswer()){
                    correct = false;
                    System.out.println("Sorry. Your answer is wrong! You still win $" + df.format(values[7]));
                    playAgain();
                }
                else {
                    if (i == 11){
                        System.out.println("Congratulations! You answered all of the questions correctly! You win $1,000,000.00");
                        playAgain();
                    }
                    correct = true;
                    newValue = df.format(values[i]);
                    System.out.println("You have won $" + newValue);
                    i++;
                    System.out.println("Your answer is correct!"+"\nPress Q to quit or C to continue");
                    String userInput = scanner.nextLine();
                    if (userInput.equalsIgnoreCase("Q")){
                        System.exit(0);
                    }
                }
            }
        }
        while(correct);

    }
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        G.Greetings();
        getQuestions();
    }

}