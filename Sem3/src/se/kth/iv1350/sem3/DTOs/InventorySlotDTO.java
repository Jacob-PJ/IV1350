package src.se.kth.iv1350.sem3.DTOs;

public class InventorySlotDTO {

    private final ItemDTO item;
    private final int stock;

    // Constructor which paies and item with the stock of that item in the inventory
    public InventorySlotDTO(ItemDTO item, int stock) {
        this.item = item;
        this.stock = stock;
    }

    // Returns the item ID of the item in the inventory slot
    public int getItemID() {
        return item.getID();
    }

    // Returns the item Object from the inventory slot
    public ItemDTO getItem() {
        return item;
    }

    // Returns the stock left of the item in the inventory slot
    public int getQuantity() {
        return stock;
    }

}
