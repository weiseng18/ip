package duke;

import duke.MyException.EmptyDescriptionException;
import duke.MyException.UnknownCommandException;
import duke.MyTask.Deadline;
import duke.MyTask.Event;
import duke.MyTask.Todo;
import duke.Parser.Parser;

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

        TaskList nextList = prevList;

        switch (command) {
        case MARK:
            nextList = handleMark(nextList, tokens);
            break;
        case UNMARK:
            nextList = handleUnmark(nextList, tokens);
            break;
        case BYE:
            Ui.printExitGreeting();
            return new CommandHandlerOutput(prevList, true);
        case LIST:
            prevList.listEntries();
            break;
        case TODO:
            handleTodo(nextList, input);
            break;
        case DEADLINE:
            handleDeadline(nextList, input);
            break;
        case EVENT:
            handleEvent(nextList, input);
            break;
        case DELETE:
            nextList = handleDelete(nextList, tokens);
            break;
        case HELP:
            Ui.display_help();
            break;
        case FIND:
            handleFind(nextList, tokens);
            break;
        default:
            throw new UnknownCommandException();
        }

        return new CommandHandlerOutput(prevList, false);
    }

    static TaskList handleMark(TaskList list, String[] tokens) {
        int id = Integer.parseInt(tokens[1]) - 1;
        list.markTask(id);
        return list;
    }

    static TaskList handleUnmark(TaskList list, String[] tokens) {
        int id = Integer.parseInt(tokens[1]) - 1;
        list.unmarkTask(id);
        return list;
    }

    static TaskList handleTodo(TaskList list, String input) throws EmptyDescriptionException {
        Todo t = Parser.parseTodoInput(input);
        list.addTask(t);
        return list;
    }

    static TaskList handleDeadline(TaskList list, String input) throws EmptyDescriptionException {
        Deadline t = Parser.parseDeadlineInput(input);
        list.addTask(t);
        return list;
    }

    static TaskList handleEvent(TaskList list, String input) throws EmptyDescriptionException {
        Event t = Parser.parseEventInput(input);
        list.addTask(t);
        return list;
    }

    static TaskList handleDelete(TaskList list, String[] tokens) {
        int id = Integer.parseInt(tokens[1]) - 1;
        list.deleteTask(id);
        return list;
    }

    static void handleFind(TaskList list, String[] tokens) {
        list.find(tokens[1]);
    }
}
