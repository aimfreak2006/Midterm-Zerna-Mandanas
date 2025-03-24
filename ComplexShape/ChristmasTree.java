/**
 ChristmasTree class is used in the MeteorNightChannel Class.
 It uses EquilateralTriangle classes for its leaves.
 It also extends the DrawingObject, using its draw method and instance field.

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
import java.awt.geom.*;

public class ChristmasTree extends DrawingObject
{

    private double height, numberLeaves;

    /**
     * Constructor for ChristmasTree class.
     *It asks for different parameters,
     *
     * @param xPosition      the x-coordinate of the ChristmasTree.
     * @param yPosition      the y-coordinate of the ChristmasTree.
     *                       (x,y) is the bottom center of the log/wood.
     * @param height         the height of the ChristmasTree.
     * @param numberLeaves   The number of triangles/leaves the tree has.
     * @param color          the color of the leaves.
     */
    public ChristmasTree(double xPosition, double yPosition, double height, int numberLeaves, Color color)
    {
        super(xPosition, yPosition, 0, color);
        this.height = height;
        this.numberLeaves = numberLeaves;
    }

    /**
     * Draws a ChristmasTree with a certain amount of Triangles.
     * Using the graphics2d object to do so.
     *
     * @param graphics2d the Graphics2D object used for drawing
     */
    @Override
    public void draw(Graphics2D graphics2d)
    {
        double total = (2*numberLeaves + 1);
        double heightTriangle = height * (3 / total);
        double yTriangle = yPosition - (height * 1/5);

        for (int i = 0; i < numberLeaves; i++)
        {
            EquilateralTriangle triangle1 = new EquilateralTriangle(xPosition, yTriangle, 0, heightTriangle, color, -1);
            triangle1.draw(graphics2d);
            yTriangle -= (heightTriangle * 2/3);
        }

        double xWood = xPosition - (heightTriangle * 1/8);
        double yWood = yPosition - (height * 1/5);
        double widthWood = heightTriangle * 1/4;
        double heightWood = height * 1/5;
        Rectangle2D.Double wood = new Rectangle2D.Double(xWood, yWood, widthWood, heightWood);

        graphics2d.setColor(new Color(64,29,8));
        graphics2d.fill(wood);
    }
}
