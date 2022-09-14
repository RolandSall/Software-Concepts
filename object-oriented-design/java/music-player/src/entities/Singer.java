package entities;

import DTOs.CreateSongDto;
import repos.IMusicSystemDbContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Singer extends BaseUser {

    private List<Song> songs;
    private List<Notification> notifications;
    private int songCounter = 0;


    public Singer(UUID id, String firstName, String lastName) {
        super(id, firstName, lastName);
        songs = new ArrayList<>();
        notifications = new ArrayList<>();
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Singer)) return false;
        Singer singer = (Singer) o;
        return super.getId() == singer.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.getId());
    }

    public void addSongNotification(Notification notification){
        notifications.add(notification);
        songCounter++;
    }

    public void removeSongNotification(Notification notification){
        notifications.add(notification);
        songCounter--;
    }

    public void displayNotifications(){
        System.out.println(notifications);
    }

    public int getNumberOfSongsInPlayLists(){
        return songCounter;
    }

    public void readNotification(UUID notificationId){
        Notification notification = notifications.stream().filter(not -> not.getId().equals(notificationId)).findFirst().get();
        notification.read();

    }
}
