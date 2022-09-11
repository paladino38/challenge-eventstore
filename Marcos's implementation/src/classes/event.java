package classes;

public class event {
    private final String type;
    private final long timestamp;

    public event(String type, long timestamp) {
        this.type = type;
        this.timestamp = timestamp;
    }

    public String type() {
        return type;
    }

    public long timestamp() {
        return timestamp;
    }
}
