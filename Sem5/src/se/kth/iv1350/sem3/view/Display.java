package src.se.kth.iv1350.sem3.view;

/**
 * Singleton class of the display
 */
public class Display {

    private static final Display instance = new Display();

    /**
     * Private constructor
     */
    private Display() {
    }

    /**
     *
     * @return The single Display instance.
     */
    public static Display getInstance() {
        return instance;
    }

    /**
     * Displays a message on the screen (Printed to the console in our case).
     *
     * @param message The message to display.
     */
    public void showMessage(String message) {
        System.out.println(message);
    }
}
