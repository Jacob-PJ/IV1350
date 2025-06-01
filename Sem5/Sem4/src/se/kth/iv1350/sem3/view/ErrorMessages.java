package src.se.kth.iv1350.sem3.view;

import java.util.Locale;
import java.math.BigDecimal;

import src.se.kth.iv1350.sem3.model.ItemInCart;
import src.se.kth.iv1350.sem3.model.Sale;

/**
 * Provides templates for messages that are used in various parts of the sale
 * process.
 * These messages help communicate feedback to the user.
 */
public class ErrorMessages {

    /**
     * Creates an error message for when an item is not found.
     *
     * @param itemID Item ID that was not found.
     * @return Formatted error message as a <code>String</code>.
     */
    public String createItemNotFoundMessage(int itemID) {
        return "ERROR: Item ID " + itemID + " not found";
    }

    /**
     * Creates an error message for when a database failure occurs.
     * 
     * @return Formatted error message as a <code>String</code>.
     */
    public String createDatabaseFailureMessage() {
        return "ERROR: Inventory database failure: ";
    }
}
