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

        memory.add(new Task(s));
    }

    static void list_entries() {
        System.out.println(separator);
        for (int i = 0; i < memory.size(); i++) {
            int num = i + 1;
            System.out.print(indent + num + ". ");
            System.out.println(memory.get(i).name);
        }
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
