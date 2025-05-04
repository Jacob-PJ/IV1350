package se.kth.iv1350.tests.se.kth.iv1350.controller;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Random;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;

import se.kth.iv1350.sem3.DTOs.SaleDTO;
import se.kth.iv1350.sem3.controller.Controller;
import se.kth.iv1350.sem3.model.Sale;

class ControllerTest {

    private Controller controller;

    @BeforeEach
    void setUp() {
        controller = new Controller(); // Properly initialize the controller field
    }

    @AfterEach
    void tearDown() {
        controller = null;
    }

    @Test
    public void testStartSale() {
        controller.startSale();

        // Verify that currentSale != null
        assertNotNull(controller.getCurrentSale(), "startSale did create a Sale object");

        // Verify the currentSale is initialized correctly
        Sale currentSale = controller.getCurrentSale();
        assertNotNull(currentSale.getTimeOfSale(), "startSale did register time of sale");
        assertEquals(0, currentSale.getSaleID(), "New sale should have a saleID of 0");

        // Verify that saleDTO is created
        assertNotNull(currentSale.getSaleInfo(), "saleDTO was not created");
    }

    @Test
    public void testRegistercustomerForDiscount(String customerIdentifier) {

    }

    @Test
    public void testPayment(int payment) {

    }

    @Test
    public void testEndSale(int amountPaid, int change) {
    }

    @Test
    public void testEnterItemIdentifier(int itemIdentifier, int quantity) {

    }
}