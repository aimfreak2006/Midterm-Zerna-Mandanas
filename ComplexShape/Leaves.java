/**
 Leaves class Draws another type of Leaves other than triangles for a tree using circles.
 It also extends the DrawingObject using its draw method and attributes.

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

package ComplexShape;

import BasicShape.Circle;
import BasicShape.DrawingObject;

import java.awt.*;

public class Leaves extends DrawingObject
{

    private double angle;

    /**
     * Constructor for Leaves.
     *
     * @param xPosition      the x value of the Leaves
     * @param yPosition      the y value of the Leaves
     * @param size           how big the Leaves are
     * @param color          the color of the Leaves.
     */
    
    public Leaves(double xPosition, double yPosition, double size, Color color)
    {
        super(xPosition, yPosition, size, color);
        angle = 0;
    }

    /**
     * Draws Leaves using Circles.
     *
     * @param graphics2d the Graphics2D object used for drawing
     */
    @Override
    public void draw(Graphics2D graphics2d)
    {
        Circle midCircle = new Circle(xPosition, yPosition, size, color);
        graphics2d.setColor(color);
        midCircle.draw(graphics2d);
        for (int i = 0; i < 9; i++)
        {
            double newX = xPosition + Math.cos(Math.toRadians(angle)) * size/2;
            double newY = yPosition + Math.sin(Math.toRadians(angle)) * size/2;
            angle += 360 / 9;
            Circle circle = new Circle(newX, newY, size/2, color);
            circle.draw(graphics2d);
        }
    }
}
