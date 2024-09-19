package panorama;

import panorama.command.Command;
import panorama.command.Response;
import panorama.exception.EmptyDescriptionException;
import panorama.exception.EmptyKeywordException;
import panorama.exception.IdOutOfBoundsException;
import panorama.exception.InvalidDateException;
import panorama.exception.NonIntegerIdException;
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
        taskList = new TaskList(false);
        parser = new Parser(taskList);
    }

    public Response getResponse(String input) {
        try {
            Command c = parser.parseCommand(input);
            return c.execute();
        } catch (UnknownCommandException | EmptyDescriptionException
                | NonIntegerIdException | IdOutOfBoundsException
                | EmptyKeywordException | InvalidDateException e) {
            return new Response(e.getMessage(), false);
        }
    }

    public String getWelcomeMessage() {
        return ui.getWelcomeMessage();
    }
}
