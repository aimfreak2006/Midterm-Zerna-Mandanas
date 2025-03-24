/**
 Lamp represents a graphical lamp object. It uses LampHead object and a Rectangle2D to draw the Lamp.
 It provides methods for drawing a lamp
 with specified position, dimensions, and color.

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

public class Lamp
{
    private double xPosition, yPosition, width, height;
    private boolean isNight;
    private Color color;

    /**
     * Constructs a new Lamp.
     * It will have  with specified position, height, and color.
     *
     * @param xPosition The x-coordinate of the Lamp.
     * @param yPosition The y-coordinate of the Lamp.
     *                  (x,y) is at the center of the base of the Rectangle2D.
     * @param width      The width of the Lamp.
     * @param height     The height of the Lamp.
     * @param color      The color of the Lamp.
     */

    public Lamp(double xPosition, double yPosition, double width, double height, Color color, boolean isNight)
    {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.width = width;
        this.height = height;
        this.color = color;
        this.isNight = isNight;
    }


    /**
     * Draws the Lamp.
     * It uses the provided Graphics2D object.
     *
     * @param graphics2d The Graphics2D object used for drawing.
     */
    public void draw(Graphics2D graphics2d)
    {
        double xBottom = xPosition - (width * 7/20);
        double yBottom = yPosition - (height * 1/20);
        double heightBottom = height * 1/10;
        double widthBottom = width * 7/10;
        Ellipse2D.Double bottom = new Ellipse2D.Double(xBottom, yBottom, widthBottom, heightBottom);
        graphics2d.setColor(Color.BLACK);
        graphics2d.fill(bottom);

        double xStand = xPosition - (width * 1/20);
        double yStand = yPosition - (height * 11/20);
        double heightStand = height * 1/2;
        double widthStand = width * 1/10;
        Rectangle2D.Double stand = new Rectangle2D.Double(xStand, yStand, widthStand, heightStand);
        graphics2d.setColor(Color.BLUE);
        graphics2d.fill(stand);

        double yHead = yPosition - (height * 37/60);
        double heightHead = height * 2/5;
        Color colorHead = Color.GRAY;

        if (isNight)
        {
            colorHead = Color.WHITE;
            graphics2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.50f));
            LampHead shadow1 = new LampHead(xPosition, yHead, 2*width, 2*heightHead, Color.WHITE);
            shadow1.draw(graphics2d);

            graphics2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.30f));
            LampHead shadow2 = new LampHead(xPosition, yHead, 4*width, 4*heightHead, Color.WHITE);
            shadow2.draw(graphics2d);

            graphics2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
        }

        LampHead head = new LampHead(xPosition, yHead, width, heightHead, colorHead);
        head.draw(graphics2d);
    }
}
