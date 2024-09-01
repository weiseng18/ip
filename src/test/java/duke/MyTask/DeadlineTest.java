package duke.MyTask; // same package as the class being tested

import duke.Parser.DateParser;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeadlineTest {
    String name = "Deadline Task";
    LocalDateTime date = LocalDateTime.now();
    Deadline d = new Deadline(name, date);

    @Test
    public void initializeTest() {
        assertEquals(d.name, name);
        assertEquals(d.date, date);
    }

    @Test
    public void toStringTest() {
        String expected = "[D] [ ] " + name + " (by: " + DateParser.format(date) + ")";
        assertEquals(d.toString(), expected);
    }

    @Test
    public void toFileStringTest() {
        String expected = "D|0|" + name + "|" + DateParser.formatForHardDisk(date);
        assertEquals(d.toFileString(), expected);
    }
}

