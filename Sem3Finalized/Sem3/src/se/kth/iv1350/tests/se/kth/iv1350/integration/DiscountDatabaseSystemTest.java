package se.kth.iv1350.tests.se.kth.iv1350.integration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;

import se.kth.iv1350.sem3.integration.DiscountDatabaseSystem;

class DiscountDatabaseSystemTest {

    private DiscountDatabaseSystem discountDatabaseSystem;

    @BeforeEach
    void setUp() {
        discountDatabaseSystem = new DiscountDatabaseSystem();
    }

    @AfterEach
    void tearDown() {
        discountDatabaseSystem = null;
    }

    @Test
    public void testFetchDiscount() {

    }
}