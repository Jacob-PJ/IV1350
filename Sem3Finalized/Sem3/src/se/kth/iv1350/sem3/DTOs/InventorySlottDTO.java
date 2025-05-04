package se.kth.iv1350.sem3.DTOs;

public class InventorySlottDTO {

    ItemDTO item;
    int quantity;

    public InventorySlottDTO(ItemDTO item, int quantity) {
        this.item = item;
        this.quantity = quantity;

    }

    public int getItemIdentifier() {
        return item.getItemIdentifier();
    }

    public ItemDTO getItemDTO() {
        return item;
    }

}
