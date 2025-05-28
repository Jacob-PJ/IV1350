package src.se.kth.iv1350.sem3.DTOs;

/**
 * Pairs an item with its stock quantity in the inventory
 */
public class InventorySlotDTO {

    private final ItemDTO item;
    private final int stock;

    /**
     * Creates a new inventory slot with an item and its stock quantity
     *
     * @param item  item stored in this inventory slot
     * @param stock quantity of the item in stock
     */
    public InventorySlotDTO(ItemDTO item, int stock) {
        this.item = item;
        this.stock = stock;
    }

    /**
     * Gets the ID of an item
     *
     * @return item ID
     */
    public int getItemID() {
        return item.getID();
    }

    /**
     * Gets the item stored in this inventory slot
     *
     * @return item
     */
    public ItemDTO getItem() {
        return item;
    }

    /**
     * Gets the quantity of the item in stock
     *
     * @return stock quantity
     */
    public int getQuantity() {
        return stock;
    }
}
