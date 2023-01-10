public class addMoney {
    static int values [] = new int [] {500, 1000, 2000, 5000, 10000, 20000, 50000, 75000, 150000, 250000, 500000, 1000000};
    public int getMoney(int value) {
        int newvalue = 0; // Creates a new variable which will contain the new value
        while (true) {
            for (int i = 0; i < 12; i++) // Goes through the 12 possible prize amounts
            {
                if (value == values[i]) // Checks to see if the value the user is at is the same as the value in the array
                {
                    newvalue = values[i + 1]; // Sets the new value to be the next value in the array
                    break; // Ends the program
                } else {
                    newvalue = value; // Sets the new value to the same value
                }
            }
            return newvalue; // returns the newvalue
        }
    }
    public static void gameFinally(int getMoney, int question, boolean correct) {
        System.out.println("Thank you for playing 'Who Wants to Be a Millionaire'!");
        System.out.println("You have won $" + getMoney + ".");
        if (!correct) {
            System.out.println("Unfortunately, you answered incorrectly on question number " + question + ".");
        } else {
            System.out.println("Congratulations, you answered all of the questions correctly!");
        }
    }

    public static void main(String[] args) {

    }
}

