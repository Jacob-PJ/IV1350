package test.se.kth.iv1350.sem3.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import src.se.kth.iv1350.sem3.integration.Printer;

/**
 * Unit tests for the Printer class.
 * Verifies the behavior of the printReceipt method.
 */
public class TestPrinter {
    private Printer printer;

    /**
     * Initializes the Printer before each test.
     */
    @BeforeEach
    public void setUp() {
        printer = new Printer();
    }

    /**
     * Sets the Printer to null after each test.
     */
    @AfterEach
    public void tearDown() {
        printer = null;
    }

    /**
     * Tests that the receipt is correctly printed to the console.
     */
    @Test
    public void testPrintReceipt() {
        String receipt = "Receipt:abcd efgh";

        // Capture System.out
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        printer.printReceipt(receipt);

        assertEquals(receipt + System.lineSeparator(), outContent.toString());

        // Reset System.out
        System.setOut(System.out);
    }
}
