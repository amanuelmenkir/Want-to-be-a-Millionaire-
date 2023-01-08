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
                if(!Question.checkChoice()){
                    correct = false;
                }
                else {
                    correct = true;
                    i++;
                }
            }
            else if (i >= 4 && i <= 8){
                Question.randomQuestion("medium.txt");
                if(!Question.checkChoice()){
                    correct = false;
                }
                else {
                    correct = true;
                    i++;
                }
            }
            else if (i > 8){
                Question.randomQuestion("hard.txt");
                if(!Question.checkChoice()){
                    correct = false;
                }
                else {
                    correct = true;
                    i++;
                }
            }
        }
        while(correct);

    }
    public static void main(String[] args) throws IOException {
        getQuestions();
    }

}
