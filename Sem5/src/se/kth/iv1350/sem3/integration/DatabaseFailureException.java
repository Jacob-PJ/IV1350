package src.se.kth.iv1350.sem3.integration;

/**
 * Thrown when the inventory or database system cannot be accessed
 */
public class DatabaseFailureException extends Exception {

    /**
     * Creates a new instance of DatabaseFailureException
     * with a default error message
     */
    public DatabaseFailureException() {
        super("Database failure");
    }

    /**
     * Creates a new instance of DatabaseFailureException with a specified error
     * message
     *
     * @param message message explaining the reason for the failure
     */
    public DatabaseFailureException(String message) {
        super(message);
    }
}
