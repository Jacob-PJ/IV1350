package se.kth.iv1350.sem3.integration;

import se.kth.iv1350.sem3.DTOs.InventorySlottDTO;
import se.kth.iv1350.sem3.DTOs.ItemDTO;
import java.util.ArrayList;
import java.util.List;

public class InventoryDatabaseSystem {

    InventorySlottDTO[] databsaseSystem = new InventorySlottDTO[100];
    private List<ItemDTO> currentInventory = new ArrayList<>();

    public InventoryDatabaseSystem() {
        currentInventory.add(new ItemDTO(1001, "Milk 1 L", 32.40, 12, 25));
        currentInventory.add(new ItemDTO(1002, "Coffee 200 g", 54.00, 12, 15));
        currentInventory.add(new ItemDTO(1003, "Sourdough bread", 34.90, 12, 30));
    }

    public boolean getItemInvStatus(int itemIdentifier) {
        return true;
    }

    public ItemDTO fetchItem(int itemIdentifier, boolean itemInvStatus) {
        if (!itemInvStatus)
            return null;
        for (ItemDTO item : currentInventory) {
            if (item.getItemIdentifier() == itemIdentifier) {
                return item;
            }
        }
        return null;

    }

    public void reduceStock(List<ItemDTO> soldItems) {
        for (ItemDTO sold : soldItems) {
            int itemIdentifier = sold.getItemIdentifier();
            int quantity = sold.getQuantity();

            for (ItemDTO item : currentInventory) {
                if (item.getItemIdentifier() == itemIdentifier) {
                    item.decreaseQuantity(quantity);
                    break;
                }
            }
            // will throw if not enough left
        }
    }

    // InventorySlottDTO[] databsaseSystem = new InventorySlottDTO[100];

    // public InventoryDatabaseSystem() {

    // }

    // public boolean getItemInvStatus(int itemIdentifier) {
    // for (int i = 0; i < databsaseSystem.length; i++) {
    // if (databsaseSystem[i].getItemIdentifier() == itemIdentifier) {
    // return true;
    // }
    // }
    // return false;
    // }

    // public ItemDTO fetchItem(int itemIdentifier, boolean itemInvStatus) {
    // for (int i = 0; i < databsaseSystem.length; i++) {
    // if (databsaseSystem[i].getItemIdentifier() == itemIdentifier) {
    // return databsaseSystem[i].getItemDTO();
    // }
    // }
    // throw new IllegalArgumentException("Item not found in inventory database
    // system.");
    // }

    // public void reduceStock(int[] list) {

    // }

}
