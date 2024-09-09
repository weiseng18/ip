package panorama.task; // same package as the class being tested

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodoTest {
    String name = "Todo Task";
    Todo t = new Todo(name);

    @Test
    public void toString_success() {
        String expected = "[T] [ ] " + name;
        assertEquals(expected, t.toString());
    }

    @Test
    public void toFileString_success() {
        String expected = "T|0|" + name;
        assertEquals(expected, t.toFileString());
    }
}

