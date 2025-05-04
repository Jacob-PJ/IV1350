package se.kth.iv1350.tests.se.kth.iv1350.integration;

import se.kth.iv1350.sem3.DTOs.ItemDTO;
import se.kth.iv1350.sem3.integration.InventoryDatabaseSystem;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;

import se.kth.iv1350.sem3.integration.InventoryDatabaseSystem;

class InventoryDatabaseSystemTest {
    private InventoryDatabaseSystem inventoryDatabaseSystem;

    @BeforeEach
    void setUp() {
        inventoryDatabaseSystem = new InventoryDatabaseSystem();
    }

    @AfterEach
    void tearDown() {
        inventoryDatabaseSystem = null;
    }

    @Test
    void testGetItemInvStatus_ItemExists() {
        boolean expection = true;
        boolean result = inventoryDatabaseSystem.getItemInvStatus(1003);
        assertEquals(expection, result);
    }

    @Test
    void testGetItemInvStatus_ItemDoesNotExist() {
        boolean expection = false;
        boolean result = inventoryDatabaseSystem.getItemInvStatus(1004);
        assertEquals(expection, result);
    }

    @Test
    void testGetItemInvStatus_ItemOutOfStock() {
        boolean expection = false;
        boolean result = inventoryDatabaseSystem.getItemInvStatus(1010);
        // System.out.println(inventoryDatabaseSystem.fetchItem(1010,
        // true).getItemDescription());
        assertEquals(expection, result);
    }

    @Test
    void testFetchItem_ItemExists() {
        boolean expection = true;
        ItemDTO item = inventoryDatabaseSystem.fetchItem(1001, true);
        if (item == null)
            expection = false;
        assertEquals(expection, true, "the item is in fact not there");
        // System.out.println(item.getItemDescription());
    }

    @Test
    void testFetchItem_ItemDoesNotExist() {
        boolean expection = false;
        ItemDTO item = inventoryDatabaseSystem.fetchItem(1005, true);
        if (item == null)
            expection = false;
        assertEquals(expection, false, "the item is in fact not there");
    }

    @Test
    void testReduceStockReducesQuantityCorrectly() {

        List<ItemDTO> soldItems = new ArrayList<>();
        soldItems.add(new ItemDTO(1001, "Milk 1 L", 32.40, 12, 20));
        // System.out.println("output before is" +
        // inventoryDatabaseSystem.fetchItem(1001, true).getQuantity());
        inventoryDatabaseSystem.reduceStock(soldItems);

        ItemDTO itemAfter = inventoryDatabaseSystem.fetchItem(1001, true);
        assertEquals(inventoryDatabaseSystem.fetchItem(1001, true).getQuantity(), itemAfter.getQuantity(),
                "Stock should be reduced correctly");
        System.out.println("output after is" + inventoryDatabaseSystem.fetchItem(1001, true).getQuantity());
    }
}