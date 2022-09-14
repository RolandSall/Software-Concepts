package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PlayList {
    private UUID id;
    private String name;
    private List<Song> songs;


    private final int CAPACITY = 100;

    public PlayList(String name, BaseUser baseUser) {
        id = UUID.randomUUID();
        this.name = name;
        songs = new ArrayList<>();
        // or use the userID instead of a whole object
    }

    public PlayList(String name, List<Song> songs, BaseUser baseUser) {
        id = UUID.randomUUID();
        this.name = name;
        this.songs = songs;
    }

    public String getName() {
        return name;
    }

    public void addSong(Song song){
        if(songs.size() < 100)
            songs.add(song);
        else
            System.out.println("Not Enough Capacity");
    }

    public void removeSong(Song song) {
        songs.remove(song);
    }
}
