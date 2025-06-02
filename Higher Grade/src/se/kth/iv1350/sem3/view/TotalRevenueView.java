package src.se.kth.iv1350.sem3.view;

import src.se.kth.iv1350.sem3.model.RevenueObserver;
import src.se.kth.iv1350.sem3.model.TotalRevenueTemplate;

import java.math.BigDecimal;

/**
 * Observer that displays the running total revenue to the console.
 * Used to provide immediate feedback after each completed sale.
 */
// public class TotalRevenueView implements TotalRevenueTemplate {
public class TotalRevenueView extends TotalRevenueTemplate {
    // private BigDecimal totalRevenue;

    /**
     * Creates an instance of <code>TotalRevenueView</code>, initializing it to
     * zero.
     */
    /*
     * public TotalRevenueView() {
     * this.totalRevenue = BigDecimal.ZERO;
     * }
     */

    /**
     * Updates the running total revenue and displays the updated amount to the
     * console.
     *
     * @param saleRevenue Revenue from the completed sale as a
     *                    <code>BigDecimal</code>.
     */
    /*
     * @Override
     * public void updateRevenue(BigDecimal saleRevenue) {
     * this.totalRevenue = this.totalRevenue.add(saleRevenue);
     * System.out.println("Total revenue today: " + this.totalRevenue + " SEK");
     * }
     */

    @Override
    protected void doShowTotalIncome(String totalRevenueMessage) {
        System.out.println(totalRevenueMessage);
    }

    @Override
    protected void handleErrors(Exception e) {
        System.out.println("Error: " + e.getMessage());
    }
}
