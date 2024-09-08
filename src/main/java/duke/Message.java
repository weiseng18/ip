package duke;

public class Message {
    public class MyException {
        public static final String EMPTY_DESCRIPTION = "Description cannot be empty.";
        public static final String INVALID_DATE = "Invalid date specified.";
        public static final String UNKNOWN_COMMAND = "Unknown command.";
    }

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
