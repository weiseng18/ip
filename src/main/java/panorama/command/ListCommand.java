package panorama.command;

import panorama.TaskList;

public class ListCommand implements Command {
    private TaskList taskList;

    public static final String COMMAND_WORD = "list";

    public ListCommand(TaskList taskList) {
        this.taskList = taskList;
    }

    @Override
    public boolean isBye() {
        return false;
    }

    @Override
    public String execute() {
        return taskList.toString();
    }
}
