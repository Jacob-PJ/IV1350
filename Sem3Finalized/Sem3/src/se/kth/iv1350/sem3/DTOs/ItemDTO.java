package se.kth.iv1350.sem3.DTOs;

public class ItemDTO {
    private int itemIdentifier;
    private String description;
    private double price;
    private int vatRate;
    private int quantity;

    public ItemDTO(int itemIdentifier, String description, double price, int vatRate, int quantity) {
        this.itemIdentifier = itemIdentifier;
        this.description = description;
        this.price = price;
        this.vatRate = vatRate;
        this.quantity = quantity;

    }

    public int getItemIdentifier() {
        return itemIdentifier;
    }

    public String getItemDescription() {
        return this.description;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public double getPrice() {
        return this.price;
    }

    public int getVatRate() {
        return this.vatRate;
    }

    public void decreaseQuantity(int amount) {
        this.quantity -= amount;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
