package panorama.task; // same package as the class being tested

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import panorama.DateParser;

public class DeadlineTest {
    String name = "Deadline Task";
    LocalDate date = LocalDate.now();
    Deadline d = new Deadline(name, date);

    @Test
    public void toString_success() {
        String expected = "[D] [ ] " + name + " (by: " + DateParser.format(date) + ")";
        assertEquals(expected, d.toString());
    }

    @Test
    public void toFileString_success() {
        String expected = "D|0|" + name + "|" + DateParser.formatForHardDisk(date);
        assertEquals(expected, d.toFileString());
    }
}


