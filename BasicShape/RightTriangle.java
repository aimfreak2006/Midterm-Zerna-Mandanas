/**
 RightTriangle class draws a right triangle with base and height.
 It extends the Triangle class and provides a specific
 implementation for right triangles.

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
package BasicShape;

import java.awt.*;

public class RightTriangle extends Triangle
{
    /**
     * Constructor for RightTriangle.
     * It asks for different parameters for Line.
     *
     * @param xPosition the x-coordinate of the triangle's base
     * @param yPosition the y-coordinate of the triangle's base
     * @param rotation  the rotation angle of the triangle (in degrees)
     * @param width     the width
     * @param height    the height
     * @param color     the color
     * @param direction the direction
     */

    public RightTriangle(double xPosition, double yPosition, double rotation, double width, double height, Color color, int direction)
    {
        double xPositionMid = xPosition + direction*width;
        double xPivot = xPosition + width / 2;
        double yPositionEnd = yPosition - height;

        super(xPosition, yPosition, xPositionMid, yPosition, xPosition, yPositionEnd, xPivot, yPosition, rotation, color);

    }
}

