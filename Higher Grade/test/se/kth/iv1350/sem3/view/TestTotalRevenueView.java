package test.se.kth.iv1350.sem3.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import src.se.kth.iv1350.sem3.view.TotalRevenueView;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;

public class TestTotalRevenueView {

    private TotalRevenueView totalRevenueView;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    /**
     * Sets up a new TotalRevenueView instance and tests its functionality.
     * Redirects System.out to capture output for verification.
     */
    @BeforeEach
    public void setUp() {
        totalRevenueView = new TotalRevenueView();
        System.setOut(new PrintStream(outContent));
    }

    /**
     * Cleans up after each test by resetting the TotalRevenueView
     * and restoring System.out to its original state.
     */
    @AfterEach
    public void tearDown() {
        totalRevenueView = null;
        System.setOut(originalOut);
    }

    /**
     * Verifies that the updateRevenue method prints the correct output
     * when called with a specific revenue value.
     */
    @Test
    public void testUpdateRevenuePrintsCorrectOutput() {
        BigDecimal revenue = new BigDecimal("100.00");
        String expectedOutput = "Total revenue: 100.00 SEK" + System.lineSeparator();

        totalRevenueView.updateRevenue(revenue);

        assertEquals(expectedOutput, outContent.toString());
    }
}
