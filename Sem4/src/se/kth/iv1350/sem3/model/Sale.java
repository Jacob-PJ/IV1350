package src.se.kth.iv1350.sem3.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class representing a sale.
 * Holds information about items, pricing, VAT, payment, and discounts.
 */
public class Sale {

    private LocalDateTime timeOfSale;
    private List<ItemInCart> items;
    private BigDecimal totalPrice;
    private BigDecimal totalVAT;
    private BigDecimal payment;
    private BigDecimal change;
    private DiscountStrategy discountStrategy;
    private BigDecimal totalDiscount;
    private String customerID = "George";

    private final List<RevenueObserver> revenueObservers;

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
        this.totalDiscount = BigDecimal.ZERO;
        this.revenueObservers = new ArrayList<>();
    }

    /**
     * @return Timestamp when the sale was initiated as a
     *         <code>LocalDateTime</code>.
     */
    public LocalDateTime getTimeOfSale() {
        return this.timeOfSale;
    }

    /**
     * @return String representation of the sale timestamp.
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
     * @return Total price of the sale, including any applied discounts, as a
     *         <code>BigDecimal</code>.
     */
    public BigDecimal getTotalPriceOfSale() {
        return this.totalPrice;
    }

    /**
     * @return Total price of the sale, including any applied discounts, as a
     *         <code>BigDecimal</code>.
     */
    public BigDecimal getTotalDiscount() {
        return this.totalDiscount;
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
     * @param addedPrice Price to be added as a <code>BigDecimal</code>.
     */
    private void updateTotalPrice(BigDecimal addedPrice) {
        this.totalPrice = this.totalPrice.add(addedPrice);
    }

    /**
     * Sets the strategy used to apply discounts.
     *
     * @param strategy Discount strategy to use as a {@link DiscountStrategy}.
     */
    public void setDiscountStrategy(DiscountStrategy strategy) {
        this.discountStrategy = strategy;
    }

    /**
     * Applies the selected discount strategy and reduces the total price.
     * 
     * @return Current discount amount as a <code>BigDecimal</code>.
     */
    public BigDecimal addDiscount() {
        BigDecimal discountAmount = discountStrategy.getDiscount(totalPrice, items, customerID);
        updateTotalPrice(discountAmount.negate());
        this.totalDiscount = this.totalDiscount.add(discountAmount);
        return discountAmount;
    }

    /**
     * Shows current total discount.
     * 
     * @return Total discount as a <code>BigDecimal</code>.
     */
    public BigDecimal showCurrentTotalDiscount() {
        return this.totalDiscount;
    }

    /**
     * Adds a value to the current total VAT.
     *
     * @param addedVAT VAT to be added as a <code>BigDecimal</code>.
     */
    private void addToTotalVAT(BigDecimal addedVAT) {
        this.totalVAT = this.totalVAT.add(addedVAT);
    }

    /**
     * Finds the index of a matching item in the list.
     *
     * @param item Item to search for as a {@link ItemInCart}.
     * @return Index if found, otherwise <code>-1</code>.
     */
    private int findIndexOfItem(ItemInCart item) {
        for (int i = 0; i < this.items.size(); i++) {
            if (this.items.get(i).getID() == item.getID()) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Adds an item to the sale or updates the quantity if the item already exists.
     *
     * @param itemAdded Item to be added as a {@link ItemInCart}.
     */
    public void addItem(ItemInCart itemAdded) {
        int index = findIndexOfItem(itemAdded);

        if (index == -1) {
            this.items.add(itemAdded);
        } else {
            this.items.get(index).increaseQuantity(itemAdded.getQuantity());
        }

        updateTotalPrice(itemAdded.getPrice());
        addToTotalVAT(itemAdded.getVAT());
    }

    /**
     * Registers the customer's payment and calculates change.
     * Notifies all revenue observers after a completed payment.
     *
     * @param payment Amount paid by the customer as a <code>BigDecimal</code>.
     */
    public void makePayment(BigDecimal payment) {
        this.payment = payment;
        this.change = payment.subtract(totalPrice);
        notifyRevenueObservers();
    }

    /**
     * Adds an observer that will be notified of revenue updates.
     *
     * @param observer Observer to add as a {@link RevenueObserver}.
     */
    public void addRevenueObserver(RevenueObserver observer) {
        revenueObservers.add(observer);
    }

    /**
     * Notifies all registered observers of the revenue to add after the sale.
     */
    private void notifyRevenueObservers() {
        for (RevenueObserver observer : revenueObservers) {
            observer.updateRevenue(totalPrice);
        }
    }
}
