package test.se.kth.iv1350.sem3.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import src.se.kth.iv1350.sem3.integration.DatabaseFailureException;
import src.se.kth.iv1350.sem3.integration.InventoryDatabaseSystem;
import src.se.kth.iv1350.sem3.integration.ItemNotFoundException;

/**
 * Unit test for {@link ItemNotFoundException}.
 * This class verifies that the correct exception is thrown and that the
 * correct message is returned when a non-existing item ID is searched for.
 */
public class TestItemNotFoundException {

    private InventoryDatabaseSystem inv;

    /**
     * Initializes the <code>InventoryDatabaseSystem</code> before each test.
     */
    @BeforeEach
    void setUp() {
        inv = new InventoryDatabaseSystem();
    }

    /**
     * Tears down <code>InventoryDatabaseSystem</code> after each test.
     */
    @AfterEach
    void tearDown() {
        inv = null;
    }

    /**
     * Tests that an {@link ItemNotFoundException} is thrown and returns the correct
     * message when an item ID that does not exist in the inventory is searched for.
     */
    @Test
    void testItemNotFoundException() {
        int nonExistentID = 999;
        String expectedMessage = "Item with ID " + nonExistentID + " not found in the inventory.";
        String actualMessage = "";

        try {
            inv.fetchItem(nonExistentID);
        } catch (DatabaseFailureException dfe) {
            actualMessage = dfe.getMessage();
        } catch (ItemNotFoundException infe) {
            actualMessage = infe.getMessage();
        }

        assertEquals(expectedMessage, actualMessage, "Expected message for non-existent item ID.");
    }
}
