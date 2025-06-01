package src.se.kth.iv1350.sem3.model;

import java.math.BigDecimal;
import java.util.Locale;

/**
 * Class representing a receipt for a sale.
 * The receipt contains the time of sale, list of items, and payment
 * information.
 */
public class Receipt {

    private String receipt;
    private final Sale sale;

    /**
     * Creates a receipt for a sale.
     *
     * @param sale Sale to create a receipt for. Must be a valid <code>Sale</code>
     *             object.
     */
    public Receipt(Sale sale) {
        this.receipt = "";
        this.sale = sale;
    }

    /**
     * Generates the receipt content based on the sale.
     * Appends formatted details such as time, items, totals, and change.
     */
    public void generateReceipt() {
        receipt += "- - - - - - - - - - - - - - - - - - Begin receipt - - - - - - - - - - - - - - - - - - -\n";
        receipt += "Time of Sale : " + sale.getTimeOfSaleAsString() + "\n";

        for (ItemInCart item : sale.getItems()) {
            BigDecimal unitPrice = item.getUnitPrice();
            BigDecimal totalItemPrice = unitPrice.multiply(BigDecimal.valueOf(item.getQuantity()));

            receipt += item.getName() + " " + item.getQuantity()
                    + " x " + String.format(Locale.US, "%.2f", unitPrice)
                    + " " + String.format(Locale.US, "%.2f", totalItemPrice)
                    + " SEK\n";
        }

        receipt += "Total price : " + String.format(Locale.US, "%.2f", sale.getTotalPriceOfSale()) + " SEK\n";
        receipt += "VAT : " + String.format(Locale.US, "%.2f", sale.getTotalVATofSale()) + " SEK\n";
        receipt += "Cash : " + String.format(Locale.US, "%.2f", sale.getPayment()) + " SEK\n";
        receipt += "Change : " + String.format(Locale.US, "%.2f", sale.getChange()) + " SEK\n";
        receipt += "Total Discount : " + String.format(Locale.US, "%.2f", sale.getTotalDiscount()) + " SEK\n";
        receipt += "- - - - - - - - - - - - - - - - - - End receipt - - - - - - - - - - - - - - - - - - - - -\n";
    }

    /**
     * Returns the generated receipt.
     *
     * @return The formatted receipt as a <code>String</code>.
     */
    public String getReceipt() {
        return receipt;
    }
}
