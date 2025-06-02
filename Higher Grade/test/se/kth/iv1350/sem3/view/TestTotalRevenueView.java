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

    @BeforeEach
    public void setUp() {
        totalRevenueView = new TotalRevenueView();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void tearDown() {
        totalRevenueView = null;
        System.setOut(originalOut);
    }

    @Test
    public void testUpdateRevenuePrintsCorrectOutput() {
        BigDecimal revenue = new BigDecimal("100.00");
        String expectedOutput = "Total revenue: 100.00 SEK" + System.lineSeparator();

        totalRevenueView.updateRevenue(revenue);

        assertEquals(expectedOutput, outContent.toString());
    }
}
