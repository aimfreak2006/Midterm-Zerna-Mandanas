/**
 Sun class draws sun with rays using position,size, and ray description.
 It extends the DrawingObject class and provides
 methods for drawing and updating the sun's position.

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

import BasicShape.*;
import java.awt.*;

public class Sun extends DrawingObject
{
    private EquilateralTriangle[] sunRays;
    private int rayQuantity, angle; //pwede on click  from 8 to 16 to 32 rays
    private double newX, newY;
    private Circle sun;
    private boolean movingDown;

    /**
     * Constructor for Sun.
     *
     * @param xPosition the x-coordinate of the sun's center
     * @param yPosition the y-coordinate of the sun's center
     * @param size      the size of the sun
     * @param rayQuantity the number of rays emanating from the sun
     * @param color     the color of the sun
     */
    public Sun(double xPosition, double yPosition, double size, int rayQuantity, Color color)
    {
        super(xPosition, yPosition, size, color);
        this.rayQuantity = rayQuantity;
        sunRays = new EquilateralTriangle[rayQuantity];
        angle = 0;
        movingDown = true;
    }

    /**
     * Draws the sun using the provided Graphics2D object.
     *
     * @param graphics2d the Graphics2D object used for drawing
     */
    @Override
    public void draw(Graphics2D graphics2d)
    {
        sun =  new Circle(xPosition, yPosition, size, color);
        for (int i = 0; i < rayQuantity; i++)
        {
            newX = Math.cos(Math.toRadians(angle)) * size / 2;
            newY = Math.sin(Math.toRadians(angle)) * size / 2;
            angle += 360 / rayQuantity;
            sunRays[i] = new EquilateralTriangle(xPosition + newX, yPosition+ newY, angle, size, new Color(217, 207, 72),1);
        }
        for (int i = 0; i < sunRays.length ; i++)
        {
            sunRays[i].draw(graphics2d);
        }
        angle += 2;
        angle = angle % 360;

        graphics2d.setColor(color);
        sun.draw(graphics2d);
    }

    /**
     * Updates the position and size of the sun.
     * Makes the sun move and grow.
     */
    public void updatePosition() {
        if (movingDown) {
            yPosition += 1.2;
            size -= 0.25;
            if (yPosition >= 420)
            {
                movingDown = false;
                size = 30;
            }
        }
        else
        {
            yPosition -= 0.6;
            size += 0.17;
            if (yPosition <= 130)
            {
                movingDown = true;
            }
        }
    }

    /**
     * Used by Sky to determine whether to add gradient.
     * Used to determine the color of the sky.
     * @return yPosition of the Sun
     */
    public double getY()
    {
        return yPosition;
    }
}