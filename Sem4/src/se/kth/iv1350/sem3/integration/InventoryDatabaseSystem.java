package src.se.kth.iv1350.sem3.integration;

import java.math.BigDecimal;

import src.se.kth.iv1350.sem3.DTOs.InventorySlotDTO;
import src.se.kth.iv1350.sem3.DTOs.ItemDTO;

public class InventoryDatabaseSystem {

    InventorySlotDTO[] databaseSystem = new InventorySlotDTO[100];

    // Constructor for InventoryDatabaseSystem which adds some dummy items to the
    // inventory
    // for testing purposes.
    public InventoryDatabaseSystem() {
        // Initialize the inventory with some items
        databaseSystem[0] = new InventorySlotDTO(
                new ItemDTO("Apple", 1, "Fresh apple", BigDecimal.valueOf(10), BigDecimal.valueOf(0.1)), 50);
        databaseSystem[1] = new InventorySlotDTO(
                new ItemDTO("Banana", 2, "Ripe banana", BigDecimal.valueOf(5), BigDecimal.valueOf(0.05)), 30);
        databaseSystem[2] = new InventorySlotDTO(
                new ItemDTO("Orange", 3, "Juicy orange", BigDecimal.valueOf(8), BigDecimal.valueOf(0.08)), 20);
    }

    // Returns the item with the given itemID from the inventory database system
    public ItemDTO fetchItem(int itemID) throws DatabaseFailureException, ItemNotFoundException// HAHAH
                                                                                               // U CAN
                                                                                               // ACT
                                                                                               // DO
                                                                                               // SEVERAL
                                                                                               // EXCEPTIONS

    {

        if (itemID == -1) {
            throw new DatabaseFailureException("Inventory database failure");
        }
        for (InventorySlotDTO item : databaseSystem) {
            if (item != null && item.getItemID() == itemID) {
                return item.getItem();
            }
        }
        throw new ItemNotFoundException("Item with ID " + itemID + " not found in the inventory.");

    }
}
