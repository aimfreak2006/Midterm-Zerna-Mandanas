/**
 DaySign class draws sign displaying the word "DAY".
 The letters are made using an array of Basic Shape Square.

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

import BasicShape.DrawingObject;
import BasicShape.Square;
import java.awt.*;

public class DaySign {
    private DrawingObject[] letterD;
    private DrawingObject[] letterA;
    private DrawingObject[] letterY;

    /**
     * Constructor of the class.
     * It is empty to just instantiate.
     */
    public DaySign() { }

    /**
     * Draws the "DAY" sign on Graphics2D canvas.
     * To show the user what channel is drawn.
     *
     * @param graphics2D for drawing.
     */
    public void draw(Graphics2D graphics2D) {
        int startX = 710; // X-position
        int startY = 100; // Y-position

        letterD = new DrawingObject[]{
                new Square(startX, startY, 20, Color.YELLOW),//left
                new Square(startX, startY + 20, 20, Color.YELLOW), //left
                new Square(startX, startY + 40, 20, Color.YELLOW), //left
                new Square(startX, startY + 60, 20, Color.YELLOW), //left
                new Square(startX, startY + 80, 20, Color.YELLOW), //left
                new Square(startX + 40, startY + 20, 20, Color.YELLOW),//right
                new Square(startX + 40, startY + 40, 20, Color.YELLOW),//right
                new Square(startX + 40, startY + 60, 20, Color.YELLOW),//right
                new Square(startX + 20, startY + 80, 20, Color.YELLOW),//mid
                new Square(startX + 20, startY, 20, Color.YELLOW) //mid

        };

        startY += 120; //Y Gap

        letterA = new DrawingObject[]{
                new Square(startX, startY, 20, Color.YELLOW), //left
                new Square(startX + 20, startY, 20, Color.YELLOW),//mid
                new Square(startX + 40, startY, 20, Color.YELLOW),//right
                new Square(startX, startY + 20, 20, Color.YELLOW),//left
                new Square(startX + 40, startY + 20, 20, Color.YELLOW),//right
                new Square(startX, startY + 40, 20, Color.YELLOW),//left
                new Square(startX + 20, startY + 40, 20, Color.YELLOW),//mid
                new Square(startX + 40, startY + 40, 20, Color.YELLOW),//right
                new Square(startX, startY + 60, 20, Color.YELLOW),//left
                new Square(startX + 40, startY + 60, 20, Color.YELLOW),//right
                new Square(startX, startY + 80, 20, Color.YELLOW),//left
                new Square(startX + 40, startY + 80, 20, Color.YELLOW)//right
        };

        startY += 120;

        letterY = new DrawingObject[]{
                new Square(startX, startY, 20, Color.YELLOW), //left
                new Square(startX, startY + 20, 20, Color.YELLOW),//left
                new Square(startX + 40, startY, 20, Color.YELLOW),//right
                new Square(startX + 40, startY + 20, 20, Color.YELLOW), //right
                new Square(startX + 20, startY + 40, 20, Color.YELLOW), //mid
                new Square(startX + 20, startY + 60, 20, Color.YELLOW), //mid
                new Square(startX + 20, startY + 80, 20, Color.YELLOW) //mid
        };

        for (DrawingObject d : letterD)
            d.draw(graphics2D);

        for (DrawingObject a : letterA)
            a.draw(graphics2D);

        for (DrawingObject y : letterY)
            y.draw(graphics2D);
    }
}
