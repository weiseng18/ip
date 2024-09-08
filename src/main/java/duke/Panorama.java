package duke;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import duke.MyException.EmptyDescriptionException;
import duke.MyException.UnknownCommandException;
import duke.MyTask.Task;

/**
 * Main class for the Panorama application.
 * Handles user interactions, command processing, and task management.
 */
public class Panorama {
    private static TaskList taskList;

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

                CommandHandlerOutput o = CommandHandler.handleCommand(taskList, input);
                taskList = o.taskList;
                hasExited = o.isByeCommand;
            } catch (EmptyDescriptionException | UnknownCommandException | DateTimeParseException e) {
                System.out.println(Ui.INDENT + e.getMessage());
            }
        }

        // Save task list to file after exiting
        try {
            List<Task> memory = taskList.getMemory();
            storage.saveTaskList(memory);
            Ui.printSavedToFile();
        } catch (IOException e) {
            System.out.println(Ui.INDENT + e.getMessage());
        }
    }
}

