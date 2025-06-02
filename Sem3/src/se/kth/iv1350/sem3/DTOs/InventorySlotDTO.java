package src.se.kth.iv1350.sem3.DTOs;

/**
 * Pairs an item with its stock quantity in the inventory.
 * This is used to represent a slot in the inventory containing
 * both the item and the amount available.
 */
public class InventorySlotDTO {

    private final ItemDTO item;
    private final int stock;

    /**
     * Creates a new inventory slot with an item and its stock quantity.
     *
     * @param item  The {@link ItemDTO} stored in this inventory slot.
     * @param stock The quantity of the item in stock.
     */
    public InventorySlotDTO(ItemDTO item, int stock) {
        this.item = item;
        this.stock = stock;
    }

    /**
     * Gets the ID of the item in this slot.
     *
     * @return The item ID as an <code>int</code>.
     */
    public int getItemID() {
        return item.getID();
    }

    /**
     * Gets the item stored in this inventory slot.
     *
     * @return The {@link ItemDTO} stored in the slot.
     */
    public ItemDTO getItem() {
        return item;
    }

    /**
     * Gets the quantity of the item in stock.
     *
     * @return The number of units available as an <code>int</code>.
     */
    public int getQuantity() {
        return stock;
    }
}
