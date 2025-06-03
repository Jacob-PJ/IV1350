package test.se.kth.iv1350.sem3.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import src.se.kth.iv1350.sem3.model.LastMessage;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test class for LastMessage.
 * Verifies the functionality for storing, updating, and clearing messages.
 */
public class TestLastMessage {

    private LastMessage lastMessage;

    /**
     * Initializes a new LastMessage instance before each test.
     */
    @BeforeEach
    public void setUp() {
        lastMessage = new LastMessage();
    }

    /**
     * Nullifies the LastMessage instance after each test.
     */
    @AfterEach
    public void tearDown() {
        lastMessage = null;
    }

    /**
     * Verifies that the initial message is an empty string.
     */
    @Test
    public void testInitialMessageIsEmpty() {
        assertEquals("", lastMessage.getMessage(), "Initial message should be empty");
    }

    /**
     * Verifies that new messages are appended correctly to the existing message.
     */
    @Test
    public void testUpdateMessageAppendsText() {
        String msg1 = "a";
        lastMessage.updateMessage(msg1);
        assertEquals(msg1, lastMessage.getMessage(), "Messages should match");

        String msg2 = "b";
        lastMessage.updateMessage(msg2);
        assertEquals(msg1 + msg2, lastMessage.getMessage(), "Messages should be combined");
    }

    /**
     * Verifies that calling clearMessage resets the message to an empty string.
     */
    @Test
    public void testClearMessageResetsText() {
        lastMessage.updateMessage("a");
        lastMessage.clearMessage();
        assertEquals("", lastMessage.getMessage(), "Message should be empty");
    }
}
