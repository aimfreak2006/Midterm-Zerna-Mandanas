/**
 InterfaceChannel class is used to manage interaction of the user.
 Represents a channel with a specified position and visual properties.
 It extends the DrawingObject class and
 provides abstract methods for updating position and handling button actions.

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

import BasicShape.DrawingObject;
import MainPackage.Sound;

import java.awt.*;

public abstract class InterfaceChannel extends DrawingObject {
    private boolean channel;

    /**
     * Constructor for InterfaceChannel.
     * It asks for different parameters.
     *
     * @param xPosition the x-coordinate of the channel's position
     * @param yPosition the y-coordinate of the channel's position
     * @param size      the size of the channel (interpretation depends on the subclass)
     * @param color     the color of the channel
     */
    public InterfaceChannel(double xPosition, double yPosition, double size, Color color) {
        super(xPosition, yPosition, size, color);
        channel = true;
    }

    /**
     * Abstract method to update the position of the channel. Used by others.
     */
    public abstract void updatePosition();

    /**
     * Abstract method to handle button actions. Used by others.
     */
    public abstract void buttonAction();

    /**
     * Abstract method to handle button off actions. Used by others.
     */
    public abstract void buttonOffAction();

    /**
     * Abstract method to handle music files. Used by others.
     */
    public abstract Sound getMusic();
}
