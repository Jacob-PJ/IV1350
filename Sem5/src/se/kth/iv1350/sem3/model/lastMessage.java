package src.se.kth.iv1350.sem3.model;

public class lastMessage {

    private String message;

    public lastMessage() {
        this.message = "";
    }

    public void updateMessage(String message) {
        this.message += message;
    }

    public void clearMessage() {
        this.message = "";
    }

    public String getMessage() {
        return message;
    }

}
