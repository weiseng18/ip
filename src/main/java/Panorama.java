import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Panorama {

    // Constants
    static String separator = "    ____________________________________________________________";
    static String indent = "     "; // 5 spaces
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

    static void add_entry(String s) {
        System.out.println(separator);
        System.out.print(indent + "added: ");
        System.out.println(s);
        System.out.println(separator);

        memory.add(new Todo(s));
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        welcome_greeting();
        memory = new ArrayList<Task>();

        String input;
        boolean hasExited = false;

        while (!hasExited) {
            input = scanner.nextLine();
            String[] tokens = input.split(" ");

            // assume that if the first word is mark/unmark, and there are 2 words, then it is a marking command
            if (tokens[0].equals("mark") && tokens.length == 2) {
                mark_task(tokens[1]);
            } else if (tokens[0].equals("unmark") && tokens.length == 2) {
                unmark_task(tokens[1]);
            } else {
                switch (input) {
                    case "bye":
                        exit_greeting();
                        hasExited = true;
                        break;
                    case "list":
                        list_entries();
                        break;
                    default:
                        add_entry(input);
                }
            }
        }
    }
}
