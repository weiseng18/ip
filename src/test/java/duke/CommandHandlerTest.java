package duke; // same package as the class being tested

import duke.MyTask.Task;
import duke.MyTask.Todo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandHandlerTest {
    private TaskList initTaskList() {
        TaskList taskList = new TaskList();
        taskList.addTask(new Todo("todo"));
        return taskList;
    }

    @Test
    public void handleMarkTest() {
        TaskList taskList = initTaskList();

        // Assert that the task is unmarked initially
        Task t = taskList.getMemory().get(0);
        assertEquals(false, t.getIsDone());

        // Mark the task
        taskList.markTask(0);

        // Assert that the task is now marked
        t = taskList.getMemory().get(0);
        assertEquals(true, t.getIsDone());
    }

    @Test
    public void handleUnmarkTest() {
        TaskList taskList = initTaskList();

        // Mark the task
        taskList.markTask(0);

        // Assert that the task is marked initially
        Task t = taskList.getMemory().get(0);
        assertEquals(true, t.getIsDone());

        // Mark the task
        taskList.unmarkTask(0);

        // Assert that the task is now unmarked
        t = taskList.getMemory().get(0);
        assertEquals(false, t.getIsDone());
    }
}

