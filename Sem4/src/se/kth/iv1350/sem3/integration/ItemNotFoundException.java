package src.se.kth.iv1350.sem3.integration;

import src.se.kth.iv1350.sem3.DTOs.ItemDTO;

/**
 * Thrown when an item could not be found in the inventory system.
 */
public class ItemNotFoundException extends Exception {

    /**
     * Creates an instance of <code>ItemNotFoundException</code> with a default
     * error message.
     */
    public ItemNotFoundException() {
        super("The item that was searched for was not found.");
    }

    /**
     * Creates an instance of <code>ItemNotFoundException</code> with a custom error
     * message.
     *
     * @param itemID The ID of the item that could not be found.
     */
    public ItemNotFoundException(int itemID) {
        super("ERROR: Item ID " + itemID + " not found");
    }

    /**
     * Provides a detailed message about the database failure.
     *
     * @return A string containing a detailed message about the database failure.
     */
    public String getDevMessage() {
        String message = "";
        message += "ItemNotFoundException\n";
        message += java.time.LocalDate.now() + "\n";
        message += java.time.LocalTime.now() + "\n";
        message += this.getMessage() + "\n";

        return message;
    }
}
