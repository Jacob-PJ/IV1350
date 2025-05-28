package test.se.kth.iv1350.sem3.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.se.kth.iv1350.sem3.DTOs.ItemDTO;
import src.se.kth.iv1350.sem3.integration.DatabaseFailureException;
import src.se.kth.iv1350.sem3.integration.InventoryDatabaseSystem;
import src.se.kth.iv1350.sem3.integration.ItemNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

public class TestInventoryDatabaseSystem {

    private InventoryDatabaseSystem inv;

    @BeforeEach
    public void setUp() {
        // Initialize the InventoryDatabaseSystem
        inv = new InventoryDatabaseSystem();
    }

    @AfterEach
    public void tearDown() {
        // Set inventoryDatabaseSystem to null
        inv = null;
    }

    // Making sure that items in the database can be fetched
    @Test
    public void testFetchItemFound() {
        int existingID = 1; // Predefined as apple
        ItemDTO result = null;
        try {
            result = inv.fetchItem(existingID);
        } catch (DatabaseFailureException dfe) {
            result = null;
        } catch (ItemNotFoundException ine) {
            result = null;
        }

        assertEquals(existingID, result.getID(), "Fetched item ID should match requested ID");
    }

    // Making sure that a non-existing item returns null
    @Test
    public void testFetchItemNotFound() {
        int nonExistingID = 9999;
        String result = null;
        try {
            inv.fetchItem(nonExistingID);
        } catch (DatabaseFailureException dfe) {
            result = dfe.getMessage();
        } catch (ItemNotFoundException infe) {
            result = infe.getMessage();
        }

        assertEquals(result, "Item with ID 9999 not found in the inventory.", "Error message should match");
    }

}
