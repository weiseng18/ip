package panorama; // same package as the class being tested

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.junit.jupiter.api.Test;

public class DateParserTest {
    @Test
    public void parse_validDate_success() {
        String dateStr = "2020-08-01";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate expected = LocalDate.parse(dateStr, formatter);

        assertEquals(expected, DateParser.parse(dateStr));
    }

    @Test
    public void parse_invalidDate_exceptionThrown() {
        String dateStr = "abcdef";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        DateTimeParseException e = assertThrows(DateTimeParseException.class, () -> {
            LocalDate.parse(dateStr, formatter);
        });

        String expectedMessage = "Text '" + dateStr + "' could not be parsed at index 0";
        assertEquals(expectedMessage, e.getMessage());
    }
}
