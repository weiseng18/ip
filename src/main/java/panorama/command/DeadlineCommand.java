package panorama.command;

import java.time.LocalDate;

import panorama.TaskList;
import panorama.task.Deadline;

public class DeadlineCommand implements Command {
    private TaskList taskList;

    private String name;
    private LocalDate date;

    public static final String COMMAND_WORD = "deadline";

    public DeadlineCommand(TaskList taskList, String name, LocalDate date) {
        this.taskList = taskList;
        this.name = name;
        this.date = date;
    }

    @Override
    public String execute() {
        Deadline deadline = new Deadline(name, date);
        taskList.add(deadline);
        return "Added task:\n" + deadline.toString();
    }
}
