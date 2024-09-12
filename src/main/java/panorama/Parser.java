package panorama;

import java.time.LocalDate;

import panorama.command.ByeCommand;
import panorama.command.Command;
import panorama.command.DeadlineCommand;
import panorama.command.DeleteCommand;
import panorama.command.EventCommand;
import panorama.command.FindCommand;
import panorama.command.HelpCommand;
import panorama.command.ListCommand;
import panorama.command.MarkCommand;
import panorama.command.TodoCommand;
import panorama.command.UnmarkCommand;
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

        case TodoCommand.COMMAND_SHORTHAND:
        case TodoCommand.COMMAND_WORD: {
            if (rest.equals("")) {
                throw new EmptyDescriptionException();
            }
            return new TodoCommand(taskList, rest);
        }

        case DeadlineCommand.COMMAND_SHORTHAND:
        case DeadlineCommand.COMMAND_WORD: {
            if (rest.equals("")) {
                throw new EmptyDescriptionException();
            }
            String[] contentTokens = rest.split(" /by ", 2);
            String name = contentTokens[0];
            LocalDate date = DateParser.parse(contentTokens[1]);
            return new DeadlineCommand(taskList, name, date);
        }

        case EventCommand.COMMAND_SHORTHAND:
        case EventCommand.COMMAND_WORD: {
            if (rest.equals("")) {
                throw new EmptyDescriptionException();
            }
            String[] contentTokens = rest.split(" /from ", 2);
            String name = contentTokens[0];
            String[] dateRangeTokens = contentTokens[1].split(" /to ", 2);
            LocalDate from = DateParser.parse(dateRangeTokens[0]);
            LocalDate to = DateParser.parse(dateRangeTokens[1]);
            return new EventCommand(taskList, name, from, to);
        }

        case MarkCommand.COMMAND_SHORTHAND:
        case MarkCommand.COMMAND_WORD: {
            int id = Integer.parseInt(rest) - 1;
            return new MarkCommand(taskList, id);
        }

        case UnmarkCommand.COMMAND_SHORTHAND:
        case UnmarkCommand.COMMAND_WORD: {
            int id = Integer.parseInt(rest) - 1;
            return new UnmarkCommand(taskList, id);
        }

        case DeleteCommand.COMMAND_SHORTHAND:
        case DeleteCommand.COMMAND_WORD: {
            int id = Integer.parseInt(rest) - 1;
            return new DeleteCommand(taskList, id);
        }

        case ListCommand.COMMAND_SHORTHAND:
        case ListCommand.COMMAND_WORD: {
            return new ListCommand(taskList);
        }

        case FindCommand.COMMAND_SHORTHAND:
        case FindCommand.COMMAND_WORD: {
            return new FindCommand(taskList, rest);
        }

        case ByeCommand.COMMAND_SHORTHAND:
        case ByeCommand.COMMAND_WORD: {
            return new ByeCommand();
        }

        case HelpCommand.COMMAND_SHORTHAND:
        case HelpCommand.COMMAND_WORD: {
            return new HelpCommand();
        }

        default:
            throw new UnknownCommandException();

        }
    }
}
