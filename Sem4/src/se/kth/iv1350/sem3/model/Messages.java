package src.se.kth.iv1350.sem3.model;

import java.util.Locale;

public class Messages {

    // A template for the message when an item is added to the cart
    public String createAddedItemMessage(ItemInCart itemAdded) {
        String addedItemMessage = "Added " + itemAdded.getQuantity() + " items with ID " + itemAdded.getID() + ":\n";
        addedItemMessage += "Item ID: " + itemAdded.getID() + "\n";
        addedItemMessage += "Item name: " + itemAdded.getName() + "\n";
        addedItemMessage += "Item cost: " + String.format(Locale.US, "%.2f", itemAdded.getUnitPrice()) + " SEK\n";
        addedItemMessage += "VAT: " + itemAdded.getVATAsPercentageString() + "\n";
        addedItemMessage += "Item description: " + itemAdded.getDescription() + "\n\n";

        return addedItemMessage;
    }

    // A template for displaying the running cost of the sale
    public String createRunningCostMessage(Sale sale) {
        String runningCostMessage = "Total cost (incl. VAT): " +
                String.format(Locale.US, "%.2f", sale.getTotalPriceOfSale()) + " SEK\n";
        runningCostMessage += "Total VAT: " +
                String.format(Locale.US, "%.2f", sale.getTotalVATofSale()) + " SEK\n\n";

        return runningCostMessage;
    }

    public String createStartSaleMessage() {
        return "------------------Starting Sale-------------------\n";
    }

    public String createItemNotFoundMessage(int itemID) {
        return "Item ID " + itemID + " not found.\n";
    }

    public String createDatabaseFailureMessage(String dbs) {
        return dbs + " database could not be accesed";
    }
}
