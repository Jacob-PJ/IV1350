package src.se.kth.iv1350.sem3.util;

import java.math.BigDecimal;

import src.se.kth.iv1350.sem3.model.RevenueObserver;

/**
 * Observer that logs the total accumulated revenue to a file.
 */
public class TotalRevenueFileOutput implements RevenueObserver {
    private final FileLogger writer;
    private BigDecimal totalRevenue;

    /**
     * Constructor for the TotalRevenueFileOutput class.
     */
    public TotalRevenueFileOutput() {
        writer = new FileLogger("logs/totalRevenue.txt");
        totalRevenue = BigDecimal.ZERO;
    }

    @Override
    public void updateRevenue(BigDecimal saleRevenue) {
        totalRevenue = totalRevenue.add(saleRevenue);
        writer.writeLine("Total revenue: " + totalRevenue + " SEK");
    }
}
