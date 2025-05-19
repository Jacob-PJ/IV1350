package test.se.kth.iv1350.sem3.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import src.se.kth.iv1350.sem3.integration.Printer;

public class TestPrinter {
    private Printer printer;

    @BeforeEach
    public void setUp() {
        // Initialize the printer
        printer = new Printer();
    }

    @AfterEach
    public void tearDown() {
        // Set printer to null
        printer = null;
    }

    // Making sure that the printer prints out the correct receipt
    @Test
    public void testPrintReceipt() {
        String receipt = "Receipt: \nItem 1: $10.00\nItem 2: $20.00\nTotal: $30.00";

        // Capture System.out
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        printer.printReceipt(receipt);

        assertEquals(receipt + System.lineSeparator(), outContent.toString());

        // Reset System.out
        System.setOut(System.out);
    }
}