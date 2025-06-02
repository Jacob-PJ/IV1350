package test.se.kth.iv1350.sem3.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import src.se.kth.iv1350.sem3.integration.Printer;

/**
 * Unit tests for the Printer class.
 * Verifies the behavior of the printReceipt method.
 */
public class PrinterTest {
    private Printer printer;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    /**
     * Initializes the Printer and redirects System.out before each test.
     */
    @BeforeEach
    public void setUp() {
        printer = new Printer();
        System.setOut(new PrintStream(outContent));
    }

    /**
     * Cleans up after each test by resetting System.out and nulling the printer.
     */
    @AfterEach
    public void tearDown() {
        printer = null;
        System.setOut(originalOut);
    }

    /**
     * Verifies that the receipt is correctly printed to the console.
     */
    @Test
    public void testPrintReceipt() {
        String receipt = "Receipt:abcd efgh";
        printer.printReceipt(receipt);
        assertEquals(receipt + System.lineSeparator(), outContent.toString());
    }
}
