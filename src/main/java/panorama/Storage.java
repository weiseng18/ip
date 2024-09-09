package panorama;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import panorama.task.Deadline;
import panorama.task.Event;
import panorama.task.Task;
import panorama.task.Todo;

/**
 * Handles loading and saving of tasks from/to a file.
 */
public class Storage {
    private static final String SAVE_FILE_NAME = "./data.txt";

    /**
     * Loads the task list from the file specified by {@code SAVE_FILE_NAME}.
     * If the file does not exist, it returns an empty {@code TaskList}.
     *
     * @return A {@code TaskList} object containing tasks loaded from the file.
     * @throws FileNotFoundException If the file is not found.
     */
    TaskList loadTaskList() throws FileNotFoundException {
        File file = new File(SAVE_FILE_NAME);
        Scanner scanner = new Scanner(file);

        TaskList taskList = new TaskList();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            // Note that | is a special char in regex
            String[] tokens = line.split("\\|");

            if (tokens[0].equals("T")) {
                taskList.add(new Todo(tokens[2]));
            } else if (tokens[0].equals("D")) {
                LocalDate date = DateParser.parse(tokens[3]);
                taskList.add(new Deadline(tokens[2], date));
            } else {
                LocalDate from = DateParser.parse(tokens[3]);
                LocalDate to = DateParser.parse(tokens[4]);
                taskList.add(new Event(tokens[2], from, to));
            }

            // Set marked/unmarked correctly
            // Default is unmarked
            if (tokens[1].equals("1")) {
                taskList.mark(taskList.numTasks() - 1);
            }
        }

        scanner.close();

        return taskList;
    }

    /**
     * Saves the current list of tasks to the file specified by {@code SAVE_FILE_NAME}.
     *
     * @param memory The list of {@code Task} objects to be saved.
     * @throws IOException If an I/O error occurs while writing to the file.
     */
    void saveTaskList(List<Task> memory) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(SAVE_FILE_NAME));
        for (int i = 0; i < memory.size(); i++) {
            writer.write(memory.get(i).toFileString() + "\n");
        }
        writer.close();
    }
}

