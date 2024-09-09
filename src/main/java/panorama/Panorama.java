package panorama;

import java.io.FileNotFoundException;
import java.io.IOException;

import panorama.command.Command;
import panorama.exception.EmptyDescriptionException;
import panorama.exception.UnknownCommandException;

public class Panorama {
    private Parser parser;
    private Storage storage;
    private TaskList taskList;
    private Ui ui;

    public Panorama() {
        storage = new Storage();
        ui = new Ui();

        try {
            taskList = storage.loadTaskList();
        } catch (FileNotFoundException e) {
            ui.showError(e.getMessage());
            // Initialize empty TaskList anyway
            taskList = new TaskList();
        }

        parser = new Parser(taskList);
    }

    public void run() {
        ui.showWelcome();

        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                ui.showLine();
                Command c = parser.parseCommand(fullCommand);
                String output = c.execute();
                System.out.println(output);

                isExit = c.isBye();
            } catch (EmptyDescriptionException | UnknownCommandException e) {
                ui.showError(e.getMessage());
            } finally {
                ui.showLine();
            }
        }

        try {
            storage.saveTaskList(taskList);
        } catch (IOException e) {
            ui.showError(e.getMessage());
        }
    }

    public static void main(String[] args) {
        new Panorama().run();
    }
}
