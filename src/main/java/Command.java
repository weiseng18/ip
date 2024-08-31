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

    Command(String command) {
        this.command = command;
    }

    public static Command fromString(String command) {
        for (Command cmd: Command.values()) {
            if (cmd.command.equalsIgnoreCase(command)) {
                return cmd;
            }
        }
        return null;
    }
}

