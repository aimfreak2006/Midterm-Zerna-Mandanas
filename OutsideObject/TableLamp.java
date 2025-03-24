/**
 TableLamp draws table lamp.
 It extends DrawingObject and provides methods for
 drawing a table lamp with dimensions and color.

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

package OutsideObject;

import TableLamp.*;
import java.awt.*;
import java.awt.geom.*;
import BasicShape.*;

public class TableLamp extends DrawingObject
{
    private double width, height;
    private boolean isNight;


    /**
     * Constructs a new TableLamp instance with specified position, height, and color.
     *
     * @param xPosition The x-coordinate of the TableLamp.
     * @param yPosition The y-coordinate of the TableLamp.
     *                  (x,y) is at the top left corner of the TableLamp
     * @param width      The width of the TableLamp.
     * @param height     The height of the TableLamp.
     * @param color      The color of the TableLamp.
     */
    public TableLamp(double xPosition, double yPosition, double width, double height, Color color)
    {
        super(xPosition, yPosition, 0, color);
        this.width = width;
        this.height = height;
        isNight = false;
    }

    /**
     * Draws the TableLamp.
     * It uses the provided Graphics2D object.
     *
     * @param graphics2d The Graphics2D object used for drawing.
     */
    @Override
    public void draw(Graphics2D graphics2d)
    {
        Rectangle2D.Double table = new Rectangle2D.Double(xPosition, yPosition, width, height);
        graphics2d.setColor(new Color(191,154,80));
        graphics2d.fill(table);
        graphics2d.setColor(new Color(54,29,4));
        graphics2d.draw(table);

        double xDrawer = xPosition + (3*width / 20);
        double yUpper = yPosition + (height / 7);
        double yLower = yPosition + (4*height / 7);
        double widthDrawer = 7*width / 10;
        double heightDrawer = 2*height / 7;

        Drawer upperDrawer = new Drawer(xDrawer, yUpper, widthDrawer, heightDrawer, new Color(189,219,99));
        upperDrawer.draw(graphics2d);

        Drawer lowerDrawer = new Drawer(xDrawer, yLower, widthDrawer, heightDrawer, new Color(189,219,99));
        lowerDrawer.draw(graphics2d);

        double xTop = xPosition - width/7;
        double yTop = yPosition - height/7;
        double widthTop = 9*width / 7;
        double heightTop = height/7;

        Rectangle2D.Double tableTop = new Rectangle2D.Double(xTop, yTop, widthTop, heightTop);
        graphics2d.setColor(new Color(191,154,80));
        graphics2d.fill(tableTop);
        graphics2d.setColor(new Color(54,29,4));
        graphics2d.draw(tableTop);
    }
}
