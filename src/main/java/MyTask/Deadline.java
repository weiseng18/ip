package MyTask;

import Parser.DateParser;

import java.time.LocalDateTime;

public class Deadline extends Task {
    LocalDateTime date;

    public Deadline(String name, LocalDateTime date) {
        super(name, 'D');
        this.date = date;
    }

    public String toFileString() {
        return super.toFileString() + "|" + DateParser.formatForHardDisk(date);
    }

    public String toString() {
        return super.toString() + " (by: " + DateParser.format(date) + ")";
    }
}
