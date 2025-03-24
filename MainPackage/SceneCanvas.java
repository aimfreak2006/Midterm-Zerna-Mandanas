/**
 SceneCanvas class is used to display a graphical scene with interactive elements.
 Provides methods for handling keyboard, mouse input,
 draws background items, a lamp, a podium, and a button on top.

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

package MainPackage;

import java.awt.*;
import javax.swing.*;

import BasicShape.DrawingObject;
import Channels.*;
import Inputs.*;
import MainTable.ButtonPress;
import OutsideObject.*;

/**
 *
 */
public class SceneCanvas extends JComponent
{
    private Remote remote;
    private DrawingObject[] backgroundItems;
    private Table podium;
    private ButtonPress button;

    /**
     * Constructor for SceneCanvas.
     * Initializes the scene with default components and input listeners.
     */
    public SceneCanvas()
    {
        addKeyListener(new KeyboardInput( this));
        addMouseListener(new MouseInput(this));
        remote = new Remote();
        backgroundItems = new DrawingObject[]{
                new Table(340,500,150,150,Color.RED),
                new TableLamp(10,375,100,100,Color.RED),
        };
        button = new ButtonPress(397, 502, 18, Color.RED);
    }

    /**
     * Returns the Remote object associated with this SceneCanvas.
     * Used by other classes.
     *
     * @return the Remote object
     */
    public Remote getRemote(){
        return remote;
    }

    /**
     * Handles mouse click events by simulating a button press and repainting the scene.
     * Trigger the actions when mouse is clicked.
     */
    public void mouseClick()
    {

        button.pressButtonMotion(13);
        repaint();
    }

    /**
     * Handles mouse release events by simulating a button release and repainting the scene.
     * Trigger action when mouse is released.
     */
    public void mouseRelease()
    {
        button.pressButtonMotion(-13);
        repaint();
    }

    /**
     * Switches to the previous channel on the remote control and repaints the scene.
     * To switch what channel to update.
     */
    public void previousChannel()
    {
        System.out.println("Channel 1");
        remote.getChannel().getMusic().close();
        remote.getNextChannel().getMusic().reload();
        remote.changeChannel();
        remote.getNextChannel().getMusic().loop();
        repaint();
    }

    /**
     * Switches to the next channel on the remote control and repaints the scene.
     * To switch what channel to update.
     */
    public  void nextChannel()
    {
        System.out.println("Channel 2");
        remote.getChannel().getMusic().close();
        remote.getNextChannel().getMusic().reload();
        remote.changeChannel();
        remote.getNextChannel().getMusic().loop();
        repaint();
    }

    /**
     * Draws the graphical components of the scene.
     * The main Graphics of the project.
     *
     * @param graphics the Graphics object used for drawing
     */
    @Override
    protected void paintComponent(Graphics graphics)
    {
        Graphics2D graphics2d = (Graphics2D) graphics;
        RenderingHints smoothing = new RenderingHints
        (
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON
        );
        graphics2d.setRenderingHints(smoothing);


        graphics2d.setColor(Color.orange);
        remote.draw(graphics2d);
        for (DrawingObject items : backgroundItems)
        {
            items.draw(graphics2d);
        }
        button.draw(graphics2d);
        graphics2d.drawString("Press The Button", 350, 495);
    }
}
