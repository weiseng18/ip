package duke;

public class Message {
    public class MyException {
        public static String EMPTY_DESCRIPTION = "Description cannot be empty.";
        public static String INVALID_DATE = "Invalid date specified.";
        public static String UNKNOWN_COMMAND = "Unknown command.";
    }

    public class CommandFormat {
        // task listing
        public static String LIST = "list";
        public static String FIND = "find (description)";

        public static String BYE = "bye";

        // task creation
        public static String TODO = "todo (description)";
        public static String DEADLINE = "deadline (description) /by (date_string)";
        public static String EVENT = "event (description) /from (date_string) /to (date_string)";

        // task amendment
        public static String MARK = "mark (task_id)";
        public static String UNMARK = "unmark (task_id)";
        public static String DELETE = "delete (task_id)";
    }
}
