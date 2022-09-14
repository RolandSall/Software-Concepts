package services.singer;

import DTOs.CreateSongDto;
import entities.Singer;
import entities.Song;

public interface ISingerService {

    public void addSong(CreateSongDto song);
}
