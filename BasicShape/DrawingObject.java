/**
 DrawingObject Abstract class is for drawing object.
 It provides properties of shapes such as position, size, and color.

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

package BasicShape;
import java.awt.*;

public abstract class DrawingObject
{
    protected double xPosition;
    protected double yPosition;
    protected double size;
    protected Color color;

    /**
     * Constructor for DrawingObject.
     * It asks for different parameter.
     *
     * @param xPosition the x-axis position
     * @param yPosition the y-axis position
     * @param size      the size of the object
     * @param color     the color of the object
     */
    public DrawingObject(double xPosition, double yPosition, double size, Color color)
    {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.size = size;
        this.color = color;
    }

    /**
     * Abstract method to draw the object. It uses the provided Graphics2D object.
     *
     * @param graphics2d the Graphics2D object used for drawing
     */
    public abstract void draw(Graphics2D graphics2d);

}
