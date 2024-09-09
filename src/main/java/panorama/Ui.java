package panorama;

/**
 * Handles user interaction by printing various messages to the console.
 */
public class Ui {
    public void showLine() {
        System.out.println("____________________________________________________________");
    }

    public void showWelcome() {
        System.out.println("Hello! I'm Panorama\nWhat can I do for you?");
    }

    public void showError(String errMessage) {
        System.out.println("Error: " + errMessage);
    }
}
