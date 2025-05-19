package src.se.kth.iv1350.sem3.integration;

/**
 * This class represents an exception that occurs when there is a failure in the
 * database.
 */
public class DatabaseFailureException extends Exception {

    /**
     * Defaut constructor for DatabaseFailureExceptionwithout
     */

    // Constructor for DatabaseFailureException, acts as a default message if no
    // arguments are given
    public DatabaseFailureException() {
        super("Database failure");
    }

    /**
     * Constructor for DatabaseFailureException, takes a message as an argument.
     * 
     * @param message A message explaining the reason for the failure.
     */

    public DatabaseFailureException(String message) {
        super(message);
    }
}
