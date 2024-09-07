package duke;

public class Ui {
    // Constants
    public static final String SEPARATOR = "    ____________________________________________________________";
    public static final String INDENT = "     "; // 5 spaces

    static void welcome_greeting() {
        System.out.println(SEPARATOR);
        System.out.println(INDENT + "Hello! I'm Panorama");
        System.out.println(INDENT + "What can I do for you?");
        System.out.println(SEPARATOR);
    }

    static void exit_greeting() {
        String exit_statement = "Bye. Hope to see you again soon!";
        System.out.println(SEPARATOR);
        System.out.println(INDENT + exit_statement);
        System.out.println(SEPARATOR);
    }

    static void display_help() {
        System.out.println(SEPARATOR);

        System.out.println(INDENT + "list");
        System.out.println(INDENT + "find (description)");
        System.out.println(INDENT + "bye");

        System.out.println(INDENT + "todo (description)");
        System.out.println(INDENT + "deadline (description) /by (date_string)");
        System.out.println(INDENT + "event (description) /from (date_string) /to (date_string)");

        System.out.println(INDENT + "mark (task_id)");
        System.out.println(INDENT + "unmark (task_id)");
        System.out.println(INDENT + "delete (task_id)");

        System.out.println(SEPARATOR);
    }

    private static void sendMessage(String err) {
        System.out.println(INDENT + err);
        System.out.println(SEPARATOR);
    }

    static void handleEmptyDescriptionException() {
        sendMessage("The task description cannot be empty.");
    }

    static void handleUnknownCommandException() {
        sendMessage("Unknown command.");
    }

    static void handleDateTimeParseException() {
        sendMessage("Invalid date.");
    }

    static void handleDataTxtNotFound() {
        sendMessage("./data.txt does not exist. Starting from an empty task list.");
    }

    static void handleFileSavingException() {
        sendMessage("Error in saving to file.");
    }

    static void printLoadTaskList() {
        sendMessage("Successfully loaded task list.");
    }

    static void printSavedToFile() {
        sendMessage("Successfully saved to file.");
    }
}
