/**
 Stars class draws star with twinkle effects based on position,
 size, and color. Stars is used in MeteorNight.
 It extends the DrawingObject class and provides methods for
 drawing and updating the star's position.

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
import BasicShape.Hexagon;

import java.awt.*;
import java.awt.geom.Path2D;

public class Stars extends DrawingObject {

    private double xCenterPosition, yCenterPosition, size;
    private Hexagon shadow;
    private double topX, topY, leftX, leftY, bottomX, bottomY, rightX, rightY;
    private float defaultOpacityLevel = 1.0f, shineOpacity = 0.10f, starShine = 0.80f;

    /**
     * Constructor for Stars. It accepts different parameter for stars.
     *
     * @param xPosition the x-coordinate for center
     * @param yPosition the y-coordinate for center
     * @param size      the size of the star
     * @param color     the color of the star
     */
    public Stars(double xPosition, double yPosition, double size, Color color)
    {
        super(xPosition, yPosition, size, color);
        this.xCenterPosition = xPosition; //center ng star
        this.yCenterPosition =  yPosition;
        this.leftX = xPosition - 4.5 * size;
        this.leftY = yPosition;
        this.bottomX = xPosition;
        this.bottomY = yPosition + 16 * size;
        this.rightX = xPosition +  4.5 * size;
        this.rightY = yPosition;
        this.topX = xCenterPosition;
        this.topY = yCenterPosition - 16 * size;
        shadow = new Hexagon(xCenterPosition, yCenterPosition, size, Color.WHITE);
    }

    /**
     * Randomly changes the twinkle effect of the star by adjusting its opacity.
     * Making the sky so bright.
     */
    private void changeTwinkle()
    {
        this.shineOpacity += ((float) Math.random() / 8);
    }

    /**
     * Draws the star using the provided Graphics2D object.
     * Incl. drawing a shadow (hexagon) of star.
     *
     * @param graphics2D the Graphics2D object used for drawing
     */
    @Override
    public void draw(Graphics2D graphics2D) {
        changeTwinkle();
        graphics2D.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, shineOpacity));
        graphics2D.setColor(Color.WHITE);
        shadow.draw(graphics2D); //add hexagon as star twinkle
        graphics2D.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, defaultOpacityLevel)); //reset to not affect other shapes
        putStar(graphics2D); //draw the star over its shadow;
        starShine = 0.80f;
        shineOpacity = 0.10f;
    }

    /**
     * Changes the color of the star.
     * It accepts RGB values.
     *
     * @param red   red component
     * @param green green component
     * @param blue  blue component
     */
    public void changeColor(int red, int green, int blue)
    {
        this.color = new Color(red, green, blue);
    }

    /**
     * Draws a curved star shape using Path2D. Applies a shine effect.
     *
     * @param graphics2D the Graphics2D object used for drawing
     */
    private void putStar(Graphics2D graphics2D)
    {
        Path2D.Double star = new Path2D.Double();
        star.moveTo(topX, topY);
        star.curveTo(xCenterPosition, yCenterPosition, leftX + size *  2.8, leftY, leftX - 20 , leftY); //top to left
        star.curveTo(leftX + size *  2.8, leftY, xCenterPosition, yCenterPosition, bottomX, bottomY); //left to bottom
        star.curveTo(xCenterPosition, yCenterPosition, rightX - size *  2.8, rightY, rightX + 20, rightY); //bottom to right
        star.curveTo(rightX - size *  2.8, rightY, xCenterPosition, yCenterPosition, topX, topY);//right to top
        star.closePath();
        starShine -= Math.random() / 3;
        graphics2D.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, starShine));
        graphics2D.setColor(color);
        graphics2D.fill(star);
        graphics2D.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, defaultOpacityLevel));
    }

    /**
     * Updates the position of the star.
     * It accepts x and y coordinate.
     *
     * @param xPosition the new x-coordinate star's center
     * @param yPosition the new y-coordinate star's center
     */
    public void updatePosition(double xPosition, double yPosition){
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }
}
