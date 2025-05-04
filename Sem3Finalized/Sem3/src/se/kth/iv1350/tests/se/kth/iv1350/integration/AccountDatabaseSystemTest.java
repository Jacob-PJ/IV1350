package se.kth.iv1350.tests.se.kth.iv1350.integration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;

import se.kth.iv1350.sem3.integration.AccountDatabaseSystem;

class AccountDatabaseSystemTest {

    private AccountDatabaseSystem accountDatabaseSystem;

    @BeforeEach
    void setUp() {
        accountDatabaseSystem = new AccountDatabaseSystem();
    }

    @AfterEach
    void tearDown() {
        accountDatabaseSystem = null;
    }

    @Test
    public void testFinalizePurchase() {

    }

    @Test
    public void testCalculateChange() {

    }
}