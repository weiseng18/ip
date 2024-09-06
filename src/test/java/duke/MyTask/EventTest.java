package duke.MyTask; // same package as the class being tested

import duke.Parser.DateParser;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EventTest {
    String name = "Event Task";
    LocalDateTime from = LocalDateTime.now();
    LocalDateTime to = from.plusYears(1);
    Event e  = new Event(name, from, to);

    @Test
    public void toStringTest() {
        String dateFrom = DateParser.format(from);
        String dateTo = DateParser.format(to);
        String expected = "[E] [ ] " + name + " (from: " + dateFrom + " to: " + dateTo + ")";
        assertEquals(e.toString(), expected);
    }

    @Test
    public void toFileStringTest() {
        String dateFrom = DateParser.formatForHardDisk(from);
        String dateTo = DateParser.formatForHardDisk(to);
        String expected = "E|0|" + name + "|" + dateFrom + "|" + dateTo;
        assertEquals(e.toFileString(), expected);
    }
}


