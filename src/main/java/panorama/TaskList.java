package panorama;

import java.util.ArrayList;
import java.util.List;

import panorama.task.Task;

/**
 * Manages a list of {@code Task} objects.
 * Provides methods to add, list, mark, unmark, and delete tasks.
 */
public class TaskList {
    private List<Task> tasks;

    /**
     * Initializes an empty task list.
     */
    public TaskList() {
        tasks = new ArrayList<>();
    }

    /**
     * Initializes the task list with a pre-existing list of tasks.
     *
     * @param list The initial list of {@code Task} objects.
     */
    public TaskList(List<Task> list) {
        tasks = list;
    }

    /**
     * Adds a {@code Task} to the list.
     *
     * @param Task The task to be added.
     */
    public void add(Task task) {
        tasks.add(task);
    }

    /**
     * Marks a task as done.
     * The task is identified by its index in the list.
     *
     * @param stringId The index of the task to be marked as done.
     */
    public void mark(int id) {
        tasks.get(id).setDone(true);
    }

    /**
     * Marks a task as not done.
     * The task is identified by its index in the list.
     *
     * @param stringId The index of the task to be marked as not done.
     */
    public void unmark(int id) {
        tasks.get(id).setDone(false);
    }

    /**
     * Deletes a task from the list.
     * The task is identified by its index in the list.
     *
     * @param stringId The index of the task to be deleted.
     */
    public Task delete(int id) {
        return tasks.remove(id);
    }

    /**
     * Filters the list for tasks which contain {@code keyword} in the name.
     *
     * @param keyword The search keyword.
     */
    public TaskList find(String keyword) {
        List<Task> result = new ArrayList<>();

        for (Task t: tasks) {
            String name = t.getName();
            String[] words = name.split(" ");

            boolean found = false;
            for (String word: words) {
                if (word.equals(keyword)) {
                    found = true;
                    break;
                }
            }

            if (found) {
                result.add(t);
            }
        }


        return new TaskList(result);
    }

    /**
     * Retrieves a task at the specified index.
     *
     * @param index The index of the task to be retrieved.
     * @return The task at the specified index.
     */
    public Task get(int index) {
        return tasks.get(index);
    }

    /**
     * Retrieves all tasks.
     *
     * @return The list of tasks.
     */
    public List<Task> getTasks() {
        return tasks;
    }


    /**
     * Returns the number of tasks in the list.
     *
     * @return The number of tasks in the list.
     */
    public int numTasks() {
        return tasks.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tasks.size(); i++) {
            if (i > 0) {
                sb.append("\n");
            }
            int num = i + 1;
            sb.append(num);
            sb.append(". ");
            sb.append(tasks.get(i).toString());
        }
        return sb.toString();
    }
}
