package panorama.command;

public class ByeCommand implements Command {
    public static final String COMMAND_WORD = "bye";

    @Override
    public boolean isBye() {
        return true;
    }

    @Override
    public String execute() {
        return "Bye. Hope to see you again soon!";
    }
}
