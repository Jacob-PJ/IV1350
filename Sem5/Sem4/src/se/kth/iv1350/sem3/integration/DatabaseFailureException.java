package src.se.kth.iv1350.sem3.integration;

/**
 * Thrown when the inventory or database system cannot be accessed.
 * Indicates a failure to communicate with an external data source.
 */
public class DatabaseFailureException extends RuntimeException {

    /**
     * Creates a new instance of <code>DatabaseFailureException</code>
     * with a default error message.
     */
    public DatabaseFailureException() {
        super("Database failure");
    }

    /**
     * Creates a new instance of <code>DatabaseFailureException</code>
     * with a given error message.
     *
     * @param database The name of the database that failed.
     */
    public DatabaseFailureException(String database) {
        super("ERROR: " + database + " database failure");
    }

    /**
     * Provides a detailed message about the database failure.
     * Includes the current date, time, and the original error message.
     *
     * @return <code>String</code> containing a detailed message about the database
     *         failure.
     */
    public String getDevMessage() {
        String message = "";
        message += "DatabaseFailiureExceptio\n";
        message += java.time.LocalDate.now() + "\n";
        message += java.time.LocalTime.now() + "\n";
        message += this.getMessage() + "\n";

        return message;
    }
}
