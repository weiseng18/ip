package duke;

public class CommandHandlerOutput {
    private TaskList taskList;
    private boolean isByeCommand;

    public CommandHandlerOutput(TaskList taskList, boolean isByeCommand) {
        this.taskList = taskList;
        this.isByeCommand = isByeCommand;
    }

    public TaskList getTaskList() {
        return taskList;
    }

    public boolean isByeCommand() {
        return this.isByeCommand;
    }
}

