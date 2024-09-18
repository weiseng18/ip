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
    public void parseTodoCommand_shorthand_success() {
        String command = TodoCommand.COMMAND_SHORTHAND + " new_task";
        assertDoesNotThrow(() -> {
            Command c = parser.parseCommand(command);
            assertEquals(TodoCommand.class, c.getClass());
        });
    }

    @Test
    public void parseTodoCommand_success() {
        String command = TodoCommand.COMMAND_WORD + " new_task";
        assertDoesNotThrow(() -> {
            Command c = parser.parseCommand(command);
            assertEquals(TodoCommand.class, c.getClass());
        });
    }

    @Test
    public void parseTodoCommand_emptyDescription_exceptionThrown() {
        String command = TodoCommand.COMMAND_WORD + " ";
        assertThrows(EmptyDescriptionException.class, () -> parser.parseCommand(command));
    }

    @Test
    public void parseDeadlineCommand_shorthand_success() {
        String command = DeadlineCommand.COMMAND_SHORTHAND + " new_task /by 2024-09-01";
        assertDoesNotThrow(() -> {
            Command c = parser.parseCommand(command);
            assertEquals(DeadlineCommand.class, c.getClass());
        });
    }

    @Test
    public void parseDeadlineCommand_success() {
        String command = DeadlineCommand.COMMAND_WORD + " new_task /by 2024-09-01";
        assertDoesNotThrow(() -> {
            Command c = parser.parseCommand(command);
            assertEquals(DeadlineCommand.class, c.getClass());
        });
    }

    @Test
    public void parseDeadlineCommand_emptyDescription_exceptionThrown() {
        String command = DeadlineCommand.COMMAND_WORD + " ";
        assertThrows(EmptyDescriptionException.class, () -> parser.parseCommand(command));
    }

    @Test
    public void parseEventCommand_shorthand_success() {
        String command = EventCommand.COMMAND_SHORTHAND + " new_task /from 2024-09-01 /to 2024-09-03";
        assertDoesNotThrow(() -> {
            Command c = parser.parseCommand(command);
            assertEquals(EventCommand.class, c.getClass());
        });
    }

    @Test
    public void parseEventCommand_success() {
        String command = EventCommand.COMMAND_WORD + " new_task /from 2024-09-01 /to 2024-09-03";
        assertDoesNotThrow(() -> {
            Command c = parser.parseCommand(command);
            assertEquals(EventCommand.class, c.getClass());
        });
    }

    @Test
    public void parseEventCommand_emptyDescription_exceptionThrown() {
        String command = EventCommand.COMMAND_WORD + " ";
        assertThrows(EmptyDescriptionException.class, () -> parser.parseCommand(command));
    }

    @Test
    public void parseMarkCommand_shorthand_success() {
        String command = MarkCommand.COMMAND_SHORTHAND + " 1";
        assertDoesNotThrow(() -> {
            Command c = parser.parseCommand(command);
            assertEquals(MarkCommand.class, c.getClass());
        });
    }

    @Test
    public void parseMarkCommand_success() {
        String command = MarkCommand.COMMAND_WORD + " 1";
        assertDoesNotThrow(() -> {
            Command c = parser.parseCommand(command);
            assertEquals(MarkCommand.class, c.getClass());
        });
    }

    @Test
    public void parseUnmarkCommand_shorthand_success() {
        String command = UnmarkCommand.COMMAND_SHORTHAND + " 1";
        assertDoesNotThrow(() -> {
            Command c = parser.parseCommand(command);
            assertEquals(UnmarkCommand.class, c.getClass());
        });
    }

    @Test
    public void parseUnmarkCommand_success() {
        String command = UnmarkCommand.COMMAND_WORD + " 1";
        assertDoesNotThrow(() -> {
            Command c = parser.parseCommand(command);
            assertEquals(UnmarkCommand.class, c.getClass());
        });
    }

    @Test
    public void parseDeleteCommand_shorthand_success() {
        String command = DeleteCommand.COMMAND_SHORTHAND + " 1";
        assertDoesNotThrow(() -> {
            Command c = parser.parseCommand(command);
            assertEquals(DeleteCommand.class, c.getClass());
        });
    }

    @Test
    public void parseDeleteCommand_success() {
        String command = DeleteCommand.COMMAND_WORD + " 1";
        assertDoesNotThrow(() -> {
            Command c = parser.parseCommand(command);
            assertEquals(DeleteCommand.class, c.getClass());
        });
    }

}
