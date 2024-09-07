package duke; // same package as the class being tested

import java.util.List;

import duke.MyTask.Task;
import duke.MyTask.Todo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

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

    @Test
    public void handleTodoTest() {
        TaskList taskList = initTaskList();
        int previousSize = taskList.getMemory().size();

        String name = "todo_task";

        assertDoesNotThrow(() -> {
            TaskList newList = CommandHandler.handleTodo(taskList, "todo " + name);

            // List size increases by 1
            assertEquals(previousSize + 1, newList.getMemory().size());

            // Check last element added
            List<Task> memory = newList.getMemory();
            Task last = memory.get(memory.size() - 1);
            assertEquals(name, last.getName());
        });
    }

    @Test
    public void handleDeadlineTest() {
        TaskList taskList = initTaskList();
        int previousSize = taskList.getMemory().size();

        String name = "deadline_task";
        String validDate = "2024-09-01 2354";

        String query = "deadline " + name + " /by " + validDate;

        assertDoesNotThrow(() -> {
            TaskList newList = CommandHandler.handleDeadline(taskList, query);

            // List size increases by 1
            assertEquals(previousSize + 1, newList.getMemory().size());

            // Check last element added
            List<Task> memory = newList.getMemory();
            Task last = memory.get(memory.size() - 1);
            assertEquals(name, last.getName());
        });
    }


    @Test
    public void handleEventTest() {
        TaskList taskList = initTaskList();
        int previousSize = taskList.getMemory().size();

        String name = "todo_task";
        String validStartDate = "2024-09-01 2354";
        String validEndDate = "2024-09-02 1247";

        String query = "event " + name + " /from " + validStartDate + " /to " + validEndDate;

        assertDoesNotThrow(() -> {
            TaskList newList = CommandHandler.handleEvent(taskList, query);

            // List size increases by 1
            assertEquals(previousSize + 1, newList.getMemory().size());

            // Check last element added
            List<Task> memory = newList.getMemory();
            Task last = memory.get(memory.size() - 1);
            assertEquals(name, last.getName());
        });
    }


    @Test
    public void handleDeleteTest() {
        TaskList taskList = initTaskList();
        taskList.deleteTask(0);
        int size = taskList.getMemory().size();
        assertEquals(0, size);
    }
}

