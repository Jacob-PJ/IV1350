package src.se.kth.iv1350.sem3.model;

import java.io.IOException;

import java.math.BigDecimal;

public abstract class TotalRevenueTemplate implements RevenueObserver {

    BigDecimal totalRevenue = BigDecimal.ZERO;

    @Override
    public final void updateRevenue(BigDecimal saleRevenue) {
        addToRevnue(saleRevenue);
        showTotalIncome();
    }

    public void addToRevnue(BigDecimal saleRevenue) {
        this.totalRevenue = totalRevenue.add(saleRevenue);
    }

    private void showTotalIncome() {

        String totalRevenueMessage = "Total revenue: " + totalRevenue + " SEK";
        try {
            doShowTotalIncome(totalRevenueMessage);
        } catch (Exception e) {
            handleErrors(e);
        }
    }

    protected abstract void doShowTotalIncome(String totalRevenueMessage) throws Exception;

    protected abstract void handleErrors(Exception e);

}
