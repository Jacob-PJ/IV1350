package test.se.kth.iv1350.sem3.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.Locale;

import src.se.kth.iv1350.sem3.DTOs.ItemDTO;
import src.se.kth.iv1350.sem3.model.ItemInCart;
import src.se.kth.iv1350.sem3.model.Receipt;
import src.se.kth.iv1350.sem3.model.Sale;

public class TestReciept {

    private Sale sale;
    private Receipt receipt;

    @BeforeEach
    public void setUp() {
        // Initialize the Sale object
        sale = new Sale();
        receipt = new Receipt(sale);
    }

    @AfterEach
    public void tearDown() {
        // Set sale to null
        sale = null;
    }

    // Test that the receipt is generated correctly
    @Test
    public void testGetReceipt() {

        // Filling sale with some dummy items
        ItemDTO itemDTO = new ItemDTO("Test Item", 1, "Test Desc", new BigDecimal("10.00"), new BigDecimal("0.10"));
        ItemInCart item = new ItemInCart(itemDTO, 2); // 2 items
        sale.addItem(item);
        sale.makePayment(new BigDecimal("30.00"));

        // Generate receipt from sale

        receipt.generateReciept();
        String actualReceipt = receipt.getReceipt();

        // Build expected string using same formatting logic
        String expectedReceipt = "- - - - - - - - - - - - - - - - - - Begin receipt - - - - - - - - - - - - - - - - - - -\n";
        expectedReceipt += "Time of Sale : " + sale.getTimeOfSaleAsString() + "\n";
        expectedReceipt += "Test Item 2 x " + String.format(Locale.US, "%.2f", new BigDecimal("10.00"));
        expectedReceipt += " " + String.format(Locale.US, "%.2f", new BigDecimal("20.00")) + " SEK\n";
        expectedReceipt += "Total price : " + String.format(Locale.US, "%.2f", new BigDecimal("20.00")) + " SEK\n";
        expectedReceipt += "VAT : " + String.format(Locale.US, "%.2f", new BigDecimal("2.00")) + " SEK\n";
        expectedReceipt += "Chash : " + String.format(Locale.US, "%.2f", new BigDecimal("30.00")) + " SEK\n";
        expectedReceipt += "Change : " + String.format(Locale.US, "%.2f", new BigDecimal("10.00")) + " SEK\n";
        expectedReceipt += "- - - - - - - - - - - - - - - - - - End receipt - - - - - - - - - - - - - - - - - - - - -\n";

        assertEquals(expectedReceipt, actualReceipt);
    }
}
