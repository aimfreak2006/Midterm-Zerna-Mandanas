/**
 Volcano class draws volcano with lava flows using position, size, and color.
 It extends the Mountain class and provides methods for drawing the volcano and provides the instance fields.

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

import java.awt.*;
import java.awt.geom.*;
import BasicShape.*;

public class Volcano extends Mountain
{
    LavaFlow flow1, flow2, flow3;
    double[] randomPoints1 = new double[8];
    double[] randomPoints2 = new double[8];
    double[] randomPoints3 = new double[8];


    /**
     * Generates a random number from 0 to .5 and are stored in the randomPoints arrays. These
     * are to be used in generating the LavaFlow objects.
     */
    private void generateRandomPoints()
    {
        for (int i = 0; i < 4; i++)
        {
            randomPoints1[i] = Math.random() * 1/2;
            randomPoints1[i+1] = Math.random() * 1/2;

            randomPoints2[i] = Math.random() * 1/2;
            randomPoints2[i+1] = Math.random() * 1/2;

            randomPoints3[i] = Math.random() * 1/2;
            randomPoints3[i+1] = Math.random() * 1/2;
        }
    }

    /**
     * Constructor for Volcano. Accepts different parameters.
     *
     * @param xPosition   the x-coordinate of the Volcano
     * @param yPosition   the y-coordinate  of the Volcano
     *                    (x,y) is at the bottom center of the Mountain
     * @param width       the size width of the hole of the Mountain
     * @param colorHill   the color the Mountain's hill or base.
     * @param colorHole   the color of the Mountain's Hole.
     */
    public Volcano(double xPosition, double yPosition, double width, Color colorHill, Color colorHole)
    {
        super(xPosition, yPosition, width, colorHill, colorHole);
        generateRandomPoints();
    }


    /**
     * Draws the Volcano using the provided Graphics2D.
     * It is drawn together with the LavaFlow.
     *
     * @param graphics2d the Graphics2D object used for drawing
     */
    @Override
    public void draw(Graphics2D graphics2d)
    {
        ComplexShape.Mountain volcano = new ComplexShape.Mountain(xPosition, yPosition, size, color, colorHole);
        volcano.draw(graphics2d);

        double heightFlow = size * 3;
        double yFlow = yPosition - heightFlow;
        double xFlow2 = xPosition - (size * 1/3);
        double xFlow3 = xPosition + (size * 1/3);

        flow1 = new LavaFlow(xPosition, yFlow, 5, size, heightFlow, colorHole, randomPoints1);
        flow2 = new LavaFlow(xFlow2, yFlow, 5, size, heightFlow, colorHole, randomPoints2);
        flow3 = new LavaFlow(xFlow3, yFlow, 5, size, heightFlow, colorHole, randomPoints3);

        flow1.draw(graphics2d);
        flow2.draw(graphics2d);
        flow3.draw(graphics2d);

        graphics2d.setStroke(new BasicStroke(1));
    }
}

