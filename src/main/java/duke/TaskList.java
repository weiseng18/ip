package duke;

import java.util.ArrayList;
import java.util.List;

// Task folder
import duke.MyTask.Task;

/**
 * Manages a list of {@code Task} objects.
 * Provides methods to add, list, mark, unmark, and delete tasks.
 */
public class TaskList {
    private List<Task> memory;

    /**
     * Initializes an empty task list.
     */
    public TaskList() {
        memory = new ArrayList<>();
    }

    /**
     * Initializes the task list with a pre-existing list of tasks.
     *
     * @param list The initial list of {@code Task} objects.
     */
    public TaskList(List<Task> list) {
        memory = list;
    }

    /**
     * Adds a {@code Task} to the list.
     *
     * @param Task The task to be added.
     */
    void addTask(Task task) {
        memory.add(task);

        System.out.println(Ui.SEPARATOR);
        System.out.println(Ui.INDENT + "Added task:");
        System.out.println(Ui.INDENT + memory.get(memory.size() - 1));
        System.out.println(Ui.SEPARATOR);
    }

    /**
     * Lists all tasks in the task list.
     * Each task is displayed with its index number.
     */
    void listEntries() {
        System.out.println(Ui.SEPARATOR);
        for (int i = 0; i < memory.size(); i++) {
            int num = i + 1;
            System.out.print(Ui.INDENT + num + ". ");
            System.out.println(memory.get(i));
        }
        System.out.println(Ui.SEPARATOR);
    }

    /**
     * Marks a task as done.
     * The task is identified by its index in the list.
     *
     * @param stringId The index of the task to be marked as done.
     */
    void markTask(int id) {
        memory.get(id).setDone(true);
        System.out.println(Ui.SEPARATOR);
        System.out.println(Ui.INDENT + "Nice! I've marked this task as done:");
        System.out.println(Ui.INDENT + memory.get(id));
        System.out.println(Ui.SEPARATOR);
    }

    /**
     * Marks a task as not done.
     * The task is identified by its index in the list.
     *
     * @param stringId The index of the task to be marked as not done.
     */
    void unmarkTask(int id) {
        memory.get(id).setDone(false);
        System.out.println(Ui.SEPARATOR);
        System.out.println(Ui.INDENT + "OK, I've marked this task as not done yet:");
        System.out.println(Ui.INDENT + memory.get(id));
        System.out.println(Ui.SEPARATOR);
    }

    /**
     * Deletes a task from the list.
     * The task is identified by its index in the list.
     *
     * @param stringId The index of the task to be deleted.
     */
    void deleteTask(int id) {
        Task task = memory.remove(id);
        System.out.println(Ui.SEPARATOR);
        System.out.println(Ui.INDENT + "Noted. I've removed this task:");
        System.out.println(Ui.INDENT + task);
        System.out.println(Ui.SEPARATOR);
    }

    void find(String keyword) {
        List<Task> result = new ArrayList<>();
        for (Task t: memory) {
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

        // NOTE: Assume that the ID for delete is still based on the global list.

        System.out.println(Ui.SEPARATOR);
        System.out.println(Ui.INDENT + "Here are the matching tasks in your list:");
        for (int i = 0; i < result.size(); i++) {
            int num = i + 1;
            System.out.print(Ui.INDENT + num + ". ");
            System.out.println(result.get(i));
        }
        System.out.println(Ui.SEPARATOR);
    }

    /**
     * Returns the list of tasks.
     *
     * @return The list of {@code Task} objects.
     */
    public List<Task> getMemory() {
        return memory;
    }
}

