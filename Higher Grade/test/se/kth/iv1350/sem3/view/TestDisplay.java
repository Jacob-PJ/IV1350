package test.se.kth.iv1350.sem3.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import src.se.kth.iv1350.sem3.view.Display;

public class TestDisplay {

    private Display display;

    /**
     * Initializes the Display before each test.
     */
    @BeforeEach
    public void setUp() {
        display = Display.getInstance();
    }

    /**
     * Sets the Display to null after each test.
     */
    @AfterEach
    public void tearDown() {
        display = null;
    }

    /**
     * Tests that the showMessage method displays the correct message.
     */
    @Test
    public void testShowMessage() {
        String message = "abcd efgh";

        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        display.showMessage(message);

        assertEquals(message + System.lineSeparator(), outContent.toString());

        // Reset System.out
        System.setOut(System.out);
    }
}
