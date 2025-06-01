package test.se.kth.iv1350.sem3.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.se.kth.iv1350.sem3.DTOs.ItemDTO;
import src.se.kth.iv1350.sem3.integration.InventoryDatabaseSystem;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the {@link InventoryDatabaseSystem} class.
 * Ensures that items can be correctly fetched and handles invalid IDs properly.
 */
public class TestInventoryDatabaseSystem {

    private InventoryDatabaseSystem inventoryDatabaseSystem;

    /**
     * Sets up the test fixture before each test.
     * Initializes an instance of {@link InventoryDatabaseSystem}.
     */
    @BeforeEach
    public void setUp() {
        inventoryDatabaseSystem = new InventoryDatabaseSystem();
    }

    /**
     * Cleans up resources after each test.
     */
    @AfterEach
    public void tearDown() {
        inventoryDatabaseSystem = null;
    }

    /**
     * Verifies that a known item can be fetched successfully by ID.
     * Item with ID 1 (Apple) is predefined in the test setup.
     */
    @Test
    public void testFetchItemFound() {
        int existingID = 1;
        ItemDTO result = inventoryDatabaseSystem.fetchItem(existingID);

        assertNotNull(result, "Expected to find item with ID 1");
        assertEquals(existingID, result.getID(), "Fetched item ID should match requested ID");
    }

    /**
     * Verifies that fetching an item with a non-existent ID returns null.
     */
    @Test
    public void testFetchItemNotFound() {
        int nonExistingID = 9999;
        ItemDTO result = inventoryDatabaseSystem.fetchItem(nonExistingID);

        assertNull(result, "Expected null for non-existing item ID");
    }
}
