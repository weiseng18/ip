package duke.MyTask;

import duke.Parser.DateParser;

import java.time.LocalDateTime;

public class Event extends Task {
    private LocalDateTime from, to;

    public Event(String name, LocalDateTime from, LocalDateTime to) {
        super(name, 'E');
        this.from = from;
        this.to = to;
    }

    public String toFileString() {
        String dateFrom = DateParser.formatForHardDisk(from);
        String dateTo = DateParser.formatForHardDisk(to);
        return super.toFileString() + "|" + dateFrom + "|" + dateTo;
    }

    public String toString() {
        String dateFrom = DateParser.format(from);
        String dateTo = DateParser.format(to);
        return super.toString() + " (from: " + dateFrom + " to: " + dateTo + ")";
    }
}
