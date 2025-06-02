package src.se.kth.iv1350.sem3.model;

import java.math.BigDecimal;

/**
 * Interface for observers that should be notified of revenue updates.
 * Used to react to completed sales and track total revenue.
 */
public interface RevenueObserver {

    /**
     * Called when a new sale has been completed to update the total revenue.
     *
     * @param totalRevenue Updated total revenue after the new sale as a
     *                     <code>BigDecimal</code>.
     */
    void updateRevenue(BigDecimal totalRevenue);
}
