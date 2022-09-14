package entities;

import java.util.UUID;

public abstract class Notification {

    private UUID id;
    private boolean read;

    public Notification(UUID id, boolean read) {
        this.id = id;
        this.read = read;
    }

    public UUID getId() {
        return id;
    }

    public boolean isRead() {
        return read;
    }

    public void read(){
        this.read = true;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "id=" + id +
                ", read=" + read +
                '}';
    }
}
