package panorama.command;

import panorama.TaskList;
import panorama.task.Task;

public class UnmarkCommand implements Command {
    private TaskList taskList;

    private int id;

    public static final String COMMAND_WORD = "unmark";

    public UnmarkCommand(TaskList taskList, int id) {
        this.taskList = taskList;
        this.id = id;
    }

    @Override
    public boolean isBye() {
        return false;
    }

    @Override
    public String execute() {
        taskList.unmark(id);
        Task task = taskList.get(id);
        return "OK, I've marked this task as not done yet:" + task.toString();
    }
}
