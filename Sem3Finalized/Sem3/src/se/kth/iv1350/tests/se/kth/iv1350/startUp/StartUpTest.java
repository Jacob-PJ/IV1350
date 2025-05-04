package se.kth.iv1350.tests.se.kth.iv1350.startUp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;

import se.kth.iv1350.sem3.startUp.StartUp;

public class StartUpTest {

    private StartUp startUp;

    @BeforeEach
    void setUp() {
        startUp = new StartUp();
    }

    @AfterEach
    void tearDown() {
        startUp = null;
    }

    @Test
    public void testMain() {

    }

}