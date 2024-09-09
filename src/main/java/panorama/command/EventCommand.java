package panorama.command;

import java.time.LocalDate;

import panorama.TaskList;
import panorama.task.Event;

public class EventCommand implements Command {
    private TaskList taskList;

    private String name;
    private LocalDate from;
    private LocalDate to;

    public static final String COMMAND_WORD = "event";

    public EventCommand(TaskList taskList, String name, LocalDate from, LocalDate to) {
        this.taskList = taskList;
        this.name = name;
        this.from = from;
        this.to = to;
    }

    @Override
    public String execute() {
        Event event = new Event(name, from, to);
        taskList.add(event);
        return "Added task:\n" + event.toString();
    }
}
