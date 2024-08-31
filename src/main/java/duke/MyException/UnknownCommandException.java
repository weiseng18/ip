package duke.MyException;

public class UnknownCommandException extends Exception {
    public UnknownCommandException() {
        super("     Unknown command.");
    }
}
