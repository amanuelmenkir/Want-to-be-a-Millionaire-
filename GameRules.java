
import java.util.Scanner;
public class GameRules {

    public static void playAgainQuestion(){

    }
        public void Greetings(){
            Scanner sc = new Scanner(System.in);
            System.out.println("Welcome! Ready to Become A Millionaire?");
            System.out.println("Enter your name");
            String playerName = sc.nextLine();

            System.out.println("Hello "+playerName+"! "+ "Here are the rules: " );
            System.out.println("In order to play this game, you need to enter your name first" +
                    "\nOnce the questions pops up you can ask for hints, but you will get only 3 hints throughout the whole game"+
                    "\nTo advance towards the next levels, you need to answer questions correctly, after each " +
                    "correctly answered question,\nyou will need to decide to keep your score and leave or to keep " +
                    "going to next rounds.\nYou win when you reach one million dollars.\n");

            System.out.println("Press enter to start");
              String ready = sc.nextLine();



        }

    public void greeting() {
    }
}

