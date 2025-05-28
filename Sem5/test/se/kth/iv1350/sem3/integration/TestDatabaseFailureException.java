package test.se.kth.iv1350.sem3.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import src.se.kth.iv1350.sem3.integration.DatabaseFailureException;
import src.se.kth.iv1350.sem3.integration.InventoryDatabaseSystem;
import src.se.kth.iv1350.sem3.integration.ItemNotFoundException;

public class TestDatabaseFailureException {
    private InventoryDatabaseSystem inv;

    @BeforeEach
    void setUp() {
        inv = new InventoryDatabaseSystem();
    }

    @AfterEach
    void tearDown() {
        inv = null;
    }

    /**
     * 
     */
    @Test
    void testDatabaseFailureException() {

        String expectedMessage = "Inventory database failure";
        String actualMessage = "";

        try {
            inv.fetchItem(-1);
        } catch (DatabaseFailureException dfe) {
            actualMessage = dfe.getMessage();
        } catch (ItemNotFoundException infe) {
            actualMessage = infe.getMessage();
        }

        assertEquals(actualMessage, "Inventory database failure");

    }
}
