package src.se.kth.iv1350.sem3.model;

import java.util.Locale;

/**
 * Provides templates for messages that are used in various parts of the sale
 * process.
 * These messages help communicate feedback to the user.
 */
public class Messages {

    /**
     * Creates a message detailing the added item.
     *
     * @param itemAdded The {@link ItemInCart} that was added to the cart.
     * @return Formatted message describing the added item as a <code>String</code>.
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
     * @param sale The current {@link Sale} instance.
     * @return Formatted message of total cost and VAT as a <code>String</code>.
     */
    public String createRunningCostMessage(Sale sale) {
        String runningCostMessage = "Total cost (incl. VAT): " +
                String.format(Locale.US, "%.2f", sale.getTotalPriceOfSale()) + " SEK\n";
        runningCostMessage += "Total VAT: " +
                String.format(Locale.US, "%.2f", sale.getTotalVATofSale()) + " SEK\n\n";

        return runningCostMessage;
    }

    /**
     * Creates a message to indicate that a new sale has started.
     *
     * @return A <code>String</code> indicating the start of a sale.
     */
    public String createStartSaleMessage() {
        return "------------------Starting Sale-------------------\n";
    }

    /**
     * Creates a message to indicate that an item was not found.
     *
     * @param itemID The ID of the item that was not found.
     * @return A <code>String</code> describing the error.
     */
    public String createItemNotFoundMessage(int itemID) {
        return "Item ID " + itemID + " not found.\n";
    }
}
