package duke.Parser;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Provides utility methods for parsing and formatting dates.
 * Supports conversion between string representations and {@code LocalDateTime} objects.
 */
public class DateParser {
    private static final DateTimeFormatter INPUT_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");
    private static final DateTimeFormatter OUTPUT_FORMATTER = DateTimeFormatter.ofPattern("MMM dd yyyy HHmm");

    /**
     * Parses a string in the format "yyyy-MM-dd HHmm" into a {@code LocalDateTime} object.
     *
     * @param dateStr The date string to be parsed.
     * @return A {@code LocalDateTime} object representing the parsed date and time.
     * @throws DateTimeParseException If the provided string cannot be parsed into a date.
     */
    public static LocalDateTime parse(String dateStr) throws DateTimeParseException {
        return LocalDateTime.parse(dateStr, INPUT_FORMATTER);
    }

    /**
     * Returns a string representation of the {@code LocalDateTime} object in the format "MMM dd yyyy HHmm".
     * This format is suitable for displaying to users in the terminal.
     *
     * @param dateTime The {@code LocalDateTime} object to be formatted.
     * @return A string representing the date and time in the specified output format.
     */
    public static String format(LocalDateTime dateTime) {
        return dateTime.format(OUTPUT_FORMATTER);
    }

    /**
     * Returns a string representation of the {@code LocalDateTime} object in the format "yyyy-MM-dd HHmm".
     * This format is suitable for storing date and time on disk.
     *
     * @param dateTime The {@code LocalDateTime} object to be formatted.
     * @return A string representing the date and time in the specified storage format.
     */
    public static String formatForHardDisk(LocalDateTime dateTime) {
        return dateTime.format(INPUT_FORMATTER);
    }
}

