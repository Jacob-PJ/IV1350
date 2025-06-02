package src.se.kth.iv1350.sem3.integration;

import java.math.BigDecimal;

import src.se.kth.iv1350.sem3.DTOs.InventorySlotDTO;
import src.se.kth.iv1350.sem3.DTOs.ItemDTO;

/**
 * A simple inventory database system for our program to interact with.
 * Contains a set of predefined items that can be retrieved by ID.
 */
public class InventoryDatabaseSystem {

    private final InventorySlotDTO[] databaseSystem = new InventorySlotDTO[10];

    /**
     * Creates a new instance of the inventory system and fills it with data.
     * The inventory is simulated with a fixed set of items.
     */
    public InventoryDatabaseSystem() {
        databaseSystem[0] = new InventorySlotDTO(
                new ItemDTO("Apple", 1, "Fresh apple", BigDecimal.valueOf(10), BigDecimal.valueOf(0.1)), 50);
        databaseSystem[1] = new InventorySlotDTO(
                new ItemDTO("Banana", 2, "Ripe banana", BigDecimal.valueOf(5), BigDecimal.valueOf(0.05)), 30);
        databaseSystem[2] = new InventorySlotDTO(
                new ItemDTO("Orange", 3, "Juicy orange", BigDecimal.valueOf(8), BigDecimal.valueOf(0.08)), 20);
    }

    /**
     * Fetches an item from the inventory system based on its ID.
     *
     * @param itemID Identifier of the item to retrieve.
     * @return <code>ItemDTO</code> corresponding to the given ID.
     * @throws DatabaseFailureException If the database cannot be contacted
     *                                  (simulated when <code>itemID == -1</code>).
     * @throws ItemNotFoundException    If the item with the given ID does not exist
     *                                  in the system.
     * @link ItemDTO
     */
    public ItemDTO fetchItem(int itemID) throws DatabaseFailureException, ItemNotFoundException {
        if (itemID == -1) {
            throw new DatabaseFailureException("Inventory");
        }

        for (InventorySlotDTO item : databaseSystem) {
            if (item != null && item.getItemID() == itemID) {
                return item.getItem();
            }
        }

        throw new ItemNotFoundException(itemID);
    }
}
