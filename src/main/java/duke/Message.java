package duke;

/**
 * The {@code Message} class contains constant strings that represent various messages and command formats used.
 */
public class Message {

    /**
     * The {@code MyException} class contains constant error messages used
     * throughout the application to describe various exceptions.
     */
    public class MyException {
        public static final String EMPTY_DESCRIPTION = "Description cannot be empty.";
        public static final String INVALID_DATE = "Invalid date specified.";
        public static final String UNKNOWN_COMMAND = "Unknown command.";
    }

    /**
     * The {@code CommandFormat} class contains constant strings that define
     * the format for various commands accepted by the application.
     */
    public class CommandFormat {
        // task listing
        public static final String LIST = "list";
        public static final String FIND = "find (description)";

        public static final String BYE = "bye";

        // task creation
        public static final String TODO = "todo (description)";
        public static final String DEADLINE = "deadline (description) /by (date_string)";
        public static final String EVENT = "event (description) /from (date_string) /to (date_string)";

        // task amendment
        public static final String MARK = "mark (task_id)";
        public static final String UNMARK = "unmark (task_id)";
        public static final String DELETE = "delete (task_id)";
    }
}
