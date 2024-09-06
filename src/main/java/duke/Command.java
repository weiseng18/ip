package duke;

/**
 * Represents the commands available in the application.
 * Each command corresponds to a specific action that can be taken by the user.
 */
public enum Command {
    MARK("mark"),
    UNMARK("unmark"),
    BYE("bye"),
    LIST("list"),
    TODO("todo"),
    DEADLINE("deadline"),
    EVENT("event"),
    DELETE("delete"),
    HELP("help");

    private String command;

    private Command(String command) {
        this.command = command;
    }

    /**
     * Returns the corresponding {@code Command} for the given string.
     * If the provided string does not match any known command, {@code null} is returned.
     *
     * @param command The string representing the command.
     * @return The corresponding {@code Command}, or {@code null} if no match is found.
     */
    public static Command fromString(String command) {
        for (Command cmd: Command.values()) {
            if (cmd.command.equalsIgnoreCase(command)) {
                return cmd;
            }
        }
        return null;
    }
}

