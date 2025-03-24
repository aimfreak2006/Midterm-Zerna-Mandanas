/**
 MouseInput class is used to handle mouse events for button actions on a SceneCanvas.
MouseListener interface to detect mouse presses and releases,
 for button state and triggers actions when the mouse is clicked

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

package Inputs;

import MainPackage.SceneCanvas;
import MainPackage.Sound;

import java.awt.event.*;


public class MouseInput implements MouseListener {

    private SceneCanvas actionButton;

    /**
     * Constructor for MouseInput. Initialized the action button.
     *
     * @param actionButton the SceneCanvas object that will be controlled by mouse input
     */
    public MouseInput(SceneCanvas actionButton)
    {
        this.actionButton = actionButton;}

    /**
     * Handles mouse presses. Turns the button on.
     *
     * @param e the MouseEvent object containing information about the mouse press
     */
    @Override
    public void mousePressed(MouseEvent e) {
        actionButton.getRemote().buttonOn();
        actionButton.mouseClick();
    }

    /**
     * Handles mouse releases. Turns the button off.
     *
     * @param e the MouseEvent object containing information about the mouse release
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        actionButton.mouseRelease();
        actionButton.getRemote().buttonOff();
    }

    /**
     * Not implemented. We didn't use in the program.
     *
     * @param e the MouseEvent
     */
    @Override
    public void mouseEntered(MouseEvent e) {}

    /**
     * Not implemented. We didn't use in the program.
     *
     * @param e the MouseEvent
     */
    @Override
    public void mouseExited(MouseEvent e) {}

    /**
     * Not implemented. We didn't use in the program.
     *
     * @param e the MouseEvent about the mouse click
     */
    @Override
    public void mouseClicked(MouseEvent e) {}
}
