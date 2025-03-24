/**
 KeyboardInput class is used to handle keyboard events for channel navigation.
 KeyListener interface to detect arrow key presses,
 used to control the channel switching on a SceneCanvas.

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

package Inputs;

import MainPackage.SceneCanvas;
import java.awt.event.*;

public class KeyboardInput implements KeyListener {

    private SceneCanvas remoteForChannel;

    /**
     * Constructor for KeyboardInput.
     * It initialized the remoteForChannel.
     *
     * @param remoteForChannel the SceneCanvas object that will be controlled by keyboard input
     */
    public KeyboardInput(SceneCanvas remoteForChannel)
    {
        this.remoteForChannel = remoteForChannel;
    }

    /**
     * Not implemented. We didn't use in the program.
     * @param e the KeyEvent about the key typed
     */
    @Override
    public void keyTyped(KeyEvent e)
    {

    }

    /**
     * Handles key presses. Currently, detects left and right arrow key presses to switch channels.
     *
     * @param e the KeyEvent object containing information about the key pressed
     */
    @Override
    public void keyPressed(KeyEvent e)
    {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                remoteForChannel.previousChannel();
                break;
            case KeyEvent.VK_RIGHT:
                remoteForChannel.nextChannel();
                break;
            default:
                break;
        }
    }

    /**
     * Not implemented. We didn't use in the program.
     *
     * @param e the KeyEvent about the key released
     */
    @Override
    public void keyReleased(KeyEvent e) {}
}