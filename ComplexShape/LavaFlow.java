/**
 LavaFlow class draw a lava flow with a starting place and size.
 It provides methods for drawing the lava flow based on random points and an imaginary
 rectangle with a width and height influencing its path.
 It also extends DrawingObject using its draw method and its attributes.

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

public class LavaFlow extends DrawingObject
{
    private double newWidthRight, newWidthLeft, newHeight;
    private double xStart, yStart;
    private double[] randomPoints;

    /**
     * Constructor for LavaFlow.
     * It asks for different parameters.
     *
     * @param xPosition      the starting x of the LavaFlow.
     * @param yPosition      the starting y of the LavaFlow.
     * @param size           the thickness of the LavaFlow.
     * @param width          the width of the imaginary rectangle
     * @param height         the height of the imaginary rectangle
     * @param color          the color of the LavaFlow.
     * @param randomPoints   the x and y scalar to be used on randomizing the points.
     */

    public LavaFlow(double xPosition, double yPosition, double size, double width, double height, Color color, double[] randomPoints)
    {
        super(xPosition, yPosition, size, color);
        newWidthLeft = width/2;
        newWidthRight = width/2;
        newHeight = height;
        xStart = xPosition;
        yStart = yPosition;
        this.randomPoints = randomPoints;
    }

    /**
     * Draws a LavaFlow using 4 Line Objects.
     *
     * @param graphics2d the Graphics2D object used for drawing
     */
    @Override
    public void draw(Graphics2D graphics2d)
    {
        for (int i = 0; i < 4; i++)
        {
            double xScalar = randomPoints[i];
            double yScalar = randomPoints[i+1];
            double currentWidth = newWidthRight;

            if (i % 2 == 0)
            {
                xScalar = -xScalar;
                currentWidth = newWidthLeft;
            }

            double xEnd = xStart + (currentWidth * xScalar);
            double yEnd = yStart + (newHeight * yScalar);

            Line line = new Line(xStart, yStart, xEnd, yEnd, 5, color);
            line.draw(graphics2d);

            double xDifference = xStart - xEnd;
            double yDifference = yEnd - yStart;
            newWidthLeft = newWidthLeft - xDifference;
            newWidthRight = newWidthRight + xDifference;
            newHeight = newHeight - yDifference;

            xStart = xEnd;
            yStart = yEnd;
        }
    }
}
