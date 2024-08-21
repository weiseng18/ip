import java.util.Scanner;

public class Panorama {

    // Constants
    String separator = "    ____________________________________________________________";
    String indent = "     "; // 5 spaces

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(separator);
        System.out.println(indent + "Hello! I'm Panorama");
        System.out.println(indent + "What can I do for you?");
        System.out.println(separator);

        String input;
        String exit_command = "bye";
        String exit_statement = "Bye. Hope to see you again soon!";

        while (true) {
            input = scanner.nextLine();
            if (input.equals(exit_command)) {
                System.out.println(indent + exit_statement);
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
