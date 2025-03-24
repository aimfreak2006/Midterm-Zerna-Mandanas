/**
 Remote class manage and switch current and next channel.
 It provides methods for drawing the current channel,
 handling button actions, and switching channels.

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

package Channels;

import MainPackage.Sound;

import java.awt.*;

/**
 * Constructor for Remote.
 * Initializes the remote with Day and Night Scene.
 */
public class Remote {
    private InterfaceChannel currentChannel, nextChannel;
    private boolean buttonPressed;
    private Sound clickSFX;

    /**
     * Constructor for Remote.
     * It asks for different parameters.
     */
    public Remote()
    {
        currentChannel = new MeteorDay();
        nextChannel = new MeteorNight();
        buttonPressed = false;
        clickSFX = new Sound("Sounds/ClickSFX.wav");
    }

    /**
     * Turns button on in the remote.
     * Play the click SFX.
     */
    public void buttonOn()
    {
        buttonPressed = true;
        clickSFX.play();
    }

    /**
     * Turns button off in the remote.
     * Used by other class.
     */
    public void buttonOff()
    {
        buttonPressed = false;
    }

    /**
     * Draws the current channel with/without button user interaction
     * using the provided Graphics2D object.
     *
     * @param graphics2d the Graphics2D object used for drawing
     */
    public void draw(Graphics2D graphics2d)
    {
        currentChannel.draw(graphics2d);
        if (buttonPressed){
            currentChannel.buttonAction();
        }
        if (!buttonPressed){
            currentChannel.buttonOffAction();
        }
    }

    /**
     * Switches the current and next channels.
     * Used by others.
     */
    public void changeChannel()
    {
        InterfaceChannel previousCurrentChannel = currentChannel;
        currentChannel = nextChannel;
        nextChannel = previousCurrentChannel;
    }

    /**
     * Returns the current channel.
     * It is used by other files.
     *
     * @return the current InterfaceChannel object
     */
    public InterfaceChannel getChannel()
    {
        return currentChannel;
    }

    public InterfaceChannel getNextChannel() {return nextChannel;};
}
