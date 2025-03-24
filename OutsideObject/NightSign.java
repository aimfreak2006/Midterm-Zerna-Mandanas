/**
 The NightSign class draws the word "NIGHT".
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

public class NightSign {
    private DrawingObject[] letterN;
    private DrawingObject[] letterI;
    private DrawingObject[] letterG;
    private DrawingObject[] letterH;
    private DrawingObject[] letterT;

    /**
     * Constructor of the class.  It is empty to just instantiate.
     */
    public NightSign() {}

    /**
     * Draws the "NIGHT" sign on Graphics2D canvas.
     * To show the user what channel is drawn.
     *
     * @param graphics2D for drawing.
     */
    public void draw(Graphics2D graphics2D) {
        int startX = 720;
        int startY = 40;
        int letterSpacing = 100;

        letterN = new DrawingObject[]{
                new Square(startX, startY, 20, Color.BLUE),
                new Square(startX, startY + 20, 20, Color.BLUE),
                new Square(startX, startY + 40, 20, Color.BLUE),
                new Square(startX, startY + 60, 20, Color.BLUE),
                new Square(startX + 10, startY + 15, 20, Color.BLUE), //mid
                new Square(startX + 5, startY, 20, Color.BLUE), //mid
                new Square(startX + 30, startY + 30, 20, Color.BLUE), //mid
                new Square(startX + 33, startY + 42, 20, Color.BLUE), //mid
                new Square(startX + 40, startY, 20, Color.BLUE),
                new Square(startX + 40, startY + 20, 20, Color.BLUE),
                new Square(startX + 40, startY + 40, 20, Color.BLUE),
                new Square(startX + 40, startY + 60, 20, Color.BLUE)
        };

        startY += letterSpacing;
        letterI = new DrawingObject[]{
                new Square(startX + 20, startY, 20, Color.BLUE),
                new Square(startX + 20, startY + 20, 20, Color.BLUE),
                new Square(startX + 20, startY + 40, 20, Color.BLUE),
                new Square(startX + 20, startY + 60, 20, Color.BLUE)
        };

        startY += letterSpacing;
        letterG = new DrawingObject[]{
                new Square(startX, startY, 20, Color.BLUE),
                new Square(startX + 20, startY, 20, Color.BLUE),
                new Square(startX + 40, startY, 20, Color.BLUE),
                new Square(startX, startY + 20, 20, Color.BLUE),
                new Square(startX, startY + 40, 20, Color.BLUE),
                new Square(startX + 40, startY + 40, 20, Color.BLUE),
                new Square(startX, startY + 60, 20, Color.BLUE),
                new Square(startX + 20, startY + 60, 20, Color.BLUE),
                new Square(startX + 40, startY + 60, 20, Color.BLUE)
        };

        startY += letterSpacing;
        letterH = new DrawingObject[]{
                new Square(startX, startY, 20, Color.BLUE),
                new Square(startX, startY + 20, 20, Color.BLUE),
                new Square(startX, startY + 40, 20, Color.BLUE),
                new Square(startX, startY + 60, 20, Color.BLUE),
                new Square(startX + 20, startY + 40, 20, Color.BLUE),
                new Square(startX + 40, startY, 20, Color.BLUE),
                new Square(startX + 40, startY + 20, 20, Color.BLUE),
                new Square(startX + 40, startY + 40, 20, Color.BLUE),
                new Square(startX + 40, startY + 60, 20, Color.BLUE)
        };

        startY += letterSpacing;

        letterT = new DrawingObject[]{
                new Square(startX, startY, 20, Color.BLUE),
                new Square(startX + 20, startY, 20, Color.BLUE),
                new Square(startX + 40, startY, 20, Color.BLUE),
                new Square(startX + 20, startY + 20, 20, Color.BLUE),
                new Square(startX + 20, startY + 40, 20, Color.BLUE),
                new Square(startX + 20, startY + 60, 20, Color.BLUE)
        };

        for (DrawingObject n : letterN) n.draw(graphics2D);
        for (DrawingObject i : letterI) i.draw(graphics2D);
        for (DrawingObject g : letterG) g.draw(graphics2D);
        for (DrawingObject h : letterH) h.draw(graphics2D);
        for (DrawingObject t : letterT) t.draw(graphics2D);
    }
}
