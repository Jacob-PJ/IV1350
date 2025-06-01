package src.se.kth.iv1350.sem3.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class representing a sale.
 * Holds information about items, pricing, VAT, payment, and change.
 */
public class Sale {

    private LocalDateTime timeOfSale;
    private List<ItemInCart> items;
    private BigDecimal totalPrice;
    private BigDecimal totalVAT;
    private BigDecimal payment;
    private BigDecimal change;

    /**
     * Creates a sale instance and initializes all fields.
     */
    public Sale() {
        this.timeOfSale = LocalDateTime.now();
        this.items = new ArrayList<>();
        this.totalPrice = BigDecimal.ZERO;
        this.totalVAT = BigDecimal.ZERO;
        this.payment = BigDecimal.ZERO;
        this.change = BigDecimal.ZERO;
    }

    /**
     * @return Timestamp when the sale was initiated as a
     *         <code>LocalDateTime</code>.
     */
    public LocalDateTime getTimeOfSale() {
        return this.timeOfSale;
    }

    /**
     * @return String representation of the sale timestamp as a <code>String</code>.
     */
    public String getTimeOfSaleAsString() {
        return getTimeOfSale().toString();
    }

    /**
     * @return Unmodifiable list of items in the sale as a <code>List</code>.
     */
    public List<ItemInCart> getItems() {
        return Collections.unmodifiableList(this.items);
    }

    /**
     * @return Total price of the sale as a <code>BigDecimal</code>.
     */
    public BigDecimal getTotalPriceOfSale() {
        return this.totalPrice;
    }

    /**
     * @return Total VAT calculated for the sale as a <code>BigDecimal</code>.
     */
    public BigDecimal getTotalVATofSale() {
        return this.totalVAT;
    }

    /**
     * @return Amount of money paid by the customer as a <code>BigDecimal</code>.
     */
    public BigDecimal getPayment() {
        return this.payment;
    }

    /**
     * @return Amount of change to pay out as a <code>BigDecimal</code>.
     */
    public BigDecimal getChange() {
        return this.change;
    }

    /**
     * Adds a value to the current total price.
     *
     * @param addedPrice <code>BigDecimal</code> amount to add.
     */
    private void addToTotalPrice(BigDecimal addedPrice) {
        this.totalPrice = this.totalPrice.add(addedPrice);
    }

    /**
     * Adds a value to the current total VAT.
     *
     * @param addedVAT <code>BigDecimal</code> VAT to be added.
     */
    private void addToTotalVAT(BigDecimal addedVAT) {
        this.totalVAT = this.totalVAT.add(addedVAT);
    }

    /**
     * Finds the index of a matching item in the list.
     *
     * @param item <code>ItemInCart</code> to search for.
     * @return Index if found, otherwise -1 as an <code>int</code>.
     */
    private int findIndexOfItem(ItemInCart item) {
        for (int i = 0; i < this.items.size(); i++) {
            if (this.items.get(i).getID() == item.getID()) {
                return i;
            }
        }
        return -1;
    }

    public ItemInCart getItemByIndex(int index) {
        return this.items.get(index);
    }

    /**
     * Adds an item to the sale or updates the quantity if the item already exists.
     * Also updates total price and VAT.
     *
     * @param itemAdded <code>ItemInCart</code> object to be added.
     */
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

    /**
     * Registers the customer's payment and calculates change.
     *
     * @param payment Amount paid as a <code>BigDecimal</code>.
     */
    public void makePayment(BigDecimal payment) {
        this.payment = payment;
        this.change = payment.subtract(totalPrice);
    }
}
