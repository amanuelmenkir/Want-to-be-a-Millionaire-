import java.io.IOException;

public class findAnswer {
    static Question question = new Question();
public static void getQuestions() throws IOException{
    for(int i=0; i<12; i++){
        if (i < 4){
            question.randomQuestion("easy.txt");

        }
        else if (i >= 4 && i <= 8){
            question.randomQuestion("hard.txt");

        }
        else if (i > 8){
            question.randomQuestion("medium.txt");

        }
    }

}


}
