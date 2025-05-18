package src.se.kth.iv1350.sem3.DTOs;

import java.math.BigDecimal;

public class ItemDTO {
    private final String name;
    private final int ID;
    private final BigDecimal price;
    private final BigDecimal VAT;
    private final String description;

    // Constructor which defines the item with its name, ID, description, price and
    // VAT
    public ItemDTO(String name, int ID, String description, BigDecimal price, BigDecimal VAT) {
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.price = price;
        this.VAT = VAT;
    }

    // Returns the name of the item
    public String getName() {
        return this.name;
    }

    // Returns the price of the item
    public BigDecimal getPrice() {
        return this.price;
    }

    // Returns the ID of the item
    public int getID() {
        return this.ID;
    }

    // Returns the VAT of the item
    public BigDecimal getVAT() {
        return this.VAT;
    }

    // Returns the description of the item
    public String getDescription() {
        return this.description;
    }
}
