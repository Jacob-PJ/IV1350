package test.se.kth.iv1350.sem3.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import src.se.kth.iv1350.sem3.integration.Display;

public class TestDisplay {

    private Display display;

    @BeforeEach
    public void setUp() {
        // Initialize the printer
        display = new Display();
    }

    @AfterEach
    public void tearDown() {
        // Set printer to null
        display = null;
    }

    // Making sure that the display prints out the correct message
    @Test
    public void testShowMessage() {
        String message = "Test Message";

        // Capture System.out
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        display.showMessage(message);

        assertEquals(message + System.lineSeparator(), outContent.toString());

        // Reset System.out
        System.setOut(System.out);
    }
}
