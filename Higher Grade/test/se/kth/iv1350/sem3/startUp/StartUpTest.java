package test.se.kth.iv1350.sem3.startUp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import src.se.kth.iv1350.sem3.startUp.StartUp;

/**
 * Unit tests for the {@link StartUp} class.
 * Verifies that the main method produces expected console output.
 */
public class StartUpTest {

    private ByteArrayOutputStream printoutBuffer;
    private PrintStream originalSysOut;

    /**
     * Sets up the test environment by redirecting System.out to a
     * ByteArrayOutputStream
     * to capture printed output for verification.
     */
    @BeforeEach
    void setUp() {
        printoutBuffer = new ByteArrayOutputStream();
        PrintStream inMemSysOut = new PrintStream(printoutBuffer);
        originalSysOut = System.out;
        System.setOut(inMemSysOut);
    }

    /**
     * Cleans up the test environment by resetting System.out to its original state
     * and nullifying the printout buffer.
     */
    @AfterEach
    void tearDown() {
        printoutBuffer = null;
        System.setOut(originalSysOut);
    }

    /**
     * Verifies that the main method of StartUp class runs without throwing any
     * exceptions.
     */
    @Test
    void testMainPrintsStartingSaleMessage() {
        StartUp.main(null);
        String output = printoutBuffer.toString();
        assertTrue(output.contains("Starting Sale"), "Expected 'Starting Sale' message not found.");
    }

    /**
     * Verifies that the main method of StartUp class prints the expected total
     * revenue message.
     */
    @Test
    void testMainPrintsTotalRevenue() {
        StartUp.main(null);
        String output = printoutBuffer.toString();
        assertTrue(output.contains("Total revenue:"), "Expected total revenue message not found.");
    }

    /**
     * Verifies that the main method of StartUp class prints the expected total
     * number of sales message.
     */
    @Test
    void testMainPrintsReceiptBoundaries() {
        StartUp.main(null);
        String output = printoutBuffer.toString();
        assertTrue(output.contains("Begin receipt"), "Expected 'Begin receipt' message not found.");
        assertTrue(output.contains("End receipt"), "Expected 'End receipt' message not found.");
    }

    /**
     * Verifies that the main method of StartUp class prints the expected error
     * message.
     */
    @Test
    void testMainPrintsInheritanceMessage() {
        StartUp.main(null);
        String output = printoutBuffer.toString();
        assertTrue(output.contains("Inheritance:"), "Expected output from RandomInheritance not found.");
    }

    /**
     * Verifies that the main method of StartUp class prints the expected
     * compositance message.
     */
    @Test
    void testMainPrintsCompositanceMessage() {
        StartUp.main(null);
        String output = printoutBuffer.toString();
        assertTrue(output.contains("Compositance:"), "Expected output from RandomCompositor not found.");
    }
}
