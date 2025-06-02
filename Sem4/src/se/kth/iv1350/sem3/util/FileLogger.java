package src.se.kth.iv1350.sem3.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * A general purpose logger that appends text messages to a specified log file.
 * Useful for recording messages or errors to a file during execution.
 */
public class FileLogger {
    private final String filePath;

    /**
     * Creates a new <code>FileLogger</code> that writes to the specified file path.
     *
     * @param filePath The path to the log file.
     */
    public FileLogger(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Writes a line of text to the log file.
     *
     * @param message Message to write to the file.
     * @throws IOException if an I/O error occurs when writing to the file.
     */
    public void writeLine(String message) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath, true))) {
            writer.println(message);
        } catch (IOException IOe) {
            System.out.println("Failed to write to " + filePath);
            IOe.printStackTrace();
        }
    }
}
