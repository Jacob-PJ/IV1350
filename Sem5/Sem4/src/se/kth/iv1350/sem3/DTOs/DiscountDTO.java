package src.se.kth.iv1350.sem3.DTOs;

/**
 * Used to pair an item ID with a discount amount.
 * This class is a simple DTO that holds a mapping
 * between an item and a discount applied to it.
 */
public class DiscountDTO {
    private final int itemID;
    private double discountAmount;

    /**
     * Creates a new instance of <code>DiscountDTO</code>.
     *
     * @param itemID         The ID of the item.
     * @param discountAmount The discount amount associated with the item.
     */
    public DiscountDTO(int itemID, double discountAmount) {
        this.itemID = itemID;
        this.discountAmount = discountAmount;
    }

    /**
     * Gets the ID of the item.
     *
     * @return The item ID as an <code>int</code>.
     */
    public int getItemID() {
        return itemID;
    }

    /**
     * Gets the discount amount for the item.
     *
     * @return The discount amount as a <code>double</code>.
     */
    public double getDiscountAmount() {
        return discountAmount;
    }

    /**
     * Sets a new discount amount.
     * (Commented out as a DTO should be immutable.)
     *
     * @param discountAmount The new discount amount to apply.
     */
    /*
     * public void setDiscountAmount(double discountAmount) {
     * this.discountAmount = discountAmount;
     * }
     */
}
