package src.se.kth.iv1350.sem3.model;

/**
 * Holds and updates the last message to be displayed in the system.
 * Useful for communicating feedback from operations like sales or item lookups.
 */
public class LastMessage {

    private String message;

    /**
     * Creates a new instance of <code>LastMessage</code>, initializing it as empty.
     */
    public LastMessage() {
        this.message = "";
    }

    /**
     * Appends a new message to the current message.
     *
     * @param message Message to append as a <code>String</code>.
     */
    public void updateMessage(String message) {
        this.message += message;
    }

    /**
     * Clears the current message.
     */
    public void clearMessage() {
        this.message = "";
    }

    /**
     * Retrieves the current message.
     *
     * @return Message that is currently held as a <code>String</code>.
     */
    public String getMessage() {
        return message;
    }
}
