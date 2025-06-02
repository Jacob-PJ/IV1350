package test.se.kth.iv1350.sem3.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import src.se.kth.iv1350.sem3.view.Display;

public class DisplayTest {

    private Display display;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    /**
     * Sets up a new Display instance and redirects System.out before each test.
     */
    @BeforeEach
    public void setUp() {
        display = Display.getInstance();
        System.setOut(new PrintStream(outContent));
    }

    /**
     * Cleans up after each test by resetting the Display and System.out.
     */
    @AfterEach
    public void tearDown() {
        display = null;
        System.setOut(originalOut);
    }

    /**
     * Verifies that the showMessage method prints the correct message to the
     * console.
     */
    @Test
    public void testShowMessage() {
        String message = "abcd efgh";
        display.showMessage(message);
        assertEquals(message + System.lineSeparator(), outContent.toString());
    }
}
