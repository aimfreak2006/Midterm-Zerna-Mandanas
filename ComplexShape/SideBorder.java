/**
 The SideBorder class draws a left and right outside border (outside the screen).
 This class is needed in the MeteorNight channel so that the clouds would disappear once they reach the outside
 of the screen.

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

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class SideBorder
{  
    /**
     * Draws the left and right outside borders. Additionally, it creates a small black Rectangle2D object
     * to imitate the shadow of the screen.
     *
     * @param graphics2d the Graphics2D object used for drawing
     */
    public static void drawBorders(Graphics2D graphics2d)
    {
        Rectangle2D.Double leftBorder = new Rectangle2D.Double(0,25,125,450);
        Rectangle2D.Double rightBorder = new Rectangle2D.Double(675,25,125,450);
        Rectangle2D.Double smallRight = new Rectangle2D.Double(675,35,10,450);

        graphics2d.setColor(new Color(176, 179, 184));
        graphics2d.fill(leftBorder);
        graphics2d.fill(rightBorder);

        graphics2d.setColor(Color.BLACK);
        graphics2d.fill(smallRight);
    }
}
