package se.kth.iv1350.tests.se.kth.iv1350.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;

import se.kth.iv1350.sem3.model.Sale;

class SaleTest {
    private Sale sale;

    @BeforeEach
    void setUp() {
        sale = new Sale();
    }

    @AfterEach
    void tearDown() {
        sale = null;
    }

    @Test
    public void testSetTimeOfSale() {

    }

    @Test
    public void testUpdateTotalcost(int amount) {

    }

    @Test
    public void testEndSale() {

    }

    @Test
    public void testAddDiscount(int[][] listOfDiscoutns) {

    }

    @Test
    public void testFetchCurrentSalesItemList() {

    }

    @Test
    public void testUpdateList(int itemIdentifier, int quantity) {

    }
}