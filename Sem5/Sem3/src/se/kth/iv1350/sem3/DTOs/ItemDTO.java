package src.se.kth.iv1350.sem3.DTOs;

import java.math.BigDecimal;

/**
 * Represents an item in the system.
 * Contains basic information about the item such as name, ID, description,
 * price, and VAT.
 */
public class ItemDTO {
    private final String name;
    private final int ID;
    private final BigDecimal price;
    private final BigDecimal VAT;
    private final String description;

    /**
     * Creates a new instance of <code>ItemDTO</code>.
     *
     * @param name        The name of the item.
     * @param ID          The identifier of the item.
     * @param description A short description of the item.
     * @param price       The price of the item.
     * @param VAT         The VAT rate for the item.
     */
    public ItemDTO(String name, int ID, String description, BigDecimal price, BigDecimal VAT) {
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.price = price;
        this.VAT = VAT;
    }

    /**
     * Gets the name of the item.
     *
     * @return The item's name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets the price of the item.
     *
     * @return The item's price.
     */
    public BigDecimal getPrice() {
        return this.price;
    }

    /**
     * Gets the identifier of the item.
     *
     * @return The item ID.
     */
    public int getID() {
        return this.ID;
    }

    /**
     * Gets the VAT rate for the item.
     *
     * @return The item's VAT.
     */
    public BigDecimal getVAT() {
        return this.VAT;
    }

    /**
     * Gets the description of the item.
     *
     * @return The item's description.
     */
    public String getDescription() {
        return this.description;
    }
}
