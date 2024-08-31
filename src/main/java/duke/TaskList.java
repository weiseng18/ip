package duke;

import java.util.ArrayList;
import java.util.List;

// Parser folder
import duke.Parser.Parser;

// Exceptions folder
import duke.MyException.EmptyDescriptionException;

// Task folder
import duke.MyTask.Task;

public class TaskList {
    private List<Task> memory;

    public TaskList() {
        memory = new ArrayList<>();
    }

    public TaskList(List<Task> list) {
        memory = list;
    }

    void addTodoTask(String input) throws EmptyDescriptionException {
        Task t = Parser.parseTodoInput(input);
        memory.add(t);
        printTaskAdded(memory.size() - 1);
    }

    void addDeadlineTask(String input) throws EmptyDescriptionException {
        Task t = Parser.parseDeadlineInput(input);
        memory.add(t);
        printTaskAdded(memory.size() - 1);
    }

    void addEventTask(String input) throws EmptyDescriptionException {
        Task t = Parser.parseEventInput(input);
        memory.add(t);
        printTaskAdded(memory.size() - 1);
    }

    void listEntries() {
        System.out.println(Ui.SEPARATOR);
        for (int i = 0; i < memory.size(); i++) {
            int num = i + 1;
            System.out.print(Ui.INDENT + num + ". ");
            System.out.println(memory.get(i));
        }
        System.out.println(Ui.SEPARATOR);
    }

    void markTask(String stringId) {
        int id = Integer.parseInt(stringId) - 1;
        memory.get(id).setIsDone(true);
        System.out.println(Ui.SEPARATOR);
        System.out.println(Ui.INDENT + "Nice! I've marked this task as done:");
        System.out.println(Ui.INDENT + memory.get(id));
        System.out.println(Ui.SEPARATOR);
    }

    void unmarkTask(String stringId) {
        int id = Integer.parseInt(stringId) - 1;
        memory.get(id).setIsDone(false);
        System.out.println(Ui.SEPARATOR);
        System.out.println(Ui.INDENT + "OK, I've marked this task as not done yet:");
        System.out.println(Ui.INDENT + memory.get(id));
        System.out.println(Ui.SEPARATOR);
    }

    void deleteTask(String stringId) {
        int id = Integer.parseInt(stringId) - 1;
        Task task = memory.remove(id);
        System.out.println(Ui.SEPARATOR);
        System.out.println(Ui.INDENT + "Noted. I've removed this task:");
        System.out.println(Ui.INDENT + task);
        System.out.println(Ui.SEPARATOR);
    }
    
    private void printTaskAdded(int index) {
        System.out.println(Ui.SEPARATOR);
        System.out.println(Ui.INDENT + "Added task:");
        System.out.println(Ui.INDENT + memory.get(index));
        System.out.println(Ui.SEPARATOR);
    }

    List<Task> getMemory() {
        return memory;
    }
}
