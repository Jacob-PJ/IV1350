package src.se.kth.iv1350.sem3.DTOs;

import java.math.BigDecimal;

/**
 * Represents an item in the system
 */
public class ItemDTO {
    private final String name;
    private final int ID;
    private final BigDecimal price;
    private final BigDecimal VAT;
    private final String description;

    /**
     * Creates a new instance of ItemDTO
     *
     * @param name        name of the item
     * @param ID          identifier of the item
     * @param description description of the item
     * @param price       price of the item
     * @param VAT         VAT rate for the item
     */
    public ItemDTO(String name, int ID, String description, BigDecimal price, BigDecimal VAT) {
        this.name = name;
        this.ID = ID;
        this.description = description;
        this.price = price;
        this.VAT = VAT;
    }

    /**
     * Gets the name of the item
     *
     * @return item's name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the price of the item
     *
     * @return item's price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Gets the identifier of the item
     *
     * @return item ID
     */
    public int getID() {
        return ID;
    }

    /**
     * Gets the VAT rate
     *
     * @return VAT
     */
    public BigDecimal getVAT() {
        return VAT;
    }

    /**
     * Gets the description of the item
     *
     * @return description of the item
     */
    public String getDescription() {
        return description;
    }
}
