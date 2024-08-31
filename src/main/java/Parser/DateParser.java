package Parser;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateParser {
    private static final DateTimeFormatter INPUT_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");
    private static final DateTimeFormatter OUTPUT_FORMATTER = DateTimeFormatter.ofPattern("MMM dd yyyy HHmm");

    /**
     * Parses a string in the format yyyy-mm-dd HHmm into a LocalDateTime object.
     */
    public static LocalDateTime parse(String dateStr) throws DateTimeParseException {
        return LocalDateTime.parse(dateStr, INPUT_FORMATTER);
    }

    /**
     * Returns a date string in the format MMM dd yyyy HHmm.
     * For output to terminal.
     */
    public static String format(LocalDateTime dateTime) {
        return dateTime.format(OUTPUT_FORMATTER);
    }

    /**
     * Returns a date string in the format yyyy-mm-dd HHmm.
     * For output to hard disk.
     */
    public static String formatForHardDisk(LocalDateTime dateTime) {
        return dateTime.format(INPUT_FORMATTER);
    }
}

