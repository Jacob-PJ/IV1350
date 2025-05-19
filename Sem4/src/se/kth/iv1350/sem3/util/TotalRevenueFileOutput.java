package src.se.kth.iv1350.sem3.util;

import java.math.BigDecimal;

import src.se.kth.iv1350.sem3.model.RevenueObserver;

public class TotalRevenueFileOutput implements RevenueObserver {
    private final FileLogger writer = new FileLogger("logs/totalRevenue.txt");

    public void updateRevenue(BigDecimal totalRevenue) {
        writer.writeLine("Total revenue: " + totalRevenue + " SEK");
    }
}

// ("../../../../../../logs/totalRevenue.txt");