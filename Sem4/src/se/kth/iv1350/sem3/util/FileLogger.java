package src.se.kth.iv1350.sem3.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * A general-purpose file writer for appending messages to a text file.
 */
public class FileLogger {
    private final String filePath;

    public FileLogger(String filePath) {
        this.filePath = filePath;
    }

    public void writeLine(String message) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath, true))) {
            writer.println(message);
        } catch (IOException e) {
            System.out.println("Failed to write to " + filePath);
            e.printStackTrace();
        }
    }
}
