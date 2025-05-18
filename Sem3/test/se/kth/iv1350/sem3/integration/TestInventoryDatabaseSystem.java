package test.se.kth.iv1350.sem3.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.se.kth.iv1350.sem3.DTOs.ItemDTO;
import src.se.kth.iv1350.sem3.integration.InventoryDatabaseSystem;

import static org.junit.jupiter.api.Assertions.*;

public class TestInventoryDatabaseSystem {

    private InventoryDatabaseSystem inventoryDatabaseSystem;

    @BeforeEach
    public void setUp() {
        // Initialize the InventoryDatabaseSystem
        inventoryDatabaseSystem = new InventoryDatabaseSystem();
    }

    @AfterEach
    public void tearDown() {
        // Set inventoryDatabaseSystem to null
        inventoryDatabaseSystem = null;
    }

    // Making sure that items in the database can be fetched
    @Test
    public void testFetchItemFound() {
        int existingID = 1; // Predefined as apple
        ItemDTO result = inventoryDatabaseSystem.fetchItem(existingID);

        assertNotNull(result, "Expected to find item with ID 1");
        assertEquals(existingID, result.getID(), "Fetched item ID should match requested ID");
    }

    // Making sure that a non-existing item returns null
    @Test
    public void testFetchItemNotFound() {
        int nonExistingID = 9999;
        ItemDTO result = inventoryDatabaseSystem.fetchItem(nonExistingID);

        assertNull(result, "Expected null for non-existing item ID");
    }
}
