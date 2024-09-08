package duke;

/**
 * The {@code CommandHandlerOutput} class is a container for the output
 * of a command handler in the Duke application.
 *
 * It stores the current state of the {@link TaskList} and a boolean flag indicating
 * whether the command issued was a "bye" command.
 */

public class CommandHandlerOutput {
    private TaskList taskList;
    private boolean isByeCommand;

    /**
     * Constructs a {@code CommandHandlerOutput} object with the specified task list
     * and a flag for the "bye" command.
     *
     * @param taskList the current state of the task list
     * @param isByeCommand {@code true} if the command is "bye", {@code false} otherwise
     */
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

