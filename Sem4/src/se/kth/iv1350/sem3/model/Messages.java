package src.se.kth.iv1350.sem3.model;

import java.util.Locale;
import java.math.BigDecimal;

/**
 * Provides templates for messages that are used in various parts of the sale
 * process.
 * These messages help communicate feedback to the user.
 */
public class Messages {

    /**
     * Creates a message detailing the added item.
     *
     * @param itemAdded Item that was added to the cart.
     * @return Formatted string with item details as a <code>String</code>.
     */
    public String createAddedItemMessage(ItemInCart itemAdded) {
        String addedItemMessage = "Added " + itemAdded.getQuantity() + " items with ID " + itemAdded.getID() + ":\n";
        addedItemMessage += "Item ID: " + itemAdded.getID() + "\n";
        addedItemMessage += "Item name: " + itemAdded.getName() + "\n";
        addedItemMessage += "Item cost: " + String.format(Locale.US, "%.2f", itemAdded.getUnitPrice()) + " SEK\n";
        addedItemMessage += "VAT: " + itemAdded.getVATAsPercentageString() + "\n";
        addedItemMessage += "Item description: " + itemAdded.getDescription() + "\n\n";

        return addedItemMessage;
    }

    /**
     * Creates a message showing the current total cost and VAT of the sale.
     *
     * @param sale Current sale.
     * @return Formatted string showing the running total and VAT as a
     *         <code>String</code>.
     */
    public String createRunningCostMessage(Sale sale) {
        String runningCostMessage = "Total cost (incl. VAT): " +
                String.format(Locale.US, "%.2f", sale.getTotalPriceOfSale()) + " SEK\n";
        runningCostMessage += "Total VAT: " +
                String.format(Locale.US, "%.2f", sale.getTotalVATofSale()) + " SEK\n\n";

        return runningCostMessage;
    }

    /**
     * Creates a message showing the current total discount.
     *
     * @param amount the amount of discount.
     * @return Formatted string showing the current discount as a
     *         <code>String</code>.
     */
    public String createShowCurrentDiscountMessage(BigDecimal amount) {
        String currentDiscount = "The discount amount received is: " + amount + " SEK\n";
        return currentDiscount;
    }

    /**
     * Creates a message showing the current total discount.
     *
     * @param amount the amount of discount.
     * @return Formatted string showing the running total discount as a
     *         <code>String</code>.
     */
    public String createShowTotalDiscountMessage(BigDecimal amount) {
        String totalDiscount = "Your total discount is " + amount + " SEK\n";
        return totalDiscount;
    }

    /**
     * Creates a message to indicate that a new sale has started.
     *
     * @return Formatted string signaling the beginning of a sale as a
     *         <code>String</code>.
     */
    public String createStartSaleMessage() {
        return "------------------Starting Sale-------------------\n";
    }
}
