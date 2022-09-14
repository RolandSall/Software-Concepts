package services.playList;

import entities.PlayList;
import entities.Song;

public interface IPlayListService {

     void addSong(PlayList user, Song song);


      void removeSong(PlayList playList, Song song);
}
