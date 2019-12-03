package gameflappybird;

import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SoundManager {

    private String path;
    private Clip clip;

    public SoundManager(String path) {
        this.path = path;
    }

    public void play(boolean isLoop) {
        if (clip != null && clip.isRunning()) {
            return;
        }
        
        try {
            AudioInputStream au
                    = AudioSystem.getAudioInputStream(getClass().getResource(path));

            clip = AudioSystem.getClip();
            //open tuong voi play
            if (isLoop) {
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }
            clip.open(au);
            clip.start();
//            playOnThread(au);
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    private void playOnThread(AudioInputStream au) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    clip.open(au);
                    clip.start();
                } catch (LineUnavailableException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }

    public void stop() {
        if (clip != null) {
            clip.close();
            clip = null;
        }
    }
}
