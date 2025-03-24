/**
 Square class draws a square shape with
 a specified center position and size.
 It extends the DrawingObject class and
 provides methods for drawing the square.

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
import java.awt.geom.*;

public class Square extends DrawingObject
{
    Rectangle2D.Double square;


    /**
     * Constructor for Square.
     *It asks for different parameters,
     *
     * @param xPosition the x-coordinate of the square's center
     * @param yPosition the y-coordinate of the square's center
     * @param size      the side length
     * @param color     the color
     */
    public Square(double xPosition, double yPosition, double size, Color color)
    {
        super(xPosition, yPosition, size, color);
        square = new Rectangle2D.Double(xPosition - size / 2, yPosition - size / 2, size, size);
    }

    /**
     * Draws the square.
     * It used the provided Graphics2D object.
     *
     * @param graphics2d the Graphics2D object used for drawing
     */
    public void draw(Graphics2D graphics2d)
    {
        graphics2d.setColor(color);
        graphics2d.fill(square);
    }
}
