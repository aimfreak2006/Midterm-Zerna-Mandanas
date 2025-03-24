/**
 Mountain Class draws a mountain or a dormant volcano using Path2D and a Circle.
 It also extends the abstract class DrawingObject, using its abstract method and instance fields.

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

import BasicShape.DrawingObject;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;

public class Mountain extends DrawingObject
{
    protected Color colorHole;

    /**
     * Constructor for Mountain. It calls the Constructor of the Drawing object to initialize its Attributes.
     *
     * @param xPosition   the x-coordinate of the Mountain
     * @param yPosition   the y-coordinate  of the Mountain
     *                    (x,y) is at the bottom center of the Mountain
     * @param width       the size width of the hole of the Mountain
     * @param colorHill   the color the Mountain's hill or base.
     * @param colorHole   the color of the Mountain's Hole.
     */
    public Mountain(double xPosition, double yPosition, double width, Color colorHill, Color colorHole)
    {
        super(xPosition, yPosition, width, colorHill);
        this.colorHole = colorHole;
    }

    /**
     * Draws the Mountain using the provided Graphics2D object.
     * Uses an ellipse and Path2D to draw a Mountain
     *
     * @param graphics2d the Graphics2D object used for drawing
     */
    @Override
    public void draw(Graphics2D graphics2d)
    {
        double xUpperLeft = xPosition - (size * 1/2);
        double xUpperRight = xPosition + (size * 1/2);
        double xLowerLeft = xUpperLeft - size;
        double xLowerRight = xUpperRight + size;

        double yUpper = yPosition - (size * 3);
        
        Path2D.Double mountain = new Path2D.Double();
        mountain.moveTo(xUpperLeft, yUpper);
        mountain.lineTo(xUpperRight, yUpper);
        mountain.lineTo(xLowerRight, yPosition);
        mountain.lineTo(xLowerLeft, yPosition);
        mountain.closePath();
        graphics2d.setColor(color);
        graphics2d.fill(mountain);


        double xHole = xPosition - (size * 1/2);
        double yHole = yPosition - (size * 25/8);
        double heightHole = size * 1/4;
        Ellipse2D.Double hole = new Ellipse2D.Double(xHole, yHole, size, heightHole);
        graphics2d.setColor(colorHole);
        graphics2d.fill(hole);
    }
}
