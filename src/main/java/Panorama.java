import java.util.Scanner;
import java.util.List;

import java.util.Locale;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.time.format.DateTimeParseException;

// Task folder
import MyTask.Task;

// Exceptions folder
import MyException.EmptyDescriptionException;
import MyException.UnknownCommandException;

public class Panorama {

    // Constants
    public static final String SEPARATOR = "    ____________________________________________________________";
    public static final String INDENT = "     "; // 5 spaces

    static void welcome_greeting() {
        System.out.println(SEPARATOR);
        System.out.println(INDENT + "Hello! I'm Panorama");
        System.out.println(INDENT + "What can I do for you?");
        System.out.println(SEPARATOR);
    }

    static void exit_greeting() {
        String exit_statement = "Bye. Hope to see you again soon!";
        System.out.println(SEPARATOR);
        System.out.println(INDENT + exit_statement);
        System.out.println(SEPARATOR);
    }

    static void display_help() {
        System.out.println(SEPARATOR);

        System.out.println(INDENT + "list");
        System.out.println(INDENT + "bye");

        System.out.println(INDENT + "todo (description)");
        System.out.println(INDENT + "deadline (description) /by (date_string)");
        System.out.println(INDENT + "event (description) /from (date_string) /to (date_string)");

        System.out.println(INDENT + "mark (task_id)");
        System.out.println(INDENT + "unmark (task_id)");
        System.out.println(INDENT + "delete (task_id)");

        System.out.println(SEPARATOR);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskList taskList = new TaskList();;
        Storage storage = new Storage();

        // force locale
        Locale.setDefault(Locale.ENGLISH);

        welcome_greeting();

        // Check for past data
        try {
            List<Task> loadedTaskList = storage.loadTaskList();
            taskList = new TaskList(loadedTaskList);
            System.out.println("Successfully loaded task list.");
        } catch (FileNotFoundException e) {
            System.out.println("./data.txt does not exist. Starting from an empty task list.");
        }
        System.out.println(SEPARATOR);

        String input;
        boolean hasExited = false;

        while (!hasExited && scanner.hasNext()) {
            try {
                input = scanner.nextLine();
                String[] tokens = input.split(" ");
                Command command = Command.fromString(tokens[0]);

                switch (command) {
                    case MARK:
                        taskList.markTask(tokens[1]);
                        break;
                    case UNMARK:
                        taskList.unmarkTask(tokens[1]);
                        break;
                    case BYE:
                        exit_greeting();
                        hasExited = true;
                        break;
                    case LIST:
                        taskList.listEntries();
                        break;
                    case TODO:
                        taskList.addTodoTask(input);
                        break;
                    case DEADLINE:
                        taskList.addDeadlineTask(input);
                        break;
                    case EVENT:
                        taskList.addEventTask(input);
                        break;
                    case DELETE:
                        taskList.deleteTask(tokens[1]);
                        break;
                    case HELP:
                        display_help();
                        break;
                    default:
                        throw new UnknownCommandException();
                }
            } catch (EmptyDescriptionException e) {
                System.out.println(INDENT + "The task description cannot be empty.");
                System.out.println(SEPARATOR);
            } catch (UnknownCommandException e) {
                System.out.println(INDENT + "Unknown command.");
                System.out.println(SEPARATOR);
            } catch (DateTimeParseException e) {
                System.out.println(INDENT + "Invalid date");
                System.out.println(SEPARATOR);
            }
        }

        // Save task list to file after exiting
        try {
            List<Task> memory = taskList.getMemory();
            storage.saveTaskList(memory);
            System.out.println("Successfully saved to file.");
        } catch (IOException e) {
            System.out.println("Error in saving to file.");
        }
    }
}
