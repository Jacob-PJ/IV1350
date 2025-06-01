package src.se.kth.iv1350.sem3.model;

import java.math.BigDecimal;
import java.util.Locale;

/**
 * Represents a receipt for a completed sale.
 * Contains item details, payment information, and totals.
 */
public class Receipt {

    private String receipt;
    Sale sale;

    /**
     * Creates a new instance of <code>Receipt</code> for a specific sale.
     *
     * @param sale The {@link Sale} this receipt is based on.
     */
    public Receipt(Sale sale) {
        this.receipt = "";
        this.sale = sale;
    }

    /**
     * Generates the textual representation of the receipt based on the sale data.
     * Includes timestamp, item list, totals, payment and change.
     */
    public void generateReciept() {
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
        receipt += "Cash : " + String.format(Locale.US, "%.2f", sale.getPayment()) + " SEK\n"; // fixed typo: Chash →
                                                                                               // Cash
        receipt += "Change : " + String.format(Locale.US, "%.2f", sale.getChange()) + " SEK\n";
        receipt += "- - - - - - - - - - - - - - - - - - End receipt - - - - - - - - - - - - - - - - - - - - -\n";
    }

    /**
     * Returns the full receipt text.
     *
     * @return The receipt content as a <code>String</code>.
     */
    public String getReceipt() {
        return receipt;
    }
}
