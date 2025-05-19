package src.se.kth.iv1350.sem3.model;

import java.math.BigDecimal;

public interface RevenueObserver {

    void updateRevenue(BigDecimal totalRevenue);
}
