package duke;

public class CommandHandlerOutput {
    TaskList taskList;
    boolean isByeCommand;

    public CommandHandlerOutput(TaskList taskList, boolean isByeCommand) {
        this.taskList = taskList;
        this.isByeCommand = isByeCommand;
    }
}

