/**
 Triangle class draws a triangle with 3 lines and can rotate.
 It extends the DrawingObject class and provides
 methods for drawing and rotating the triangle.

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
import java.awt.geom.*;

public class Triangle extends DrawingObject
{
    private double xPositionMid, xPositionEnd, yPositionMid, yPositionEnd, xPivot, yPivot, rotation;

    /**
     * Constructor for Triangle.
     * It asks for different parameters.
     *
     * @param xPositionStart the x-coordinate of the first line
     * @param yPositionStart the y-coordinate of the first line
     * @param xPositionMid   the x-coordinate of the second line
     * @param yPositionMid   the y-coordinate of the second line
     * @param xPositionEnd   the x-coordinate of the third line
     * @param yPositionEnd   the y-coordinate of the third line
     * @param xPivot         the x-coordinate for rotation
     * @param yPivot         the y-coordinate for rotation
     * @param rotation       the rotation angle in degrees
     * @param color          the color of the triangle
     */
    public Triangle(double xPositionStart, double yPositionStart, double xPositionMid, double yPositionMid, double xPositionEnd, double yPositionEnd, double xPivot, double yPivot, double rotation, Color color)
    {
        super(xPositionStart, yPositionStart, 0, color);
        this.xPositionMid = xPositionMid;
        this.xPositionEnd = xPositionEnd;
        this.yPositionMid = yPositionMid;
        this.yPositionEnd = yPositionEnd;
        this.xPivot = xPivot;
        this.yPivot = yPivot;
        this.rotation = rotation;
    }

    /**
     * Draws the triangle using the provided Graphics2D object.
     * The triangle is drawn based on its vertices and rotated around the pivot point.
     *
     * @param graphics2d the Graphics2D object used for drawing
     */
    @Override
    public void draw(Graphics2D graphics2d)
    {
        Path2D.Double triangle = new Path2D.Double();
        triangle.moveTo(xPosition, yPosition);
        triangle.lineTo(xPositionMid, yPositionMid);
        triangle.lineTo(xPositionEnd, yPositionEnd);

        triangle.closePath();

        AffineTransform reset = graphics2d.getTransform();
        graphics2d.rotate(Math.toRadians(rotation), xPivot, yPivot);

        graphics2d.setColor(color);
        graphics2d.fill(triangle);
        graphics2d.setTransform(reset);
    }

    /**
     * Returns the x-coordinate of the first vertex.
     *
     * @return the x-coordinate
     */
    public double getX()
    {
        return xPosition;
    }

    /**
     * Returns the y-coordinate of the first vertex.
     *
     * @return the y-coordinate
     */
    public double getY()
    {
        return yPosition;
    }

    /**
     * Rotates the triangle by the specified angle around its pivot point.
     *
     * @param rotation the angle of rotation in degrees
     */
    public void rotate(double rotation)
    {
        this.rotation += rotation;
    }
}