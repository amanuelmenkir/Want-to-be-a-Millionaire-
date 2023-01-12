import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Sounds {
    String music ="";
    static Question question = new Question();
    public static void playSound(String level) throws LineUnavailableException, UnsupportedAudioFileException, IOException
    {
        Scanner scanner = new Scanner(System.in);
        String music = level+"/" + String.valueOf(question.newi)+".wav";
        File file = new File(music);
        AudioInputStream audionStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audionStream);
        clip.start();
       // String response = scanner.next();
    }
}
