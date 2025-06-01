package src.se.kth.iv1350.sem3.util;

/**
 * Handles logging of error messages to a file for persistent storage.
 * Used to record system errors that may need to be reviewed later.
 */
public class ErrorLogger {
    private final FileLogger writer = new FileLogger("logs/errorLog.txt");

    /**
     * Logs a specified error message to the error log file.
     *
     * @param message Error message to log.
     * @link FileLogger
     */
    public void log(String message) {
        writer.writeLine(message);
    }
}

// (../../../../../logs/errorLog.txt)
