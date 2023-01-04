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

//    public static void correctAnswer() throws IOException {
//        Random random = new Random();
//        int i = (rn.nextInt(3)) * 7;
//        for (int l = 0; l < 5; l++) {
//            String line = Files.readAllLines(Paths.get("easy.txt")).get(i + l);
//            //   String line33 = Files.readAllLines(Paths.get("easy.txt")).get(i + 1);
//            System.out.println(line);
//            // System.out.println(line33);
//        }
//    }
}
