/**
 Cloud class draws a 2D drawing of a cloud using Triangle and Circle.
 It also extends DrawingObject, using its fields and methods.

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

import BasicShape.Circle;
import BasicShape.DrawingObject;
import BasicShape.EquilateralTriangle;

import java.awt.*;

public class Cloud extends DrawingObject
{
    /**
     * Constructor for Cloud class.
     * It asks for different parameters.
     *
     * @param xPosition      the x-coordinate of the Cloud.
     * @param yPosition      the y-coordinate of the Cloud.
     *                       (x,y) is the bottom center of the Triangle.
     * @param size           the size of the Cloud (base of the Equilateral Triangle)
     * @param color          the color of the clouds.
     */
    public Cloud(double xPosition, double yPosition, double size, Color color)
    {
        super(xPosition, yPosition, size, color);
    }

    /**
     * Draws a Cloud with the use of the graphics2d object.
     * Played in the SceneCanvas.
     *
     * @param graphics2d the Graphics2D object used for drawing
     */
    @Override
    public void draw(Graphics2D graphics2d)
    {
        EquilateralTriangle base = new EquilateralTriangle(xPosition, yPosition, 0, size, color, -1);
        double xLeft = xPosition - (size / 2);
        double xRight = xPosition + (size / 2);
        double sizeCircle = size * 1/3;
        double yCircle = yPosition - (size * 1/6);

        base.draw(graphics2d);

        for (int i = 0; i < 3; i++)
        {
            Circle leftCircle = new Circle(xLeft, yCircle, sizeCircle, color);
            Circle rightCircle = new Circle(xRight, yCircle, sizeCircle, color);

            leftCircle.draw(graphics2d);
            rightCircle.draw(graphics2d);

            xLeft = xLeft + (size * 1/6);
            xRight = xRight - (size * 1/6);
            yCircle = yCircle - (size * 1/6);
        }

        double yTopCircle = yPosition - Math.sqrt((3 * size * size) / 4) + size * 1/4;
        Circle topCircle = new Circle(xPosition, yTopCircle, sizeCircle*1.5, color); 
        topCircle.draw(graphics2d);
    }
}
