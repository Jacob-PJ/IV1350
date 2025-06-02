package src.se.kth.iv1350.sem3.util;

import java.math.BigDecimal;
import src.se.kth.iv1350.sem3.model.RevenueObserver;

/**
 * Observer that logs the total accumulated revenue to a file.
 * Used to keep a running record of all sales.
 */
public class TotalRevenueFileOutput implements RevenueObserver {
    private final FileLogger writer;
    private BigDecimal totalRevenue;

    /**
     * Creates a new instance of <code>TotalRevenueFileOutput</code> that logs
     * revenue.
     * Initializes the total revenue to zero.
     */
    public TotalRevenueFileOutput() {
        writer = new FileLogger("logs/totalRevenue.txt");
        totalRevenue = BigDecimal.ZERO;
    }

    /**
     * Updates the total revenue and writes the updated value to the log file.
     *
     * @param saleRevenue Revenue from the most recent sale.
     */
    @Override
    public void updateRevenue(BigDecimal saleRevenue) {
        totalRevenue = totalRevenue.add(saleRevenue);
        writer.writeLine("Total revenue: " + totalRevenue + " SEK");
    }
}
