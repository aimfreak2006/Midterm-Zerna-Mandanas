/**
 Table draws table using the Parallelogram class, Rectangle2D.Double, Triangle, and Path2D.
 It extends DrawingObject and give methods for
 drawing a table with dimensions and color.

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
import BasicShape.*;
import MainTable.*;

import java.awt.*;
import java.awt.geom.*;

public class Table extends DrawingObject
{
    private double width, height;
    private ButtonPress button;

    /**
     * Constructs a new Table.
     * It will have a specified position, height, and color.
     *
     * @param xPosition The x-coordinate of the Table.
     * @param yPosition The y-coordinate of the Table.
     *                  (x,y) is in the top left corner of the Table (below the sign)
     * @param width      The width of the Table.
     * @param height     The height of the Table.
     * @param color      The color of the Table.
     */
    public Table(double xPosition, double yPosition, double width, double height, Color color)
    {
        super(xPosition, yPosition, 0, color);
        this.width = width;
        this.height = height;
    }

    /**
     * Draws the Table.
     * It will use the provided Graphics2D object.
     *
     * @param graphics2d The Graphics2D object used for drawing.
     */
    @Override
    public void draw(Graphics2D graphics2d)
    {
        double yParallelogram = yPosition + (7*height / 16);
        double widthParallelogram = width / 4;
        double heightParallelogram = 3 * height / 4;

        double xRectangle = xPosition + width/4;
        double widthRectangle = 3*width / 4;
        double heightRectangle = 3*height / 4;

        double yTriangleMid = yPosition + height/4;

        double xTableTop2 = xPosition + widthRectangle;
        double xTableTop3 = xRectangle + widthRectangle;

        Parallelogram parallelogram = new Parallelogram(xPosition, yParallelogram, widthParallelogram, heightParallelogram, 0, new Color(112,8,32));
        Rectangle2D.Double rectangle = new Rectangle2D.Double(xRectangle, yParallelogram, widthRectangle, heightRectangle);
        Triangle triangle = new Triangle(xPosition, yPosition, xPosition, yTriangleMid, xRectangle, yParallelogram, 0, 0, 0, new Color(79,12,28));
        Rectangle2D.Double sign = new Rectangle2D.Double(xPosition, yPosition - height*.10, widthRectangle, height*.10);

        Path2D.Double tableTop = new Path2D.Double();
        tableTop.moveTo(xPosition, yPosition);
        tableTop.lineTo(xTableTop2, yPosition);
        tableTop.lineTo(xTableTop3, yParallelogram);
        tableTop.lineTo(xRectangle, yParallelogram);
        tableTop.closePath();
        graphics2d.setColor(new Color(163,18,52));
        graphics2d.fill(tableTop);

        parallelogram.draw(graphics2d);
        graphics2d.setColor(new Color(235,124,150));
        graphics2d.fill(rectangle);
        triangle.draw(graphics2d);

        graphics2d.setColor(new Color(48,10,19));
        graphics2d.fill(sign);
    }
}

