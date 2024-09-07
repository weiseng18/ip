package duke;

import duke.MyTask.Todo;
import duke.MyTask.Deadline;
import duke.MyTask.Event;

import duke.Parser.Parser;

import duke.MyException.EmptyDescriptionException;
import duke.MyException.UnknownCommandException;

public class CommandHandler {
    /**
     * Handles user commands by parsing the input string and executing the corresponding actions.
     * Recognizes commands such as MARK, UNMARK, BYE, LIST, TODO, DEADLINE, EVENT, DELETE, HELP, and FIND.
     *
     * @param TaskList The previous task list
     * @param input The user command input string.
     * @return {@code CommandHandlerOutput} The updated task list, and a boolean indicating whether the BYE command was executed.
     * @throws EmptyDescriptionException If a task command lacks a description.
     * @throws UnknownCommandException If the command is not recognized.
     */
    static CommandHandlerOutput handleCommand(TaskList prevList, String input) throws EmptyDescriptionException, UnknownCommandException {
        String[] tokens = input.split(" ");
        Command command = Command.fromString(tokens[0]);

        int id;

        switch (command) {
        case MARK:
            id = Integer.parseInt(tokens[1]) - 1;
            prevList.markTask(id);
            break;
        case UNMARK:
            id = Integer.parseInt(tokens[1]) - 1;
            prevList.unmarkTask(id);
            break;
        case BYE:
            Ui.printExitGreeting();
            return new CommandHandlerOutput(prevList, true);
        case LIST:
            prevList.listEntries();
            break;
        case TODO:
            Todo t = Parser.parseTodoInput(input);
            prevList.addTask(t);
            break;
        case DEADLINE:
            Deadline d = Parser.parseDeadlineInput(input);
            prevList.addTask(d);
            break;
        case EVENT:
            Event e = Parser.parseEventInput(input);
            prevList.addTask(e);
            break;
        case DELETE:
            id = Integer.parseInt(tokens[1]) - 1;
            prevList.deleteTask(id);
            break;
        case HELP:
            Ui.display_help();
            break;
        case FIND:
            prevList.find(tokens[1]);
            break;
        default:
            throw new UnknownCommandException();
        }

        return new CommandHandlerOutput(prevList, false);
    }
}
