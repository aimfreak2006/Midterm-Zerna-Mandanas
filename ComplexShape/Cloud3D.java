/**
 Cloud3D class draws two Clouds object to make a 3D cloud.
 It also extends DrawingObject using the draw method and the instance field of the abstract class.

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

import BasicShape.DrawingObject;

import java.awt.*;

public class Cloud3D extends DrawingObject
{

    private double speed;

    /**
     * Constructor for Cloud3D.
     * It asks for different parameters.
     *
     * @param xPosition      the x-coordinate of the Cloud3D.
     * @param yPosition      the y-coordinate of the Cloud3d.
     *                       (x,y) is the coordinates of the Upper Cloud.
     * @param size           the size of the Cloud3D (base of the Equilateral Triangle)
     * @param speed          how fast the cloud is moving across the screen.
     * @param color          the color of the Upper Cloud.
     */
    
    public Cloud3D(double xPosition, double yPosition, double size, double speed, Color color)
    {  
        super(xPosition, yPosition, size, color);
        this.speed = speed;
    }

    /**
     * Draws a Cloud with the use of the graphics2d object.
     *
     * @param graphics2d the Graphics2D object used for drawing
     */
    @Override
    public void draw(Graphics2D graphics2d)
    {
        Cloud cloud1 = new Cloud(xPosition + size*.1, yPosition + size*.1, size, Color.GRAY);
        Cloud cloud2 = new Cloud(xPosition, yPosition, size, color);

        cloud1.draw(graphics2d);
        cloud2.draw(graphics2d);
    }

    /**
     * Updates the Cloud3D's xPosition. Used for animation.
     */
    public void moveCloud()
    {
        xPosition += speed;
    }

    /**
     * Returns the current xPosition of the Cloud3D object.
     * 
     * @return xPosition of Cloud3D
     */
    public double getX()
    {
        return xPosition;
    }
}
