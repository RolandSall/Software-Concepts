package services.notfication;

import entities.EmailNotification;
import entities.Notification;
import entities.Singer;
import entities.Song;

import java.util.List;

public class NotificationManager implements INotificationManager{



    @Override
    public void removedSongNotify(List<Singer> singers, Song song) {
        for(Singer singer: singers){
            Notification notification = new EmailNotification(song.getName() + "has been removed to one of the users playlist");
            singer.removeSongNotification(notification);
        }

    }

    @Override
    public void addSongNotify(List<Singer> singers, Song song) {
        for(Singer singer: singers){
            Notification notification = new EmailNotification(song.getName() + "has been added to one of the users playlist");
            singer.addSongNotification(notification);
        }
    }
}
