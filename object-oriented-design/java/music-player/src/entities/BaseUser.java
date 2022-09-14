package entities;

import Strategy.IShuffleBehaviour;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public abstract class BaseUser {

    private UUID id;
    private String firstName;
    private String lastName;

    private Song currentPlayedSong;

    private List<PlayList> playList;



    public BaseUser(UUID id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        playList = new ArrayList<>();
    }


    protected UUID getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }



    public void playSong(Song song){
        currentPlayedSong = song;
        System.out.println("Playing Song..." + song.getName());
    }

    public void stopSong(){
        currentPlayedSong = null;
        System.out.println("Stop Song");
    }


    public void shufflePlayList(PlayList playList, IShuffleBehaviour shuffleBehaviour){
        shuffleBehaviour.shuffle(playList);

    }

    public List<PlayList> getPlayList() {
        return playList;
    }


    public void setPlayList(List<PlayList> playList) {
        this.playList = playList;
    }


    public PlayList getPlayListByName(String name) {
        for (PlayList pList : playList
        ) {
            if (pList.getName().equalsIgnoreCase(name))
                return pList;
        }

        return null;

    }

}
