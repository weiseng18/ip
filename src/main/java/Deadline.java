public class Deadline extends Task {
    String date;

    public Deadline(String name, String date) {
        super(name, 'D');
        this.date = date;
    }

    public String toString() {
        return super.toString() + " (by: " + date + ")";
    }
}
