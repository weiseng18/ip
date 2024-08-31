import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Panorama {

    // Constants
    static final String separator = "    ____________________________________________________________";
    static final String indent = "     "; // 5 spaces
    // Memory
    static List<Task> memory;

    static void welcome_greeting() {
        System.out.println(separator);
        System.out.println(indent + "Hello! I'm Panorama");
        System.out.println(indent + "What can I do for you?");
        System.out.println(separator);
    }

    static void exit_greeting() {
        String exit_statement = "Bye. Hope to see you again soon!";
        System.out.println(separator);
        System.out.println(indent + exit_statement);
        System.out.println(separator);
    }

    static void add_todo(String name) {
        memory.add(new Todo(name));

        System.out.println(separator);
        System.out.println(indent + "Added task:");
        System.out.println(indent + memory.get(memory.size() - 1));
        System.out.println(separator);
    }

    static void add_deadline(String name, String date) {
        memory.add(new Deadline(name, date));

        System.out.println(separator);
        System.out.println(indent + "Added task:");
        System.out.println(indent + memory.get(memory.size() - 1));
        System.out.println(separator);
    }

    static void add_event(String name, String from, String to) {
        memory.add(new Event(name, from, to));

        System.out.println(separator);
        System.out.println(indent + "Added task:");
        System.out.println(indent + memory.get(memory.size() - 1));
        System.out.println(separator);
    }

    static void list_entries() {
        System.out.println(separator);
        for (int i = 0; i < memory.size(); i++) {
            int num = i + 1;
            System.out.print(indent + num + ". ");
            System.out.println(memory.get(i));
        }
        System.out.println(separator);
    }

    static void mark_task(String string_id) {
        String mark_statement = "Nice! I've marked this task as done:";

        int id = Integer.parseInt(string_id);
        // because input is 1-indexed
        memory.get(id - 1).isDone = true;

        System.out.println(separator);
        System.out.println(indent + mark_statement);
        System.out.println(indent + memory.get(id - 1));
        System.out.println(separator);
    }

    static void unmark_task(String string_id) {
        String unmark_statement = "OK, I've marked this task as not done yet:";

        int id = Integer.parseInt(string_id);
        // because input is 1-indexed
        memory.get(id - 1).isDone = false;

        System.out.println(separator);
        System.out.println(indent + unmark_statement);
        System.out.println(indent + memory.get(id - 1));
        System.out.println(separator);
    }

    static void delete_task(String string_id) {
        String delete_statement = "Noted. I've removed this task:";

        int id = Integer.parseInt(string_id);
        Task t = memory.get(id - 1);

        // because input is 1-indexed
        memory.remove(id - 1);

        System.out.println(separator);
        System.out.println(indent + delete_statement);
        System.out.println(indent + t);
        System.out.println(separator);
    }

    static void display_help() {
        System.out.println(separator);

        System.out.println(indent + "list");
        System.out.println(indent + "bye");

        System.out.println(indent + "todo (description)");
        System.out.println(indent + "deadline (description) /by (date_string)");
        System.out.println(indent + "event (description) /from (date_string) /to (date_string)");

        System.out.println(indent + "mark (task_id)");
        System.out.println(indent + "unmark (task_id)");
        System.out.println(indent + "delete (task_id)");

        System.out.println(separator);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        welcome_greeting();
        memory = new ArrayList<Task>();

        String input;
        boolean hasExited = false;

        while (!hasExited && scanner.hasNext()) {
            try {
                input = scanner.nextLine();
                String[] tokens = input.split(" ");
                String name;

                // for splitting tokens further
                String contents;
                String[] content_tokens;

                switch (tokens[0]) {
                    case "mark":
                        mark_task(tokens[1]);
                        break;
                    case "unmark":
                        unmark_task(tokens[1]);
                        break;
                    case "bye":
                        exit_greeting();
                        hasExited = true;
                        break;
                    case "list":
                        list_entries();
                        break;
                    case "todo":
                        if (input.length() <= 5) {
                            throw new EmptyDescriptionException();
                        }

                        name = input.substring(5);
                        add_todo(name);
                        break;
                    case "deadline":
                        if (input.length() <= 9) {
                            throw new EmptyDescriptionException();
                        }

                        contents = input.substring(9);

                        content_tokens = contents.split(" /by ");
                        name = content_tokens[0];
                        String date = content_tokens[1];

                        add_deadline(name, date);
                        break;
                    case "event":
                        if (input.length() <= 6) {
                            throw new EmptyDescriptionException();
                        }

                        contents = input.substring(6);

                        content_tokens = contents.split(" /from ");
                        name = content_tokens[0];

                        String[] dateRange = content_tokens[1].split(" /to ");

                        String from = dateRange[0];
                        String to = dateRange[1];

                        add_event(name, from, to);
                        break;
                    case "delete":
                        delete_task(tokens[1]);
                        break;
                    case "help":
                        display_help();
                        break;
                    default:
                        throw new UnknownCommandException();
                }
            } catch (EmptyDescriptionException e) {
                System.out.println(indent + "The task description cannot be empty.");
                System.out.println(separator);
            } catch (UnknownCommandException e) {
                System.out.println(indent + "Unknown command.");
                System.out.println(separator);
            }
        }
    }
}
