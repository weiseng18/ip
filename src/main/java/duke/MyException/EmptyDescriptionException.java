package duke.MyException;

/**
 * Thrown to indicate that a task description is empty.
 * This exception is used to signal that a user-provided input for a task
 * does not include a required description.
 */
public class EmptyDescriptionException extends Exception {
    /**
     * Constructs a new {@code EmptyDescriptionException} with a default error message.
     */
    public EmptyDescriptionException() {
        super("     Description cannot be empty.");
    }
}
