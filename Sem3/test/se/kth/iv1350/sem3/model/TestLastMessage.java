package test.se.kth.iv1350.sem3.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import src.se.kth.iv1350.sem3.model.LastMessage;

import static org.junit.jupiter.api.Assertions.*;

public class TestLastMessage {

    private LastMessage lastMessage;

    @BeforeEach
    public void setUp() {
        lastMessage = new LastMessage();
    }

    @Test
    public void testInitialMessageIsEmpty() {
        assertEquals("", lastMessage.getMessage(), "Initial message should be empty");
    }

    @Test
    public void testUpdateMessageAppendsText() {
        String msg1 = "a";
        lastMessage.updateMessage(msg1);
        assertEquals(msg1, lastMessage.getMessage(), "Messages should match");

        String msg2 = "b";
        lastMessage.updateMessage(msg2);
        assertEquals(msg1 + msg2, lastMessage.getMessage(), "Messages should be combined");
    }

    @Test
    public void testClearMessageResetsText() {
        lastMessage.updateMessage("a");
        lastMessage.clearMessage();
        assertEquals("", lastMessage.getMessage(), "Message should be empty");
    }
}
