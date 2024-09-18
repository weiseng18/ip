package panorama; // same package as the class being tested

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import panorama.task.Task;
import panorama.task.Todo;

public class TaskListTest {
    private TaskList taskList;

    @BeforeEach
    public void setup() {
        // Initialize an empty TaskList before each
        taskList = new TaskList(true);
    }

    @Test
    public void taskList_initializeEmpty_success() {
        List<Task> tasks = taskList.getTasks();
        assertEquals(0, tasks.size());
    }

    @Test
    public void taskList_initializeWithList_success() {
        List<Task> presetTasks = new ArrayList<>();
        presetTasks.add(new Todo("task 1"));
        presetTasks.add(new Todo("task 2"));

        // re-initialize
        taskList = new TaskList(presetTasks, true);

        List<Task> tasks = taskList.getTasks();
        assertEquals(presetTasks.size(), tasks.size());
    }

    @Test
    public void add_success() {
        Todo t = new Todo("task 1");
        taskList.add(t);

        Task task = taskList.get(0);
        assertEquals(t, task);
    }
}
