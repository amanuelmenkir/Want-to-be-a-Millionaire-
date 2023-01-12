import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Main {
    static FindAnswer findAnswer = new FindAnswer();
    static GameRules gameRules = new GameRules();

    public static void main(String[] args) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        gameRules.Greetings();
        findAnswer.getQuestions();

    }
}
