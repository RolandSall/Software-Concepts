package entities;

import java.util.UUID;

public class EmailNotification extends Notification{
    private String content;

    public EmailNotification(String content) {
        super(UUID.randomUUID(),false);
        this.content = content;
    }

    @Override
    public String toString() {

        return  super.toString() + " EmailNotification{" +
                "content='" + content + '\'' +
                '}';
    }
}
