package panorama.command;

import panorama.TaskList;

public class ListCommand implements Command {
    public static final String COMMAND_WORD = "list";

    private TaskList taskList;

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
