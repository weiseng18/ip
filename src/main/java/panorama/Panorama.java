package panorama;

import java.io.FileNotFoundException;
import java.io.IOException;

import panorama.command.Command;
import panorama.exception.EmptyDescriptionException;
import panorama.exception.UnknownCommandException;

/**
 * Represents the main class for managing the Panorama application.
 */
public class Panorama {
    private Parser parser;
    private Storage storage;
    private TaskList taskList;
    private Ui ui;

    /**
     * Constructs a Panorama instance and initializes the application components.
     * It sets up the storage, UI, and parser. If the task list cannot be loaded,
     * an empty task list is initialized instead.
     */
    public Panorama() {
        storage = new Storage();
        ui = new Ui();

        try {
            taskList = storage.loadTaskList();
        } catch (FileNotFoundException e) {
            ui.showError(e.getMessage());
            // Initialize empty TaskList anyway
            taskList = new TaskList();
        }

        parser = new Parser(taskList);
    }

    public String getResponse(String input) {
        try {
            Command c = parser.parseCommand(input);
            return c.execute();
        } catch (UnknownCommandException | EmptyDescriptionException e) {
            return e.getMessage();
        }
    }

    /**
     * Runs the Panorama application.
     * It starts the application's main loop, which reads user commands,
     * parses them, executes the corresponding actions, and displays results.
     * The loop continues until a "bye" command is received.
     * After exiting the loop, the current task list is saved to storage.
     */
    public void run() {
        ui.showWelcome();

        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                ui.showLine();
                Command c = parser.parseCommand(fullCommand);
                String output = c.execute();
                System.out.println(output);

                isExit = c.isBye();
            } catch (EmptyDescriptionException | UnknownCommandException e) {
                ui.showError(e.getMessage());
            } finally {
                ui.showLine();
            }
        }

        try {
            storage.saveTaskList(taskList);
        } catch (IOException e) {
            ui.showError(e.getMessage());
        }
    }

    public static void main(String[] args) {
        new Panorama().run();
    }
}
