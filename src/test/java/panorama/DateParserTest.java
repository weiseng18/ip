package panorama; // same package as the class being tested

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DateParserTest {
    @Test
    public void parseTest() {
        String dateStr = "2020-08-01";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate expected = LocalDate.parse(dateStr, formatter);

        assertEquals(expected, DateParser.parse(dateStr));
    }

    @Test
    public void parseDateTimeParseExceptionTest() {
        String dateStr = "abcdef";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        DateTimeParseException e = assertThrows(DateTimeParseException.class, () -> {
            LocalDate.parse(dateStr, formatter);
        });

        String expectedMessage = "Text '" + dateStr + "' could not be parsed at index 0";
        assertEquals(expectedMessage, e.getMessage());
    }
}
