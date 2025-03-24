/**
 Moon class is used to draw a static moon.
 Represents a moon with a specified color.
 It extends the DrawingObject class and provides methods
 for drawing and changing the moon's color.

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
import java.awt.geom.Path2D;

public class Moon extends DrawingObject
{
    /**
     * Constructor for Moon.
     * @param //color the color of the moon
     */
    public Moon(Color color)
    {
        super(0, 0, 0, color);
        this.color = color;
    }

    /**
     * Draws the moon using the provided Graphics2D object.
     *
     * @param graphics2d the Graphics2D object used for drawing
     */
    @Override
    public void draw(Graphics2D graphics2d) {
        Path2D.Double moon = new Path2D.Double();
        moon.moveTo(567.2,88.2);
        moon.curveTo(442,118.5, 537, 278.7, 619.4, 186);
        moon.curveTo(558.2, 226.8, 491, 118.3, 567.2, 88.2);
        graphics2d.setColor(color);
        graphics2d.fill(moon);
    }

    /**
     * Changes the color of the moon.
     *
     * @param red   red component of the color (0-255)
     * @param green green component of the color (0-255)
     * @param blue  blue component of the color (0-255)
     */
    public void changeColor(double red, double green, double blue)
    {
        this.color = new Color((int) red, (int) green, (int) blue);
    }

}