import java.io.IOException;
import java.util.Scanner;

public class findAnswer {
    static Scanner scanner = new Scanner(System.in);
    static Question question = new Question();
    //static int i = 0;
    public static boolean correct;

    public static void getQuestions() throws IOException{
        int i = 0;


        do{

            if (i < 4){
                question.randomQuestion("easy.txt");
                if(!question.checkChoice()){
                    System.out.println(i);
                    correct = false;
                }
                else {
                    correct = true;
                    i++;
                }
            }
            else if (i >= 4 && i <= 8){
                question.randomQuestion("medium.txt");
                if(!question.checkChoice()){
                    System.out.println(i);
                    correct = false;
                }
                else {
                    correct = true;
                    i++;
                }
            }
            else if (i > 8){
                question.randomQuestion("hard.txt");
                if(!question.checkChoice()){
                    System.out.println(i);
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
