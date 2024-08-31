package Parser;

import java.time.LocalDateTime;

import MyTask.Task;
import MyTask.Todo;
import MyTask.Deadline;
import MyTask.Event;

import MyException.EmptyDescriptionException;

public class Parser {
    public static Task parseTodoInput(String input) throws EmptyDescriptionException {
        if (input.length() <= 5) {
            throw new EmptyDescriptionException();
        }
        String name = input.substring(5);
        return new Todo(name);
    }

    public static Task parseDeadlineInput(String input) throws EmptyDescriptionException {
        if (input.length() <= 9) {
            throw new EmptyDescriptionException();
        }

        String[] contentTokens = input.substring(9).split(" /by ");
        String name = contentTokens[0];
        LocalDateTime date = DateParser.parse(contentTokens[1]);
        return new Deadline(name, date);
    }

    public static Task parseEventInput(String input) throws EmptyDescriptionException {
        if (input.length() <= 6) {
            throw new EmptyDescriptionException();
        }
        String[] contentTokens = input.substring(6).split(" /from ");
        String name = contentTokens[0];

        String[] dateRange = contentTokens[1].split(" /to ");
        LocalDateTime from = DateParser.parse(dateRange[0]);
        LocalDateTime to = DateParser.parse(dateRange[1]);
        return new Event(name, from, to);
    }
}
