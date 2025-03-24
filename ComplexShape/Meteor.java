/**
 Meteor class draws meteor with rays using position, size, and color.
 It extends the DrawingObject class and provides methods
 for drawing the meteor and updating its position.

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



public class Meteor extends DrawingObject {
    private Circle meteorBody, meteorInterior;
    private Line[] rays;
    private double newX, newY, initialX = 640, initialY  = 80, initialSize = 20;
    private int angle, numRays;
    private Color meteorColor, meteorInside, rayColor;

    /**
     * Constructor for Meteor.
     *
     * @param xPosition   the x-coordinate meteor's position
     * @param yPosition   the y-coordinate  meteor's position
     * @param size        the size
     * @param meteorColor the color meteor's outer body
     * @param meteorInside the color meteor's interior
     * @param rayColor    the color of the rays
     */
    public Meteor(double xPosition, double yPosition, double size, Color meteorColor, Color meteorInside, Color rayColor) {
        super(xPosition, yPosition, size, meteorColor);
        this.numRays = 50;
        rays = new Line[numRays];
        angle = 0;
        this.meteorColor = meteorColor;
        this.meteorInside = meteorInside;
        this.rayColor = rayColor;
        makeRays();
    }

    /**
     * Creates rays for the meteor based on its current position and angle.
     */
    private void makeRays()
    {
        for (int i = 0; i < numRays; i++) {
            newX = Math.cos(Math.toRadians(angle)) * size / 2;
            newY = Math.sin(Math.toRadians(angle)) * size / 2;
            rays[i] = (new Line(xPosition + newX + 1, yPosition + newY, xPosition + newX + 11, yPosition + newY - 10, 0.1, Color.BLACK));
            angle += 360 / numRays;
            angle = angle % 360;
        }
    }

    /**
     * Draws the meteor using the provided Graphics2D object.
     *
     * @param graphics2d the Graphics2D object used for drawing
     */
    @Override
    public void draw(Graphics2D graphics2d) {
        meteorBody = new Circle(xPosition, yPosition, size, meteorColor);
        meteorInterior = new Circle(xPosition, yPosition, size - 20, meteorInside);
        for (Line ray : rays) {
            graphics2d.setColor(rayColor);
            ray.draw(graphics2d);
        }
        meteorBody.draw(graphics2d);
        meteorInterior.draw(graphics2d);
    }

    /**
     * Updates all properties of the meteor including its position and size.
     */
    private void updateAll()
    {
        xPosition = xPosition - 2.2;
        yPosition = yPosition + 2.2;
        size = size + 1.4;
    }

    /**
     * Updates the position of the meteor and resets it if it moves past a certain point.
     */
    public void updatePosition() {
        updateAll();
        if (meteorBody.getY() >= 180){
            xPosition = initialX;
            yPosition = initialY;
            size = initialSize;
        }

        for (int i = 0; i < numRays; i++)
        {
            newX = Math.cos(Math.toRadians(angle)) * size / 2;
            newY = Math.sin(Math.toRadians(angle)) * size / 2;
            rays[i] = (new Line(xPosition + newX + 1, yPosition - newY - 1, xPosition + newX + size/2, yPosition - newY - size/2, 1.1 + size / 200, rayColor));
            angle += 360 / numRays;
            angle = angle % 360;
        }
    }

    /**
     * Changes the color of the meteor's outer body.
     *
     * @param red   red component of the color (0-255)
     * @param green green component of the color (0-255)
     * @param blue  blue component of the color (0-255)
     */
    public void changeMeteorOutsideColor(int red, int green, int blue)
    {
        this.meteorColor = new Color(red, green, blue);
    }

    /**
     * Changes the color of the rays emitted from the meteor.
     *
     * @param red   red component of the ray color (0-255)
     * @param green green component of the ray color (0-255)
     * @param blue  blue component of the ray color (0-255)
     */
    public void changeRayColor(int red, int green, int blue)
    {
        this.rayColor = new Color(red, green, blue);
    }
}
