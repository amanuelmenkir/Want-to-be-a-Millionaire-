
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.Scanner;
public class GameRules {

    public static void playAgainQuestion(){

    }
        public void Greetings() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
            Scanner sc = new Scanner(System.in);
            System.out.println("Welcome! Ready to Become A Millionaire?");
            System.out.println("Enter your name");
            String playerName = sc.nextLine();

            System.out.println("Hello "+playerName+"! "+ "Here are the rules: " );
            System.out.println("In order to win this game, you need to answer 12 questions correctly." +
                    "\nOnce the question pops up you can ask for hints, but you will only receive 3 hints throughout the whole game." +
                    "\nWe have 3 levels; easy, medium, and hard. " +
                    "\nTo advance towards the next level, you need to answer questions correctly. After each correctly answered question," +
                    "\nyou will need to decide to leave and keep your prize or to keep going to the next rounds." +
                    "\nYou win when you reach one million dollars. Good luck!\n");

            System.out.println("Press enter to start");
              String ready = sc.nextLine();



        }
}

