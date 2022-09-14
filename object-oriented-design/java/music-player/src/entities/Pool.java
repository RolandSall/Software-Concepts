package entities;

import java.util.HashMap;
import java.util.List;

public class Pool {

    private List<Song> songs;
    private List<Singer> singers;

    private HashMap<Singer, List<Song>> singerHashMap;

    public void addSong(Song song){
        // you add songs to the pool

        
        Singer singer = song.getSingers().get(0);
        List<Song> singersSongs = singerHashMap.get(singer);
        singersSongs.add(song);
    }


}
