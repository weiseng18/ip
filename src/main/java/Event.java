public class Event extends Task {
    String from, to;

    public Event(String name, String from, String to) {
        super(name, 'E');
        this.from = from;
        this.to = to;
    }

    public String toFileString() {
        return super.toFileString() + "|" + from + "|" + to;
    }

    public String toString() {
        return super.toString() + " (from: " + from + " to: " + to + ")";
    }
}
