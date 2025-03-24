/**
 ButtonPress class draws button that can be pressed and released.
 It provides methods for drawing the button and button presses.

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

package MainTable;

import java.awt.*;
import java.awt.geom.*;

//lagay sa drawing obj later

public class ButtonPress
{
    private double xPosition, yPosition, height, subtract;
    private Color color;

    /**
     * Constructs a new ButtonPress.
     * It has instance with specified position, height, and color.
     *
     * @param xPosition The x-coordinate of the button's position.
     * @param yPosition The y-coordinate of the button's position.
     * @param height     The height of the button.
     * @param color      The color of the button.
     */
    public ButtonPress(double xPosition, double yPosition, double height, Color color)
    {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.height = height;
        this.color = color;
        this.subtract = 0;
    }

    /**
     * Draws the button.
     * It uses the provided Graphics2D object.
     *
     * @param graphics2d The Graphics2D object used for drawing.
     */
    public void draw(Graphics2D graphics2d)
    {
        double yRectangle = yPosition + height / 2 + subtract;
        double yLowerCircle = yPosition + height;
        double width = height * 2;

        double heightRectangle = height - subtract;
        double yUpperCircle = yPosition + subtract;

        Ellipse2D.Double lowerCircle = new Ellipse2D.Double(xPosition, yLowerCircle, width, height);
        Rectangle2D.Double rectangle = new Rectangle2D.Double(xPosition, yRectangle, width, heightRectangle);
        Ellipse2D.Double upperCircle = new Ellipse2D.Double(xPosition, yUpperCircle, width, height);

        graphics2d.setColor(Color.ORANGE);
        graphics2d.fill(lowerCircle);
        graphics2d.fill(rectangle);

        graphics2d.setColor(Color.RED);
        graphics2d.fill(upperCircle);
    }

    /**
     * Button press motion through the subtract value.
     * It is used by different classes.
     *
     * @param distance The amount to adjust the subtract value.
     */
    public void pressButtonMotion(double distance)
    {
        subtract += distance;
    }
}
