package services.singer;

import DTOs.CreateSongDto;
import entities.Singer;
import entities.Song;
import repos.IMusicSystemDbContext;

public class SingerService implements ISingerService{


    IMusicSystemDbContext iMusicSystemDbContext;

    public SingerService(IMusicSystemDbContext iMusicSystemDbContext) {
        this.iMusicSystemDbContext = iMusicSystemDbContext;
    }

    @Override
    public void addSong(CreateSongDto song) {
        Song newSong = iMusicSystemDbContext.saveSong(song);
        for(Singer singer: song.getSingers())
            singer.addSong(newSong);
    }
}
