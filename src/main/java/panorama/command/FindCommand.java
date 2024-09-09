package panorama.command;

import panorama.TaskList;

/**
 * Represents a command to find tasks in the task list that match a keyword.
 */
public class FindCommand implements Command {
    public static final String COMMAND_WORD = "find";

    private TaskList taskList;

    private String keyword;

    /**
     * Constructs a FindCommand with the specified task list and keyword.
     *
     * @param taskList The task list to search within.
     * @param keyword  The keyword to search for in task descriptions.
     */
    public FindCommand(TaskList taskList, String keyword) {
        this.taskList = taskList;
        this.keyword = keyword;
    }

    @Override
    public boolean isBye() {
        return false;
    }

    @Override
    public String execute() {
        TaskList filteredList = taskList.find(keyword);
        return filteredList.toString();
    }
}
