package panorama;

import java.time.LocalDate;

import panorama.command.Command;
import panorama.command.DeadlineCommand;
import panorama.command.EventCommand;
import panorama.command.TodoCommand;
import panorama.exception.EmptyDescriptionException;
import panorama.exception.UnknownCommandException;

/**
 * Parses user input.
 */
public class Parser {
    private TaskList taskList;

    public Parser(TaskList taskList) {
        this.taskList = taskList;
    }

    /**
     * Parses the user input and returns an executable command based on the input.
     *
     * @param input The user's input string to be parsed.
     * @return A {@code Command} representing the parsed command.
     */
    public Command parseCommand(String input)
            throws EmptyDescriptionException, UnknownCommandException {
        String stripped = input.strip();
        String[] tokens = stripped.split(" ", 2);

        String command = tokens[0];
        String rest = tokens.length > 1 ? tokens[1] : "";

        switch (command) {

        case TodoCommand.COMMAND_WORD: {
            if (rest.equals("")) {
                throw new EmptyDescriptionException();
            }
            return new TodoCommand(taskList, rest);
        }

        case DeadlineCommand.COMMAND_WORD: {
            if (rest.equals("")) {
                throw new EmptyDescriptionException();
            }
            String[] contentTokens = rest.split(" /by ", 2);
            String name = contentTokens[0];
            LocalDate date = DateParser.parse(contentTokens[1]);
            return new DeadlineCommand(taskList, name, date);
        }

        case EventCommand.COMMAND_WORD: {
            if (rest.equals("")) {
                throw new EmptyDescriptionException();
            }
            String[] contentTokens = rest.split(" /from ", 2);
            String name = contentTokens[0];
            String[] dateRangeTokens = rest.split(" /to ", 2);
            LocalDate from = DateParser.parse(dateRangeTokens[0]);
            LocalDate to = DateParser.parse(dateRangeTokens[1]);
            return new EventCommand(taskList, name, from, to);
        }

        default:
            throw new UnknownCommandException();

        }
    }
}
