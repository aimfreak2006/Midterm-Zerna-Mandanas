/**
 Drawer draws a Drawer for the TableLamp. It uses Circles and Rectangle2D objects to do so.

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

package TableLamp;

import java.awt.*;
import java.awt.geom.*;

public class Drawer
{
    private double xPosition, yPosition, width, height;
    private Color color;


    /**
     * Constructs a new Drawer.
     * It will have specified position, height, and color.
     *
     * @param xPosition The x-coordinate of the Drawer.
     * @param yPosition The y-coordinate of the Drawer.
     *                  (x,y) is at the top left corner of the Drawer.
     * @param width      The width of the Drawer.
     * @param height     The height of the Drawer.
     * @param color      The color of the Drawer.
     */
    public Drawer(double xPosition, double yPosition, double width, double height, Color color)
    {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    /**
     * Draws the Drawer.
     * It uses the provided Graphics2D object.
     *
     * @param graphics2d The Graphics2D object used for drawing.
     */
    public void draw(Graphics2D graphics2d)
    {
        Rectangle2D.Double outer = new Rectangle2D.Double(xPosition, yPosition, width, height);

        double xInner = xPosition + (7*width / 20);
        double yInner = yPosition + (3*height / 20);
        double widthInner = width * .3;
        double heightInner = height * .7;
        Rectangle2D.Double inner = new Rectangle2D.Double(xInner, yInner, widthInner, heightInner);

        double xCircle = xPosition + ((25*width - 14*height)/50);
        double yCircle = yPosition + (11*height / 50);
        double widthCircle = height * 7/25;
        Ellipse2D.Double circle = new Ellipse2D.Double(xCircle, yCircle, widthCircle*2, widthCircle*2);

        graphics2d.setColor(color);
        graphics2d.fill(outer);
        graphics2d.fill(inner);

        graphics2d.setColor(new Color(191,154,80));
        graphics2d.fill(circle);

        graphics2d.setColor(new Color(54,29,4));
        graphics2d.draw(outer);
        graphics2d.draw(inner);
        graphics2d.draw(circle);
    }
}
