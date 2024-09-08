package duke.Parser;

import java.time.LocalDateTime;

import duke.MyException.EmptyDescriptionException;
import duke.MyTask.Deadline;
import duke.MyTask.Event;
import duke.MyTask.Todo;

/**
 * Parses user input to create {@code Task} objects.
 * Supports parsing input for todo, deadline, and event tasks.
 */
public class Parser {

    /**
     * Parses input to create a {@code Todo} task.
     * The input should be in the format "todo `name`", where `name` is the description of the task.
     *
     * @param input The user input string to be parsed.
     * @return A {@code Todo} task with the specified `name`.
     * @throws EmptyDescriptionException If the input does not contain a task description.
     */
    public static Todo parseTodoInput(String input) throws EmptyDescriptionException {
        if (input.length() <= 5) {
            throw new EmptyDescriptionException();
        }
        String name = input.substring(5);
        return new Todo(name);
    }

    /**
     * Parses input to create a {@code Deadline} task.
     * The input should be in the format "deadline `name` /by `date`", where `name` is the description
     * of the task and `date` is the due date.
     *
     * @param input The user input string to be parsed.
     * @return A {@code Deadline} task with the specified `name` and due `date`.
     * @throws EmptyDescriptionException If the input does not contain a task description or date.
     */
    public static Deadline parseDeadlineInput(String input) throws EmptyDescriptionException {
        if (input.length() <= 9) {
            throw new EmptyDescriptionException();
        }

        String[] contentTokens = input.substring(9).split(" /by ");
        String name = contentTokens[0];
        LocalDateTime date = DateParser.parse(contentTokens[1]);
        return new Deadline(name, date);
    }

    /**
     * Parses input to create an {@code Event} task.
     * The input should be in the format "event `name` /from `start_date` /to `end_date`",
     * where `name` is the description of the task, `start_date` is the start date and time,
     * and `end_date` is the end date and time.
     *
     * @param input The user input string to be parsed.
     * @return An {@code Event} task with the specified `name`, `start_date`, and `end_date`.
     * @throws EmptyDescriptionException If the input does not contain a task description or dates.
     */
    public static Event parseEventInput(String input) throws EmptyDescriptionException {
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

