package se.kth.iv1350.tests.se.kth.iv1350.integration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;

import se.kth.iv1350.sem3.integration.Printer;

class PrinterTest {
    private Printer printer;

    @BeforeEach
    void setUp() {
        printer = new Printer();
    }

    @AfterEach
    void tearDown() {
        printer = null;
    }

    @Test

    void testPrint() {

    }
}