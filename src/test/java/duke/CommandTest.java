package duke; // same package as the class being tested

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandTest {
    @Test
    public void fromStringValidTest() {
        String command = "mark";

        // Note that Command constructor is private.
        Command result = Command.fromString(command);
        assertNotEquals(null, result);
    }

    @Test
    public void fromStringInvalidTest() {
        String command = "invalid command name";

        Command result = Command.fromString(command);
        assertEquals(null, result);
    }
}

