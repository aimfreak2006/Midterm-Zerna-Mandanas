/**
 Hexagon class draw a hexagon shape composed of a
 central square and additional geometric paths.
 It extends the DrawingObject class and provides methods for drawing the hexagon.

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
import java.awt.geom.Path2D;

public class Hexagon extends DrawingObject
{
    private Square hexagonBody;
    private double xCenterPosition,yCenterPosition;
    private Path2D.Double hexagonExtra;

    /**
     * Constructor for Hexagon.
     * Ask for different parameters.
     *
     * @param xPosition the x-coordinate of the hexagon's center
     * @param yPosition the y-coordinate of the hexagon's center
     * @param size      the size of the hexagon (interpretation depends on the shape's geometry)
     * @param color     the color of the hexagon
     */
    public Hexagon(double xPosition, double yPosition, double size, Color color)
    {
        super(xPosition, yPosition, size, color);
        this.xCenterPosition = xPosition; //center of the start
        this.yCenterPosition =  yPosition;
        this.size = size;
        hexagonBody = new Square(xPosition, yPosition, size, color);
        hexagonExtra = new Path2D.Double();
    }

    /**
     * Draws the hexagon using the provided Graphics2D object.
     * The hexagon is composed of a central square and additional geometric paths.
     *
     * @param graphics2D the Graphics2D object used for drawing
     */
    @Override
    public void draw(Graphics2D graphics2D)
    {
        hexagonExtra.moveTo(xCenterPosition, yCenterPosition - 12 * size); //right above the center
        hexagonExtra.lineTo(xCenterPosition + 6 * size, yCenterPosition - 12 * size); //to the  (1st corner)
        hexagonExtra.lineTo(xCenterPosition + 13 * size, yCenterPosition);//1st corner to 2nd
        hexagonExtra.lineTo(xCenterPosition + 6 * size, yCenterPosition + 12 * size); //2nd  to 3rd
        hexagonExtra.lineTo(xCenterPosition - 6 * size, yCenterPosition + 12 * size); //3rd to 4th
        hexagonExtra.lineTo(xCenterPosition - 13 * size , yCenterPosition); //4th to 5th
        hexagonExtra.lineTo(xCenterPosition - 6 * size, yCenterPosition - 12 * size); //5th to 6th
        hexagonExtra.closePath();
        hexagonBody.draw(graphics2D);
        graphics2D.setColor(color);
        graphics2D.fill(hexagonExtra);
    }
}