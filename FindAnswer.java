import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class FindAnswer {
    static GameRules G=new GameRules();
    static Sounds sounds = new Sounds();
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
    // method to get next question
    public static void getNextQuestion(int i, String questionFile, String soundFile) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        question.randomQuestion(i,questionFile);
        sounds.playSound(soundFile);
        Question.checkChoice();
    }
    // Method for actions in case if answer is wrong
    public static void afterWrongAnswer( String uniqueText) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        Sounds.playCorrectSound("wrongAnswer");
        correct = false;
        System.out.println("Sorry, your answer is wrong! " + uniqueText);
        playAgain();
    }

    // Method for actions in case if answer is correct
    public static void afterCorrectAnswer(int i) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        Sounds.playCorrectSound("correctAnswer");
        correct = true;
        newValue = df.format(values[i]);
        System.out.println("You have won $" + newValue);

        System.out.println("Your answer is correct!"+"\nIf you want to leave with the current prize money enter Q. Otherwise press Enter");                    String userInput = scanner.nextLine();
        if (userInput.equalsIgnoreCase("Q")){
            System.exit(0);
        }
    }

    public static void getQuestions() throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        int i = 0;

        do{
            Sounds.playCorrectSound("MainTheme");               //playing background sound

            System.out.println("This is question #" + (i + 1));

            if (i < 4){
                if (i ==0){question.list.clear();question.randomNum();}     //clear list and create new random list
                getNextQuestion(i, "easy.txt", "easySound");
                if(!Question.checkAnswer()){
                    afterWrongAnswer( "You win nothing. Thanks for playing! xD");
                }
                else {
                    afterCorrectAnswer(i);
                    i++;
                }
            }
            else if (i >= 4 && i < 8){
                if (i ==4){
                    System.out.println("You have reached your 1st checkpoint! Minimum Prize amount is: $5,000.00");
                    question.list.clear();question.randomNum();     //clear list and create new random list
                }
                getNextQuestion(i, "medium.txt", "mediumSounds");
                if(!Question.checkAnswer()){
                    afterWrongAnswer( "You still win $" + df.format(values[3]));
                }
                else {
                    afterCorrectAnswer(i);
                    i++;
                }
            }
            else if (i >= 8){
                if (i ==8){
                    System.out.println("You have reached your 2nd checkpoint! Minimum Prize amount is: $75,000.00");
                    question.list.clear();question.randomNum();     //clear list and create new random list
                }
                getNextQuestion(i-6, "hard.txt", "hardSounds");
                if(!Question.checkAnswer()){
                    afterWrongAnswer( "You still win $" + df.format(values[7]));
                }
                else {

                    if (i == 11){
                        System.out.println("Congratulations! You answered all of the questions correctly! You win $1,000,000.00");
                        playAgain();
                    }
                    afterCorrectAnswer(i);
                    i++;
                }
            }
        }
        while(correct);

    }
}