package panorama.command;

import panorama.TaskList;
import panorama.task.Task;

/**
 * Represents a command to delete a task from the task list.
 */
public class DeleteCommand implements Command {
    public static final String COMMAND_WORD = "delete";

    private TaskList taskList;

    private int id;

    /**
     * Constructs a DeleteCommand with the specified task list and task ID.
     *
     * @param taskList The task list from which the task will be deleted.
     * @param id       The ID of the task to be deleted.
     */
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
