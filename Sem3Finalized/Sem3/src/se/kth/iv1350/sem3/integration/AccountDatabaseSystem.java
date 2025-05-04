package se.kth.iv1350.sem3.integration;

import se.kth.iv1350.sem3.model.Sale;

public class AccountDatabaseSystem {

    int totalSales;

    public AccountDatabaseSystem() {
        totalSales = 0;
    }

    public void finalizePurchase(Sale sale, int totalCost, int payment) {

    }

    public void incrementAmountOfSales() {
        totalSales++;
    }

    public int getNewSaleID() {
        return totalSales;
    }
}
