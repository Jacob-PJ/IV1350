package src.se.kth.iv1350.sem3.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sale {

    private LocalDateTime timeOfSale;
    private List<ItemInCart> items;
    private BigDecimal totalPrice;
    private BigDecimal totalVAT;
    private BigDecimal payment;
    private BigDecimal change;

    // Constructor which creates a new sale with the current time and initializes
    // the list of items
    public Sale() {
        this.timeOfSale = LocalDateTime.now();
        this.items = new ArrayList<>();
        this.totalPrice = BigDecimal.ZERO;
        this.totalVAT = BigDecimal.ZERO;
        this.payment = BigDecimal.ZERO;
        this.change = BigDecimal.ZERO;
    }

    // Sets the time of sale to the current time
    public LocalDateTime getTimeOfSale() {
        return this.timeOfSale;
    }

    // Returns the time of sale as a string
    public String getTimeOfSaleAsString() {
        return getTimeOfSale().toString();
    }

    // Returns the list of items in the sale
    public List<ItemInCart> getItems() {
        return Collections.unmodifiableList(this.items);
    }

    // Returns the total price of the sale
    public BigDecimal getTotalPriceOfSale() {
        return this.totalPrice;
    }

    // Returns the total VAT of the sale
    public BigDecimal getTotalVATofSale() {
        return this.totalVAT;
    }

    // Returns the payment made by the customer
    public BigDecimal getPayment() {
        return this.payment;
    }

    // Returns teh cahnge
    public BigDecimal getChange() {
        return this.change;
    }

    // Add to the total price
    private void addToTotalPrice(BigDecimal addedPrice) {
        this.totalPrice = this.totalPrice.add(addedPrice);
    }

    // Add to the total VAT
    private void addToTotalVAT(BigDecimal addedVAT) {
        this.totalVAT = this.totalVAT.add(addedVAT);
    }

    // finds the index of an item int the list of purchased items
    private int findIndexOfItem(ItemInCart item) {
        for (int i = 0; i < this.items.size(); i++) {
            if (this.items.get(i).getID() == item.getID()) {
                return i;
            }
        }
        return -1;
    }

    // Takes an ItemCartDTO (Item + Price) object and adds it to the list of items,
    // as well as updating the price and VAT. If the item is
    // already in the list, it updates the quantity of the item and adds the price
    public void addItem(ItemInCart itemAdded) {

        int index = findIndexOfItem(itemAdded);

        if (index == -1) {
            this.items.add(itemAdded);
        } else {
            this.items.get(index).increaseQuantity(itemAdded.getQuantity());
        }

        addToTotalPrice(itemAdded.getPrice());
        addToTotalVAT(itemAdded.getVAT());
    }

    // Takes a payment and updates the payment variable and calculates the change
    public void makePayment(BigDecimal payment) {
        this.payment = payment;
        this.change = payment.subtract(totalPrice);
    }

}
