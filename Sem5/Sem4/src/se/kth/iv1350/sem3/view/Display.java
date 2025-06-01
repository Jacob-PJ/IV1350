package src.se.kth.iv1350.sem3.view;

/**
 * Singleton class of the <code>Display</code>.
 * Used to show messages to the user, printed to the console in this case.
 */
public class Display {

    private static final Display instance = new Display();

    /**
     * Private constructor to prevent external instantiation.
     */
    private Display() {
    }

    /**
     * Returns the single <code>Display</code> instance.
     *
     * @return Single <code>Display</code> instance.
     */
    public static Display getInstance() {
        return instance;
    }

    /**
     * Displays a message on the screen.
     * In this version, the message is printed to the console.
     *
     * @param message Message to display.
     */
    public void showMessage(String message) {
        System.out.println(message);
    }
}
