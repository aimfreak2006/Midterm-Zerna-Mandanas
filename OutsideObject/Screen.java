/**
 Screen makes a screen object on canvas together with its shadow.
 It provides methods for drawing the screen with a specified position, size, and color.

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
import java.awt.*;
import java.awt.geom.*;

public class Screen
{
    private int width, height, xPosition, yPosition;
    private GradientPaint color;


    /**
     * Constructs a new Screen instance.
     * It has specified position, height, and color.
     *
     * @param xPosition The x-coordinate of the Screen.
     * @param yPosition The y-coordinate of the Screen.
     *                  (x,y) is at the top left corner of the Screen
     * @param width      The width of the Screen.
     * @param height     The height of the Screen.
     * @param color      The color of the Screen.
     */
    public Screen(int xPosition, int yPosition, int width, int height, GradientPaint color)
    {
        this.width = width;
        this.height = height;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.color = color;
    }

    /**
     * Draws the Screen.
     * It uses the provided Graphics2D object.
     *
     * @param graphics2d The Graphics2D object used for drawing.
     */
    public void drawScreen(Graphics2D graphics2d)
    {
        Rectangle2D.Double shadow = new Rectangle2D.Double(xPosition + 10, yPosition + 10, width, height);
        graphics2d.setColor(Color.BLACK);
        graphics2d.fill(shadow);

        Rectangle2D.Double screen = new Rectangle2D.Double(xPosition, yPosition, width, height);
        graphics2d.setPaint(color);
        graphics2d.fill(screen);
    }

}
