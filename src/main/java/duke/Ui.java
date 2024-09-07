package duke;

/**
 * Handles user interaction by printing various messages to the console.
 */
public class Ui {
    // Constants
    public static final String SEPARATOR = "    ____________________________________________________________";
    public static final String INDENT = "     "; // 5 spaces

    /**
     * Displays the welcome greeting message.
     */
    static void printWelcomeGreeting() {
        System.out.println(SEPARATOR);
        System.out.println(INDENT + "Hello! I'm Panorama");
        System.out.println(INDENT + "What can I do for you?");
        System.out.println(SEPARATOR);
    }

    /**
     * Displays the exit greeting message.
     */
    static void printExitGreeting() {
        String exit_statement = "Bye. Hope to see you again soon!";
        System.out.println(SEPARATOR);
        System.out.println(INDENT + exit_statement);
        System.out.println(SEPARATOR);
    }

    /**
     * Displays a help message with a list of available commands.
     */
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

    /**
     * Sends the specified message to the console, followed by a separator.
     *
     * @param err The message to be sent.
     */
    private static void sendMessage(String err) {
        System.out.println(INDENT + err);
        System.out.println(SEPARATOR);
    }

    /**
     * Handles the situation where the data.txt file is not found.
     * Prints a message indicating that an empty task list is being started.
     */
    static void handleDataTxtNotFound() {
        sendMessage("./data.txt does not exist. Starting from an empty task list.");
    }

    /**
     * Handles the exception where saving to the file fails.
     * Prints an error message to the console.
     */
    static void handleFileSavingException() {
        sendMessage("Error in saving to file.");
    }

    /**
     * Prints a message indicating that the task list was successfully loaded.
     */
    static void printLoadTaskList() {
        sendMessage("Successfully loaded task list.");
    }

    /**
     * Prints a message indicating that the task list was successfully saved to the file.
     */
    static void printSavedToFile() {
        sendMessage("Successfully saved to file.");
    }
}
