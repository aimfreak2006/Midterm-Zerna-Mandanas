/**
 Parallelogram draws a parallelogram using two RightTriangle and a Rectangle.
 It provides methods for drawing the parallelogram
 with specified dimensions and rotation.
 This class is useful for drawing the Table object.

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

package MainTable;

import java.awt.*;
import java.awt.geom.*;
import BasicShape.*;

public class Parallelogram
{
    private double xPosition, yPosition, width, height, rotation;
    private Color color;


    /**
     * Constructs a new Parallelogram instance with specified position, height, and color.
     * It asks for different parameters.
     *
     * @param xPosition The x-coordinate of the Parallelogram.
     * @param yPosition The y-coordinate of the Parralelogram.
     *                  (x,y) is at the top left corner of the Parallelogram
     * @param width      The width of the Parallelogram.
     * @param height     The height of the Parallelogram.
     * @param color      The color of the Parallelogram.
     */
    public Parallelogram(double xPosition, double yPosition, double width, double height, double rotation, Color color)
    {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.width = width;
        this.height = height;
        this.rotation = rotation;
        this.color = color;
    }

    /**
     * Draws the Parallelogram using the provided Graphics2D object.
     * It used the SceneCanvas to draw.
     *
     * @param graphics2d The Graphics2D object used for drawing.
     */
    public void draw(Graphics2D graphics2d)
    {
        double rectangleHeight = height * 3/4;
        double triangleHeight = height * 1/4;

        double yTriangle2 = yPosition + rectangleHeight;

        Rectangle2D.Double rectangle = new Rectangle2D.Double(xPosition, yPosition, width, rectangleHeight);
        RightTriangle triangle1 = new RightTriangle(xPosition, yPosition, rotation, width, triangleHeight, color, 1);
        RightTriangle triangle2 = new RightTriangle(xPosition, yTriangle2, 180 + rotation, width, triangleHeight, color, 1);

        graphics2d.setColor(color);
        graphics2d.fill(rectangle);
        triangle1.draw(graphics2d);
        triangle2.draw(graphics2d);
    }
}

