package panorama.command;

import panorama.Message;

/**
 * Represents a command to display help information, including available commands and their formats.
 */
public class HelpCommand implements Command {
    public static final String COMMAND_WORD = "help";

    @Override
    public boolean isBye() {
        return false;
    }

    @Override
    public String execute() {
        StringBuilder sb = new StringBuilder();

        sb.append(Message.CommandFormat.LIST + "\n");
        sb.append(Message.CommandFormat.FIND + "\n");

        sb.append(Message.CommandFormat.BYE + "\n");
        sb.append(Message.CommandFormat.HELP + "\n");

        sb.append(Message.CommandFormat.TODO + "\n");
        sb.append(Message.CommandFormat.DEADLINE + "\n");
        sb.append(Message.CommandFormat.EVENT + "\n");

        sb.append(Message.CommandFormat.MARK + "\n");
        sb.append(Message.CommandFormat.UNMARK + "\n");
        sb.append(Message.CommandFormat.DELETE);

        return sb.toString();
    }
}
