package src.se.kth.iv1350.sem3.util;

/**
 * Logs error messages to a file
 */
public class ErrorLogger {
    private final FileLogger writer = new FileLogger("logs/errorLog.txt");

    public void log(String message) {
        writer.writeLine(message);
    }
}

// ("../../../../../logs/errorLog.txt");