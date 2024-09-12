package panorama.command;

import panorama.TaskList;
import panorama.task.Todo;

/**
 * Represents a command to add a todo task to the task list.
 */
public class TodoCommand implements Command {
    public static final String COMMAND_WORD = "todo";

    private TaskList taskList;

    private String name;

    /**
     * Constructs a TodoCommand with the specified task list and todo name.
     *
     * @param taskList The task list to which the todo task will be added.
     * @param name     The name of the todo task.
     */
    public TodoCommand(TaskList taskList, String name) {
        this.taskList = taskList;
        this.name = name;
    }

    @Override
    public boolean isBye() {
        return false;
    }

    @Override
    public String execute() {
        assert taskList != null;
        Todo todo = new Todo(name);
        taskList.add(todo);
        return "Added task:\n" + todo.toString();
    }
}
