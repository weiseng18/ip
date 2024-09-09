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
    private TaskList taskList;
    private Ui ui;

    /**
     * Constructs a Panorama instance and initializes the application components.
     * It sets up the storage, UI, and parser. If the task list cannot be loaded,
     * an empty task list is initialized instead.
     */
    public Panorama() {
        ui = new Ui();
        taskList = new TaskList();
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

    public String getWelcomeMessage() {
        return ui.getWelcomeMessage();
    }
}
