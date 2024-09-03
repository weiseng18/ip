package duke;

import java.util.Scanner;
import java.util.List;

import java.util.Locale;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.time.format.DateTimeParseException;

// Task folder
import duke.MyTask.Task;

// Exceptions folder
import duke.MyException.EmptyDescriptionException;
import duke.MyException.UnknownCommandException;

public class Panorama {
    static TaskList taskList;
    static Ui ui;

    /**
     * @return true if BYE command was executed, false otherwise
     */
    static boolean handleCommand(String input) throws EmptyDescriptionException, UnknownCommandException {
        String[] tokens = input.split(" ");
        Command command = Command.fromString(tokens[0]);

        switch (command) {
        case MARK:
            taskList.markTask(tokens[1]);
            break;
        case UNMARK:
            taskList.unmarkTask(tokens[1]);
            break;
        case BYE:
            ui.exit_greeting();
            return true;
        case LIST:
            taskList.listEntries();
            break;
        case TODO:
            taskList.addTodoTask(input);
            break;
        case DEADLINE:
            taskList.addDeadlineTask(input);
            break;
        case EVENT:
            taskList.addEventTask(input);
            break;
        case DELETE:
            taskList.deleteTask(tokens[1]);
            break;
        case HELP:
            ui.display_help();
            break;
        default:
            throw new UnknownCommandException();
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        taskList = new TaskList();
        Storage storage = new Storage();

        // force locale
        Locale.setDefault(Locale.ENGLISH);

        ui.welcome_greeting();

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
