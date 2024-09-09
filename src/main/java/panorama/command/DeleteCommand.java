package panorama.command;

import panorama.TaskList;
import panorama.task.Task;

public class DeleteCommand implements Command {
    public static final String COMMAND_WORD = "delete";

    private TaskList taskList;

    private int id;

    public DeleteCommand(TaskList taskList, int id) {
        this.taskList = taskList;
        this.id = id;
    }

    @Override
    public boolean isBye() {
        return false;
    }

    @Override
    public String execute() {
        Task deletedTask = taskList.delete(id);
        return "Noted. I've removed this task:\n" + deletedTask.toString();
    }
}
