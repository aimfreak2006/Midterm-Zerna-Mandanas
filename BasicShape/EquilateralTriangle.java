/**
 Equilateral Triangle class draw an equilateral triangle given only 2 points.
 It extends the Triangle class and use it for making equilateral triangles.

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

public class EquilateralTriangle extends Triangle
{
    /**
     * Constructor for Equilateral Triangle.
     * Ask for different parameter for triangle.
     *
     * @param xPosition center of triangle
     * @param yPosition center of triangle
     * @param rotation degree of rotation of the triangle
     * @param size size of the triangle
     * @param color color of the triangle
     * @param direction direction of the triangle
     */
    public EquilateralTriangle(double xPosition, double yPosition, double rotation, double size, Color color, int direction)
    {
        double xPositionStart = xPosition - size/2;
        double yPositionMid = yPosition + direction * Math.sqrt((3 * size * size) / 4);
        double xPositionEnd = xPosition + size/2;

        super(xPositionStart, yPosition, xPosition, yPositionMid, xPositionEnd, yPosition, xPosition, yPosition, rotation, color);
    }
}