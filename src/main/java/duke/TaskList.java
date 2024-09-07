package duke;

import java.util.ArrayList;
import java.util.List;

// Exceptions folder
import duke.MyException.EmptyDescriptionException;

// Task folder
import duke.MyTask.Task;
import duke.MyTask.Todo;
import duke.MyTask.Deadline;
import duke.MyTask.Event;

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
     * Adds a {@code Todo} task to the list.
     * The input should be in the format "todo `name`", where `name` is the description of the task.
     *
     * @param input The user input string to be parsed.
     * @throws EmptyDescriptionException If the input does not contain a task description.
     */
    void addTodoTask(Todo task) throws EmptyDescriptionException {
        memory.add(task);
        printTaskAdded(memory.size() - 1);
    }

    /**
     * Adds a {@code Deadline} task to the list.
     * The input should be in the format "deadline `name` /by `date`", where `name` is the description
     * of the task and `date` is the due date.
     *
     * @param input The user input string to be parsed.
     * @throws EmptyDescriptionException If the input does not contain a task description or date.
     */
    void addDeadlineTask(Deadline task) throws EmptyDescriptionException {
        memory.add(task);
        printTaskAdded(memory.size() - 1);
    }

    /**
     * Adds an {@code Event} task to the list.
     * The input should be in the format "event `name` /from `start_date` /to `end_date`",
     * where `name` is the description of the task, `start_date` is the start date and time,
     * and `end_date` is the end date and time.
     *
     * @param input The user input string to be parsed.
     * @throws EmptyDescriptionException If the input does not contain a task description or dates.
     */
    void addEventTask(Event task) throws EmptyDescriptionException {
        memory.add(task);
        printTaskAdded(memory.size() - 1);
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
    void markTask(String stringId) {
        int id = Integer.parseInt(stringId) - 1;
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
    void unmarkTask(String stringId) {
        int id = Integer.parseInt(stringId) - 1;
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
    void deleteTask(String stringId) {
        int id = Integer.parseInt(stringId) - 1;
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
     * Prints a message indicating that a task has been added.
     *
     * @param index The index of the task that was added.
     */
    private void printTaskAdded(int index) {
        System.out.println(Ui.SEPARATOR);
        System.out.println(Ui.INDENT + "Added task:");
        System.out.println(Ui.INDENT + memory.get(index));
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

