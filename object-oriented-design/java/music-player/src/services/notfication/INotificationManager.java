package services.notfication;

import entities.Singer;
import entities.Song;

import java.util.List;

public interface INotificationManager {


    public void removedSongNotify(List<Singer> singers, Song song);

    void addSongNotify(List<Singer> singers, Song song);
}
