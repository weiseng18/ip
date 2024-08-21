import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Panorama {

    // Constants
    static String separator = "    ____________________________________________________________";
    static String indent = "     "; // 5 spaces

    // Commands
    static String exit_command = "bye";

    static void welcome_greeting() {
        System.out.println(separator);
        System.out.println(indent + "Hello! I'm Panorama");
        System.out.println(indent + "What can I do for you?");
        System.out.println(separator);
    }

    static void exit_greeting() {
        String exit_statement = "Bye. Hope to see you again soon!";
        System.out.println(indent + exit_statement);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        welcome_greeting();

        String input;

        while (true) {
            input = scanner.nextLine();
            if (input.equals(exit_command)) {
                exit_greeting();
                break;
            } else {
              System.out.println(separator);
              System.out.println(indent + input);
              System.out.println(separator);
              System.out.println();
            }
        }

        scanner.close();
    }
}
