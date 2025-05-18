package src.se.kth.iv1350.sem3.model;

import java.math.BigDecimal;

import src.se.kth.iv1350.sem3.DTOs.ItemDTO;

public class ItemInCart {
    private ItemDTO item;
    private int quantity;

    // Constructor which pairs and item with the qunatity of that item being
    // purchased
    public ItemInCart(ItemDTO item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    // Returns name of the item
    public String getName() {
        return this.item.getName();
    }

    // Retirns the quantity of the item being purchased
    public int getQuantity() {
        return this.quantity;
    }

    // Returns the unit price of the item being purchased, including VAT
    public BigDecimal getUnitPrice() {
        return this.item.getPrice();
    }

    // Returns the unit VAT of the item being purchased
    public BigDecimal getUnitVAT() {
        return this.item.getVAT();
    }

    // Returns the ID of the item being purchased
    public int getID() {
        return this.item.getID();
    }

    // Returns the item object of the item being purchased
    public ItemDTO getItem() {
        return this.item;
    }

    // Returns the description of the item being purchased
    public String getDescription() {
        return this.item.getDescription();
    }

    // Returns total VAT of the items being purchased
    public BigDecimal getVAT() {
        return this.item.getPrice()
                .multiply(this.item.getVAT())
                .multiply(BigDecimal.valueOf(this.quantity));
    }

    // Rreturns the VAT of the item being purchased as a string
    public String getVATAsPercentageString() {
        return this.item.getVAT().multiply(BigDecimal.valueOf(100)) + " %";
    }

    // Returns total price of the items being purchased
    public BigDecimal getPrice() {
        return this.item.getPrice().multiply(BigDecimal.valueOf(quantity));
    }

    // Inxreases the quantity of the item being purchased by a given amount
    public void increaseQuantity(int additional) {
        this.quantity += additional;
    }
}
