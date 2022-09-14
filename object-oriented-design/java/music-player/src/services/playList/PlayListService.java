package services.playList;

import entities.PlayList;
import entities.Song;
import repos.IMusicSystemDbContext;
import services.notfication.INotificationManager;
import services.notfication.NotificationManager;

public class PlayListService implements IPlayListService{

    private INotificationManager notificationManager;

    public PlayListService() {
        this.notificationManager = new NotificationManager();
    }

     @Override
    public void addSong(PlayList playList, Song song) {
        playList.addSong(song);
        notificationManager.addSongNotify(song.getSingers(), song);

    }

    @Override
    public void removeSong(PlayList playList, Song song) {
        playList.removeSong(song);
        notificationManager.removedSongNotify(song.getSingers(), song);

    }
}
