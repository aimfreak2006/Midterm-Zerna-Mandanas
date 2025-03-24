/**
 Sound handles playing, looping, reloading
 and stopping sound effects and background music.
 Without it, there will be no music.

 @authors Gabriel D. Zerna (244970) & Amir Ismael C. Mandanas (242875)
 @version 4 March 2025

 We have not discussed the Java language code in our program
 with anyone other than our instructor or the teaching assistants
 assigned to this course.

 We have not used Java language code obtained from another student,
 or any other unauthorized source, either modified or unmodified.

 If any Java language code or documentation used in our program
 was obtained from another source, such as a textbook or website,
 that has been clearly noted with a proper citation in the comments
 of our program.
 **/

package MainPackage;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sound {
    private Clip clip;
    private String fileName;

    /**
     * Constructor for the Sound class.
     * It accepts the file name of the wav file.
     *
     * @param fileName The path to the audio file.
     */
    public Sound(String fileName){
        this.fileName = fileName;
        try
        {
            AudioInputStream music = AudioSystem.getAudioInputStream(new File(fileName));
            clip = AudioSystem.getClip();
            clip.open(music);
        }
        catch (UnsupportedAudioFileException | IOException | LineUnavailableException e)
        {
            throw new RuntimeException("Something is Wrong!" + e);
        }
    }

    /**
     * It calls the file again for it to be
     */
    public void reload()
    {
        try
        {
            AudioInputStream music = AudioSystem.getAudioInputStream(new File(fileName));
            clip = AudioSystem.getClip();
            clip.open(music);
        }
        catch (UnsupportedAudioFileException | IOException | LineUnavailableException e)
        {
            throw new RuntimeException("Something is Wrong!" + e);
        }
    }

    /**
     * Plays the sound once from the beginning.
     */
    public void play()
    {
        if (clip != null)
        {
            clip.setFramePosition(0);
            clip.start();
        }
    }

    public void pauseResume()
    {
        if (clip != null)
        {
            long pause = clip.getFrameLength();
        }
    }

    /**
     * Loops the sound continuously.
     */
    public void loop()
    {
        if (clip != null)
        {
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
    }

    /**
     * Closes the clip hence stops the music.
     */
    public void close()
    {
        if (clip != null)
        {
            clip.stop();
            clip.close();
        }
    }
}
