public abstract class Task {
    String name;
    boolean isDone;
    char c;

    public Task(String name, char c) {
        this.name = name;
        this.isDone = false;
        this.c = c;
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
