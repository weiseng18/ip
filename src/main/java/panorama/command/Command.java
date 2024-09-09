package panorama.command;

/**
 * Represents a command available in the application.
 * Can be run with the execute function to perform a specific action.
 */
public interface Command {
    /**
     * Executes the command, and returns a response.
     *
     * @return A response that indicates the result of executing the command.
     */
    String execute();

    /**
     * Indicates if it is a bye command.
     *
     * @return true if {@code ByeCommand} and false otherwise
     */
    boolean isBye();
}
