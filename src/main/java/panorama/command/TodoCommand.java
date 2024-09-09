package panorama.command;

import panorama.TaskList;
import panorama.task.Todo;

public class TodoCommand implements Command {
    private TaskList taskList;

    private String name;

    public TodoCommand(TaskList taskList, String name) {
        this.taskList = taskList;
        this.name = name;
    }

    @Override
    public String execute() {
        Todo todo = new Todo(name);
        taskList.add(todo);
        return "Added task:\n" + todo.toString();
    }
}
