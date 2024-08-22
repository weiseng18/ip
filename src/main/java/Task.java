public class Task {
    String name;
    boolean isDone;

    public Task(String name) {
        this.name = name;
        this.isDone = false;
    }

    public String toString() {
        String output = "";
        output += this.isDone ? "[x]" : "[ ]";
        output += " ";
        output += this.name;
        return output;
    }
}
