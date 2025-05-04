package se.kth.iv1350.tests.se.kth.iv1350.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;

import se.kth.iv1350.sem3.model.Receipt;

class ReceiptTest {
    private Receipt receipt;

    @BeforeEach
    void setUp() {
        receipt = new Receipt();
    }

    @AfterEach
    void tearDown() {
        receipt = null;
    }

    @Test
    void testMakeReceipt() {

    }
}