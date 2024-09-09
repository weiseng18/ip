package panorama.command;

import panorama.TaskList;

public class FindCommand implements Command {
    private TaskList taskList;

    private String keyword;

    public static final String COMMAND_WORD = "find";

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
