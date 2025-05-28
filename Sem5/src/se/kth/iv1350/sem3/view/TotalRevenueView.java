package src.se.kth.iv1350.sem3.view;

import src.se.kth.iv1350.sem3.model.RevenueObserver;

import java.math.BigDecimal;

/**
 * Observer that displays the running total revenue to the console.
 */
public class TotalRevenueView implements RevenueObserver {

    private BigDecimal totalRevenue;

    public TotalRevenueView() {
        this.totalRevenue = BigDecimal.ZERO;
    }

    @Override
    public void updateRevenue(BigDecimal totalRevenue) {
        this.totalRevenue = this.totalRevenue.add(totalRevenue);
        System.out.println("Total revenue today: " + this.totalRevenue + " SEK");
    }
}
