package panorama; // same package as the class being tested

import panorama.command.Command;
import panorama.command.TodoCommand;
import panorama.exception.EmptyDescriptionException;
import panorama.task.Todo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParserTest {
    TaskList taskList;
    Parser parser;

    @BeforeEach
    public void setup() {
        taskList = new TaskList();
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
}
