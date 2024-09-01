package duke.Parser; // same package as the class being tested

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DateParserTest {
    @Test
    public void parseTest() {
        String dateStr = "2020-08-01 2347";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");
        LocalDateTime expected = LocalDateTime.parse(dateStr, formatter);

        assertEquals(DateParser.parse(dateStr), expected);
    }

    @Test
    public void parseExceptionTest() {
        String dateStr = "abcdef";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");

        DateTimeParseException e = assertThrows(DateTimeParseException.class, () -> {
            LocalDateTime.parse(dateStr, formatter);
        });

        String expectedMessage = "Text '" + dateStr + "' could not be parsed at index 0";
        assertEquals(e.getMessage(), expectedMessage);
    }
}
