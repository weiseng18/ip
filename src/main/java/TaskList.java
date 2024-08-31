import java.util.ArrayList;
import java.util.List;

import java.time.LocalDateTime;

// Parser folder
import Parser.DateParser;

// Exceptions folder
import MyException.EmptyDescriptionException;

// Task folder
import MyTask.Task;
import MyTask.Todo;
import MyTask.Deadline;
import MyTask.Event;

public class TaskList {
    private List<Task> memory;

    public TaskList() {
        memory = new ArrayList<>();
    }

    public TaskList(List<Task> list) {
        memory = list;
    }

    void addTodoTask(String input) throws EmptyDescriptionException {
        if (input.length() <= 5) {
            throw new EmptyDescriptionException();
        }
        String name = input.substring(5);
        memory.add(new Todo(name));
        printTaskAdded(memory.size() - 1);
    }

    void addDeadlineTask(String input) throws EmptyDescriptionException {
        if (input.length() <= 9) {
            throw new EmptyDescriptionException();
        }

        String[] contentTokens = input.substring(9).split(" /by ");
        String name = contentTokens[0];
        LocalDateTime date = DateParser.parse(contentTokens[1]);
        memory.add(new Deadline(name, date));
        printTaskAdded(memory.size() - 1);
    }

    void addEventTask(String input) throws EmptyDescriptionException {
        if (input.length() <= 6) {
            throw new EmptyDescriptionException();
        }
        String[] contentTokens = input.substring(6).split(" /from ");
        String name = contentTokens[0];

        String[] dateRange = contentTokens[1].split(" /to ");
        LocalDateTime from = DateParser.parse(dateRange[0]);
        LocalDateTime to = DateParser.parse(dateRange[1]);
        memory.add(new Event(name, from, to));
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
