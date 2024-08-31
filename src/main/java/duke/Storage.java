package duke;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

import java.time.LocalDateTime;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;

// Parser folder
import duke.Parser.DateParser;

// Task folder
import duke.MyTask.Task;
import duke.MyTask.Todo;
import duke.MyTask.Deadline;
import duke.MyTask.Event;

public class Storage {
    // Constants
    private static final String SAVE_FILE_NAME = "./data.txt";

    /**
     * Load task list from ./data.txt.
     * If non-existent, assume that there is no past data.
     */
    List<Task> loadTaskList() throws FileNotFoundException {
        File myFile = new File(SAVE_FILE_NAME);
        Scanner myReader = new Scanner(myFile);

        // Temporary list for return
        List<Task> memory = new ArrayList<>();

        while (myReader.hasNextLine()) {
            String task = myReader.nextLine();
            // Note that | is a special char in regex
            String[] tokens = task.split("\\|");

            if (tokens[0].equals("T")) {
                memory.add(new Todo(tokens[2]));
            } else if (tokens[0].equals("D")) {
                LocalDateTime date = DateParser.parse(tokens[3]);
                memory.add(new Deadline(tokens[2], date));
            } else {
                LocalDateTime from = DateParser.parse(tokens[3]);
                LocalDateTime to = DateParser.parse(tokens[4]);
                memory.add(new Event(tokens[2], from, to));
            }

            // Set marked/unmarked correctly
            memory.get(memory.size() - 1).setIsDone(tokens[1].equals("1"));
        }

        return memory;
    }

    /**
     * Save current task list to ./data.txt.
     */
    void saveTaskList(List<Task> memory) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(SAVE_FILE_NAME));
        for (int i = 0; i < memory.size(); i++) {
            writer.write(memory.get(i).toFileString() + "\n");
        }
        writer.close();
    }

}
