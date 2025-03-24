/**
 SceneStarter is used to initiate the application.
 Provides the main entry point for running the scene.

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

public class SceneStarter
{
    /**
     * The main entry point for the application.
     * Creates a new SceneFrame and sets up its GUI.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args)
    {
        SceneFrame sceneFrame = new SceneFrame(600, 800);
        sceneFrame.setUpGUI();
    }
}