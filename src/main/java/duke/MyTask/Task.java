package duke.MyTask;

public abstract class Task {
    String name;
    boolean isDone;
    char c;

    public Task(String name, char c) {
        this.name = name;
        this.isDone = false;
        this.c = c;
    }

    public void setIsDone(boolean status) {
        this.isDone = status;
    }

    /**
     * Represent Task as a string that is easier for read/write
     * Note the use of | as the separator.
     */
    public String toFileString() {
        String output = "";
        output += c;
        output += "|";
        output += this.isDone ? "1" : "0";
        output += "|";
        output += this.name;
        return output;
    }

    public String toString() {
        String output = "";
        output += "[" + c + "]";
        output += " ";
        output += this.isDone ? "[x]" : "[ ]";
        output += " ";
        output += this.name;
        return output;
    }
}
