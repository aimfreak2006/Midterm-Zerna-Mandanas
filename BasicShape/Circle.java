/**
 Circle class is used to draw Complex Shapes
 with a specified center position and size.
 It extends the DrawingObject class and provides methods for drawing the circle.

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
import java.awt.*; // for the color and graphics classes
import java.awt.geom.*; // for creating shapes and paths

public class Circle extends DrawingObject
{
    Ellipse2D.Double circle;

    /**
     * Constructor for Circle. Instantiate the circle.
     *
     * @param xPosition the x-axis center of  circle
     * @param yPosition the y-axis center of circle
     * @param size      the diameter of the circle
     * @param color     the color of the circle
     */
    public Circle(double xPosition, double yPosition, double size, Color color)
    {
        super(xPosition, yPosition, size, color);
        circle = new Ellipse2D.Double(xPosition - size/2, yPosition - size/2, size, size);
    }

    /**
     * Draws the circle using the provided Graphics2D object.
     * Set color and draws it.
     *
     * @param graphics2d the Graphics2D for drawing
     */
    @Override
    public void draw(Graphics2D graphics2d)
    {
        graphics2d.setColor(color);
        graphics2d.fill(circle);
    }

    /**
     * Returns the y-coordinate circle.
     * For other class to use it.
     *
     * @return the y-coordinate circle
     */
    public double getY()
    {
        return yPosition - size / 2;
    }
}
