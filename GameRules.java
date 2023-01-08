public class GameRules {

    public GameRules(){

    }
    public void Greetings(){


        System.out.println("Welcome! Ready to Become A Millionaire?");
        System.out.println("Here are the rules: " );
        System.out.println("In order to play this game, you need to enter your name first" +
                "\n\nOnce the questions pops up you can ask for hints, but you will get only 3 hints throughout the whole game"+
                "\n\nTo advance towards the next levels, you need to answer questions correctly, after each " +
                "correctly answered question,\n\nyou will need to decide to keep your score and leave or to keep " +
                "going to next rounds.\n\nYou win when you reach one million dollars.");



    }
    public static void main(String[] args) {
        GameRules myObj = new GameRules();
        myObj.Greetings();
    }

}
