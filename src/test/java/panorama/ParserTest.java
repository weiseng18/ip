package panorama; // same package as the class being tested

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import panorama.command.Command;
import panorama.command.DeadlineCommand;
import panorama.command.DeleteCommand;
import panorama.command.EventCommand;
import panorama.command.MarkCommand;
import panorama.command.TodoCommand;
import panorama.command.UnmarkCommand;
import panorama.exception.EmptyDescriptionException;
import panorama.task.Todo;

public class ParserTest {
    private TaskList taskList;
    private Parser parser;

    @BeforeEach
    public void setup() {
        taskList = new TaskList();
        // For mark, unmark, delete, find, list
        taskList.add(new Todo("todo task"));
        parser = new Parser(taskList);
    }

    @Test
    public void parseTodoCommand_success() {
        String command = "todo new_task";
        assertDoesNotThrow(() -> {
            Command c = parser.parseCommand(command);
            assertEquals(TodoCommand.class, c.getClass());
        });
    }

    @Test
    public void parseTodoCommand_emptyDescription_exceptionThrown() {
        String command = "todo ";
        assertThrows(EmptyDescriptionException.class, () -> parser.parseCommand(command));
    }

    @Test
    public void parseDeadlineCommand_success() {
        String command = "deadline new_task /by 2024-09-01";
        assertDoesNotThrow(() -> {
            Command c = parser.parseCommand(command);
            assertEquals(DeadlineCommand.class, c.getClass());
        });
    }

    @Test
    public void parseDeadlineCommand_emptyDescription_exceptionThrown() {
        String command = "deadline ";
        assertThrows(EmptyDescriptionException.class, () -> parser.parseCommand(command));
    }

    @Test
    public void parseEventCommand_success() {
        String command = "event new_task /from 2024-09-01 /to 2024-09-03";
        assertDoesNotThrow(() -> {
            Command c = parser.parseCommand(command);
            assertEquals(EventCommand.class, c.getClass());
        });
    }

    @Test
    public void parseEventCommand_emptyDescription_exceptionThrown() {
        String command = "event ";
        assertThrows(EmptyDescriptionException.class, () -> parser.parseCommand(command));
    }

    @Test
    public void parseMarkCommand_success() {
        String command = "mark 1";
        assertDoesNotThrow(() -> {
            Command c = parser.parseCommand(command);
            assertEquals(MarkCommand.class, c.getClass());
        });
    }

    @Test
    public void parseUnmarkCommand_success() {
        String command = "unmark 1";
        assertDoesNotThrow(() -> {
            Command c = parser.parseCommand(command);
            assertEquals(UnmarkCommand.class, c.getClass());
        });
    }

    @Test
    public void parseDeleteCommand_success() {
        String command = "delete 1";
        assertDoesNotThrow(() -> {
            Command c = parser.parseCommand(command);
            assertEquals(DeleteCommand.class, c.getClass());
        });
    }

}
