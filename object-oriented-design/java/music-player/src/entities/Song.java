package entities;

import java.util.List;
import java.util.UUID;

public class Song {

    private UUID id;
    private String name;
    private List<Singer> singers;

    public Song(UUID id ,String name, List<Singer> singers) {
        this.id = id;
        this.name = name;
        this.singers = singers;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Singer> getSingers() {
        return singers;
    }
}
