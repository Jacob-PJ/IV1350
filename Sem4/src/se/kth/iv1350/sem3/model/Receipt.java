package src.se.kth.iv1350.sem3.model;

import java.math.BigDecimal;
import java.util.Locale;

public class Receipt {

    private String receipt;
    Sale sale;

    // Constructor for Receipt class, which works as a template for the receipt
    public Receipt(Sale sale) {
        this.receipt = "";
        this.sale = sale;
    }

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
        receipt += "Chash : " + String.format(Locale.US, "%.2f", sale.getPayment()) + " SEK\n";
        receipt += "Change : " + String.format(Locale.US, "%.2f", sale.getChange()) + " SEK\n";
        receipt += "- - - - - - - - - - - - - - - - - - End receipt - - - - - - - - - - - - - - - - - - - - -\n";
    }

    // Returns the receipt
    public String getReceipt() {
        return receipt;
    }
}
