/**
 SceneFrame manage and display graphical scenes.
 Window frame with a canvas for rendering animations.

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
import java.awt.event.*;

public class SceneFrame extends  JFrame{

    private int height;
    private int width;
    private animate movement = new animate();
    private SceneCanvas canvas;

    /**
     * Constructs a new SceneFrame with specified dimensions.
     * It creates an instance of SceneCanvas.
     *
     * @param height The height of the frame.
     * @param width  The width of the frame.
     */
    public SceneFrame(int height, int width)
    {
        this.height = height;
        this.width = width;
        canvas = new SceneCanvas();
    }

    /**
     * Sets up the graphical user interface for the frame.
     * Used in the SceneStarter.
     */
    public void setUpGUI()
    {
        JFrame frame = new JFrame();
        Container contentPane = frame.getContentPane();
        contentPane.setBackground(new Color(176, 179, 184));
        canvas.setPreferredSize(new Dimension(width,height));
        contentPane.add(canvas);
        frame.pack();
        frame.setTitle("Midterm Project - Zerna - Mandanas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
        canvas.requestFocus();
        movement.startAnimation();
    }

    /**
     * Inner class responsible for managing animations.
     * It uses Timer to animate the scene.
     */
    private class animate
    {
        private int refreshRate;
        private ActionListener repainter;
        private Timer move;

        /**
         * Inner class animate that handles the timer that refresh the scene.
         * It uses 40fps or refreshes the scene 40 times a second.
         */
        private animate()
        {
            refreshRate = 24; //1000/24 = 40fps
            repainter = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    canvas.getRemote().getChannel().updatePosition();
                    canvas.repaint();
                }
            };
            move = new Timer(refreshRate, repainter);
        }
        /**
         * Starts the animation loop. It will trigger refreshing the scene.
         */
            private void startAnimation()
            {move.start();}
        }
}
