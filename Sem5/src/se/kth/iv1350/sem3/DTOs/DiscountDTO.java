package src.se.kth.iv1350.sem3.DTOs;

/**
 * Used to pair an item ID with a discount amount
 */
public class DiscountDTO {
    private final int itemID;
    private double discountAmount;

    /**
     * Creates a new instance of DiscountDTO
     *
     * @param itemID         ID of the item
     * @param discountAmount discount amount
     */
    public DiscountDTO(int itemID, double discountAmount) {
        this.itemID = itemID;
        this.discountAmount = discountAmount;
    }

    /**
     * Gets the item ID
     *
     * @return item ID
     */
    public int getItemID() {
        return itemID;
    }

    /**
     * Gets the discount amount
     *
     * @return discount amount
     */
    public double getDiscountAmount() {
        return discountAmount;
    }

    /**
     * Sets a new discount amount
     * (Commented out as DTO should be immutable)
     *
     * @param discountAmount new discount amount to apply
     */
    /*
     * public void setDiscountAmount(double discountAmount) {
     * this.discountAmount = discountAmount;
     * }
     */
}
