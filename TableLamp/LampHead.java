/**
 LampHead represents a graphical lampHead object. It uses two triangles, a rectangle, and an ellipse
 object to draw the LampHead.

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
import BasicShape.*;

public class LampHead
{
    private double xPosition, yPosition, width, height;
    private Color color;

    /**
     * Constructs a new LampHead instance.
     * It will have specified position, height, and color.
     *
     * @param xPosition The x-coordinate of the LampHead.
     * @param yPosition The y-coordinate of the LampHead.
     *                  (x,y) is at the center of the Ellipse2D.
     * @param width      The width of the LampHead.
     * @param height     The height of the LampHead.
     * @param color      The color of the LampHead.
     */
    public LampHead(double xPosition, double yPosition, double width, double height, Color color)
    {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    /**
     * Draws the Lamp.
     * It uses the provided Graphics2D object.
     *
     * @param graphics2d The Graphics2D object used for drawing.
     */
    public void draw(Graphics2D graphics2d)
    {
        double heightEllipse = height * 1/3;
        double xEllipse = xPosition - width * 1/2;
        double yEllipse = yPosition - heightEllipse * 1/2;
        Ellipse2D.Double ellipse = new Ellipse2D.Double(xEllipse, yEllipse, width, heightEllipse);
        graphics2d.setColor(color);
        graphics2d.fill(ellipse);

        double xLeftTriangle = xPosition - (width * 1/6);
        double xRightTriangle = xPosition + (width * 1/6);
        double widthTriangle = width * 1/3;
        double heightTriangle = height * 5/6;

        double yRectangle = yPosition - (height * 5/6);

        RightTriangle leftTriangle = new RightTriangle(xLeftTriangle, yPosition, 0, widthTriangle, heightTriangle, color, -1);
        RightTriangle rightTriangle = new RightTriangle(xRightTriangle, yPosition, 0, widthTriangle, heightTriangle, color, 1);
        Rectangle2D.Double rectangle = new Rectangle2D.Double(xLeftTriangle, yRectangle, widthTriangle, heightTriangle);

        leftTriangle.draw(graphics2d);
        rightTriangle.draw(graphics2d);

        graphics2d.fill(rectangle);
    }
}
