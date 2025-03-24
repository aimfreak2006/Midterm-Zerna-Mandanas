/**
 The NormalTree class draws another type of tree using the Leaves class as its leaves.
 It also extends the abstract class DrawingObject, using its abstract method and instance fields.

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
import java.awt.geom.Rectangle2D;

public class NormalTree extends DrawingObject{
    
    /**
     * Constructor for NormalTree. It also calls the constructor of the Drawing object to initialize its
     * parameters.
     *
     * @param xPosition   the x-coordinate of the NormalTree
     * @param yPosition   the y-coordinate  of the NormalTree
     *                    (x,y) is at the bottom center of the Leaves
     * @param size        the size of the individual leaves
     * @param color       the color of the leaves.
     */
    public NormalTree(double xPosition, double yPosition, double size, Color color)
    {
        super(xPosition, yPosition, size, color);
    }

    /**
     * Draws the NormalTree using the provided Graphics2D object. Uses the Leaves and a Rectangle2D object to
     * draw the NormalTree.
     *
     * @param graphics2d the Graphics2D object used for drawing
     */
    @Override
    public void draw(Graphics2D graphics2d)
    {
        Leaves bottomMid = new Leaves(xPosition, yPosition, size, color);
        Leaves bottomLeft = new Leaves(xPosition - size/2, yPosition, size, color);
        Leaves bottomRight = new Leaves(xPosition + size/2, yPosition, size, color);
        Leaves topLeft = new Leaves(xPosition - size/8, yPosition - size/2, size, color);
        Leaves topRight = new Leaves(xPosition + size/8, yPosition - size/2, size, color);

        double xWood = xPosition - (size * 1/8);
        double yWood = yPosition + (size * 1/2);
        double widthWood = size * 1/4;
        double heightWood = size * 1.3;
        Rectangle2D.Double wood = new Rectangle2D.Double(xWood, yWood, widthWood, heightWood);

        graphics2d.setColor(new Color(64,29,8));
        graphics2d.fill(wood);

        bottomMid.draw(graphics2d);
        bottomLeft.draw(graphics2d);
        bottomRight.draw(graphics2d);
        topLeft.draw(graphics2d);
        topRight.draw(graphics2d);
    }
}
