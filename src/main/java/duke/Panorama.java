package duke;

import java.util.Scanner;
import java.util.List;
import java.util.Locale;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.time.format.DateTimeParseException;

// Parser folder
import duke.Parser.Parser;

// Task folder
import duke.MyTask.Task;
import duke.MyTask.Todo;
import duke.MyTask.Deadline;
import duke.MyTask.Event;

// Exceptions folder
import duke.MyException.EmptyDescriptionException;
import duke.MyException.UnknownCommandException;

/**
 * Main class for the Panorama application.
 * Handles user interactions, command processing, and task management.
 */
public class Panorama {
    private static TaskList taskList;

    /**
     * Handles user commands by parsing the input string and executing the corresponding actions.
     * Recognizes commands such as MARK, UNMARK, BYE, LIST, TODO, DEADLINE, EVENT, DELETE, HELP, and FIND.
     *
     * @param input The user command input string.
     * @return true if the BYE command was executed, false otherwise.
     * @throws EmptyDescriptionException If a task command lacks a description.
     * @throws UnknownCommandException If the command is not recognized.
     */
    static boolean handleCommand(String input) throws EmptyDescriptionException, UnknownCommandException {
        String[] tokens = input.split(" ");
        Command command = Command.fromString(tokens[0]);

        int id;

        switch (command) {
        case MARK:
            id = Integer.parseInt(tokens[1]) - 1;
            taskList.markTask(id);
            break;
        case UNMARK:
            id = Integer.parseInt(tokens[1]) - 1;
            taskList.unmarkTask(id);
            break;
        case BYE:
            Ui.printExitGreeting();
            return true;
        case LIST:
            taskList.listEntries();
            break;
        case TODO:
            Todo t = Parser.parseTodoInput(input);
            taskList.addTodoTask(t);
            break;
        case DEADLINE:
            Deadline d = Parser.parseDeadlineInput(input);
            taskList.addDeadlineTask(d);
            break;
        case EVENT:
            Event e = Parser.parseEventInput(input);
            taskList.addEventTask(e);
            break;
        case DELETE:
            id = Integer.parseInt(tokens[1]) - 1;
            taskList.deleteTask(id);
            break;
        case HELP:
            Ui.display_help();
            break;
        case FIND:
            taskList.find(tokens[1]);
            break;
        default:
            throw new UnknownCommandException();
        }

        return false;
    }

    /**
     * Main method to run the Panorama application.
     * Initializes the task list, loads previous tasks, handles user input, and saves tasks before exiting.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        taskList = new TaskList();
        Storage storage = new Storage();

        // force locale
        Locale.setDefault(Locale.ENGLISH);

        Ui.printWelcomeGreeting();

        // Check for past data
        try {
            List<Task> loadedTaskList = storage.loadTaskList();
            taskList = new TaskList(loadedTaskList);
            Ui.printLoadTaskList();
        } catch (FileNotFoundException e) {
            Ui.handleDataTxtNotFound();
        }

        String input;
        boolean hasExited = false;

        while (!hasExited && scanner.hasNext()) {
            try {
                input = scanner.nextLine();
                hasExited = handleCommand(input);
            } catch (EmptyDescriptionException e) {
                Ui.handleEmptyDescriptionException();
            } catch (UnknownCommandException e) {
                Ui.handleUnknownCommandException();
            } catch (DateTimeParseException e) {
                Ui.handleDateTimeParseException();
            }
        }

        // Save task list to file after exiting
        try {
            List<Task> memory = taskList.getMemory();
            storage.saveTaskList(memory);
            Ui.printSavedToFile();
        } catch (IOException e) {
            Ui.handleFileSavingException();
        }
    }
}

