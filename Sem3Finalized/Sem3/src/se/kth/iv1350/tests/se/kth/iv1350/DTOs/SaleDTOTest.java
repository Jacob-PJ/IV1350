package se.kth.iv1350.tests.se.kth.iv1350.DTOs;

import se.kth.iv1350.sem3.DTOs.ItemDTO;
import se.kth.iv1350.sem3.DTOs.SaleDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;

import se.kth.iv1350.sem3.DTOs.SaleDTO;
import java.util.ArrayList;
import java.util.List;

public class SaleDTOTest {

    private SaleDTO saleDTO;

    @BeforeEach
    void setUp() {
        saleDTO = new SaleDTO(101);

    }

    @AfterEach
    void tearDown() {
        saleDTO = null;
    }

    @Test
    public void testUpdateTotalCost(int amount) {

    }

    @Test
    public void testFetchCurrentSalesItemList() {

    }

    @Test
    public void testUpdateListAlreadyExistingItem() {
        ItemDTO newItem = new ItemDTO(1001, "Milk 1 L", 32.40, 12, 25);
        System.out.println("the quantity of the item with id 1001 is: " + saleDTO.getQuantityOfItem(1001));

        saleDTO.updateList(newItem, 1001, 10);
        System.out.println("the quantity of the item with id 1001 after update is: " + saleDTO.getQuantityOfItem(1001));
        Assertions.assertEquals(35, saleDTO.getQuantityOfItem(1001));

    }

    @Test
    public void testUpdateListNonExistingItem() {
        ItemDTO newItem = new ItemDTO(1011, "Spoiled Milk 1 L", 32.40, 12, 5);
        System.out.println("the quantity of the item with id 1011 is: " + saleDTO.getQuantityOfItem(1011));

        saleDTO.updateList(newItem, 1011, 10);
        System.out.println("the quantity of the item with id 1011 after update is: " + saleDTO.getQuantityOfItem(1011));
        Assertions.assertEquals(15, saleDTO.getQuantityOfItem(1011));

    }
}