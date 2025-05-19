package src.se.kth.iv1350.sem3.DTOs;

public class DiscountDTO {
    private final int itemID;
    private double discountAmount;

    public DiscountDTO(int itemID, double discountAmount) {
        this.itemID = itemID;
        this.discountAmount = discountAmount;
    }

    public int getItemID() {
        return itemID;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }
}
