package src.se.kth.iv1350.sem3.model;

import java.math.BigDecimal;
import src.se.kth.iv1350.sem3.DTOs.ItemDTO;

/**
 * Represents an item in the customer's cart.
 * Pairs the item with the quantity being purchased.
 */
public class ItemInCart {
    private ItemDTO item;
    private int quantity;

    /**
     * Creates an instance of <code>ItemInCart</code>.
     *
     * @param item     Item being purchased as a {@link ItemDTO}.
     * @param quantity Quantity of the item as an <code>int</code>.
     */
    public ItemInCart(ItemDTO item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    /**
     * Returns the name of the item.
     *
     * @return Item's name as a <code>String</code>.
     */
    public String getName() {
        return this.item.getName();
    }

    /**
     * Returns the quantity of the item.
     *
     * @return Quantity of the item as an <code>int</code>.
     */
    public int getQuantity() {
        return this.quantity;
    }

    /**
     * Returns the unit price of the item.
     *
     * @return Item's unit price as a {@link BigDecimal}.
     */
    public BigDecimal getUnitPrice() {
        return this.item.getPrice();
    }

    /**
     * Returns the VAT rate of the item.
     *
     * @return VAT rate as a {@link BigDecimal}.
     */
    public BigDecimal getUnitVAT() {
        return this.item.getVAT();
    }

    /**
     * Returns the ID of the item.
     *
     * @return Item ID as an <code>int</code>.
     */
    public int getID() {
        return this.item.getID();
    }

    /**
     * Returns the item object.
     *
     * @return <code>ItemDTO</code> object.
     */
    public ItemDTO getItem() {
        return this.item;
    }

    /**
     * Returns the description of the item.
     *
     * @return Item description as a <code>String</code>.
     */
    public String getDescription() {
        return this.item.getDescription();
    }

    /**
     * Returns the total VAT for the total amount of items in the cart.
     *
     * @return Total VAT for the quantity of items as a {@link BigDecimal}.
     */
    public BigDecimal getVAT() {
        return this.item.getPrice()
                .multiply(this.item.getVAT())
                .multiply(BigDecimal.valueOf(this.quantity));
    }

    /**
     * Returns the VAT percentage as a string.
     *
     * @return VAT as a percentage string.
     */
    public String getVATAsPercentageString() {
        return this.item.getVAT().multiply(BigDecimal.valueOf(100)) + " %";
    }

    /**
     * Returns the total price for the amount of this item in the cart.
     *
     * @return Total price for the quantity of items as a {@link BigDecimal}.
     */
    public BigDecimal getPrice() {
        return this.item.getPrice().multiply(BigDecimal.valueOf(quantity));
    }

    /**
     * Increases the quantity of the item in the cart by a given amount.
     *
     * @param additional Number of items to add as an <code>int</code>.
     * @throws IllegalArgumentException If <code>additional</code> is negative.
     */
    public void increaseQuantity(int additional) {
        if (additional < 0) {
            throw new IllegalArgumentException("Cannot increase quantity by a negative amount.");
        }
        this.quantity += additional;
    }
}
