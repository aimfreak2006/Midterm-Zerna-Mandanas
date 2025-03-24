/**
 Sea class is used to make water wave pattern for sea.
 Represents a sea with a specified position, wave properties, and color.
 It extends the DrawingObject class and provides methods for drawing and updating the sea's wave.

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

public class Sea extends DrawingObject {

    private double periodGap, gapAmount;
    private double amplitudeHeight = 30;
    private double waveTide, directionSpeed;
    private Color color;
    private double xBoundary, yBoundary;
    private boolean heightChecker;

    /**
     * Constructor for Sea.
     *
     * @param xPosition the x-coordinate sea starting point
     * @param yPosition the y-coordinate sea starting point
     * @param gapAmount the gap amount influencing the wave's frequency
     * @param waveTide  the tide factor affecting the wave's amplitude
     * @param directionSpeed the speed moves horizontally
     * @param color     the color of the sea
     */
    public Sea(double xPosition, double yPosition, double gapAmount, double waveTide, double directionSpeed, Color color)
    {
        super(xPosition, yPosition, 0, color);
        this.gapAmount = gapAmount;
        this.directionSpeed = directionSpeed;
        this.waveTide = waveTide;
        this.periodGap = 2 * Math.PI / gapAmount;
        this.color = color;
        this.xBoundary = 675;
        this.yBoundary = 475;
    }

    /**
     * Draws the sea using the provided Graphics2D object.
     *
     * @param graphics2D the Graphics2D object used for drawing
     */
    @Override
    public void draw(Graphics2D graphics2D)
    {
        Path2D.Double wave = new Path2D.Double();
        wave.moveTo(xPosition, yPosition);

        for (double x = xPosition; x <= xBoundary; x += 1)
        {
            double y = yPosition + amplitudeHeight * Math.sin(x * periodGap + directionSpeed) - waveTide;
            wave.lineTo(x, y);
        }
        wave.lineTo(xBoundary, yBoundary);
        wave.lineTo(xPosition, yBoundary);
        wave.closePath();
        graphics2D.setColor(color);
        graphics2D.fill(wave);
    }

    /**
     * Changes the color of the sea.
     *
     * @param color the new color of the sea
     */
    public void changeSeaColor(Color color)
    {
        this.color = color;
    }


    /**
     * Modifies the frequency of the wave by adjusting the gap amount.
     *
     * @param amount the new gap amount
     */
    public void modifyFrequency(double amount)
    {
        gapAmount = amount;
        this.periodGap = 2 * Math.PI / gapAmount;
    }

    /**
     * Modifies the speed of the wave by adjusting the wave amount.
     *
     * @param amount the new wavetide amount
     */
    public void modifyWaveTide(double amount)
    {
        waveTide = amount;
    }

    /**
     * Updates the position and amplitude of the wave.
     */
    public void updatePosition() {

        if (amplitudeHeight >= 30){
            heightChecker = false;
        }
        else if (amplitudeHeight <= -30)
        {
            heightChecker = true;
        }

        amplitudeHeight += heightChecker ? waveTide : -waveTide;
        directionSpeed -= 0.1;
    }
}