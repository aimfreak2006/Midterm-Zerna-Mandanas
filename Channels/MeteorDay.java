/**
 MeteorDay class draws the Day Scene.
 Represents a complex scene with a meteor, sun, sea, volcanoes, and a screen.
 It extends the InterfaceChannel class and provides methods for drawing and updating the scene.

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

package Channels;

import ComplexShape.*;
import MainPackage.Sound;
import OutsideObject.DaySign;
import OutsideObject.Screen;
import TableLamp.Lamp;

import java.awt.*;

/**
 *
 */
public class MeteorDay extends InterfaceChannel{

    private Sun sun;
    private Sea sea;
    private Meteor meteor;
    private Screen screen;
    private int red, green, blue;
    private int redRay, greenRay, blueRay;
    private DaySign indicator;
    private Volcano volcano1, volcano2;
    private GradientPaint skyColor;
    private int redSky, greenSky, blueSky;
    private double reds;
    private Lamp lamp;
    private Sound chaoticDayMusic;

    /**
     * Constructor for MeteorDay.
     */
    public MeteorDay()
    {
        super(0, 0, 0, null);
        chaoticDayMusic = new Sound("Sounds/ChaoticDay.wav");
        indicator = new DaySign();
        sun = new Sun(280, 180, 50, 9, Color.yellow);
        sea= new Sea(125, 405, 90, 4, 0.9, new Color(28, 43, 255));
        meteor = new Meteor(640,80, 20, new Color(255, 166, 0), new Color(255, 0,0), Color.BLACK);

        Color colorVolcano = new Color(79,62,87);
        Color colorLava = new Color(215,63,36);
        volcano1 = new Volcano(215,475,60,colorVolcano,colorLava);
        volcano2 = new Volcano(400,475,100, colorVolcano,colorLava);
        lamp = new Lamp(60,375-100/7,40,80,Color.GRAY,false);
        redSky = 176;
        greenSky = 128;
        blueSky = 99;
    }

    /**
     * Calculates the Red value of the sky depending on the yPosition of the sun using a linear function.
     */
    public int calculateRedSky()
    {
        return (int) Math.round((48.0/145.0)*sun.getY() + (2116.0/29.0));
    }

    /**
     * Calculates the Blue value of the sky depending on the yPosition of the sun using a linear function.
     */
    public int calculateGreenSky()
    {
        return (int) Math.round((-129.0/290.0)*sun.getY() + (7738.0/29));
    }

    /**
     * Calculates the Blue value of the sky depending on the yPosition of the sun using a linear function.
     */
    public int calculateBlueSky()
    {
        return (int) Math.round((-227.0/290.0)*sun.getY() + (9969.0/29));
    }


    /**
     * Handles button actions by changing the meteor's color, increase sea's tide & gap, and ray color randomly.
     * Now it makes sounds of clicking!
     */
    @Override
    public void buttonAction()
    {
        randomMeteorColor();
        randomMeteorRayColor();
        sea.modifyFrequency(60);
        sea.modifyWaveTide(9);
    }

    /**
     * Handles button off actions. Currently just to revert original sea gap & tide.
     */
    @Override
    public void buttonOffAction()
    {
        sea.modifyFrequency(90);
        sea.modifyWaveTide(4);
    }

    /**
     * Draws the entire meteor scene using the provided Graphics2D object.
     * It asks for different parameters.
     *
     * @param graphics2d the Graphics2D object used for drawing
     */
    @Override
    public void draw(Graphics2D graphics2d)
    {
        chaoticDayMusic.loop();
        Color topColor = new Color(116, 209, 242);
        Color bottomColor = new Color(redSky,greenSky,blueSky);
        skyColor = new GradientPaint(240, 40, topColor, 240,300, bottomColor);
        screen = new Screen(125,25,550,450,skyColor);
        screen.drawScreen(graphics2d);
        sea.draw(graphics2d);
        indicator.draw(graphics2d);
        sun.draw(graphics2d);
        sun.updatePosition();
        volcano1.draw(graphics2d);
        volcano2.draw(graphics2d);
        meteor.draw(graphics2d);
        lamp.draw(graphics2d);
    }

    /**
     * Updates the positions of the sun, sea, meteor, and sky in the scene.
     * Used by others.
     */
    @Override
    public void updatePosition()
    {
        sun.updatePosition();
        sea.updatePosition();
        meteor.updatePosition();
        redSky = calculateRedSky();
        greenSky = calculateGreenSky();
        blueSky = calculateBlueSky();
    }

    /**
     * Randomly changes the color of the meteor.
     */
    private void randomMeteorColor()
    {
        red = (int) (Math.random() * 255);
        green = (int) (Math.random() * 255);
        blue = (int) (Math.random() * 255);
        meteor.changeMeteorOutsideColor(red, green, blue);
    }

    /**
     * Randomly changes the color of the meteor's rays.
     */
    private void randomMeteorRayColor()
    {
        redRay = (int) (200 + Math.random() * (255 - 200) +1);
        greenRay = (int) (Math.random() * 255);
        blueRay = (int) (Math.random() * 255);
        meteor.changeRayColor(redRay, greenRay, blueRay);
    }

    /**
     * Return the fileName.
     * @return Sound the Filename of the music
     */
    public Sound getMusic()
    {
        return chaoticDayMusic;
    }
}
