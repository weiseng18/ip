package panorama.command;

import panorama.TaskList;
import panorama.task.Task;

public class MarkCommand implements Command {
    private TaskList taskList;

    private int id;

    public MarkCommand(TaskList taskList, int id) {
        this.taskList = taskList;
        this.id = id;
    }

    @Override
    public String execute() {
        taskList.mark(id);
        Task task = taskList.get(id);
        return "Nice! I've marked this task as done:" + task.toString();
    }
}
