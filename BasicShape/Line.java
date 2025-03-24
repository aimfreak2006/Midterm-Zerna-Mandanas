/**
 Line class draw a line segment with  start and end point.
 It extends the DrawingObject class and provides methods for drawing line.

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
import java.awt.*; // for the color and graphics classes
import java.awt.geom.*; // for creating shapes and paths

public class Line extends DrawingObject
{
    private double xPositionEnd;
    private double yPositionEnd;
    private Line2D.Double line;

    /**
     * Constructor for Line.
     * It asks for different parameters for Line.
     *
     * @param xPositionStart the x-coordinate start point
     * @param yPositionStart the y-coordinate start point
     * @param xPositionEnd   the x-coordinate point
     * @param yPositionEnd   the y-coordinate end point
     * @param size           the thickness
     * @param color          the color
     */
    public Line(double xPositionStart,  double yPositionStart, double xPositionEnd, double yPositionEnd, double size, Color color)
    {
        super(xPositionStart, yPositionStart, size, color);
        this.xPositionEnd = xPositionEnd;
        this.yPositionEnd = yPositionEnd;
        line = new Line2D.Double(xPositionStart, yPositionStart, xPositionEnd, yPositionEnd);
        
    }

    /**
     * Draws the line using the provided Graphics2D object.
     * The line is drawn with thickness and color.
     *
     * @param graphics2d the Graphics2D object used for drawing
     */
    public void draw(Graphics2D graphics2d)
    {
        int newSize = (int) size;
        graphics2d.setStroke(new BasicStroke(newSize));
        graphics2d.setColor(color);
        graphics2d.draw(line);
    }

    /**
     * Returns the x-coordinate.
     * It is the line's start point.
     *
     * @return the x-coordinate
     */
    public double getX()
    {
        return xPosition;
    }

    /**
     * Returns the y-coordinate.
     * It is the line's start point.
     *
     * @return the y-coordinate
     */
    public double getY()
    {
        return yPosition;
    }
}
