package duke.MyException;

public class EmptyDescriptionException extends Exception {
    public EmptyDescriptionException() {
        super("     Description cannot be empty.");
    }
}

