package duke.Parser; // same package as the class being tested

import duke.MyTask.Task;
import duke.MyTask.Todo;
import duke.MyException.EmptyDescriptionException;
import duke.Ui;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParserTest {
    @Test
    public void parseTodoInputTest() {
        String name = "Todo Task";
        String input = "todo " + name;

        try {
            Task t = Parser.parseTodoInput(input);

            Todo expected = new Todo(name);
            assertEquals(t.toString(), expected.toString());
        } catch (Exception e) {}
    }

    @Test
    public void parseEmptyDescriptionExceptionTest() {
        String input = "todo";

        EmptyDescriptionException e = assertThrows(EmptyDescriptionException.class, () -> {
            Parser.parseTodoInput(input);
        });

        String expectedMessage = Ui.INDENT + "Description cannot be empty.";
        assertEquals(e.getMessage(), expectedMessage);
    }
}
