/**
 MeteorNight class draws the Night Scene.
 Represents a complex scene with a moon, sea, stars, clouds, mountains, and a screen.
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

import BasicShape.DrawingObject;
import ComplexShape.*;
import MainPackage.Sound;
import OutsideObject.*;
import TableLamp.Lamp;

import java.awt.*;

public class MeteorNight extends InterfaceChannel{

    private Sea sea;
    private Moon moon;
    private Stars[] stars;
    private Screen screen;
    private int red, redStarMin = 120, redStarMax = 255;
    private int green, greenStarMin = 120, greenStarMax = 255;
    private int blue, blueStarMax = 100;
    private NightSign indicator;
    private Mountain mountain1, mountain2;
    private Cloud3D[] clouds = new Cloud3D[4];
    private DrawingObject[] frontTrees = new DrawingObject[3];
    private DrawingObject[] backTrees = new DrawingObject[4];
    private GradientPaint colorScreen;
    private Lamp lamp;
    private boolean buttonPressed = false;
    private double moonStarsXPosition = 580, moonStarsYPosition = 130;
    private double skyStarsXPosition = 160, skyStarsYPosition = 60;
    private Sound chaoticNightMusic;

    /**
     * Constructor for MeteorNight.
     */
    public MeteorNight(){
        super(0, 0, 0, null);
        chaoticNightMusic = new Sound("Sounds/ChaoticNight.wav");
        Color colorMountain = new Color(23,97,36);
        Color colorChristmasTreeLeaves = new Color(17,191,46);
        Color colorNormalTreeLeaves = new Color(222,98,27);
        Color colorCloud = new Color(198,204,198);
        Color colorMountainHole = new Color(5,64,3);
        indicator = new NightSign();
        moon = new Moon(new Color(212, 212, 212));
        sea = new Sea(125, 375, 140, 0.9, 0.4, new Color(13, 20, 120));
        stars = new Stars[]{
                new Stars(moonStarsXPosition, moonStarsYPosition + 35, 1.5, Color.YELLOW), //moon star
                new Stars(moonStarsXPosition - 20, moonStarsYPosition, 1.5, Color.YELLOW), //moon star
                new Stars(moonStarsXPosition + 20, moonStarsYPosition, 1.5, Color.YELLOW), //moon star
                new Stars(skyStarsXPosition, skyStarsYPosition, 1.5, Color.YELLOW),
                new Stars(skyStarsXPosition + 60, skyStarsYPosition + 40, 1.5, Color.YELLOW),
                new Stars(skyStarsXPosition + 120, skyStarsYPosition, 1.5, Color.YELLOW),
                new Stars(skyStarsXPosition + 180, skyStarsYPosition + 40, 1.5, Color.YELLOW),
                new Stars(skyStarsXPosition + 240, skyStarsYPosition, 1.5, Color.YELLOW),
                new Stars(skyStarsXPosition + 300, skyStarsYPosition + 40, 1.5, Color.YELLOW),
                new Stars(skyStarsXPosition + 360, skyStarsYPosition, 1.5, Color.YELLOW)};
        mountain1 = new Mountain(215,475,60, colorMountain, colorMountainHole);
        mountain2 = new Mountain(400,475,100, colorMountain, colorMountainHole);
        frontTrees = new DrawingObject[]{
                new ChristmasTree(220,400,50,3,colorChristmasTreeLeaves),
                new NormalTree(380,340,25,colorNormalTreeLeaves),
                new NormalTree(180,430,20,colorNormalTreeLeaves)
        };
        backTrees = new DrawingObject[]{
                new ChristmasTree(470,240,50,3,colorChristmasTreeLeaves),
                new ChristmasTree(500,340,70,4,colorChristmasTreeLeaves),
                new NormalTree(320,245,15,colorNormalTreeLeaves),
                new NormalTree(160,340,20,colorNormalTreeLeaves)
        };
        colorScreen = new GradientPaint(1,1, Color.darkGray, 2,2, Color.darkGray);
        for (int i = 0; i < 4; i++)
        {
            double speedSizeRandomizer = Math.random();
            double randomSize = 35 + speedSizeRandomizer * 45;
            double speedCloud = 1 + speedSizeRandomizer * 2;
            double yPosition = 100 + Math.random() * 100;

            clouds[i] = new Cloud3D(40,yPosition,randomSize,speedCloud,colorCloud);

        }
        lamp = new Lamp(60,375-100/7,40,80,Color.GRAY,true);
    }

    /**
     * Handles button actions by changing the colors of stars and moon,
     * decrease sea's tide & gap and adjusting the sea color.
     * Now it makes sounds of clicking!
     */
    @Override
    public void buttonAction()
    {
        randomStarColor();
        randomMoonColor();
        sea.changeSeaColor(new Color(212, 212, 212));
        System.out.println("working on 2");
        sea.modifyFrequency(90);
        sea.modifyWaveTide(5);
    }

    /**
     * Handles button off actions by resetting the colors of stars and moon,
     * revert original increase sea's tide & gap and adjusting the sea color.
     */
    @Override
    public void buttonOffAction()
    {
        for (Stars star: stars)
        {
            star.changeColor(255, 234, 0);
        }
        moon.changeColor(212, 212, 212);
        sea.changeSeaColor(new Color(1, 3, 105));
        sea.modifyFrequency(140);
        sea.modifyWaveTide(0.9);
    }

    /**
     * Draws the stars in the scene using the provided Graphics2D object.
     * Includes drawing the night sign
     *
     * @param graphics2d the Graphics2D object used for drawing
     */
    private void drawStars(Graphics2D graphics2d)
    {
        indicator.draw(graphics2d);
        for (Stars star: stars)
        {
            star.draw(graphics2d);
        }
    }

    /**
     * Randomly changes the color of the stars in the scene.
     */
    private void randomStarColor()
    {
        red = (int) (redStarMin + Math.random() * ((redStarMax - redStarMin) + 1));
        blue = (int) (Math.random() * (blueStarMax + 1));
        green = (int) (greenStarMin + Math.random() * ((greenStarMax - greenStarMin) + 1));
        for (Stars star: stars)
        {
            star.changeColor(red, green, blue);
        }
    }

    /**
     * Randomly changes the color.
     * In the moon in the scene.
     */
    private void randomMoonColor()
    {
        red = (int) (230 + (Math.random() * ((255-230)+1)));
        blue = (int) (Math.random() * (71));
        green = (int) (Math.random() * (71));
        moon.changeColor(red, green, blue);
    }

    /**
     * Draws the clouds that were generated randomly in the constructor.
     * Used by others.
     * 
     * @param graphics2d the Graphics2D object used for drawing
     */
    public void generateRandomCloud(Graphics2D graphics2d)
    {
        for (int i = 0; i < 4; i++)
        {
            clouds[i].draw(graphics2d);
        }
    }

    /**
     * Draws the trees that were initialized in the constructor.
     * 
     * @param graphics2d the Graphics2D object used for drawing
     */
    public void drawTrees(Graphics2D graphics2d, DrawingObject[] trees)
    {
        for (int i = 0; i < trees.length; i++)
        {
            trees[i].draw(graphics2d);
        }
    }

    /**
     * Draws the entire night scene.
     * It uses the provided Graphics2D object.
     *
     * @param graphics2d the Graphics2D object used for drawing
     */
    @Override
    public void draw(Graphics2D graphics2d)
    {
        chaoticNightMusic.loop();
        screen = new Screen(125,25,550,450, colorScreen);
        screen.drawScreen(graphics2d);
        if (buttonPressed){
            randomStarColor();
            drawStars(graphics2d);
        }
        else {
            drawStars(graphics2d);
        }

        moon.draw(graphics2d);
        sea.draw(graphics2d);
        drawTrees(graphics2d, backTrees);
        mountain1.draw(graphics2d);
        mountain2.draw(graphics2d);
        drawTrees(graphics2d, frontTrees);
        generateRandomCloud(graphics2d);
        SideBorder.drawBorders(graphics2d);
        indicator.draw(graphics2d);
        lamp.draw(graphics2d);
    }

    /**
     * Updates the position of the sea in the scene.
     * For it to print every frame.
     */
    @Override
    public void updatePosition() {
        sea.updatePosition();

        for (int i = 0; i < 4; i++)
        {
            clouds[i].moveCloud();

            if (clouds[i].getX() > 780)
            {
                double speedSizeRandomizer = Math.random();
                double randomSize = 35 + speedSizeRandomizer * 45;
                double speedCloud = 1 + speedSizeRandomizer * 2;
                double yPosition = 100 + Math.random() * 100;
                clouds[i] = new Cloud3D(40,yPosition,randomSize,speedCloud,new Color(198,204,198));
            }
        }
    }

    /**
     * Return the fileName.
     * @return Sound the Filename of the music
     */
    public Sound getMusic()
    {
        return chaoticNightMusic;
    }
}
