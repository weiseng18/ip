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
        System.out.println(INDENT + Message.Greeting.STARTUP_STATEMENT_ONE);
        System.out.println(INDENT + Message.Greeting.STARTUP_STATEMENT_TWO);
        System.out.println(SEPARATOR);
    }

    /**
     * Displays the exit greeting message.
     */
    static void printExitGreeting() {
        System.out.println(SEPARATOR);
        System.out.println(INDENT + Message.Greeting.EXIT_STATEMENT);
        System.out.println(SEPARATOR);
    }

    /**
     * Displays a help message with a list of available commands.
     */
    static void display_help() {
        System.out.println(SEPARATOR);

        System.out.println(INDENT + Message.CommandFormat.LIST);
        System.out.println(INDENT + Message.CommandFormat.FIND);

        System.out.println(INDENT + Message.CommandFormat.BYE);

        System.out.println(INDENT + Message.CommandFormat.TODO);
        System.out.println(INDENT + Message.CommandFormat.DEADLINE);
        System.out.println(INDENT + Message.CommandFormat.EVENT);

        System.out.println(INDENT + Message.CommandFormat.MARK);
        System.out.println(INDENT + Message.CommandFormat.UNMARK);
        System.out.println(INDENT + Message.CommandFormat.DELETE);

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
